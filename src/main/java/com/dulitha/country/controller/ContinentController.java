package com.dulitha.country.controller;

import com.dulitha.country.model.Continent;
import com.dulitha.country.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/continents")
@CrossOrigin(origins = "http://localhost:4200")
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @RequestMapping(method = RequestMethod.POST)
    public Continent save(@RequestBody Continent continent) {
        return continentService.save(continent);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Continent> listContinents(Pageable pageable) {
        return continentService.fetchAllContinent(pageable).getContent();
    }
}
