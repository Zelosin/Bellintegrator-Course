package com.zelosin.bellproject.dao.repository.oranization;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository("ORG_REP")
public class OrganizationDao extends AbstractBellDao<Organization> {

    protected OrganizationDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Organization findById(int id) {
        return entityManager.unwrap(Session.class).find(Organization.class, id);
    }

    @Override
    public List<Organization> getList() {
        return new ArrayList<>(entityManager.unwrap(Session.class).createQuery("from Organization").list());
    }
}
