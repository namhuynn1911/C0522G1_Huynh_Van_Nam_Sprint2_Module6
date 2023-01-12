create database if not exists project_sprint3_reactjs;
use project_sprint3_reactjs;

create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);
create table if not exists customer(
	id int primary key auto_increment,
	name varchar(30),
	is_delete bit default 0,
	day_of_birth varchar(30),
	gender int,
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	foreign key (username) references user(username)
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

create table if not exists category(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);
create table if not exists product(
	id int primary key auto_increment,
    name varchar(100),
    price int,
    discount int,
    brand varchar(50),
    price_for_sale_off int,
	is_delete bit default 0,
    category_id int,
    foreign key(category_id) references category(id)
);
create table if not exists bill_type(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);
create table if not exists bill(
	id int primary key auto_increment,
	create_date int,
    quantity int,
    customer_id int,
    foreign key(customer_id) references customer(id),
    bill_type_id int,
    foreign key(bill_type_id) references bill_type(id)
);
create table if not exists product_bill(
	id int primary key auto_increment,
	product_id int,
    bill_id int,
	foreign key (product_id) references product(id),
    foreign key (bill_id) references bill(id)
);
create table if not exists cart(
	id int primary key auto_increment,
	product_id int,
    username varchar(255),
	foreign key (product_id) references product(id),
    foreign key (username) references user(username)
);