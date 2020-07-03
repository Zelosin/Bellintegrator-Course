package com.zelosin.bellproject.dao.repository.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository("OFC_REP")
public class OfficeDao extends AbstractBellDao<Office> {
    protected OfficeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Office findById(int id) {
        return entityManager.unwrap(Session.class).find(Office.class, id);
    }

    @Override
    public List<Office> getList() {
        return new ArrayList<>(entityManager.unwrap(Session.class).createQuery("from Organization").list());
    }
}
