package com.orangeven.qiafan.app.common.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangeven.qiafan.app.common.dao.exception.DataExistsException;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractEntityModel;

public abstract class AbstractDao<E extends AbstractEntityModel> {
	
	public void create(E model) throws DataExistsException {
        if(isDataExists(model)) {
            throw new DataExistsException();
        } else {
            Session session = getSession();
            session.save(model);
        }
    }

    public void destroy(long id) throws DataNotFoundException{
        E entity = find(id);
        entity.setDisabled(true);
        update(entity);
    }

    public void update(E entity) {
        Session session = getSession();
        session.update(entity);
    }
    
    public abstract E find(long id) throws DataNotFoundException;
    protected abstract boolean isDataExists(E entity);

	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    protected EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }
    @Autowired
    private SessionFactory sessionFactory;
}
