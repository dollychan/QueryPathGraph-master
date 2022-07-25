CREATE KEYSPACE if not exists rubis_qpg WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

create table if not exists Q2(
Categories_dummy int,
Categories_id int,
Categories_name text,
 PRIMARY KEY (( Categories_dummy), Categories_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q4(
Items_id int,
Bids_date timestamp,
Bids_id int,
Users_id int,
Users_nickname text,
Bids_qty int,
Bids_bid float,
 PRIMARY KEY (( Items_id), Bids_date, Bids_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

 create table if not exists Q4_2(
 Items_id int,
 Bids_date timestamp,
 Bids_id int,
 Users_id int,
 Bids_qty int,
 Bids_bid float,
  PRIMARY KEY (( Items_id), Bids_date, Bids_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

 create table if not exists Q5_12(
 Items_id int,
 Bids_bid float,
 Bids_id int,
 Bids_qty int,
 Bids_date timestamp,
  PRIMARY KEY (( Items_id), Bids_bid, Bids_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q6(
Categories_id int,
Items_id int,
Items_end_date timestamp,
Items_name text,
Items_initial_price float,
Items_nb_of_bids int,
Items_max_bid float,
 PRIMARY KEY (( Categories_id), Items_end_date, Items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q1_7_9_14(
Users_id int,
Users_firstname text,
Users_lastname text,
Users_nickname text,
Users_password text,
Users_email text,
Users_rating int,
Users_balance float,
Users_creation_date timestamp,
 PRIMARY KEY (Users_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q8(
Users_id int,
Comments_id int,
Comments_comment text,
Comments_rating int,
Comments_date timestamp,
 PRIMARY KEY (( Users_id), Comments_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q3_10_11_13(
Items_id int,
Items_name text,
Items_description text,
Items_initial_price float,
Items_quantity int,
Items_reserve_price float,
Items_nb_of_bids int,
Items_max_bid float,
Items_start_date timestamp,
Items_end_date timestamp,
Items_buy_now float,
 PRIMARY KEY (Items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

 create table if not exists Q3_10_11_13_18_1(
 Items_id int,
 Items_name text,
 Items_description text,
 Items_initial_price float,
 Items_quantity int,
 Items_reserve_price float,
 Items_nb_of_bids int,
 Items_max_bid float,
 Items_start_date timestamp,
 Items_end_date timestamp,
 Items_buy_now float,
  PRIMARY KEY ((Items_id), Items_end_date))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q15(
Comments_id int,
Users_id int,
Users_nickname text,
 PRIMARY KEY (Comments_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

------------------------
create table if not exists Q15_2(
Comments_id int,
Users_id int,
 PRIMARY KEY (Comments_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q16(
Users_id int,
Buynow_id int,
Buynow_date timestamp,
Items_id int,
Items_name text,
Items_description text,
Items_initial_price float,
Items_quantity int,
Items_reserve_price float,
Items_nb_of_bids int,
Items_max_bid float,
Items_start_date timestamp,
Items_buy_now float,
Items_end_date timestamp,
Buynow_qty int,
 PRIMARY KEY (( Users_id), Buynow_date, Buynow_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE'};

------------------------
create table if not exists Q16_2(
Users_id int,
Buynow_id int,
Buynow_date timestamp,
Items_id int,
Buynow_qty int,
 PRIMARY KEY (( Users_id), Buynow_date, Buynow_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE'};

create table if not exists Q17(
Users_id int,
Items_id int,
Items_end_date timestamp,
Items_name text,
Items_description text,
Items_initial_price float,
Items_quantity int,
Items_reserve_price float,
Items_nb_of_bids int,
Items_max_bid float,
Items_start_date timestamp,
Items_buy_now float,
 PRIMARY KEY (( Users_id), Items_end_date, Items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE'};

create table if not exists Q18(
Users_id int,
Bids_id int,
Items_end_date timestamp,
Items_id int,
Items_name text,
Items_description text,
Items_initial_price float,
Items_quantity int,
Items_reserve_price float,
Items_nb_of_bids int,
Items_max_bid float,
Items_start_date timestamp,
Items_buy_now float,
 PRIMARY KEY (( Users_id), Items_end_date, Bids_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

 --------------
 create table if not exists Q18_2(
 Users_id int,
 Bids_id int,
 Items_id int,
  PRIMARY KEY (( Users_id), Bids_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q19(
Categories_id int,
Regions_id int,
Items_id int,
Items_end_date timestamp,
Items_name text,
Items_initial_price float,
Items_nb_of_bids int,
Items_max_bid float,
Users_id int,
 PRIMARY KEY (( Categories_id, Regions_id), Items_end_date, Users_id, Items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists Q20(
Regions_dummy int,
Regions_id int,
Regions_name text,
 PRIMARY KEY (( Regions_dummy), Regions_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE'};