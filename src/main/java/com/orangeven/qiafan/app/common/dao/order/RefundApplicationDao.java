package com.orangeven.qiafan.app.common.dao.order;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.order.RefundApplication;

@Repository
public class RefundApplicationDao extends AbstractOwnedEntityDao<RefundApplication> {

	@Override
	public RefundApplication find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, RefundApplication.class);
	}

	@Override
	public RefundApplication find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, RefundApplication.class);
	}

}
