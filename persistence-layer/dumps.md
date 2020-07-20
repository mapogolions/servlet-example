#### `nothingToCommitWhenPersistenceContextIsEmpty`
```shell script
Hibernate: 
    select
        nextval ('hibernate_sequence')
Hibernate: 
    select
        nextval ('hibernate_sequence')
```

#### `detachRemoveObjectFromPersistenceContext()`
```shell script

```

#### `removeTransientObjectFromFirstLevelCacheDoesNotPreventInsertion()`
```shell script
Hibernate: 
    insert 
    into
        public.book
        (author, isbn) 
    values
        (?, ?)
Hibernate: 
    delete 
    from
        public.book 
    where
        isbn=?
```

#### `removeTransientObjectWithNaturalKeyExecutesSelectQuery()`
```shell script
Hibernate: 
    select
        book_.isbn,
        book_.author as author2_0_ 
    from
        public.book book_ 
    where
        book_.isbn=?
```

#### `removeTransientObjectWithSurrogateKeyDoesNothing()`
```shell script
```

#### `nativeQueryForceExecutionDelayedWriteOperations()`
```shell script
Hibernate: 
    select
        nextval ('hibernate_sequence')
Hibernate: 
    insert 
    into
        public.person
        (country_of_birth, date_of_birth, email, first_name, gender, last_name, id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        * 
    from
        person

Hibernate: 
    select
        nextval ('hibernate_sequence')
Hibernate: 
    insert 
    into
        public.person
        (country_of_birth, date_of_birth, email, first_name, gender, last_name, id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        * 
    from
        person
```

#### `eachSessionHasItsOwnFirstLevelCache()`
```shell script
Hibernate: 
    insert 
    into
        public.hero
        (name) 
    values
        (?)
Hibernate: 
    select
        hero0_.id as id1_1_0_,
        hero0_.name as name2_1_0_ 
    from
        public.hero hero0_ 
    where
        hero0_.id=?
```

#### `firstLevelCacheHasCrossTransactionNature()`
```shell script
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
Hibernate:
    select
        hero0_.id as id1_1_0_,
        hero0_.name as name2_1_0_
    from
        public.hero hero0_
    where
        hero0_.id=?
Hibernate:
    select
        hero0_.id as id1_1_0_,
        hero0_.name as name2_1_0_
    from
        public.hero hero0_
    where
        hero0_.id=?

```

#### `retrievalsFetchEntitiesFromDatabaseIfFirstLevelCacheDoesNotContainEntity()`
```shell script
Hibernate:
    select
        hero0_.id as id1_1_0_,
        hero0_.name as name2_1_0_
    from
        public.hero hero0_
    where
        hero0_.id=?
```

#### `retrievalsFirstOfAllSearchForEntitiesInFirstLevelCache`
```shell script
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
```

#### `sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible()`
```shell script
Hibernate:
    select
        nextval ('hibernate_sequence')
Hibernate:
    select
        nextval ('hibernate_sequence')
Hibernate:
    insert
    into
        public.person
        (country_of_birth, date_of_birth, email, first_name, gender, last_name, id)
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        public.person
        (country_of_birth, date_of_birth, email, first_name, gender, last_name, id)
    values
        (?, ?, ?, ?, ?, ?, ?)
```

#### `identityGenerationStrategyInsertsRecordsImmediately()`
```shell script
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
```

#### `mergeUpdatesOnlyWhenNecessary()`
```shell script
Hibernate:
    insert
    into
        public.book
        (author, isbn)
    values
        (?, ?)
Hibernate:
    select
        book0_.isbn as isbn1_0_0_,
        book0_.author as author2_0_0_
    from
        public.book book0_
    where
        book0_.isbn=?
```

#### `mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed()`

```shell script
Hibernate:
    select
        book0_.isbn as isbn1_0_0_,
        book0_.author as author2_0_0_
    from
        public.book book0_
    where
        book0_.isbn=?
Hibernate:
    insert
    into
        public.book
        (author, isbn)
    values
        (?, ?)
```

#### `mergeHasOnlyInsertionSemanticWhenSurrogatePrimaryKeyIsUsed()`
```shell script
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
```

#### `trackingManagedRecordState()`

```shell script
Hibernate:
    select
        nextval ('hibernate_sequence')
Hibernate:
    insert
    into
        public.person
        (country_of_birth, date_of_birth, email, first_name, gender, last_name, id)
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate:
    update
        public.person
    set
        country_of_birth=?,
        date_of_birth=?,
        email=?,
        first_name=?,
        gender=?,
        last_name=?
    where


