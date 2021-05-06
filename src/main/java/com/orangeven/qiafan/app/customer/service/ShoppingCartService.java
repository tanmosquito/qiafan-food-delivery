package com.orangeven.qiafan.app.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;
import com.orangeven.qiafan.app.customer.dao.ShoppingCartDao;
import com.orangeven.qiafan.app.customer.model.ShoppingCartItem;

@Service
public class ShoppingCartService extends AbstractOwnedResourceService<ShoppingCartItem, ShoppingCartDao> {

	public ShoppingCartService(ShoppingCartDao dao) {
		super(dao);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShoppingCartItem> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, ShoppingCartItem.class);
	}

	@Override
	protected void updateFields(ShoppingCartItem modelInManage, ShoppingCartItem modelAsParameter) {
		modelInManage.setMechandiseId(modelAsParameter.getMerchandiseSegmentId());
		modelInManage.setMerchandiseName(modelAsParameter.getMerchandiseName());
	}

}
