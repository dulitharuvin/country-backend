package com.dulitha.country.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "continentId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Continent continent;
}
