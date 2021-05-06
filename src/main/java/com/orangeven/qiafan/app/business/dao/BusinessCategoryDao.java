package com.orangeven.qiafan.app.business.dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.orangeven.qiafan.app.business.model.BusinessCategory;
import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;

@Repository
public class BusinessCategoryDao extends AbstractOwnedEntityDao<BusinessCategory> {


    public BusinessCategory find(String name) throws NoResultException, NonUniqueResultException {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BusinessCategory> cq = builder.createQuery(BusinessCategory.class);

        Root<BusinessCategory> root = cq.from(BusinessCategory.class);
        cq.where(
                builder.equal(
                        root.get("name"),
                        name
                )
        );
        cq.select(root);

        return session.createQuery(cq).getSingleResult();
    }

	@Override
	public BusinessCategory find(long id) throws DataNotFoundException {
		return find(id, false);
	}

	@Override
	public BusinessCategory find(long id, boolean disabled) throws DataNotFoundException {
		return find(id, disabled, BusinessCategory.class);
	}


	@Override
	public BusinessCategory find(long ownerId, long id) throws DataNotFoundException {
		return super.find(ownerId, id, BusinessCategory.class);
	}


	@Override
	public BusinessCategory find(long ownerId, long id, boolean disabled) throws DataNotFoundException {
		return super.find(ownerId, id, disabled, BusinessCategory.class);
	}
}
