create table partic_activity_hist
(
    id             bigint            not null
        constraint partic_activity_hist_pk
            primary key,
    activity_type  varchar(20)
        constraint partic_activity_hist_at_cc
            check ((activity_type)::text = ANY
        ((ARRAY ['WEBINAR'::character varying, 'TEST'::character varying, 'CHALLENGE'::character varying, 'INTERVIEW'::character varying])::text[])),
    activity_id    bigint,
    score          numeric default 0 not null,
    comment        text,
    participant_id bigint            not null
        constraint partic_activity_hist_pid_fk
            references participant
);

comment on column partic_activity_hist.activity_type is 'webinar, test, case_challange, interview';

comment on column partic_activity_hist.activity_id is 'id in related table';

create unique index partic_activity_hist_id_uindex
    on partic_activity_hist (id);

create unique index partic_activity_hist_tid_uidx
    on partic_activity_hist (activity_type, activity_id);

