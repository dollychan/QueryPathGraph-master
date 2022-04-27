var conn = new Mongo('192.168.156.17:20000');

var db = conn.getDB('onlinestore_qpg');

db.createCollection("customer");
/*db.createCollection("customer",{
	validator: { $jsonSchema:{
		bsonType: "object",
		required: ["customer_id"],
		properties: {
			categories_id: {bsonType: "int"},
   			categories_dummy: {bsonType: "int"},
    			categories_name: {bsonType: "string"}
		}}
	}
});*/
db.createCollection("customer");
db.createCollection("order");
db.createCollection("product");
db.createCollection("product2");
db.createCollection("supplier");
db.createCollection("category");
db.createCollection("carrier");


db.customer.createIndex({"orders.orders_id":1},{name: "query for customer by order"});
db.customer.getIndexes();

db.order.createIndex({"items.item_id":1}, {name:"query for order by item"});

db.product.createIndex({"items.item_id":1}, {name:"query for product by item"});
db.product.createIndex({"items.orders_id":1}, {name:"query for product by order"});
db.product.getIndexes();

db.product2.createIndex({"items.item_id":1}, {name:"query for product by item"});


db.supplier.createIndex({"products.product_id":1}, {name:"query for supplier by products"});
db.supplier.getIndexes();

print('ok');

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"onlinestore_qpg"});
db2.runCommand({ shardcollection: 'onlinestore_qpg.customer', key: {customer_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.product', key: {product_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.product2', key: {product_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.category', key: {category_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.supplier', key: {supplier_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.order', key: {orders_id: 1}, unique:true})
db2.runCommand({ shardcollection: 'onlinestore_qpg.carrier', key: {carrier_id: 1}, unique:true})

print('ok');
db.stats();
