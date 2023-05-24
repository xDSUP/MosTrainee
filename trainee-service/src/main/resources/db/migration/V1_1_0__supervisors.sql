create table supervisors
(
    id          bigint not null
        constraint supervisors_pk
            primary key,
    last_name   text   not null,
    first_name  text   not null,
    middle_name text,
    email       text   not null,
    phone       varchar(10)
);
