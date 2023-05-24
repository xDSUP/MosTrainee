-- auto-generated definition
create table branches
(
    id         bigint not null
        constraint branches_pk
            primary key,
    name       text   not null,
    info       text,
    address_id bigint not null
        constraint branches_address_id_fk
            references address
);

create index branches_address_id_idx
    on branches (address_id);

create unique index branches_name_uindex
    on branches (name);

