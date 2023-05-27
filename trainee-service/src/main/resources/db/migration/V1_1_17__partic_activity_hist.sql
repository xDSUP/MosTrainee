create table partic_activity_hist
(
    id             bigint            not null
        constraint partic_activity_hist_pk
            primary key,
    activity_id    bigint            not null
        constraint partic_activity_hist_act_id_fk
            references stage_activity,
    score          numeric default 0 not null,
    comment        text,
    participant_id bigint            not null
        constraint partic_activity_hist_pid_fk
            references participant,
    uid            bigint            not null
);

comment on column partic_activity_hist.activity_id is 'id in related table';

create unique index partic_activity_hist_id_uindex
    on partic_activity_hist (id);


