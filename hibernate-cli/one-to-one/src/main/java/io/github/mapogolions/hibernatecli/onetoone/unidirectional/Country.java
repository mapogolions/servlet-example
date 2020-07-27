package io.github.mapogolions.hibernatecli.onetoone.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "country", schema = "onetoone")
public class Country {
    @Id
    private String name;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "country_capital_fkey"))
    private CapitalCity capital;
}
