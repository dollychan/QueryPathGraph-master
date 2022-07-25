var conn = new Mongo('192.168.156.13:20000');

var db = conn.getDB('rubis_w10_qpg');

db.createCollection("users2");
db.createCollection("categories");
db.createCollection("comments");
db.createCollection("items");
db.createCollection("regions");

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"rubis_w10_qpg"});
db2.runCommand({ shardcollection: 'rubis_w10_qpg.users2', key: {users_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_w10_qpg.categories', key: {categories_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_w10_qpg.comments', key: {comments_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_w10_qpg.items', key: {items_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_w10_qpg.regions', key: {regions_id: "hashed"}})

print('ok');
db.stats();
