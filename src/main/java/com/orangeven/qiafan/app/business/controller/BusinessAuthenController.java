package com.orangeven.qiafan.app.business.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangeven.qiafan.app.business.dao.BusinessAuthenDao;
import com.orangeven.qiafan.app.business.model.Business;
import com.orangeven.qiafan.app.business.service.BusinessAuthenService;
import com.orangeven.qiafan.app.common.controller.AbstractAuthenController;
import com.orangeven.qiafan.app.common.controller.exception.NotLoggedInException;
import com.orangeven.qiafan.app.common.exception.UnimplementedMethodException;

@RestController
@RequestMapping("/api/business/authen")
public class BusinessAuthenController extends AbstractAuthenController<Business, BusinessAuthenDao, BusinessAuthenService>{

	public BusinessAuthenController(@Autowired BusinessAuthenService service) {
		super(service);
	}
	@Override
	@ModelAttribute
	protected Business getInstance() {
		return new Business();
	}
	@Override
	public ResponseEntity<Business> logOut(HttpSession session) throws NotLoggedInException {
		throw new UnimplementedMethodException();
	}
}
