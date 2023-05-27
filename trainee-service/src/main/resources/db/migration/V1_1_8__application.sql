create table application
(
    id                 bigint      not null
        constraint application_pk
            primary key,
    name               text        not null,
    description        text        not null,
    requirement        text        not null,
    work_time          varchar(20) not null,
    internship_type_id bigint      not null
        constraint application_int_type_fk
            references internship_types,
    branch_id          bigint      not null
        constraint application_branch_id_fk
            references branches,
    type               varchar(10) not null,
    start_date         date        not null,
    end_date           date        not null,
    created_by         bigint      not null
        constraint application_sid_fk
            references mentors,
    created_at         date        not null,
    is_active          boolean
);

comment on column application.branch_id is 'government branch';

comment on column application.type is 'ON_SITE, REMOTE, HYBRID';


create index application_created_by_idx
    on application (created_by);

create index application_int_type_id_idx
    on application (internship_type_id);

create unique index application_name_uindex
    on application (name);

create index application_branch_id_idx
    on application (branch_id);

