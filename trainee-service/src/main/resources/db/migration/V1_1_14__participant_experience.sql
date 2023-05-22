create table participant_experience
(
    id             bigint      not null
        constraint participant_experience_pk
            primary key,
    participant_id bigint      not null
        constraint participant_experience_pid_fk
            references participant,
    work_name      text        not null,
    work_type      varchar(20) not null
        constraint participant_experience_wt_cc
            check ((work_type)::text = ANY
                    ((ARRAY ['FULL_TIME':: character varying, 'PART_TIME':: character varying, 'FREE_LANCE':: character varying, 'VOLUNTEER':: character varying, 'OWN_PROJECTS':: character varying])::text[])
                ) ,
    start_date     date        not null,
    end_date       date,
    description    text
);

comment on column participant_experience.work_type is 'work, freelance, volunteer';

create index participant_experience_pid_idx
    on participant_experience (participant_id);

