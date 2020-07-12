package com.zelosin.bellproject.service.provider.country;

import com.zelosin.bellproject.dao.model.Country;

import java.util.List;

/**
 * Интерфейс сервисного уровня справочника стран
 */
public interface CountryService {


    /**
     * Получение списка стран
     * @return список стран из Entity-объектов
     */
    List<Country> getCountryList();
}