package com.zelosin.bellproject.dao.repository.template;

import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.model.DocumentType;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.exception.DataBaseResultException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public abstract class AbstractBellDao<F, D, E> implements BellDao<F, D, E> {

    protected final EntityManager entityManager;

    protected AbstractBellDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void update(E e, int id) {
        E primeE = findById(id);
        resolveInnerElementDependecy( e);
        BeanUtils.copyProperties(e, primeE, "version", "id");
    }

    @Override
    public void save(E e) {
        resolveInnerElementDependecy(e);
        try {
            entityManager.unwrap(Session.class).save(e);
        }catch (ConstraintViolationException  exception){
            throw new DataBaseResultException("Не удалось вставить повторяющиеся значения", exception);
        }
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

    protected DocumentType getDocumentTypeByCode(int code){
        DocumentType documentType;
        TypedQuery<DocumentType> documentTypeTypedQuery = entityManager.createQuery("SELECT d FROM DocumentType d WHERE d.code=:documentCode", DocumentType.class);
        documentTypeTypedQuery.setParameter("documentCode", code);
        try {
            documentType = documentTypeTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Указан несуществующий код документа", e);
        }
        return documentType;
    }

    protected Office findOfficeById(int id){
        Office office;
        TypedQuery<Office> officeTypedQuery  = entityManager.createQuery(
                "SELECT o FROM Office o WHERE o.id=:ofcId", Office.class);
        officeTypedQuery.setParameter("ofcId", id);
        try {
            office = officeTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Идентификатор офиса задан неверно", e);
        }
        return office;
    }

    @Override
    public abstract void resolveInnerElementDependecy(E e);

    @Override
    public abstract E findById(int id);

    @Override
    public abstract List<E> getList(F f);
}
