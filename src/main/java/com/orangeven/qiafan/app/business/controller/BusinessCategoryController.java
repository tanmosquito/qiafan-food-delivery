package com.orangeven.qiafan.app.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangeven.qiafan.app.business.dao.BusinessCategoryDao;
import com.orangeven.qiafan.app.business.model.BusinessCategory;
import com.orangeven.qiafan.app.business.service.BusinessCategoryService;
import com.orangeven.qiafan.app.common.controller.AbstractOwnedResourceController;

@Controller
@RequestMapping("/business/categories")
public class BusinessCategoryController
		extends AbstractOwnedResourceController<BusinessCategory,BusinessCategoryDao,BusinessCategoryService>{

	public BusinessCategoryController(@Autowired BusinessCategoryService service) {
		super(service);
	}

	@Override
	protected BusinessCategory getInstance() {
		return new BusinessCategory();
	}
}
