package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.dao.model.Document;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.service.provider.country.CountryService;
import com.zelosin.bellproject.service.provider.document.DocumentService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public String testMeth(){
        Organization o = entityManager.unwrap(Session.class).find(Organization.class, 1);
        return o.getFullName();
    }

    @PostMapping("/docs")
    public Map provideDocumentTypesList(){
        return Collections.singletonMap("data", documentService.getDocumentTypes());
    }

    @PostMapping("/countries")
    public Map provideCountryList(){
        return Collections.singletonMap("data", countryService.getCountryList());
    }
}
