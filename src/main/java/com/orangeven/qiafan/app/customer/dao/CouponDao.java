package com.orangeven.qiafan.app.customer.dao;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.customer.model.Coupon;

@Repository
public class CouponDao extends AbstractOwnedEntityDao<Coupon> {

	@Override
	public Coupon find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, Coupon.class);
	}

	@Override
	public Coupon find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, disabled, Coupon.class);
	}

}
