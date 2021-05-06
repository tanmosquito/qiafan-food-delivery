package com.orangeven.qiafan.app.common.dao.order;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.order.Order;

@Repository
public class OrderDao extends AbstractOwnedEntityDao<Order> {

	@Override
	public Order find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, Order.class);
	}

	@Override
	public Order find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, Order.class);
	}

}
