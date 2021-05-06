package com.orangeven.qiafan.app.common.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.common.dao.order.RefundApplicationDao;
import com.orangeven.qiafan.app.common.model.order.RefundApplication;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Service
public class RefundApplicationService extends AbstractOwnedResourceService<RefundApplication, RefundApplicationDao> {

	public RefundApplicationService(RefundApplicationDao dao) {
		super(dao);
	}

	@Override
	public List<RefundApplication> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, RefundApplication.class);
	}


	@Override
	protected void updateFields(RefundApplication modelInManage, RefundApplication modelAsParameter) {
		// TODO Auto-generated method stub
		
	}

}
