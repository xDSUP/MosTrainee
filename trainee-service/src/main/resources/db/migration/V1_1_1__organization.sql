create table organization
(
    id            bigint not null
        constraint organization_pk
            primary key,
    name          text   not null,
    info          text,
    supervisor_id bigint not null
        constraint organization_sprvsr_id_fk
            references supervisors
);

create unique index organization_name_uindex
    on organization (name);

create index organization_sprvsr_id_index
    on organization (supervisor_id);

