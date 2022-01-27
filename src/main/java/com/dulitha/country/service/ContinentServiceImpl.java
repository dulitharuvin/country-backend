package com.dulitha.country.service;

import com.dulitha.country.model.Continent;
import com.dulitha.country.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContinentServiceImpl implements  ContinentService{

    @Autowired
    ContinentRepository continentRepository;

    @Override
    public Continent save(Continent continent) {
        return continentRepository.save(continent);
    }

    @Override
    public Optional<Continent> fetchContinentById(Long id) {
        return continentRepository.findById(id);
    }

    @Override
    public Page<Continent> fetchAllContinent(Pageable pageable) {
        Page<Continent> preschools = continentRepository.findAll(pageable);
        return preschools;
    }
}
