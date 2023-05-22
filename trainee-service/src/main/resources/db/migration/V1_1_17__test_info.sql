create table test_info
(
    id                   bigint      not null
        constraint test_info_pk
            primary key,
    code                 varchar(20) not null,
    description          text        not null,
    link_to_ext_resource text        not null,
    start_date           date        not null,
    start_time           time        not null,
    finished             boolean
);

create unique index test_info_code_uindex
    on test_info (code);

create unique index test_info_id_uindex
    on test_info (id);

