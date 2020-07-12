package com.zelosin.bellproject.service.provider.country;

import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.repository.country.CountryDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Country> getCountryList() {
        return countryDao.getCountryList();
    }
}