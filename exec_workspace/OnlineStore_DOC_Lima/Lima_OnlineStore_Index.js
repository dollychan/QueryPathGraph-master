var conn = new Mongo('192.168.156.17:20000');

var db = conn.getDB('onlinestore_lima');

db.createCollection("customer");
db.createCollection("category");
db.createCollection("product");
db.createCollection("supplier");
db.createCollection("carrier");

db.customer.createIndex({"orders.orders_id":1},{name: "query order in Customer"});
db.customer.createIndex({"orders.items.item_product":1},{name: "query product in Customer"});
db.customer.createIndex({"orders.items.item_id":1},{name: "query item in Customer"});

db.product.createIndex({product_supplier:1}, {name:"query for product by supplier"});
db.product.createIndex({product_category:1}, {name:"query for product by category"});
db.product.getIndexes();


print('ok');

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"onlinestore_lima"});
db2.runCommand({ shardcollection: 'onlinestore_lima.customer', key: {customer_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_lima.category', key: {category_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_lima.product', key: {product_id: 1 }, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_lima.supplier', key: {supplier_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_lima.carrier', key: {carrier_id: 1}, unique:true})

print('ok');

db.stats();
