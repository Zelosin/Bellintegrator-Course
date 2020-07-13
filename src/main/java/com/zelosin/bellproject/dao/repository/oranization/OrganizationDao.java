package com.zelosin.bellproject.dao.repository.oranization;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.exception.InnerProgramException;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
import com.zelosin.bellproject.view.transfer.OrganizationViewTransfer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("ORG_REP")
public class OrganizationDao extends AbstractBellDao<OrganizationViewFilter, OrganizationViewTransfer, Organization> {

    protected OrganizationDao(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resolveInnerElementDependecy(Organization organization) {
        if(organization == null){
            throw new InnerProgramException( new NullPointerException());
        }
        if(organization.getBaseCountry() != null) {
            organization.setBaseCountry(getCountryByCode(organization.getBaseCountry().getCode()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization findById(int id) {
        Organization organization;
        TypedQuery<Organization> organizationTypedQuery  = entityManager.createQuery(
                "SELECT o FROM Organization o WHERE o.id=:orgId", Organization.class);
        organizationTypedQuery.setParameter("orgId", id);
        try {
            organization = organizationTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Идентификатор организации задан неверно", e);
        }
        return organization;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getList(OrganizationViewFilter organizationViewFilter) {
        if(organizationViewFilter == null){
            throw new InnerProgramException( new NullPointerException());
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organizationRoot);
        if(organizationViewFilter != null){
            Predicate filterPredicate = criteriaBuilder.equal(organizationRoot.get("name"), organizationViewFilter.getName());
            if(organizationViewFilter.getIsActive() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        organizationRoot.get("isActive"), organizationViewFilter.getIsActive()));
            }
            if(organizationViewFilter.getINN() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        organizationRoot.get("INN"), organizationViewFilter.getINN()));
            }
            criteriaQuery.where(filterPredicate);
        }
        return new ArrayList<>(entityManager.createQuery(criteriaQuery).getResultList());
    }
}