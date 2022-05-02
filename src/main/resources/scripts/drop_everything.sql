--**************************************
--DROP Everything
--**************************************
Drop SEQUENCE IF EXISTS "PhyllisRobertsonHome".hibernate_sequence;
Drop Table IF EXISTS "PhyllisRobertsonHome".revinfo cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".databasechangelog cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".databasechangeloglock cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".roles cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".roles_aud cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".room cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".room_aud cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".user_roles cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".user_roles_aud cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".users cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".users_aud cascade ;

Drop Table IF EXISTS "PhyllisRobertsonHome".room;
Drop Table IF EXISTS  "PhyllisRobertsonHome".room_aud;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_aud cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_daily_care_aud cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_daily_care  cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_meal  cascade ;
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_meal_aud  cascade ; 
Drop Table IF EXISTS  "PhyllisRobertsonHome".resident_condition cascade ; 
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_condition_aud cascade ; 
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_prescription cascade ; 
Drop Table IF EXISTS "PhyllisRobertsonHome".resident_prescription_aud cascade ; 
