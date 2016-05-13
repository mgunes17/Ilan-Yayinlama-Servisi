create table donation(
	donation_id int primary key,
	company_username varchar(30) not null,
	donate_accept_unit_username varchar(30) not null,
	packet_id int not null,
	iban char,
	amount int,
	approved boolean default false
);

create table announcement(
	id int primary key,
	title varchar(30),
	brief text NOT NULL,
	content text NOT NULL,
	number_of_page_views int,
	state int not null,
	owner_company varchar(30) not null,
	owner_packet int,
	announcement_type int not null
);

create table announcement_state(
	id int primary key,
	title varchar(30) not null
);

INSERT INTO announcement_state VALUES
	(1, 'passive'),
	(2, 'active'),
	(3, 'expired'),
	(4, 'suspended') ;

create table announcement_type(
	id int primary key,
	title varchar(30)
);

INSERT INTO announcement_type VALUES
	(1, 'internship'),
	(2, 'part time'),
	(3, 'full time'),
	(4, 'freelance') ;

CREATE TABLE user_type(
	type_no smallint PRIMARY KEY,
	type_name varchar(20) UNIQUE,
	main_page char(50)
);

CREATE TABLE users(
	user_name  varchar(20) PRIMARY KEY,
	password varchar(16) NOT NULL,
	user_type_no smallint REFERENCES user_type(type_no)
);


CREATE TABLE bank_account_info(
	owner_unit_name varchar(20),
	bank_name varchar(30) NOT NULL,
	branch_bank_name varchar(30) NOT NULL,
	bank_account_number numeric(16) NOT NULL,
	iban char(34) UNIQUE,
	currency int not null,
	PRIMARY KEY(owner_unit_name)
);

CREATE TABLE department(
	code char(3) primary key,
	name varchar(50) unique
);


CREATE TABLE message(
	message_no integer primary key,
	message_title varchar(30) NOT NULL,
	message_body text NOT NULL,
	sender_email_address varchar(50) NOT NULL,
	sender_ip_address varchar(16) NOT NULL,
	is_read boolean default false,
	PRIMARY KEY(message_no)
);

CREATE TABLE donation_accept_unit(
	user_name varchar(20) REFERENCES users(user_name),
	unit_name varchar(40) NOT NULL UNIQUE,
	balance int,
	primary key(user_name)
);


create table student(
	user_name varchar(20) references users(user_name),
	name varchar(30) not null,
	surname varchar(30) not null,
	department varchar(30) not null,
	primary key(user_name)
);

create table company(
	user_name varchar(20) references users(user_name),
	mersis_no text not null unique,
	company_name varchar(30) not null,
	location varchar(30) not null,
	primary key(user_name)
);

create table announcement_packet(
	packet_id int primary key,
	title varchar(30),
	announcement_count int not null,
	price int not null,
	last_date_used timestamp not null,
	active_time int not null,
	currency int not null,
	condition text not null,
	donate_accept_unit varchar(30) not null
);

create table currency(
	id int primary key,
	title varchar(20) not null
);

INSERT INTO user_type (type_no, type_name) VALUES
	(0, 'admin'),
	(1, 'donation_accept_unit'),
	(2, 'company'),
	(3, 'student') ;
