drop table if exists cards cascade;

create table cards(
    id bigserial not null primary key,
    user_id bigserial not null,
    card_name varchar not null,
    card_image varchar not null,
    card_number varchar not null,
    foreign key (user_id) references users(id)
)