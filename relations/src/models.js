var sqlite3 = require('sqlite3').verbose();
var db = new sqlite3.Database('./relations.db');

const getAllUnaryRelations = (req, res) => {
	db.all('SELECT * FROM unary_relations', (err, rows) => {
		res.send(rows);
	});
};

const postUnaryRelation = (req, res) => {
	const relation = req.body;
	var stmt = db.prepare('INSERT INTO unary_relations VALUES ($id1, $id2)', {
		$id1: relation.id1,
		$id2: relation.id2,
	});
	stmt.run();
	stmt.finalize();
	res.sendStatus(200);
};

module.exports = {
	getAllUnaryRelations,
	postUnaryRelation,
};
