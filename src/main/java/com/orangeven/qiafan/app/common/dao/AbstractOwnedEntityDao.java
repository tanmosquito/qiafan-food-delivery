package com.orangeven.qiafan.app.common.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

public abstract class AbstractOwnedEntityDao<E extends AbstractOwnedEntityModel> extends AbstractEntityDao<E>{
	
	public E find(long ownerId, long id) throws DataNotFoundException {
		return this.find(ownerId, id, false);
	}
	public abstract E find(long ownerId, long id, boolean disabled) throws DataNotFoundException;
	
	public void destroy(E model) throws DataNotFoundException {
		E m = find(model.getOwnerId(), model.getId());
		m.setDisabled(true);
		update(model);
	}

	public List<E> findRange(long ownerId, long from, int size, Class<E> cls) throws DataNotFoundException {
        Session session = getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(cb.greaterThanOrEqualTo(root.<Long>get("ownerId"), ownerId));
        cq.select(root);

        List<E> res = session.createQuery(cq).getResultList();
        if(res.size() == 0) {
            throw new DataNotFoundException();
        } else {
            return res;
        }
    }

	public List<E> findRange(long ownerId, long from, int size, boolean disabled, Class<E> cls) throws DataNotFoundException{
		Session session = this.getSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<E> cq = builder.createQuery(cls);
		
		Root<E> root = cq.from(cls);
		cq.where(
				builder.and(
						builder.greaterThanOrEqualTo(root.<Long>get("id"), from),
						builder.equal(root.get("ownerId"), ownerId),
						builder.equal(root.get("disabled"), disabled)
						)
				);
		cq.select(root);
		
		List<E> res = session.createQuery(cq).setFetchSize(size).getResultList();
		
		if(res.size() == 0) {
			throw new DataNotFoundException();
		} else {
			return res;
		}
	}
	
	protected E find(long ownerId, long modelId, Class<E> cls) throws DataNotFoundException {
		return this.find(ownerId, modelId, false, cls);
	}
	
	protected E find(long ownerId, long modelId, boolean disabled, Class<E> cls) throws DataNotFoundException {
		Session session = this.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(cls);

        Root<E> root = cq.from(cls);
        cq.where(
                builder.and(
                        builder.equal(root.<Long>get("id"), modelId),
                        builder.equal(root.get("ownerId"), ownerId),
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
}
