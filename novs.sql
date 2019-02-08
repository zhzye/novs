create database novs;
use novs;
create table departments(id bigint(20) not null auto_increment, name varchar(50) not null default '', address varchar(200) not null default '', primary key(id));
create table staffs(id bigint(20) not null auto_increment, account varchar(50) not null default '', password varchar(50) not null default '', status varchar(50) not null default '正常', department_id bigint(20) not null default 0, name varchar(50) not null default '', born_date datetime not null, primary  key (id));