#### one-to-one (unidirectional)

```shell script
Hibernate: 
    
    create table one_to_one.pull_request (
       id  bigserial not null,
        title varchar(255),
        details_id int8,
        primary key (id)
    )
Hibernate: 
    
    create table one_to_one.pull_request_details (
       id  bigserial not null,
        affected_lines int4,
        primary key (id)
    )
Hibernate: 
    
    alter table one_to_one.pull_request 
       add constraint pull_request_pull_request_details_fkey 
       foreign key (details_id) 
       references one_to_one.pull_request_details
```
