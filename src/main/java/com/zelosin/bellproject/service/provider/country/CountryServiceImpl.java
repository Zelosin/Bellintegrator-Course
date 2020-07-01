package com.zelosin.bellproject.service.provider.country;

import com.zelosin.bellproject.dao.repository.country.CountryDao;
import com.zelosin.bellproject.dao.model.Country;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }


    @Override
    @Transactional
    public List<Country> getCountryList() {
        return countryDao.getCountryList();
    }

}
