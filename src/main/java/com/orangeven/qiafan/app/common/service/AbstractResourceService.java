package com.orangeven.qiafan.app.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orangeven.qiafan.app.common.dao.AbstractEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataExistsException;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractEntityModel;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

@Transactional
public abstract class AbstractResourceService<E extends AbstractEntityModel, T extends AbstractEntityDao<E>> {
	public AbstractResourceService(T dao) {
		this.dao = dao;
	}
	
    public void create(E entity) throws ResourceExistsException {
        try {
            dao.create(entity);
        } catch (DataExistsException e) {
            throw new ResourceExistsException(this.alreadyExistMessage);
        }
    }

    public void update(E entity) throws ResourceNotFoundException {
        E entityInManage = findById(entity.getId());
        updateFields(entityInManage, entity);
        dao.update(entityInManage);
    }
    
    protected abstract void updateFields(E entityInManage, E entityAsParameter);

    @Transactional(readOnly = true)
    public E findById(long id) throws ResourceNotFoundException {
        try {
            return dao.find(id);
        } catch (DataNotFoundException nf) {
            throw new ResourceNotFoundException(this.notFoundMessage);
        }
    }

    @Transactional(readOnly = true)
    protected List<E> findRange(long from, int size, Class<E> cls)
            throws ResourceSetSizeTooLargeException, ResourceNotFoundException {
        if(size > RESOURCE_SET_SIZE_LIMIT) {
            throw new ResourceSetSizeTooLargeException(this.setSizeTooLargeMessage);
        } else {
            try {
                return dao.findRange(from, size, cls);
            } catch (DataNotFoundException nf) {
                throw new ResourceNotFoundException(this.notFoundMessage);
            }
        }
    }
    
    @Transactional(readOnly = true)
    public abstract List<E> findRange(long from, int size)
        throws ResourceSetSizeTooLargeException, ResourceNotFoundException;

    public void delete(long id) throws ResourceNotFoundException {
        try {
            dao.destroy(id);
        }catch (DataNotFoundException nf) {
            throw new ResourceNotFoundException();
        }

    }

    protected T dao;
    protected final static int RESOURCE_SET_SIZE_LIMIT = 100;
    
    protected String notFoundMessage = "找不到资源";
    protected String alreadyExistMessage = "资源已经存在";
    protected String setSizeTooLargeMessage = "数据量太大";
}
