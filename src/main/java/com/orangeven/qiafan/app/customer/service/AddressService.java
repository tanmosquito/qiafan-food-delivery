package com.orangeven.qiafan.app.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;
import com.orangeven.qiafan.app.customer.dao.AddressDao;
import com.orangeven.qiafan.app.customer.model.Address;

@Service
public class AddressService extends AbstractOwnedResourceService<Address, AddressDao> {
	
	public AddressService(@Autowired AddressDao dao) {
		super(dao);
	}

	public List<Address> findRange(Long ownerId, long from, int size)
			throws ResourceSetSizeTooLargeException, ResourceNotFoundException {
		return super.findRange(ownerId, from, size, Address.class);
	}

	@Override
	protected void updateFields(Address entityInManage, Address entityAsParameter) {
		// TODO
	}

	@Override
	public List<Address> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		try {
			return dao.findRange(ownerId, from, size, Address.class);
		} catch (DataNotFoundException e) {
			throw new ResourceNotFoundException();
		}
	}

}
