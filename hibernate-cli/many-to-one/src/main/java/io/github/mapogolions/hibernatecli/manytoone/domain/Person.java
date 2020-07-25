package io.github.mapogolions.hibernatecli.manytoone.domain;

import javax.persistence.*;

@Entity
@Table(name = "person", schema = "manytoone")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "student_address_fkey"))
    private Address address;
}
