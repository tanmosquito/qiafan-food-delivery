package com.orangeven.qiafan.app.customer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.customer.model.Customer;

@Repository
public class CustomerDao extends AbstractEntityDao<Customer> {

    public Customer find(long id) throws DataNotFoundException {
        return super.find(id, Customer.class);
    }
    
    @Override
    protected boolean isDataExists(Customer entity) {
    	try {
    		findByColumn("account", entity.getAccount(), Customer.class);
    		return true;
		} catch (DataNotFoundException e) {
			return false;
		}
    	
    }

	@Override
	public Customer find(long id, boolean disabled) throws DataNotFoundException {
		return find(id, disabled, Customer.class);
	}

}
