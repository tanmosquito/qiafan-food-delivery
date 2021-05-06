package com.orangeven.qiafan.app.unit.customer.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.servlet.http.HttpSession;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.orangeven.qiafan.app.common.controller.exception.AlreadyLogedInException;
import com.orangeven.qiafan.app.common.dao.exception.DataExistsException;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.enumeration.Gender;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.customer.dao.CustomerDao;
import com.orangeven.qiafan.app.customer.model.Customer;
import com.orangeven.qiafan.app.customer.service.CustomerAuthenService;

@ExtendWith(EasyMockExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerDao dao;
	@Mock
	private HttpSession session;
	
	@TestSubject
	private CustomerAuthenService service = new CustomerAuthenService(dao);
	
	@Test
	public void signUpSuccessTest() throws DataExistsException, ResourceExistsException {
		Customer newCustomer = newCustomerData();
		dao.create(newCustomer);
		
		replay(dao);
		
		service.signUp(newCustomer);
	}
	
	@Test
	public void signUpWithAlreadyExistedAccountTest() throws DataExistsException {
		Customer newCustomer = newCustomerData();
		dao.create(newCustomer);
		expectLastCall().andThrow(new DataExistsException());
		
		replay(dao);
		
		assertThrows(ResourceExistsException.class, ()->service.signUp(newCustomer));
	}
	
	@Test
	public void signInSuccessTest() throws DataNotFoundException, ResourceNotFoundException, AlreadyLogedInException {
		expect(session.getAttribute("customerId")).andReturn(null);
		
		Customer customerInManage = customerInDatabase();
		expect(dao.find("test_customer", "123456")).andReturn(customerInManage);
		
		session.setAttribute("customerId", 0L);
		replay(dao, session);
		
		service.signIn(customerInManage);
	}
	
	@Test
	public void accountOrPasswordErrorTest() throws DataNotFoundException {
		
		// incorrect password but correct account
		expect(session.getAttribute("customerId")).andReturn(null);
		
		Customer incorrectPwd = incorrectPasswordSignInCustomerData();
		expect(dao.find(incorrectPwd.getAccount(), incorrectPwd.getPassword()))
		.andThrow(new DataNotFoundException());
		
		replay(dao, session);
		
		assertThrows(ResourceNotFoundException.class, ()->service.signIn(incorrectPwd));
		
		reset(dao, session);// reset mock
		
		// incorrect account but correct password
		expect(session.getAttribute("customerId")).andReturn(null);
		Customer incorrectAccount = incorrectAccountSignInCustomerData();
		expect(dao.find(incorrectAccount.getAccount(), incorrectAccount.getPassword()))
		.andThrow(new DataNotFoundException());
		
		replay(dao, session);

		assertThrows(ResourceNotFoundException.class, ()->service.signIn(incorrectAccount));
		
		reset(dao, session);// reset mock
		
		// incorrect account and password
		expect(session.getAttribute("customerId")).andReturn(null);
		Customer incorrectAccountPwd = incorrectSignInCustomerData();
		expect(dao.find(incorrectAccountPwd.getAccount(), incorrectAccountPwd.getPassword()))
		.andThrow(new DataNotFoundException());
		
		replay(dao, session);

		assertThrows(ResourceNotFoundException.class, ()->service.signIn(incorrectAccountPwd));
	}
	
	@Test
	public void userNotExistTest() throws DataNotFoundException {
		expect(session.getAttribute("customerId")).andReturn(null);
		
		Customer customerInManage = customerInDatabase();
		expect(dao.find("test_customer", "123456")).andThrow(new DataNotFoundException());
		
		session.setAttribute("customerId", 0L);
		replay(dao, session);
		
		assertThrows(ResourceNotFoundException.class, ()->service.signIn(customerInManage));
	}
	
	@Test
	public void alreadySignedInTest() throws ResourceNotFoundException, AlreadyLogedInException {
		expect(session.getAttribute("customerId")).andReturn(0L);
		
		replay(session);
		
		Customer customer = correctSignInCustomerData();
		assertThrows(AlreadyLogedInException.class, ()->service.signIn(customer));
	}
	
	private Customer correctSignInCustomerData() {
		Customer customer = new Customer();
		customer.setAccount("test_customer");
		customer.setPassword("123456");
		return customer;
	}
	
	private Customer incorrectPasswordSignInCustomerData() {
		Customer customer = new Customer();
		customer.setAccount("test_customer");
		customer.setPassword("5555");
		return customer;
	}
	
	private Customer incorrectAccountSignInCustomerData() {
		Customer customer = new Customer();
		customer.setAccount("customer");
		customer.setPassword("123456");
		return customer;
	}
	
	private Customer incorrectSignInCustomerData() {
		Customer customer = new Customer();
		customer.setAccount("customer");
		customer.setPassword("5555");
		return customer;
	}
	
	private Customer customerInDatabase() {
		return correctSignInCustomerData();
	}
	
	private Customer newCustomerData() {
		Customer customer = new Customer();
		customer.setAccount("test_new_customer");
		customer.setPassword("666666");
		customer.setGender(Gender.MALE);
		customer.setEmail("test_new_customer@qiafan.com");
		customer.setNickname("new_customer");
		customer.setPhone("13888888888");
		
		return customer;
	}
}
