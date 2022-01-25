package com.dulitha.country.service;

import com.dulitha.country.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    Country save(Long continentId, Country country);

    Country fetchCountryById(Long id);

    Page<Country> fetchAllCountries(Pageable pageable);

    Page<Country> fetchAllCountriesByContinentId(Long preschoolId, Pageable pageable);
}
