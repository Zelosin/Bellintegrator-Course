package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.model.DocumentType;
import com.zelosin.bellproject.service.provider.country.CountryService;
import com.zelosin.bellproject.service.provider.document.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final CountryService countryService;
    private final DocumentService documentService;

    public MainController(CountryService countryService, DocumentService documentService) {
        this.countryService = countryService;
        this.documentService = documentService;
    }


    @GetMapping("/test")
    public String tesMethd(){
        List<DocumentType> q = documentService.getDocumentTypes();
        return "tested";
    }
}
