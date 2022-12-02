drop table if exists users cascade;

create table users(
    id bigserial not null primary key,
    login varchar not null unique ,
    email varchar not null unique ,
    password varchar not null,
    last_lat double precision,
    last_lon double precision
)