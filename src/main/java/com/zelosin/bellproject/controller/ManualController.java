package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.service.provider.country.CountryService;
import com.zelosin.bellproject.service.provider.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ManualController {

    @Autowired
    private EntityManager entityManager;

    private final CountryService countryService;
    private final DocumentService documentService;

    public ManualController(CountryService countryService, DocumentService documentService) {
        this.countryService = countryService;
        this.documentService = documentService;
    }

    @PostMapping("/docs")
    public Map provideDocumentTypesList(){
        return Collections.singletonMap("data", documentService.getDocumentTypes());
    }

    @GetMapping("/countries")
    public Map provideCountryList(){
        return Collections.singletonMap("data", countryService.getCountryList());
    }
}
