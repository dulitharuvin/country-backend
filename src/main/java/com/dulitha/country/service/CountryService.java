package com.dulitha.country.service;

import com.dulitha.country.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CountryService {

    Country save(Country country);

    Optional<Country> fetchCountryById(Long id);

    Page<Country> fetchAllCountries(Pageable pageable);

    Page<Country> fetchAllCountriesByContinentId(Long continentId, Pageable pageable);

    Page<Country> fetchAllCountriesByNameOrCode(String searchQuery, Pageable pageable);

    Page<Country> fetchAllCountriesByNameOrCodeAndContinentId(Long continentId, String searchQuery, Pageable pageable);
}
