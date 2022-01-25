package com.dulitha.country.service;

import com.dulitha.country.model.Country;
import com.dulitha.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country fetchCountryById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return country.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<Country> fetchAllCountries(Pageable pageable) {
        Page<Country> countries = countryRepository.findAll(pageable);
        return countries;
    }

    @Override
    public Page<Country> fetchAllCountriesByContinentId(Long continentId, Pageable pageable) {
        Page<Country> branches = countryRepository.findByContinentId(continentId, pageable);
        return branches;
    }
}
