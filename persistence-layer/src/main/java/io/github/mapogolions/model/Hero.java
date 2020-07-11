package io.github.mapogolions.model;

import javax.persistence.*;

@Entity
@Table(name = "hero", schema = "public")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public Hero() { }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
