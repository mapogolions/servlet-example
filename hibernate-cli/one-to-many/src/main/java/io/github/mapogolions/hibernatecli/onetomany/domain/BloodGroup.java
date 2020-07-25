package io.github.mapogolions.hibernatecli.onetomany.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blood_group", schema = "onetomany")
public class BloodGroup {
    @Id
    private String name;

    @OneToMany
    @JoinColumn(name = "blood_group_name")
    private List<User> users;
}
