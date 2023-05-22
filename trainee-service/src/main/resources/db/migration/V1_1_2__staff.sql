create table staff
(
    id              bigint      not null
        constraint staff_pk
            primary key,
    email           text        not null,
    phone           varchar(10) not null,
    code            varchar(20) not null,
    organization_id bigint      not null
        constraint staff_org_id_fk
            references organization,
    last_name       text        not null,
    first_name      text        not null,
    middle_name     text
);

create unique index staff_code_uindex
    on staff (code);

create unique index staff_email_uindex
    on staff (email);

create unique index staff_phone_uindex
    on staff (phone);

create index staff_organization_id_idx
    on staff (organization_id);

