create table stage_scheduler
(
    id          bigint,
    code        varchar(20)           not null,
    description text                  not null,
    start_date  date                  not null,
    end_date    date                  not null,
    active      boolean default false not null
);

create unique index stage_scheduler_code_uindex
    on stage_scheduler (code);

create unique index stage_scheduler_id_uindex
    on stage_scheduler (id);

