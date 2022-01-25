package com.dulitha.country.service;

import com.dulitha.country.model.Continent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContinentService {

    Continent save(Continent preschool);

    Continent fetchContinentById(Long id);

    Page<Continent> fetchAllContinent(Pageable pageable);
}