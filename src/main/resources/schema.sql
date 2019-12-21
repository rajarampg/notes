--create database notesapp;
--use notesapp;

drop table if exists notesdetails;
CREATE TABLE notesdetails (
notes_id int auto_increment, 
notes_title varchar(300), 
notes_description VARCHAR(3000), 
created_by VARCHAR(50), 
created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
modified_on datetime, 
active boolean DEFAULT true, 
primary key(notes_id)
);