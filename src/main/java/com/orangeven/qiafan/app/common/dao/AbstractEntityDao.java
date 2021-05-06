package com.orangeven.qiafan.app.common.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractEntityModel;

abstract public class AbstractEntityDao<E extends AbstractEntityModel> extends AbstractDao<E>{
	abstract public E find(long id, boolean disabled) throws DataNotFoundException;
	
	public E find(long id) throws DataNotFoundException {
		return this.find(id, false);
	}

    protected E find(long id, Class<E> cls) throws DataNotFoundException{
        return find(id, false, cls);
    }

    protected E find(long id, boolean disabled, Class<E> cls)
        throws DataNotFoundException{
        Session session = this.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(
                builder.and(
                        builder.equal(root.get("id"),id),
                        builder.equal(root.get("disabled"), disabled)
                )
        );
        cq.select(root);

        try {
            return session.createQuery(cq).getSingleResult();
        } catch (NoResultException no) {
            // only need to catch NoResultException here
            // because database is responsible for guaranteeing the uniqueness
            throw new DataNotFoundException();
        }
    }

    protected List<E> findByColumn(String columnName, Object targetValue, Class<E> cls) throws DataNotFoundException {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(
                builder.equal(root.get(columnName),targetValue)
        );
        cq.select(root);

        List<E> results = session.createQuery(cq).getResultList();
        if(results.size() == 0) {
            throw new DataNotFoundException();
        } else {
            return results;
        }
    }

    public List<E> findRange(long from, int size, Class<E> cls) throws DataNotFoundException {
        Session session = getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(cb.greaterThanOrEqualTo(root.<Long>get("id"), from));
        cq.select(root);

        List<E> res = session.createQuery(cq).setFetchSize(size).getResultList();
        if(res.size() == 0) {
            throw new DataNotFoundException();
        } else {
            return res;
        }
    }

    public List<E> findRange(long from, int size, boolean disabled, Class<E> cls) throws DataNotFoundException {
        Session session = getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(
        		cb.greaterThanOrEqualTo(root.<Long>get("id"), from),
                cb.equal(root.get("disabled"), disabled)
        );
        cq.select(root);

        List<E> res = session.createQuery(cq).setFetchSize(size).getResultList();
        if(res.size() == 0) {
            throw new DataNotFoundException();
        } else {
            return res;
        }
    }

    protected boolean isDataExists(E entity) {
        return false;
    }
}
