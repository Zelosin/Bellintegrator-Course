package com.zelosin.bellproject.dao.repository.document;

import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.model.DocumentType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    public DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentType> getDocumentTypes() {
        List<DocumentType> returningCollection = new ArrayList<>();
        TypedQuery<DocumentType> query = entityManager
                .createQuery("SELECT dt FROM DocumentType dt", DocumentType.class);
        if(query != null){
            returningCollection = query.getResultList();
        }
        return returningCollection;
    }
}
