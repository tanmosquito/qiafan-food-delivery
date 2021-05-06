package com.orangeven.qiafan.app.common.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangeven.qiafan.app.common.controller.AbstractOwnedResourceController;
import com.orangeven.qiafan.app.common.dao.order.RefundApplicationDao;
import com.orangeven.qiafan.app.common.model.order.RefundApplication;
import com.orangeven.qiafan.app.common.service.order.RefundApplicationService;

@Controller
@RequestMapping("/refund")
public class RefundApplicationController extends AbstractOwnedResourceController<RefundApplication, RefundApplicationDao, RefundApplicationService> {

	public RefundApplicationController(RefundApplicationService service) {
		super(service);
	}

	@Override
	protected RefundApplication getInstance() {
		return new RefundApplication();
	}

}
