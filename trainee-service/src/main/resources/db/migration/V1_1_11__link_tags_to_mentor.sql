create table link_tags_to_mentor
(
    id           bigint not null,
    mentor_id    bigint not null
        constraint skill_tags_mid_fk
            references mentors,
    skill_tag_id bigint not null
        constraint skill_tags_stid_fk
            references skill_tags (id)
);

create index link_tags_to_mentor_mid_idx
    on link_tags_to_mentor (mentor_id);

create index link_tags_to_mentor_stid_idx
    on link_tags_to_mentor (skill_tag_id);

