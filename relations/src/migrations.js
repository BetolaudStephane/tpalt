var sqlite3 = require('sqlite3').verbose();
var db = new sqlite3.Database('./relations.db');

db.serialize(function () {
	db.run('DROP TABLE IF EXISTS unary_relations');
	db.run('CREATE TABLE unary_relations (id1 STRING, id2 STRING)');

	db.run('DROP TABLE IF EXISTS interests');
	db.run('CREATE TABLE interests (id INTEGER PRIMARY KEY, name STRING)');

	db.run('DROP TABLE IF EXISTS users_interests');
	db.run(
		'CREATE TABLE users_interests (user_id STRING, interest_id INTEGER, FOREIGN KEY(interest_id) REFERENCES interests(id))'
	);
});

db.close();
