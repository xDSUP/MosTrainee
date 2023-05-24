create table case_challenge_info
(
    id                   bigint      not null
        constraint case_challenge_info_pk
            primary key,
    code                 varchar(20) not null,
    description          text        not null,
    link_to_ext_resource text        not null,
    start_date           date        not null,
    start_time           time        not null,
    finished             boolean
);

create unique index case_challenge_info_code_uindex
    on case_challenge_info (code);

create unique index case_challenge_info_id_uindex
    on case_challenge_info (id);

