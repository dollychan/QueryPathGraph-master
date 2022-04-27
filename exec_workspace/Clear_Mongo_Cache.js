var conn = new Mongo('192.168.156.17:20000');

var db1 = conn.getDB('onlinestore_lima');
db1.customer.getPlanCache().clear();
db1.category.getPlanCache().clear();
db1.supplier.getPlanCache().clear();
db1.product.getPlanCache().clear();
db1.carrier.getPlanCache().clear();

var db4 = conn.getDB('onlinestore_qpg');
db4.customer.getPlanCache().clear();
db4.product.getPlanCache().clear();
db4.category.getPlanCache().clear();
db4.supplier.getPlanCache().clear();
db4.carrier.getPlanCache().clear();
db4.order.getPlanCache().clear();
db4.product2.getPlanCache().clear();

/*
var db2 = conn.getDB('onlinestore_mortadelo');
db2.customer.getPlanCache().clear();
db2.product.getPlanCache().clear();

var db3 = conn.getDB('onlinestore_mortadelo_noindex');
db3.customer.getPlanCache().clear();
db3.product.getPlanCache().clear();

var db5 = conn.getDB('onlinestore_qpg_hw');
db5.customer.getPlanCache().clear();
db5.product.getPlanCache().clear();
db5.category.getPlanCache().clear();
db5.supplier.getPlanCache().clear();
*/

print('ok');