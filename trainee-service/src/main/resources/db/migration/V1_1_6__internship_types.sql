-- auto-generated definition
create table internship_types
(
    id          bigint      not null
        constraint internship_types_pk
            primary key,
    code        varchar(20) not null,
    description text,
    is_active   boolean
);

create unique index internship_types_code_uindex
    on internship_types (code);

create unique index internship_types_id_uindex
    on internship_types (id);

