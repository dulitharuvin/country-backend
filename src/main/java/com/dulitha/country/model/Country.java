package com.dulitha.country.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Country")
@Data
public class Country extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @Column(name = "name", nullable = false)
    private String name;

    private String flagUrl;

    @Column(nullable = false)
    private Long continentId;
}
