package com.orangeven.qiafan.app.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeven.qiafan.app.business.dao.BusinessCategoryDao;
import com.orangeven.qiafan.app.business.model.BusinessCategory;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Service
@Transactional
public class BusinessCategoryService extends AbstractOwnedResourceService<BusinessCategory, BusinessCategoryDao> {

    public BusinessCategoryService(@Autowired BusinessCategoryDao dao) {
    	super(dao);
    }

	@Override
	protected void updateFields(BusinessCategory entityInManage, BusinessCategory entityAsParameter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BusinessCategory> findRange(long ownerId, long from, int size)
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException {
		return super.findRange(ownerId, from, size, BusinessCategory.class);
	}

}
