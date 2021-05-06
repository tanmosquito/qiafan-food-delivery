package com.orangeven.qiafan.app.business.dao;

import com.orangeven.qiafan.app.business.model.Business;
import com.orangeven.qiafan.app.common.dao.AbstractEntityDao;
import com.orangeven.qiafan.app.common.dao.exception.DataNotFoundException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BusinessDao extends AbstractEntityDao<Business> {

    public Business find(Business entity) throws NoResultException {
        Session session = this.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Business> cq = builder.createQuery(Business.class);

        Root<Business> root = cq.from(Business.class);
        cq.where(
                builder.and(
                        builder.or(
                                builder.equal(root.get("account"), entity.getAccount()),
                                builder.equal(root.get("phone"), entity.getPhone())
                        ),
                        builder.equal(root.get("disabled"), false)
                )
        );
        cq.select(root);

        return session.createQuery(cq).getSingleResult();
    }

    public List<Business> find(long from, int size) throws DataNotFoundException{
        Session session = this.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Business> cq = builder.createQuery(Business.class);

        Root<Business> root = cq.from(Business.class);
        cq.where(builder.gt(root.<Number>get("id"),from));
        cq.select(root);

        List<Business> results;
        if(size == 0) {
            results = session.createQuery(cq)
                    .getResultList();
        } else {
            results = session.createQuery(cq)
                    .setFetchSize(size)
                    .getResultList();
        }

        if(results.size() == 0) {
            throw new DataNotFoundException();
        } else {
            return results;
        }
    }

    public Business find(long id) throws DataNotFoundException {
        return this.find(id, Business.class);
    }
    public Business find(long id, boolean disabled) throws DataNotFoundException {
        return this.find(id, disabled, Business.class);
    }

    @Override
    protected boolean isDataExists(Business business) {
        Session session = getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<Business> root = cq.from(Business.class);
        cq.where(
                cb.or(
                        cb.equal(root.get("account"), business.getAccount()),
                        cb.equal(root.get("phone"), business.getPhone()),
                        cb.equal(root.<String>get("businessName"), business.getBusinessName())
                )
        );
        cq.select(cb.count(cq.from(Business.class)));

        Long res = session.createQuery(cq).getSingleResult();
        if (res != 0) {
            return true;
        } else {
            return false;
        }
    }
}// end of BusinessDao
