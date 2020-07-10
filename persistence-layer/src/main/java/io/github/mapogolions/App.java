package io.github.mapogolions;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IOException {
        try (var db = new Db("persistence.unit")) {
            db.transaction(
                    entityManager -> {
                        var someone = new Person("Some", "One", Gender.MALE,
                                "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia");
                        entityManager.persist(someone);
                    },
                    entityManager -> {
                        var query = "select * from public.persons limit 1";
                        var result = entityManager.createNativeQuery(query, Person.class).getSingleResult();
                        System.out.println(result);
                    });
        }
    }
}

