create database hibernate_crud_console;
use hibernate_crud_console;

create table if not exists orders(
    id bigint primary key auto_increment,
    order_name varchar(100)
);

