package com.zelosin.bellproject.dao.repository.oranization;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import com.zelosin.bellproject.view.OrganizationView;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("ORG_REP")
public class OrganizationDao extends AbstractBellDao<OrganizationView, Organization> {

    protected OrganizationDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void resolveInnerElementDependecy(Organization organization) {
        if(organization.getBaseCountry() != null) {
            organization.setBaseCountry(getCountryByCode(organization.getBaseCountry().getCode()));
        }
    }

    @Override
    public Organization findById(int id) {
        return entityManager.unwrap(Session.class).find(Organization.class, id);
    }

    @Override
    public List<Organization> getList(OrganizationView organizationView) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organizationRoot);
        if(organizationView != null){
            Predicate filterPredicate = criteriaBuilder.equal(organizationRoot.get("name"), organizationView.getName());
            if(organizationView.getIsActive() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        organizationRoot.get("isActive"), organizationView.getIsActive()));
            }
            if(organizationView.getINN() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        organizationRoot.get("INN"), organizationView.getINN()));
            }
            criteriaQuery.where(filterPredicate);
        }
        return new ArrayList<>(entityManager.createQuery(criteriaQuery).getResultList());
    }
}















