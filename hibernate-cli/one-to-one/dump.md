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
