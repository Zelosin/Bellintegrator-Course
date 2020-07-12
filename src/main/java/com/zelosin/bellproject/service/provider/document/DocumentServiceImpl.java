package com.zelosin.bellproject.service.provider.document;

import com.zelosin.bellproject.dao.model.DocumentType;
import com.zelosin.bellproject.dao.repository.document.DocumentDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Получение списка стран
 * @return список стран из Entity-объектов
 */
@Service
public class DocumentServiceImpl implements DocumentService{

    private final DocumentDao documentDao;

    public DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    /**
     * Получение списка стран
     * @return список стран из Entity-объектов
     */
    @Override
    @Transactional
    public List<DocumentType> getDocumentTypes() {
        return documentDao.getDocumentTypes();
    }
}