create table address
(
    id       bigint      not null
        constraint address_pk
            primary key,
    city     text        not null,
    street   text        not null,
    building varchar(10) not null,
    flat     varchar(10) not null,
    email    text        not null,
    phone    varchar(10) not null
);


