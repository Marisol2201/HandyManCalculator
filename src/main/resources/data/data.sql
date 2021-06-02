--DROP TABLE WEEKS;
--
--CREATE TABLE WEEKS(
--id varchar(2),
--technicianId varchar(255),
--serviceId varchar(100),
--totalWeekHours int,
--totalWeekNormalHours int,
--weekNormalDaytimeHours int,
--weekNormalNightHours int,
--sundayNormalHours int,
--totalWeekExtraHours int,
--weekExtraDaytimeHours int,
--weekExtraNightHours int,
--sundayExtraHours int);

INSERT INTO WEEKS(id, technicianId, serviceId, totalWeekHours, totalWeekNormalHours,
weekNormalDaytimeHours, weekNormalNightHours, sundayNormalHours, totalWeekExtraHours,
weekExtraDaytimeHours, weekExtraNightHours, sundayExtraHours) VALUES
('13', 'technician name 1', 'service1', 45, 30, 30, 0, 0, 15, 15, 0, 0);