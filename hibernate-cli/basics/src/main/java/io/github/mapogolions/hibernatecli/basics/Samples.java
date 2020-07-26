package io.github.mapogolions.hibernatecli.basics;

import io.github.mapogolions.hibernatecli.basics.domain.*;

import java.time.LocalDate;
import java.util.function.Consumer;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class Samples {
    public static void getReferenceOnlyCreatesProxyObject() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.getReference(Hero.class, 1L))
            )
        );
    }

    public static void nothingToCommitWhenPersistenceContextIsEmpty() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Person("Some", "One", Gender.MALE,
                                    "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia")),
                            em -> em.persist(new Person("John", "Doe", Gender.MALE,
                                    "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA")),
                            em -> em.clear()
                    )
            )
        );
    }

    public static void detachRemoveObjectFromPersistenceContext() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Book("1a", "who")),
                            em -> em.detach(em.find(Book.class, "1a"))
                    )
            )
        );
    }

    public static void removeTransientObjectFromFirstLevelCacheDoesNotPreventInsertion() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Book("1a", "who")),
                            em -> em.remove(em.find(Book.class, "1a"))
                    )
            )
        );
    }

    public static void removeTransientObjectWithNaturalKeyExecutesSelectQuery() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.remove(new Book("1a", "who")))
            )
        );
    }

    public static void removeTransientObjectWithSurrogateKeyDoesNothing() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.remove(new Hero("true hero")))
            )
        );
    }

    public static void forceExecuteDelayedWriteOperation() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Person("Some", "One", Gender.MALE,
                                    "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia")),
                            em -> em.createNativeQuery("select * from person").getResultList(),
                            em -> em.persist(new Person("John", "Doe", Gender.MALE,
                                    "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA")),
                            em -> em.createNativeQuery("select * from person").getResultList()
                    )
            )
        );
    }

    public static void eachSessionHasItsOwnFirstLevelCache() {
        basicPersistenceUnit(
            db(
                    session(
                            atomicBlock(em -> em.persist(new Hero("true hero"))),
                            atomicBlock(em -> em.find(Hero.class, 1L))
                    ),
                    session(
                            atomicBlock(em -> em.find(Hero.class, 1L))
                    )
            )
        );
    }

    public static void firstLevelCacheHasCrossTransactionNature() {
        basicPersistenceUnit(
            db(
                    session(
                            atomicBlock(em -> em.persist(new Hero("true hero"))),
                            atomicBlock(em -> em.find(Hero.class, 1L))
                    )
            )
        );
    }

    public static void retrievalsFetchEntitiesFromDatabaseIfFirstLevelCacheDoesNotContainEntity() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.find(Hero.class, 1L))
            )
        );
    }

    public static void retrievalsFirstOfAllSearchForEntitiesInFirstLevelCache() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Hero("true hero")),
                            em -> em.find(Hero.class, 1L)
                    )
            )
        );
    }

    public static void sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Person("Some", "One", Gender.MALE,
                                    "someone@gmail.com", LocalDate.of(2020, 02, 15), "Columbia")),
                            em -> em.persist(new Person("John", "Doe", Gender.MALE,
                                    "johndoe@gmail.com", LocalDate.of(2020, 02, 15), "USA"))
                    )
            )
        );
    }

    public static void identityGenerationStrategyInsertsRecordsImmediately() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Hero("Togo")),
                            em -> em.persist(new Hero("Balto"))
                    )
            )
        );
    }

    public static void mergeUpdatesOnlyWhenNecessary() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> em.persist(new Book("1a-2b-3c", "Someone")),
                            em -> em.merge(new Book("1a-2b-3c", "Someone"))
                    )
            )
        );
    }

    public static void mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.merge(new Book("1a-2b-3c", "Someone")))
            )
        );
    }

    public static void mergeHasOnlyInsertionSemanticWhenSurrogatePrimaryKeyIsUsed() {
        basicPersistenceUnit(
            db(
                    atomicBlock(em -> em.merge(new Hero("Togo")))
            )
        );
    }

    public static void trackingManagedRecordState() {
        basicPersistenceUnit(
            db(
                    atomicBlock(
                            em -> {
                                var someone = new Person("Some", "One", Gender.MALE,
                                        "someone@yandex.ru", LocalDate.of(2020, 02, 15), "Columbia");
                                em.persist(someone);
                                someone.email("someone@gmail.com");
                            })
            )
        );
    }

    public static void basicPersistenceUnit(Consumer<String> fn) {
        fn.accept("hibernate-cli.basics");
    }
}
