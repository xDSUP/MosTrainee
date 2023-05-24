create table reviews
(
    id        bigint not null
        constraint reviews_pk
            primary key,
    comment   text   not null,
    score     integer default 0,
    mentor_id bigint not null
        constraint reviews_mentor_id_fk
            references mentors
);

create index reviews_mentor_id_idx
    on reviews (mentor_id);

