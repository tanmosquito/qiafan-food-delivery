package com.orangeven.qiafan.app.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.business.dao.BusinessAuthenDao;
import com.orangeven.qiafan.app.business.model.Business;
import com.orangeven.qiafan.app.common.exception.UnimplementedMethodException;
import com.orangeven.qiafan.app.common.service.AbstractLoginableResourceService;

@Service
@Transactional
public class BusinessAuthenService extends AbstractLoginableResourceService<Business, BusinessAuthenDao>{

	public BusinessAuthenService(@Autowired BusinessAuthenDao dao) {
		super(dao);
	}

	@Override
	public void logOut() throws UnimplementedMethodException{
		throw new UnimplementedMethodException();
	}
}
