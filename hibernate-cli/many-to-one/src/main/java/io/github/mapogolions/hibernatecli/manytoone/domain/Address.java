package io.github.mapogolions.hibernatecli.manytoone.domain;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "manytoone")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String zipCode;
}
