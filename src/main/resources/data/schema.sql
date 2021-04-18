CREATE TABLE IF NOT EXISTS TECHNICIANS(
    id varchar(40) primary key,
    name varchar(100) not null
);

CREATE TABLE IF NOT EXISTS WEEKS (
    id varchar(5) primary key,
    hours int(5) not null
);

CREATE TABLE IF NOT EXISTS SERVICES (
    id varchar(40) primary key,
    name varchar(45) not null
);