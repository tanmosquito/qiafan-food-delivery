package com.orangeven.qiafan.app.common.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;

import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import com.orangeven.qiafan.app.common.exception.UnimplementedMethodException;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;

public abstract class AbstractLoginableEntityDao<E extends AbstractLoginableEntityModel> extends AbstractEntityDao<E> {

	public abstract E find(String account) throws DataNotFoundException;
	
	protected E find(String account, Class<E> cls) throws DataNotFoundException {
		Session session = this.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<E> cq = builder.createQuery(cls);
		
		Root<E> root = cq.from(cls);
		cq.where(
				builder.equal(root.get("account"), account)
		);
		cq.select(root);
		
		try {
			return session.createQuery(cq).getSingleResult();
		} catch(NoResultException no) {
			throw new DataNotFoundException();
		}
		
	}
	
	@Override
	public E find(long id, boolean disabled) throws DataNotFoundException {
		throw new UnimplementedMethodException();
	}
}
