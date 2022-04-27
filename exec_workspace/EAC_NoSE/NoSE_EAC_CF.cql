
CREATE KEYSPACE if not exists eac_nose WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

create table if not exists CF1(
server_id int,
state_timestamp timestamp,
player_id int,
state_id int,
session_id int,
player_isAdmin int,
state_posX int,
state_posY int,
state_posZ int,
PRIMARY KEY ((server_id), state_timestamp, player_id, state_id, session_id))
WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists CF2(
server_id int,
server_name text,
server_ip text,
PRIMARY KEY (server_id ))
WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists CF3(
player_id int,
session_id int,
PRIMARY KEY (( player_id), session_id ))
WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists CF4(
session_id int,
player_id int,
server_id int,
player_isAdmin int,
PRIMARY KEY ((session_id),player_id ))
WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists CF5(
player_id int,
player_isAdmin int,
PRIMARY KEY ( player_id ))
WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };



