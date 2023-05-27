create table stage_activity
(
    id                   bigint      not null
        constraint stage_activity_pk
            primary key,
    stage_id             bigint      not null
        constraint stage_activity_stage_id_fk
            references stage_scheduler,
    activity_type        varchar(20)
        constraint stage_activity_at_cc
            check ((activity_type)::text = ANY
                   ((ARRAY ['WEBINAR'::character varying, 'TEST'::character varying, 'CHALLENGE'::character varying, 'INTERVIEW'::character varying])::text[])),
    code                 varchar(20) not null,
    description          text        not null,
    link_to_ext_resource text        not null,
    start_datetime       timestamp   not null,
    end_datetime         timestamp   not null
);

create unique index stage_activity_code_uindex
    on stage_activity (code);

create unique index stage_activity_id_uindex
    on stage_activity (id);

comment on column stage_activity.activity_type is 'webinar, test, case_challange, interview';

