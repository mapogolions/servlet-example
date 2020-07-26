#### `many-to-one`
```shell script
Hibernate: 
    
    create table manytoone.address (
       id  bigserial not null,
        country varchar(255),
        zipCode varchar(255),
        primary key (id)
    )
Hibernate: 
    
    create table manytoone.person (
       id  bigserial not null,
        name varchar(255),
        permanentResidence_id int8,
        primary key (id)
    )
Hibernate: 
    
    alter table manytoone.person 
       add constraint student_permanent_residence_fkey 
       foreign key (permanentResidence_id) 
       references manytoone.address

```
