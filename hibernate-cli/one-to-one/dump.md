####`one-to-one bidirectional (parent and child sides)`
```shell script
Hibernate: 
    
    create table onetoone.pull_request (
       id  bigserial not null,
        title varchar(255),
        details_id int8,
        primary key (id)
    )
Hibernate: 
    
    create table pull_request_details (
       id int8 not null,
        affected_lines int4,
        primary key (id)
    )
Hibernate: 
    
    alter table onetoone.pull_request 
       add constraint pull_request_pull_request_details_fkey 
       foreign key (details_id) 
       references pull_request_details
```

####`one-to-one unidirectional`
```shell script
Hibernate: 
    create table onetoone.capital_city (
       id  bigserial not null,
        name varchar(255),
        primary key (id)
    )

Hibernate: 
    create table onetoone.country (
       name varchar(255) not null,
        capital_id int8,
        primary key (name)
    )

Hibernate: 
    alter table onetoone.country 
       add constraint country_capital_fkey 
       foreign key (capital_id) 
       references onetoone.capital_city
```
