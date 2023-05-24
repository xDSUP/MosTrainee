create table webinar_info
(
    id                   bigint      not null
        constraint webinar_info_pk
            primary key,
    code                 varchar(20) not null,
    description          text        not null,
    link_to_ext_resource text        not null,
    start_date           date        not null,
    start_time           time        not null,
    finished             boolean
);

create unique index webinar_info_code_uindex
    on webinar_info (code);

create unique index webinar_info_id_uindex
    on webinar_info (id);

