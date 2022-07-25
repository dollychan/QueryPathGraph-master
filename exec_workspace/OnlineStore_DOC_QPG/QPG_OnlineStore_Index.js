var conn = new Mongo('192.168.156.17:20000');

var db = conn.getDB('onlinestore_qpg');

db.createCollection("customer");
db.createCollection("order");
db.createCollection("product");
db.createCollection("supplier");
db.createCollection("category");
db.createCollection("carrier");

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"onlinestore_qpg"});
db2.runCommand({ shardcollection: 'onlinestore_qpg.customer',  key:{customer_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_qpg.product',  key:{product_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_qpg.category',  key:{category_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_qpg.supplier',  key:{supplier_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_qpg.order',  key:{orders_id: "hashed"}})
db2.runCommand({ shardcollection: 'onlinestore_qpg.carrier',  key:{carrier_id: "hashed"}})

print('ok');
db.stats();
