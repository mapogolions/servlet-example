package io.github.mapogolions.hibernatecli.onetoone.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "capital_city", schema = "onetoone")
public class CapitalCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
