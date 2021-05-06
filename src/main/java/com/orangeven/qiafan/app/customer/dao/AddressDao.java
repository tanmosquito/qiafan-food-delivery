package com.orangeven.qiafan.app.customer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.customer.model.Address;

@Repository
public class AddressDao extends AbstractOwnedEntityDao<Address> {

	@Override
	public Address find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, Address.class);
	}


	@Override
	public Address find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, Address.class);
	}
}
