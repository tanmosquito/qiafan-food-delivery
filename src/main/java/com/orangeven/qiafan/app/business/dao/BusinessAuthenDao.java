package com.orangeven.qiafan.app.business.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.business.model.Business;
import com.orangeven.qiafan.app.common.dao.AbstractLoginableEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;

@Repository
public class BusinessAuthenDao extends AbstractLoginableEntityDao<Business> {

	@Override
	public Business find(String account) throws DataNotFoundException {
		return super.find(account, Business.class);
	}

}
