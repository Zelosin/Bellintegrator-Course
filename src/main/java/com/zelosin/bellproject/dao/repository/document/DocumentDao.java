package com.zelosin.bellproject.dao.repository.document;

import com.zelosin.bellproject.dao.model.DocumentType;

import java.util.List;

public interface DocumentDao {

    List<DocumentType> getDocumentTypes();

}
