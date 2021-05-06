package com.orangeven.qiafan.app.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataExistsException;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Transactional
public abstract class AbstractOwnedResourceService<M extends AbstractOwnedEntityModel, D extends AbstractOwnedEntityDao<M>>{

	public AbstractOwnedResourceService(D dao) {
		this.dao = dao;
	}
	
	public void create(long ownerId, M model)
			throws ResourceExistsException{
		try {
			model.setOwnerId(ownerId);
			dao.create(model);
		} catch (DataExistsException e) {
			throw new ResourceExistsException(this.alreadyExistMessage);
		}
		
	}
	
	public void update(long ownerId, M model) {}
	public void delete(long ownerId, long id) throws ResourceNotFoundException {
		M m = findById(ownerId, id);
		m.setDisabled(true);
		update(ownerId, m);
	}
	
	@Transactional(readOnly = true)
	public M findById(long ownerId, long id) throws ResourceNotFoundException {
		try {
			return dao.find(ownerId, id);
		} catch (DataNotFoundException e) {
			throw new ResourceNotFoundException(this.notFoundMessage);
		}
	}
	
	@Transactional(readOnly = true)
	protected List<M> findRange(long ownerId, long from, int size, Class<M> cls) 
			throws ResourceNotFoundException, ResourceSetSizeTooLargeException{
			if(size > RESOURCE_SET_SIZE_LIMIT) {
				throw new ResourceSetSizeTooLargeException(this.setSizeTooLargeMessage);
			} else {
				try {
					return dao.findRange(ownerId, from, size, cls);
				} catch (DataNotFoundException nf) {
					throw new ResourceNotFoundException(this.notFoundMessage);
				}
			}
	}
	
	@Transactional(readOnly = true)
	public abstract List<M> findRange(long ownerId, long from, int size) throws ResourceNotFoundException, ResourceSetSizeTooLargeException;
	protected abstract void updateFields(M modelInManage, M modelAsParameter);


	protected D dao;
	protected final static int RESOURCE_SET_SIZE_LIMIT = 100;
	
	protected String notFoundMessage = "找不到资源";
    protected String alreadyExistMessage = "资源已经存在";
    protected String setSizeTooLargeMessage = "数据量太大";
}
