package com.zelosin.bellproject.dao.repository.country;

import com.zelosin.bellproject.dao.model.Country;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class CountryDaoImpl implements CountryDao{

    private final EntityManager entityManager;

    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getCountryList() {
        return entityManager.unwrap(Session.class).createQuery("from Country").list();
    }
}
