package com.zelosin.bellproject.dao.repository.template;

import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.exception.DataBaseResultException;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public abstract class AbstractBellDao<D, E> implements BellDao<D, E> {

    protected final EntityManager entityManager;

    protected AbstractBellDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void update(E e, int id) {
        E primeE = findById(id);
        resolveInnerElementDependecy(e);
        BeanUtils.copyProperties(e, primeE, "version", "id");
    }

    @Override
    public void save(E e) {
        resolveInnerElementDependecy(e);
        entityManager.unwrap(Session.class).save(e);
    }

    protected Country getCountryByCode(int code){
        Country country;
        TypedQuery<Country> countryTypedQuery = entityManager.createQuery("SELECT c FROM Country c WHERE c.code=:countryCode", Country.class);
        countryTypedQuery.setParameter("countryCode", code);
        try {
            country = countryTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Указан несуществующий код страны", e);
        }
        return country;
    }
}
