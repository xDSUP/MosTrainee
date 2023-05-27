create table mentor_activity_his
(
    id          bigint not null
        constraint mentor_activity_his_pk
            primary key,
    activity_id bigint not null
        constraint mentor_activity_his_stact_id_fk
            references stage_activity,
    score       numeric,
    comment     text,
    mentor_id   bigint not null
        constraint mentor_activity_his_mntid_fk
            references mentors
);

create index mentor_activity_his_act_id_idx
    on mentor_activity_his (activity_id);

create index mentor_activity_his_mnt_id_idx
    on mentor_activity_his (mentor_id);

