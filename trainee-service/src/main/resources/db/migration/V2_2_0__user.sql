create table user_creds
(
    id bigint primary key not null,
    username text not null,
    password text not null,
    user_type text not null
);

alter table mentors
    add constraint mentors_user_id_fkey
        foreign key (id)
            references user_creds (id);

alter table participant
    add constraint participant_user_id_fkey
        foreign key (id)
            references user_creds (id);

alter table staff
    add constraint staff_user_id_fkey
        foreign key (id)
            references user_creds (id);

alter table supervisors
    add constraint supervisors_user_id_fkey
        foreign key (id)
            references user_creds (id);