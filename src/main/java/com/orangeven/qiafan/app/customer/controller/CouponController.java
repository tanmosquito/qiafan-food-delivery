package com.orangeven.qiafan.app.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangeven.qiafan.app.common.controller.AbstractOwnedResourceController;
import com.orangeven.qiafan.app.customer.dao.CouponDao;
import com.orangeven.qiafan.app.customer.model.Coupon;
import com.orangeven.qiafan.app.customer.service.CouponService;

@Controller
@RequestMapping("/customer/coupons")
public class CouponController extends AbstractOwnedResourceController<Coupon, CouponDao, CouponService> {

	public CouponController(CouponService service) {
		super(service);
	}

	@Override
	protected Coupon getInstance() {
		return new Coupon();
	}

}
