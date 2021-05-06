package com.orangeven.qiafan.app.common.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangeven.qiafan.app.common.controller.AbstractOwnedResourceController;
import com.orangeven.qiafan.app.common.dao.order.OrderDao;
import com.orangeven.qiafan.app.common.model.order.Order;
import com.orangeven.qiafan.app.common.model.order.OrderFoodItem;
import com.orangeven.qiafan.app.common.service.order.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController extends AbstractOwnedResourceController<Order, OrderDao, OrderService>{

	public OrderController(@Autowired OrderService service) {
		super(service);
	}
	
	@PostMapping("/refund")
	public void refund(OrderFoodItem item) {
		// create refund application first
		// then set the refund state
	}

	@Override
	protected Order getInstance() {
		return new Order();
	}
}