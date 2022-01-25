package com.dulitha.country.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Continent")
@Data
public class Continent extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long continentId;

    @Column(name = "name", nullable = false)
    private String name;

}
