package com.orangeven.qiafan.app.business.dao;

import com.orangeven.qiafan.app.business.model.Merchandise;
import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;

public class MerchandiseDao extends AbstractOwnedEntityDao<Merchandise> {

	@Override
	public Merchandise find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, Merchandise.class);
	}

	@Override
	public Merchandise find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, Merchandise.class);
	}

}
