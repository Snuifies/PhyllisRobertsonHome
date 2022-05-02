SELECT * FROM "PhyllisRobertsonHome".room;
SELECT * FROM "PhyllisRobertsonHome".room_aud;

SELECT * FROM "PhyllisRobertsonHome".resident;
SELECT * FROM "PhyllisRobertsonHome".resident_aud;

SELECT * FROM "PhyllisRobertsonHome".resident_daily_care;
SELECT * FROM "PhyllisRobertsonHome".resident_daily_care_aud;

SELECT * FROM "PhyllisRobertsonHome".resident_meal;
SELECT * FROM "PhyllisRobertsonHome".resident_meal_aud;

SELECT * FROM "PhyllisRobertsonHome".resident_condition_aud;
SELECT * FROM "PhyllisRobertsonHome".resident_condition;

SELECT * FROM "PhyllisRobertsonHome".prescription;
SELECT * FROM "PhyllisRobertsonHome".prescription_aud;
SELECT * FROM "PhyllisRobertsonHome".condition_aud;


SELECT * FROM "PhyllisRobertsonHome".users;

SELECT * FROM "PhyllisRobertsonHome".roles;

SELECT * FROM "PhyllisRobertsonHome".user_roles;

SELECT * FROM "PhyllisRobertsonHome".roles_aud;

SELECT * FROM "PhyllisRobertsonHome".user_roles_aud;

SELECT * FROM "PhyllisRobertsonHome".users_aud;

SELECT * FROM "PhyllisRobertsonHome".revinfo;

SELECT r.*, rc.condition FROM "PhyllisRobertsonHome".resident_condition rc 
join "PhyllisRobertsonHome".resident r on r.room_number = rc.room_number
;
-- *********************************************
-- Get a Room with Its Resident
-- *********************************************
SELECT room.* FROM "PhyllisRobertsonHome".room room join "PhyllisRobertsonHome".resident 
res on res.room_id = room.id;

-- *********************************************
-- Get a Resident with DailyCare
-- *********************************************
SELECT res.*, rdc.* FROM "PhyllisRobertsonHome".resident res
JOIN "PhyllisRobertsonHome".resident_daily_care rdc on rdc.resident_id = res.id
WHERE res.id_number = '6212205027084';
;

update "PhyllisRobertsonHome".resident_daily_care rdc 
set rdc.resident_id = 
(select res.id from "PhyllisRobertsonHome".resident res where res.room_id = 
 (select r.id FROM "PhyllisRobertsonHome".room r where r.room_number = '1G1')
);

select res.id from "PhyllisRobertsonHome".resident res where res.room_id = 
 (select r.id FROM "PhyllisRobertsonHome".room r where r.room_number = '1G1');

SELECT rdc.* FROM "PhyllisRobertsonHome".resident_daily_care rdc
join "PhyllisRobertsonHome".resident res on rdc.resident_id = res.id
join "PhyllisRobertsonHome".room r on res.room_id = r.id
WHERE r.room_number = '1G1';
;

SELECT rdc.* FROM  rdc
join "PhyllisRobertsonHome".resident res on rdc.resident_id = res.id
join "PhyllisRobertsonHome".room r on res.room_id = r.id
WHERE r.room_number = '1G1';
;

SELECT c.* FROM  "PhyllisRobertsonHome".resident_condition c
join "PhyllisRobertsonHome".resident res on c.resident_id = res.id
join "PhyllisRobertsonHome".room r on res.room_id = r.id
WHERE r.room_number = '1G1';
;

SELECT c.* FROM  "PhyllisRobertsonHome".resident_prescription c
join "PhyllisRobertsonHome".resident res on c.resident_id = res.id
join "PhyllisRobertsonHome".room r on res.room_id = r.id
WHERE r.room_number = '1G1';
;