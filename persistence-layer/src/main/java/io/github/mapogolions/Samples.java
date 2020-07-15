package io.github.mapogolions;

import io.github.mapogolions.model.Book;
import io.github.mapogolions.model.Gender;
import io.github.mapogolions.model.Hero;
import io.github.mapogolions.model.Person;
import static io.github.mapogolions.Db.session;
import static io.github.mapogolions.Db.context;

import java.time.LocalDate;

public class Samples {
    public static void retrievalsFetchEntitiesFromDatabaseIfFirstLevelCacheDoesNotContainEntity() {
        session(entityManager -> entityManager.find(Hero.class, 1L));
    }

    public static void retrievalsFirstOfAllSearchForEntitiesInFirstLevelCache() {
        session(
                context(
                        entityManager -> entityManager.persist(new Hero("true hero")),
                        entityManager -> entityManager.find(Hero.class, 1L)
                )
        );
    }

    public static void sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible() {
        session(
                context(
                        entityManager -> entityManager.persist(new Person("Some", "One", Gender.MALE,
                            "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia")),
                        entityManager -> entityManager.persist(new Person("John", "Doe", Gender.MALE,
                            "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA"))
                )
        );
    }

    public static void identityGenerationStrategyInsertsRecordsImmediately() {
        session(
                context(
                        entityManager -> entityManager.persist(new Hero("Togo")),
                        entityManager -> entityManager.persist(new Hero("Balto"))
                )
        );
    }

    public static void mergeUpdatesOnlyWhenNecessary() {
        session(
                entityManager -> entityManager.persist(new Book("1a-2b-3c", "Someone")),
                entityManager -> entityManager.merge(new Book("1a-2b-3c", "Someone"))
        );
    }

    public static void mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed() {
        session(entityManager -> entityManager.merge(new Book("1a-2b-3c", "Someone")));
    }

    public static void mergeHasOnlyInsertionSemanticWhenSurrogatePrimaryKeyIsUsed() {
       session(entityManager -> entityManager.merge(new Hero("Togo")));
    }

    public static void trackingManagedRecordState() {
       session(entityManager -> {
                    var someone = new Person("Some", "One", Gender.MALE,
                            "someone@yandex.ru", LocalDate.of(2020, 02, 15), "Columbia");
                    entityManager.persist(someone);
                    someone.email("someone@gmail.com");
                });
    }
}
