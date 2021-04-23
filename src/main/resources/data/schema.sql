CREATE TABLE IF NOT EXISTS TECHNICIANS(
    id varchar(40) primary key,
    name varchar(100) not null
);

CREATE TABLE IF NOT EXISTS SERVICES (
    id varchar(40) primary key,
    name varchar(45) not null
);

CREATE TABLE WEEKS (
    id varchar(5) primary key,
    totalWeekHours int(5) not null,
    totalWeekNormalHours int(5) not null,
    weekNormalDaytimeHours int(5) not null,
    weekNormalNightHours int(5) not null,
    sundayNormalHours int(5) not null,
    totalWeekExtraHours int(5) not null,
    weekExtraDaytimeHours int(5) not null,
    weekExtraNightHours int(5) not null,
    sundayExtraHours int(5) not null
);