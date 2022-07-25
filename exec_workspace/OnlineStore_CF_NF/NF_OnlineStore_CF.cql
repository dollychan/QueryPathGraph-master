CREATE KEYSPACE if not exists onlinestore_nf WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE if not exists carrier(
Carrier_id int,
Carrier_contacts text,
Carrier_name text,
PRIMARY KEY (Carrier_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists supplier(
Supplier_id int,
Supplier_name text,
Supplier_contacts text,
PRIMARY KEY (Supplier_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists category(
Category_id int,
Category_description text,
PRIMARY KEY (Category_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists customer(
Customer_id int,
Customer_contacts text,
Customer_name text,
PRIMARY KEY (Customer_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists item(
Item_id int,
Item_quantity int,
Product_id int,
orders_id int,
PRIMARY KEY (Item_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists product(
Product_id int,
Product_price float,
Product_description text,
Category_id int,
Supplier_id int,
PRIMARY KEY (Product_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

CREATE TABLE if not exists orders(
orders_id int,
orders_totalPrice float,
orders_saleDate timestamp,
Customer_id int,
Payment_id int,
Payment_paymentdate timestamp,
Carrier_id int,
delivery_deliveryDate timestamp,
PRIMARY KEY (orders_id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
