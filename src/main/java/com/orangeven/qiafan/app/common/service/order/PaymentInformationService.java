package com.orangeven.qiafan.app.common.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.dao.order.PaymentInformationDao;
import com.orangeven.qiafan.app.common.model.order.PaymentInformation;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Service
public class PaymentInformationService extends AbstractOwnedResourceService<PaymentInformation, PaymentInformationDao> {

	public PaymentInformationService(PaymentInformationDao dao) {
		super(dao);
	}

	@Override
	public List<PaymentInformation> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, PaymentInformation.class);
	}

	@Override
	protected void updateFields(PaymentInformation modelInManage, PaymentInformation modelAsParameter) {
		// TODO Auto-generated method stub
		
	}

}
