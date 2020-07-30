#### `one-to-many: with JoinTable annotation`
```shell script

```

#### `one-to-many: like many-to-many with aux constraints`
```shell script
Hibernate: 
    
    create table public.user (
       id  bigserial not null,
        login varchar(255),
        primary key (id)
    )

Hibernate: 
    
    create table public.blood_group (
       name varchar(255) not null,
        primary key (name)
    )

Hibernate: 
    
    create table blood_group_user (
       BloodGroup_name varchar(255) not null,
        users_id int8 not null
    )
Hibernate: 
    
    alter table blood_group_user 
       add constraint UK_e8f2wersrbgliq3ure99jf9fi unique (users_id)

Hibernate: 
    
    alter table blood_group_user 
       add constraint FK2k22s0s7unewpcr5dotx0fwgc 
       foreign key (users_id) 
       references public.user
Hibernate: 
    
    alter table blood_group_user 
       add constraint FK3ycqsiaodkr9ficj4aw2gw6it 
       foreign key (BloodGroup_name) 
       references public.blood_group
```
