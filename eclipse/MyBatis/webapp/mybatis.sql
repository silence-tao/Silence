create database mybatis;

use mybatis;

create table user (
	id int(11) primary key auto_increment,
	userName varchar(50) default null,
	userAge int(11) default null,
	userAddress varchar(200) default null
);

insert into user values(1, 'summer', 23, '上海浦东');

create table article (
	id int(11) primary key auto_increment,
	userId int(11) not null,
	title int(11) not null,
	content text not null
);