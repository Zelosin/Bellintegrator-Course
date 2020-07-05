package com.zelosin.bellproject.dao.repository.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.view.OfficeView;
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

@Repository("OFC_REP")
public class OfficeDao extends AbstractBellDao<OfficeView, Office> {
    protected OfficeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void resolveInnerElementDependecy(Office office) {
        if(office.getBaseCountry() != null) {
            office.setBaseCountry(getCountryByCode(office.getBaseCountry().getCode()));
        }
        Organization organization;
        TypedQuery<Organization> organizationTypedQuery = entityManager.createQuery(
                "SELECT o FROM Organization o WHERE o.id=:orgID", Organization.class);
        organizationTypedQuery.setParameter("orgID", office.getOrganization().getId());
        try {
            organization = organizationTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Идентификатор организации задан неверно", e);
        }
        office.setOrganization(organization);
    }

    @Override
    public Office findById(int id) {
        return findOfficeById(id);
    }

    @Override
    public List<Office> getList(OfficeView officeView) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> OfficeRoot = criteriaQuery.from(Office.class);
        criteriaQuery.select(OfficeRoot);
        if(officeView != null){
            Predicate filterPredicate = criteriaBuilder.equal(OfficeRoot.get("organization").get("id"), officeView.getOrgId());
            if(officeView.getPhone() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        OfficeRoot.get("phone"), officeView.getPhone()));
            }
            if(officeView.getName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        OfficeRoot.get("name"), officeView.getName()));
            }
            if(officeView.getIsActive() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        OfficeRoot.get("isActive"), officeView.getIsActive()));
            }
            criteriaQuery.where(filterPredicate);
        }
        return new ArrayList<>(entityManager.createQuery(criteriaQuery).getResultList());
    }

}
