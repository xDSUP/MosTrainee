create table skill_tags
(
    id          bigint
        constraint skill_tags_pk
            unique,
    code        varchar(20),
    description text
);

create unique index skill_tags_id_uindex
    on skill_tags (id);

