create table person
(
    id       serial primary key not null,
    login    varchar(2000),
    password varchar(2000)
);

create table employee
(
    id         serial primary key not null,
    name       varchar(2000),
    secondname varchar(2000),
    inn        int
);
