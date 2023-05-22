create table participant
(
    id             bigint            not null
        constraint participant_pk
            primary key,
    last_name      varchar(30)       not null,
    first_name     varchar(30)       not null,
    middle_name    varchar(30)       not null,
    birth_date     date              not null,
    nationality    varchar(30)       not null,
    citizenship    varchar           not null,
    rating         numeric default 0 not null,
    address_id      bigint
        constraint participant_address_fk
            references address,
    education_type varchar(10)
        constraint participant_et_cc
            check ((education_type)::text = ANY
        ((ARRAY ['HIGHER'::character varying, 'SECONDARY'::character varying, 'PROF'::character varying, 'STUDENT'::character varying, 'BACHELOR'::character varying, 'MASTER'::character varying])::text[])),
    internship_id  bigint            not null
        constraint participant_int_id_fk
            references internship_types
);

create index participant_addr_id_idx
    on participant (address_id);

create index participant_int_id_idx
    on participant (internship_id);

