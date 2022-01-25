package com.dulitha.country.controller;

import com.dulitha.country.model.Continent;
import com.dulitha.country.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/continents")
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @RequestMapping(method = RequestMethod.POST)
    public Continent save(@RequestBody Continent continent) {
        return continentService.save(continent);
    }
}
