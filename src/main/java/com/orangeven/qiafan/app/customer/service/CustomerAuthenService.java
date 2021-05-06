package com.orangeven.qiafan.app.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.exception.UnimplementedMethodException;
import com.orangeven.qiafan.app.common.service.AbstractLoginableResourceService;
import com.orangeven.qiafan.app.customer.dao.CustomerAuthenDao;
import com.orangeven.qiafan.app.customer.model.Customer;

@Service
public class CustomerAuthenService extends AbstractLoginableResourceService<Customer, CustomerAuthenDao>{
	public CustomerAuthenService(@Autowired CustomerAuthenDao dao) {
		super(dao);
	}
    
    @Override
	public void logOut() throws UnimplementedMethodException {
		throw new UnimplementedMethodException();
	}
	
}
