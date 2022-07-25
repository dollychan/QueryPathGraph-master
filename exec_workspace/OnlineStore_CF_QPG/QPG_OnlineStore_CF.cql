CREATE KEYSPACE if not exists onlinestore_qpg WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE if not exists q6_1(
Supplier_id int,
Product_id int,
Category_id int,
Product_price float,
Product_description text,
PRIMARY KEY ((Supplier_id),Product_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q6(
Supplier_id int,
Supplier_name text,
Supplier_contacts text,
PRIMARY KEY (Supplier_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q6_2(
Category_id int,
Category_description text,
PRIMARY KEY (Category_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q5_1(
Product_id int,
Item_id int,
Item_quantity int,
orders_totalPrice float,
orders_id int,
orders_saleDate timestamp,
PRIMARY KEY ((Product_id),Item_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q1_2_5(
Product_id int,
Product_price float,
Product_description text,
PRIMARY KEY (Product_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q3_2(
Carrier_id int,
Carrier_contacts text,
Carrier_name text,
PRIMARY KEY (Carrier_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q1(
orders_id int,
Item_id int,
Product_id int,
Item_quantity int,
orders_totalPrice float,
orders_saleDate timestamp,
PRIMARY KEY ((orders_id),Item_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q2_1_1(
orders_id int,
orders_totalPrice float,
orders_saleDate timestamp,
Customer_id int,
Payment_id int,
Payment_paymentdate timestamp,
PRIMARY KEY (orders_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q3_2_1_4_1_3(
Customer_id int,
Customer_contacts text,
Customer_name text,
PRIMARY KEY (Customer_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists q3_1_4_1(
Customer_id int,
orders_id int,
Carrier_id int,
orders_totalPrice float,
orders_saleDate timestamp,
Payment_id int,
Payment_paymentdate timestamp,
delivery_deliveryDate timestamp,
PRIMARY KEY ((Customer_id),orders_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };