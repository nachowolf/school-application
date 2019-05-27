create table teacher_wallet (
    id serial not null primary key,
    teacher_id int not null,
    wallet_id int not null,
    foreign key (teacher_id) references teacher(teacher_id),
    foreign key (wallet_id) references wallet(wallet_id)
);