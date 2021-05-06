package com.orangeven.qiafan.app.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangeven.qiafan.app.common.controller.AbstractAuthenController;
import com.orangeven.qiafan.app.customer.dao.CustomerAuthenDao;
import com.orangeven.qiafan.app.customer.model.Customer;
import com.orangeven.qiafan.app.customer.service.CustomerAuthenService;

@RestController("customerAuthenController")
@RequestMapping("/api/customer/authen")
public class CustomerAuthenController extends AbstractAuthenController<Customer, CustomerAuthenDao, CustomerAuthenService>{
	
	public CustomerAuthenController(@Autowired CustomerAuthenService service) {
		super(service);
	}
	
	protected Customer getInstance() {
		return new Customer();
	}
}
