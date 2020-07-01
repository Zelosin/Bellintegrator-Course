package com.zelosin.bellproject.service.provider.document;

import com.zelosin.bellproject.dao.model.Document;
import com.zelosin.bellproject.dao.model.DocumentType;

import java.util.List;

public interface DocumentService {

    List<DocumentType> getDocumentTypes();

}
