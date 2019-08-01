create table if not exists users (
	id serial primary key,
	login varchar(20) not null unique,
	password varchar(100) not null
		);


insert into users (login, password)
values
       ('user', 'password'),
       ('admin', 'admin_password'),
       ('login', 'password');

create table if not exists auth_sessions (
  sid varchar(100) primary key,
  user_id integer not null unique,
  expired_date timestamp not null,
  constraint auth_sessions_user_id_fkey foreign key (user_id) references users(id)
);

create table if not exists user_info (
    id serial primary key,
    name varchar(100) not null,
    date_of_birth varchar(50) not null,
    course varchar(100) not null,
    faculty varchar(100) not null

--    constraint user_info_user_id_fkey foreign key (user_id) references users(id)
);

insert into user_info (name, date_of_birth, course, faculty)
values
('Игнатова Наталья', '03.01.1987', '4', 'Прикладная информатика'),
('Иванов Иван', '01.02.1995', '3', 'Социология');