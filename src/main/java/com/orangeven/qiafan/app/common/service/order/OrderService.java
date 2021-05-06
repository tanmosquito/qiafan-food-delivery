package com.orangeven.qiafan.app.common.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.dao.order.OrderDao;
import com.orangeven.qiafan.app.common.model.order.Order;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Service
public class OrderService extends AbstractOwnedResourceService<Order, OrderDao> {

	public OrderService(@Autowired OrderDao dao) {
		super(dao);
	}

	@Override
	public List<Order> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, Order.class);
	}

	@Override
	protected void updateFields(Order modelInManage, Order modelAsParameter) {
		// TODO Auto-generated method stub
		
	}

}
