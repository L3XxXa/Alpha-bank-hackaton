drop table if exists cards cascade;

create table cards(
    id bigserial not null primary key,
    user_id bigserial not null,
    "name" varchar not null,
    image varchar not null,
    number varchar not null,
    foreign key (user_id) references users(id)
)