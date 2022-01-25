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

    @Column(name = "code", nullable = false)
    private String code;

    @Column(nullable = false)
    private Long continentId;
}
