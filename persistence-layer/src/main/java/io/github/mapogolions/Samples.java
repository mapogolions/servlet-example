package io.github.mapogolions;

import io.github.mapogolions.model.Book;
import io.github.mapogolions.model.Gender;
import io.github.mapogolions.model.Hero;
import io.github.mapogolions.model.Person;
import java.time.LocalDate;
import static io.github.mapogolions.Db.*;

public class Samples {
    public static void eachContextHasItsOwnFirstLevelCache() {
        session(
                context(
                        unit(em -> em.persist(new Hero("true hero"))),
                        unit(em -> em.find(Hero.class, 1L))
                ),
                context(
                        unit(em -> em.find(Hero.class, 1L))
                )
        );
    }

    public static void firstLevelCacheHasCrossTransactionNature() {
        session(
                context(
                        unit(em -> em.persist(new Hero("true hero"))),
                        unit(em -> em.find(Hero.class, 1L))
                )
        );
    }

    public static void retrievalsFetchEntitiesFromDatabaseIfFirstLevelCacheDoesNotContainEntity() {
        session(
                unit(em -> em.find(Hero.class, 1L))
        );
    }

    public static void retrievalsFirstOfAllSearchForEntitiesInFirstLevelCache() {
        session(
                unit(
                        em -> em.persist(new Hero("true hero")),
                        em -> em.find(Hero.class, 1L)
                )
        );
    }

    public static void sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible() {
        session(
                unit(
                        em -> em.persist(new Person("Some", "One", Gender.MALE,
                                "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia")),
                        em -> em.persist(new Person("John", "Doe", Gender.MALE,
                                "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA"))
                )
        );
    }

    public static void identityGenerationStrategyInsertsRecordsImmediately() {
        session(
                unit(
                        em -> em.persist(new Hero("Togo")),
                        em -> em.persist(new Hero("Balto"))
                )
        );
    }

    public static void mergeUpdatesOnlyWhenNecessary() {
        session(
                unit(
                        em -> em.persist(new Book("1a-2b-3c", "Someone")),
                        em -> em.merge(new Book("1a-2b-3c", "Someone"))
                )
        );
    }

    public static void mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed() {
        session(
                unit(em -> em.merge(new Book("1a-2b-3c", "Someone")))
        );
    }

    public static void mergeHasOnlyInsertionSemanticWhenSurrogatePrimaryKeyIsUsed() {
        session(
                unit(em -> em.merge(new Hero("Togo")))
        );
    }

    public static void trackingManagedRecordState() {
        session(
                unit(
                        em -> {
                            var someone = new Person("Some", "One", Gender.MALE,
                                    "someone@yandex.ru", LocalDate.of(2020, 02, 15), "Columbia");
                            em.persist(someone);
                            someone.email("someone@gmail.com");
                        })
        );
    }
}
