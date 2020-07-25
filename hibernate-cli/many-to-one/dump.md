#### `many-to-one`
```shell script
Hibernate: 
    create table public.address (
       id  bigserial not null,
       country varchar(255),
       zipCode varchar(255),
       primary key (id)
    )
    
Hibernate: 
    create table public.student (
       id  bigserial not null,
        name varchar(255),
        address_id int8,
        primary key (id)
    )

Hibernate: 
    
    alter table public.student 
       add constraint student_address_fkey 
       foreign key (address_id) 
       references public.address
```
