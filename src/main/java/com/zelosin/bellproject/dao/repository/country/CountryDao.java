package com.zelosin.bellproject.dao.repository.country;

import com.zelosin.bellproject.dao.model.Country;

import java.util.List;


/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     * Получить список всех стран
     * @return - коллекция типа List со всеми странами
     */
    List<Country> getCountryList();

}
