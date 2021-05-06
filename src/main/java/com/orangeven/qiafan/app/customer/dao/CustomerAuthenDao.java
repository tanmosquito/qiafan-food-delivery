package com.orangeven.qiafan.app.customer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractLoginableEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.customer.model.Customer;

@Repository
public class CustomerAuthenDao extends AbstractLoginableEntityDao<Customer>{

    @Override
    public Customer find(String account) throws DataNotFoundException {
        return this.find(account, Customer.class);
    }
	
}
