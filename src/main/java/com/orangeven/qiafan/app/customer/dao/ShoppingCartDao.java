package com.orangeven.qiafan.app.customer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.customer.model.ShoppingCartItem;

@Repository
public class ShoppingCartDao extends AbstractOwnedEntityDao<ShoppingCartItem> {

	@Override
	public ShoppingCartItem find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, ShoppingCartItem.class);
	}

	@Override
	public ShoppingCartItem find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, ShoppingCartItem.class);
	}

}
