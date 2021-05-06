package com.orangeven.qiafan.app.deliverer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractLoginableEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.deliverer.model.Deliverer;

@Repository
public class DelivererDao extends AbstractLoginableEntityDao<Deliverer> {

	@Override
	public Deliverer find(long id, boolean disabled) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deliverer find(String account) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
