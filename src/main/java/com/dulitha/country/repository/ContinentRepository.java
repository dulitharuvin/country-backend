package com.dulitha.country.repository;

import com.dulitha.country.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
