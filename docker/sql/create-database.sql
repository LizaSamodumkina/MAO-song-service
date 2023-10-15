create user "song_owner" nosuperuser nocreatedb nocreaterole encrypted password '123';

create database song_db_a;

alter database song_db_a owner to song_owner;

\c song_db;

create schema "song_schema";
grant usage on schema song_schema to song_owner;
grant create on schema song_schema to song_owner;
alter default privileges in schema song_schema grant all privileges on tables to song_owner;
