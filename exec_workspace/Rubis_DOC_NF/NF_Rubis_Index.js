var conn = new Mongo('192.168.156.13:20000');

var db = conn.getDB('rubis_nf');

db.createCollection("users");
db.createCollection("categories");
db.createCollection("regions");
db.createCollection("buynow");
db.createCollection("items");
db.createCollection("comments");
db.createCollection("bids");

print('ok');

var db2 = conn.getDB('admin');
db2.runCommand({enablesharding:"rubis_nf"});
db2.runCommand({ shardcollection: 'rubis_nf.users', key: {users_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.items', key: {items_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.categories', key: {categories_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.regions', key: {regions_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.comments', key: {comments_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.bids', key: {bids_id: "hashed"}})
db2.runCommand({ shardcollection: 'rubis_nf.buynow', key: {buynow_id: "hashed"}})

print('ok');
db.stats();
