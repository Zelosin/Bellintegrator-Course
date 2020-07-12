package com.zelosin.bellproject.service.provider.document;

import com.zelosin.bellproject.dao.model.DocumentType;

import java.util.List;

/**
 * Интерфейс сервисного уровня справочника документов
 */
public interface DocumentService {

    /**
     * Получение списка документов
     * @return список документов из Entity-объектов
     */
    List<DocumentType> getDocumentTypes();
}