CREATE KEYSPACE if not exists rubis_nose WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

--Q2
create table if not exists i3722443462(
categories_dummy int,
categories_id int,
categories_name text,
 PRIMARY KEY (( categories_dummy), categories_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q4
create table if not exists i193173044(
items_id int,
bids_date timestamp,
bids_id int,
users_id int,
users_nickname text,
bids_qty int,
bids_bid float,
 PRIMARY KEY (( items_id), bids_date, bids_id, users_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q3_10_11_13
create table if not exists i1888493477(
items_id int,
items_name text,
items_description text,
items_initial_price float,
items_quantity int,
items_reserve_price float,
items_buy_now float,
items_nb_of_bids int,
items_max_bid float,
items_start_date timestamp,
items_end_date timestamp,
 PRIMARY KEY (items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q6
create table if not exists i3392968797(
categories_id int,
items_end_date timestamp,
items_id int,
items_name text,
items_initial_price float,
items_max_bid float,
items_nb_of_bids int,
 PRIMARY KEY (( categories_id), items_end_date, items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };


--Q1_7_9_14
create table if not exists i2906147889(
users_id int,
users_firstname text,
users_lastname text,
users_nickname text,
users_password text,
users_email text,
users_rating int,
users_balance float,
users_creation_date timestamp,
 PRIMARY KEY (users_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q8
create table if not exists i3157175159(
users_id int,
comments_id int,
comments_rating int,
comments_date timestamp,
comments_comment text,
 PRIMARY KEY (( users_id), comments_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q5_12
create table if not exists i3563903410(
items_id int,
bids_bid float,
bids_id int,
bids_qty int,
bids_date timestamp,
 PRIMARY KEY (( items_id), bids_bid, bids_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };


--Q15
create table if not exists i915430138(
comments_id int,
users_id int,
users_nickname text,
 PRIMARY KEY (( comments_id), users_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };


--Q16
create table if not exists i2653317939(
users_id int,
buynow_date timestamp,
buynow_id int,
items_id int,
buynow_qty int,
items_name text,
items_description text,
items_initial_price float,
items_quantity int,
items_reserve_price float,
items_buy_now float,
items_nb_of_bids int,
items_max_bid float,
items_start_date timestamp,
items_end_date timestamp,
 PRIMARY KEY (( users_id), buynow_date, buynow_id, items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q17
create table if not exists i2337785568(
users_id int,
items_id int,
items_name text,
items_description text,
items_initial_price float,
items_quantity int,
items_reserve_price float,
items_buy_now float,
items_nb_of_bids int,
items_max_bid float,
items_start_date timestamp,
items_end_date timestamp,
 PRIMARY KEY (( users_id), items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q18
create table if not exists i3553045793(
users_id int,
items_end_date timestamp,
bids_id int,
items_id int,
 PRIMARY KEY (( users_id), items_end_date, bids_id, items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q19
create table if not exists i3639792234(
regions_id int,
categories_id int,
users_id int,
items_id int,
items_name text,
items_initial_price float,
items_max_bid float,
items_nb_of_bids int,
items_end_date timestamp,
 PRIMARY KEY (( regions_id), categories_id, users_id, items_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };


--Q20
create table if not exists i590232953(
regions_dummy int,
regions_id int,
regions_name text,
 PRIMARY KEY (( regions_dummy), regions_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q5
create table if not exists i3220017915	(
 items_id int,
 bids_id int,
 bids_qty int,
 bids_bid float,
 bids_date timestamp,
  PRIMARY KEY (( items_id), bids_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };


--Q19
 create table if not exists i4047225742(
 regions_id int,
 categories_id int,
 items_end_date timestamp,
 items_id int,
 users_id int,
 items_name text,
 items_initial_price float,
 items_nb_of_bids int,
 items_max_bid float,
  PRIMARY KEY (( regions_id), categories_id,items_end_date, items_id, users_id ))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q6
 create table if not exists i1175133162(
 categories_id int,
 items_end_date timestamp,
 items_id int,
  PRIMARY KEY (( categories_id), items_end_date,items_id ))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q15
create table if not exists i3128537325(
comments_id int,
users_id int,
 PRIMARY KEY (( comments_id), users_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q19
create table if not exists i184475158(
categories_id int,
regions_id int,
users_id int,
items_id int,
items_end_date timestamp,
items_name text,
items_initial_price float,
items_nb_of_bids int,
items_max_bid float,
  PRIMARY KEY (( categories_id), regions_id, users_id, items_id ))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--Q19
create table if not exists i2817567804	(
 regions_id int,
 categories_id int,
 items_id int,
 users_id int,
 items_end_date timestamp,
 items_name text,
 items_initial_price float,
 items_nb_of_bids int,
 items_max_bid float,
  PRIMARY KEY (( regions_id), categories_id, items_id,users_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists i3264766123(
items_id int,
categories_id int,
 PRIMARY KEY (( items_id), categories_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

 --
 create table if not exists i2578518014(
 items_id int,
 buynow_id int,
 buynow_date timestamp,
 users_id int,
  PRIMARY KEY (( items_id), buynow_id, buynow_date, users_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--
create table if not exists i578710568(
   items_id int,
   users_id int,
    PRIMARY KEY (( items_id), users_id))
    WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--
create table if not exists i1683742356(
users_id int,
regions_id int,
 PRIMARY KEY (( users_id), regions_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--
create table if not exists i1912786220(
items_id int,
users_id int,
regions_id int,
 PRIMARY KEY (( items_id), users_id, regions_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

--
create table if not exists i101364659 (
items_id int,
regions_id int,
users_id int,
  PRIMARY KEY (( items_id), regions_id, users_id))
  WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
