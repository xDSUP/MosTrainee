create table link_tags_to_partic
(
    id             bigint not null,
    participant_id bigint not null
        constraint skill_tags_pid_fk
            references participant,
    skill_tag_id   bigint not null
        constraint skill_tags_stid_fk
            references skill_tags (id)
);

