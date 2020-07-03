package com.zelosin.bellproject.dao.repository.template;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public abstract class AbstractBellDao<E> implements BellDao<E> {

    protected final EntityManager entityManager;

    protected AbstractBellDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void update(E e, int id) {
        Organization primeOrganization = entityManager.unwrap(Session.class).find(Organization.class, id);
        if(primeOrganization == null){
            throw new DataBaseResultException("Id задан неверно");
        }
        BeanUtils.copyProperties(e, primeOrganization, "version", "id");
    }

    @Override
    public void save(E e) {
        entityManager.unwrap(Session.class).save(e);
    }

}
