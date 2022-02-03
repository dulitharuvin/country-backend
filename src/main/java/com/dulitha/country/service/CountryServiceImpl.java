package com.dulitha.country.service;

import com.dulitha.country.model.Country;
import com.dulitha.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> fetchCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Page<Country> fetchAllCountries(Pageable pageable) {
        Page<Country> countries = countryRepository.findAll(pageable);
        return countries;
    }

    @Override
    public Page<Country> fetchAllCountriesByContinentId(Long continentId, Pageable pageable) {
        Page<Country> countries = countryRepository.findByContinentContinentId(continentId, pageable);
        return countries;
    }

    @Override
    public Page<Country> fetchAllCountriesByNameOrCode(String searchQuery, Pageable pageable) {
        Page<Country> countries = countryRepository.findByNameOrCode(searchQuery, pageable);
        return countries;
    }

    @Override
    public Page<Country> fetchAllCountriesByNameOrCodeAndContinentId(Long continentId, String searchQuery, Pageable pageable) {
        Page<Country> countries = countryRepository.findByNameOrCodeAndContinentId(continentId, searchQuery, pageable);
        return countries;
    }
}
