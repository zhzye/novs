create database novs;
use novs;
create table departments(id bigint(20) not null auto_increment, name varchar(50) not null default '', address varchar(200) not null default '', primary key(id));