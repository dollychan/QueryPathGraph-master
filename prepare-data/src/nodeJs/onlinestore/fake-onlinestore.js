var Table = require('mysql-faker').Table,
    insert = require('mysql-faker').insert;

var category = (new Table('category', 61));
category.lorem_words('description', 2);

var supplier = (new Table('supplier', 165));
supplier.lorem_words('name')
  .lorem_words('contacts');

var carrier = (new Table('carrier', 16));
carrier.lorem_words('name')
  .lorem_words('contacts');

var payment = (new Table('payment', 1113951));
payment.date_past('paymentDate');

var product = (new Table('product', 900));
product.finance_amount('price')
  .lorem_words('description',2)
  .random_number('category', {min: 1, max: category.count})
  .random_number('supplier', {min: 1, max: supplier.count});

var customer = (new Table('customer', 32418));
customer.lorem_words('name')
     .lorem_words('contacts');

var orders = (new Table('orders', payment.count));
orders.finance_amount('totalPrice')
     .date_past('date')
     .date_past('saleDate')
     .random_number('customer', {min: 1, max: customer.count})
     .random_number('payment', {min: 1, max: payment.count});

var delivery = (new Table('delivery', payment.count));
delivery.random_number('carrier', {min: 1, max: carrier.count})
.date_past('deliveryDate');

var item = (new Table('item', 1789082));
item.random_number('quantity', {min: 1, max: 100})
  .random_number('orders', {min: 1, max: orders.count})
    .random_number('product', {min: 1, max: product.count});

insert([
  category,
  supplier,
  carrier,
  payment,
  product,
  customer,
  orders,
  item,
  delivery
], {
  host: 'localhost',
  user: 'root',
  password: 'mysql123',
  database: 'onlinestore'
}, true);
