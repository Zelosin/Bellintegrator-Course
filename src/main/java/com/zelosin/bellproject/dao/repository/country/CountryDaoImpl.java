package com.zelosin.bellproject.dao.repository.country;

import com.zelosin.bellproject.dao.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao{

    private final EntityManager entityManager;

    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Country> getCountryList() {
        List<Country> returningCollection = new ArrayList<>();
        TypedQuery<Country> query = entityManager
                .createQuery("SELECT c FROM Country c", Country.class);
        if(query != null){
            returningCollection = query.getResultList();
        }
        return returningCollection;
    }
}
