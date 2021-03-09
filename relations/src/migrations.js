var sqlite3 = require('sqlite3').verbose();
var db = new sqlite3.Database('./relations.db');

db.serialize(function () {
	db.run('DROP TABLE IF EXISTS unary_relations');
	db.run('CREATE TABLE unary_relations (id1 STRING, id2 STRING)');
});

db.close();
