package io.github.mapogolions;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons", schema = "public")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "country_of_birth", nullable = false)
    private String countryOfBirth;

    public Person(String firstName, String lastName, Gender gender, String email, LocalDate dateOfBirth, String countryOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                '}';
    }
}
