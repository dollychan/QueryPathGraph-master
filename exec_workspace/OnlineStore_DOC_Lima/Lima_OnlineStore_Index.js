var conn = new Mongo('192.168.156.17:20000');

var db = conn.getDB('onlinestore_lima');

db.createCollection("customer");
db.createCollection("category");
db.createCollection("product");
db.createCollection("supplier");
db.createCollection("carrier");

print('ok');

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"onlinestore_lima"});
db2.runCommand({ shardcollection: 'onlinestore_lima.customer', key: {customer_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_lima.category', key: {category_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_lima.product', key: {product_id: "hashed" }})
db2.runCommand({ shardcollection: 'onlinestore_lima.supplier', key: {supplier_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_lima.carrier', key: {carrier_id: "hashed"}})

print('ok');

db.stats();
