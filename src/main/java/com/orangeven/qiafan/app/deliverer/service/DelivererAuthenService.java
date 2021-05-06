package com.orangeven.qiafan.app.deliverer.service;

import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.exception.UnimplementedMethodException;
import com.orangeven.qiafan.app.common.service.AbstractLoginableResourceService;
import com.orangeven.qiafan.app.deliverer.dao.DelivererDao;
import com.orangeven.qiafan.app.deliverer.model.Deliverer;

@Service
public class DelivererAuthenService extends AbstractLoginableResourceService<Deliverer, DelivererDao> {

	public DelivererAuthenService(DelivererDao dao) {
		super(dao);
	}

	@Override
	public void logOut() {
		throw new UnimplementedMethodException();
	}
}
