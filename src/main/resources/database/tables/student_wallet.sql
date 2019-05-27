create table student_wallet (
    id serial not null primary key,
    student_id int not null,
    wallet_id int not null,
    foreign key (student_id) references student(student_id),
    foreign key (wallet_id) references wallet(wallet_id)
);