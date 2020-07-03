package com.zelosin.bellproject.dao.repository.document;

import com.zelosin.bellproject.dao.model.DocumentType;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
        return entityManager.unwrap(Session.class).createQuery("from Document").list();
    }
}
