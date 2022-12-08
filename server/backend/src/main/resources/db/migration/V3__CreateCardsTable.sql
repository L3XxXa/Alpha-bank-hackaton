drop table if exists cards cascade;

create table cards
(
    id                  bigserial not null primary key,
    user_id             bigserial not null,
    "name"              varchar   not null,
    number              varchar   not null,
    priority            int4 not null default 0,
    distance_to_nearest double precision,
    foreign key (user_id) references users (id),
    unique (user_id, "name")
)