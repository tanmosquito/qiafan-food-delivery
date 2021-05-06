package com.orangeven.qiafan.app.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangeven.qiafan.app.common.controller.AbstractOwnedResourceController;
import com.orangeven.qiafan.app.customer.dao.AddressDao;
import com.orangeven.qiafan.app.customer.model.Address;
import com.orangeven.qiafan.app.customer.service.AddressService;

@RestController
@RequestMapping("/api/customer/address")
public class CustomerAddressController extends AbstractOwnedResourceController<Address,AddressDao, AddressService>{
	public CustomerAddressController(@Autowired AddressService service) {
		super(service);
	}

	@Override
	protected Address getInstance() {
		return new Address();
	}

}
