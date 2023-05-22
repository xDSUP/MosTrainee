create table attachments
(
    id             bigint      not null
        constraint attachments_pk
            primary key,
    code           varchar(20) not null,
    name           text        not null,
    data           bytea       not null,
    application_id bigint      not null
        constraint attachments_app_id_fk
            references application,
    created_at     date        not null
);

comment on table attachments is 'documents, requirements and tasks for application';

create index attachments_app_id_idx
    on attachments (application_id);

create unique index attachments_code_uindex
    on attachments (code);

