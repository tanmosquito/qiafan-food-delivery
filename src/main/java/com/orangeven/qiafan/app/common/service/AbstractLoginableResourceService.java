package com.orangeven.qiafan.app.common.service;

import javax.transaction.Transactional;

import com.orangeven.qiafan.app.common.dao.AbstractLoginableEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataExistsException;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;
import com.orangeven.qiafan.app.common.service.exception.AuthenFailedException;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;

public abstract class AbstractLoginableResourceService<E extends AbstractLoginableEntityModel, D extends AbstractLoginableEntityDao<E>> {

	public AbstractLoginableResourceService(D dao) {
		this.dao = dao;
	}
	
	@Transactional
	public Long signIn(E entity) throws ResourceNotFoundException, AuthenFailedException {
		try {
			E e = dao.find(entity.getAccount());
			if(entity.getPassword().equals(e.getPassword())) {
				return e.getId();
			} else {
				throw new AuthenFailedException(AbstractLoginableResourceService.AUTHEN_FAILED_MSG);
			}
		} catch (DataNotFoundException e) {
			throw new ResourceNotFoundException(AbstractLoginableResourceService.NOT_REGISTER_YET_MSG);
		}
	}
	
	@Transactional
	public void signUp(E entity) throws ResourceExistsException {
		try {
			dao.create(entity);
		} catch (DataExistsException e) {
			throw new ResourceExistsException(USER_EXISTS_MSG);
		}
	}
	
	@Transactional
	public abstract void logOut();
	
	private D dao;

	private final static String NOT_REGISTER_YET_MSG = "您尚未注册！";
	private final static String AUTHEN_FAILED_MSG = "您的用户名或密码有误！";
	private final static String USER_EXISTS_MSG = "用户已经存在！";
}
