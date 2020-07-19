### `Samples.nativeQueryForceExecutionDelayedWriteOperations()`
```sh
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

### `Samples.eachContextHasItsOwnFirstLevelCache()`
```sh
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

### `Samples.firstLevelCacheHasCrossTransactionNature()`
```sh
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

### `Samples.retrievalsFetchEntitiesFromDatabaseIfFirstLevelCacheDoesNotContainEntity()`
```sh
Hibernate:
    select
        hero0_.id as id1_1_0_,
        hero0_.name as name2_1_0_
    from
        public.hero hero0_
    where
        hero0_.id=?
```

### `Samples.retrievalsFirstOfAllSearchForEntitiesInFirstLevelCache`
```sh
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
```

### `Samples.sequenceGenerationStrategyDelayActualInsertionAsLongAsPossible()`
```sh
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

### `Samples.identityGenerationStrategyInsertsRecordsImmediately()`
```sh
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

### `mergeUpdatesOnlyWhenNecessary()`
```sh
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

### `Samples.mergeIsRoundTripOperationWhenNaturalPrimaryKeyIsUsed()`

```sh
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

### `mergeHasOnlyInsertionSemanticWhenSurrogatePrimaryKeyIsUsed()`
```sh
Hibernate:
    insert
    into
        public.hero
        (name)
    values
        (?)
```

### `Samples.trackingManagedRecordState()`

```sh
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


