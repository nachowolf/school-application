create table wallet(
wallet_id serial not null primary key,
withdrawn int not null,
deposited int not null,
balance int not null
);