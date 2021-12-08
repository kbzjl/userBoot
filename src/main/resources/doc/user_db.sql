drop database if exists user_db;
create database user_db character set utf8mb4;
use user_db;

drop table if exists sys_user;
create table sys_user(
    id int(10) not null auto_increment comment '主键',
    name varchar(100) not null comment '姓名',
    cellphone varchar(100) not null unique comment '手机号码',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='用户信息表';