package com.zelosin.bellproject.dao.repository.document;

import com.zelosin.bellproject.dao.model.DocumentType;
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
        return entityManager.createQuery("SELECT d FROM DocumentType d", DocumentType.class).getResultList();
    }
}