package com.zelosin.bellproject.dao.repository.document;

import com.zelosin.bellproject.dao.model.DocumentType;
import java.util.List;

/**
 * DAO для работы с документами
 */
public interface DocumentDao {

    /**
     * Получение списка всех типов документов
     * @return коллекция типа List со всеми странами
     */
    List<DocumentType> getDocumentTypes();
}