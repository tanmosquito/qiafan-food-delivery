package com.orangeven.qiafan.app.common.dao.order;

import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.order.PaymentInformation;

@Repository
public class PaymentInformationDao extends AbstractOwnedEntityDao<PaymentInformation>{

	@Override
	public PaymentInformation find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, PaymentInformation.class);
	}

	@Override
	public PaymentInformation find(long id, boolean disabled) throws DataNotFoundException {
		return super.find(id, PaymentInformation.class);
	}

	@Override
	public PaymentInformation find(long id) throws DataNotFoundException {
		return super.find(id, PaymentInformation.class);
	}

}
