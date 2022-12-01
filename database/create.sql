create database if not exists project_spring2_6;
use project_spring2_6;

create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table  if not exists role(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);

create table if not exists user_role(
	username varchar(50),
    role_id int,
    is_delete bit default 0,
    foreign key(username) references user(username),
    foreign key(role_id) references role(id),
    primary key(username, role_id)
);
create table if not exists customer(
	id int primary key auto_increment,
	name varchar(30),
	is_delete bit default 0,
	day_of_birth varchar(30),
	gender int,
	id_card varchar(12),
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	foreign key (username) references user(username)
);
create table if not exists producer(
	id int primary key auto_increment,
	name varchar(50),
is_delete bit default 0
);
create table if not exists product_type(
	id int primary key auto_increment,
	name varchar(50),
is_delete bit default 0
);

create table if not exists product(
	id int primary key auto_increment,
	name varchar(30),
    is_delete bit default 0,
    date_of_manufacture varchar(100),
    image text,
    content text,
    price int,
    promotion varchar(100),
    producer_id int,
	foreign key(producer_id) references producer(id),
    product_type_id int,
    foreign key (product_type_id) references product_type(id)
);
create table if not exists product_customer(
id_customer int,
id_product int,
is_delete bit default 0,
foreign key(id_customer) references customer(id),
foreign key(id_product) references product(id),
primary key(id_customer, id_product)
);
