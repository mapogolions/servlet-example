package io.github.mapogolions;

import io.github.mapogolions.model.Book;
import io.github.mapogolions.model.Gender;
import io.github.mapogolions.model.Hero;
import io.github.mapogolions.model.Person;

import java.time.LocalDate;

public class Samples {
    public static void sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible() {
        Db.session(entityManager -> {
            entityManager.persist(new Person("Some", "One", Gender.MALE,
                        "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia"));
            entityManager.persist(new Person("John", "Doe", Gender.MALE,
                    "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA"));
        });
    }

    public static void identityGenerationStrategyInsertsRecordsImmediately() {
        Db.session(entityManager -> {
            entityManager.persist(new Hero("Togo"));
            entityManager.persist(new Hero("Balto"));
        });
    }

    public static void mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed() {
        Db.session(entityManager -> entityManager.merge(new Book("1a-2b-3c", "Someone")));
    }

    public static void mergeOnlyInsertsRecordWhenSurrogatePrimaryKeyIsUsed() {
        Db.session(entityManager -> entityManager.merge(new Hero("Togo")));
    }

    public static void trackingManagedRecordState() {
        Db.session(
                entityManager -> {
                    var someone = new Person("Some", "One", Gender.MALE,
                            "someone@yandex.ru", LocalDate.of(2020, 02, 15), "Columbia");
                    entityManager.persist(someone);
                    someone.email("someone@gmail.com");
                }
        );
    }
}
