package com.dulitha.country.controller;

import com.dulitha.country.model.Continent;

import com.dulitha.country.model.Country;
import com.dulitha.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(method = RequestMethod.POST)
    public Country save(@RequestBody Country country) {
        return countryService.save(country);
    }
}
