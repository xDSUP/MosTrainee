create table participant_solutions
(
    id             bigint not null
        constraint participant_solutions_pk
            primary key,
    participant_id bigint not null
        constraint participant_solutions_pid_fk
            references participant,
    application_id bigint not null
        constraint participant_solutions_appid_fk
            references application,
    solution       bytea  not null,
    comment        text,
    created_at     date,
    score          numeric
);

create index participant_solutions_appid_idx
    on participant_solutions (application_id);

create index participant_solutions_pid_idx
    on participant_solutions (participant_id);

