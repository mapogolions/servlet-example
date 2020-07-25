package io.github.mapogolions.hibernatecli.onetomany.domain;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "onetomany")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
}
