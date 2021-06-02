CREATE TABLE WEEKS (
    id varchar(2) primary key,
    technicianId varchar(100),
    serviceId varchar(50),
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