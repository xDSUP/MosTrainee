create table mentors
(
    id              bigint                     not null
        constraint mentors_pk
            primary key,
    last_name       text                       not null,
    first_name      text                       not null,
    middle_name     text,
    organization_id bigint                     not null
        constraint mentors_org_id_fk
            references organization,
    position        text                       not null,
    email           text                       not null,
    rating          double precision default 0 not null,
    is_qualified    boolean
);

create index mentors_org_id_idx
    on mentors (organization_id);

