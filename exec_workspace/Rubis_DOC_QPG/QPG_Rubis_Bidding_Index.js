var conn = new Mongo('192.168.156.13:20000');

var db = conn.getDB('rubis_bidding_qpg');

db.createCollection("users");
db.createCollection("categories");
db.createCollection("comments");
db.createCollection("items");
db.createCollection("regions");

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"rubis_bidding_qpg"});
db2.runCommand({ shardcollection: 'rubis_bidding_qpg.users', key: {users_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_bidding_qpg.categories', key: {categories_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_bidding_qpg.comments', key: {comments_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_bidding_qpg.items', key: {items_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_bidding_qpg.regions', key: {regions_id: "hashed"}})

print('ok');
db.stats();
