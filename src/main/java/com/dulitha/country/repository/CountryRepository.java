package com.dulitha.country.repository;

import com.dulitha.country.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Page<Country> findByContinentContinentId(Long continentId, Pageable pageable);

    @Query("select c from Country c where c.name like %:searchQuery% or c.code like %:searchQuery%")
    Page<Country> findByNameOrCode(@Param("searchQuery") String searchQuery, Pageable pageable);

    @Query("select c from Country c where " +
            "(c.name like %:searchQuery% or c.code like %:searchQuery%) " +
            "and continentId = :continentId")
    Page<Country> findByNameOrCodeAndContinentId(@Param("continentId") Long continentId,
                                                 @Param("searchQuery") String searchQuery,
                                                 Pageable pageable);
}
