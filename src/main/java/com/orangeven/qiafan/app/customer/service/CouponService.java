package com.orangeven.qiafan.app.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;
import com.orangeven.qiafan.app.customer.dao.CouponDao;
import com.orangeven.qiafan.app.customer.model.Coupon;

@Service
public class CouponService extends AbstractOwnedResourceService<Coupon, CouponDao> {

	public CouponService(CouponDao dao) {
		super(dao);
	}

	@Override
	public List<Coupon> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, Coupon.class);
	}

	@Override
	protected void updateFields(Coupon modelInManage, Coupon modelAsParameter) {
		// TODO Auto-generated method stub
		
	}

}
