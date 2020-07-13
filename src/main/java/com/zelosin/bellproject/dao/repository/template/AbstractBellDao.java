package com.zelosin.bellproject.dao.repository.template;

import com.zelosin.bellproject.dao.model.Citizenship;
import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.model.DocumentType;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.exception.DataBaseResultException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * {@inheritDoc}
 */
@Repository
public abstract class AbstractBellDao<F, D, E> implements BellDao<F, D, E> {

    protected final EntityManager entityManager;

    protected AbstractBellDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(E e, int id) {
        if(e == null){
            throw new DataBaseResultException("rejected", new NullPointerException());
        }
        E primeE = findById(id);
        resolveInnerElementDependecy( e);
        BeanUtils.copyProperties(e, primeE, "version", "id");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(E e) {
        if(e == null){
            throw new DataBaseResultException("rejected", new NullPointerException());
        }
        resolveInnerElementDependecy(e);
        try {
            entityManager.unwrap(Session.class).save(e);
        }catch (ConstraintViolationException  exception){
            throw new DataBaseResultException("Не удалось вставить повторяющиеся значения", exception);
        }
    }


    /**
     * Получения страны по ее коду
     * @param code код страны
     * @return Entity-объект страны
     */
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

    protected Citizenship getCitizenshipByCountry(Country country){
        Citizenship citizenship;
        TypedQuery<Citizenship> citizenshipTypedQuery = entityManager.createQuery(
                "SELECT c FROM Citizenship c WHERE c.citizenedCountry=:country", Citizenship.class);
        citizenshipTypedQuery.setParameter("country", country);
        try {
            citizenship = citizenshipTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Для данной страны в базе нет гражданства", e);
        }
        return citizenship;
    }

    /**
     * Получения типа документа по его коду
     * @param code код типа документа
     * @return Entity-объект типа документа
     */
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


    /**
     * Получение офиса по его идентификатору
     * @param id идентификатор офиса
     * @return Entity-объект офиса
     */
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
}