package com.orangeven.qiafan.app.deliverer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangeven.qiafan.app.common.controller.AbstractAuthenController;
import com.orangeven.qiafan.app.common.controller.exception.NotLoggedInException;
import com.orangeven.qiafan.app.deliverer.dao.DelivererDao;
import com.orangeven.qiafan.app.deliverer.model.Deliverer;
import com.orangeven.qiafan.app.deliverer.service.DelivererAuthenService;

@Controller
@RequestMapping("/deliverer")
public class AuthenController extends AbstractAuthenController<Deliverer, DelivererDao, DelivererAuthenService> {

	public AuthenController(DelivererAuthenService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Deliverer getInstance() {
		return new Deliverer();
	}

	@Override
	public ResponseEntity<Deliverer> logOut(HttpSession session) throws NotLoggedInException {
		// TODO Auto-generated method stub
		return null;
	}
}
