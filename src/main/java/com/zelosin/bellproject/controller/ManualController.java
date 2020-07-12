package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.service.provider.country.CountryService;
import com.zelosin.bellproject.service.provider.document.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер-обработчик справочных-запросов
 */
@RestController
@RequestMapping("/api")
public class ManualController {

    private final CountryService countryService;
    private final DocumentService documentService;

    public ManualController(CountryService countryService, DocumentService documentService) {
        this.countryService = countryService;
        this.documentService = documentService;
    }

    /**
     * Получение списка типа документво
     * @return  список типов документов
     */
    @PostMapping("/docs")
    public Object provideDocumentTypesList(){
        return documentService.getDocumentTypes();
    }

    /**
     * Получение списка стран
     * @return  список стран
     */
    @GetMapping("/countries")
    public Object provideCountryList(){
        return countryService.getCountryList();
    }
}