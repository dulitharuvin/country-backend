package com.dulitha.country.controller;

import com.dulitha.country.exception.ResourceNotFoundException;
import com.dulitha.country.model.Country;
import com.dulitha.country.service.ContinentService;
import com.dulitha.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    ContinentService continentService;

    @RequestMapping(method = RequestMethod.POST, value = "/{continentId}")
    public Country save(@PathVariable(value = "continentId") Long continentId,
                        @RequestBody Country country) {
        return continentService.fetchContinentById(continentId).map(continent -> {
            country.setContinent(continent);
            return countryService.save(country);
        }).orElseThrow(() -> new ResourceNotFoundException("ContinentId " + continentId + " not found"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Country> listCountries(@RequestParam(value = "continentId", required = false) Long continentId,
                                       @RequestParam(value = "query", required = false) String query,
                                       Pageable pageable) {

        Page<Country> countries;
        var searchQuery = (query == null) ? "" : query;
        if (continentId != null) {
            countries = countryService.fetchAllCountriesByNameOrCodeAndContinentId(continentId, searchQuery, pageable);
        } else {
            countries = countryService.fetchAllCountriesByNameOrCode(searchQuery, pageable);
        }
        return countries.getContent();
    }
}
