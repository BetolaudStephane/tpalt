var sqlite3 = require('sqlite3').verbose();
var db = new sqlite3.Database('./relations.db');

/* relations */

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

/* interests */

const getAllInterests = (req, res) => {
	db.all('SELECT * FROM interests', (err, rows) => {
		res.send(rows);
	});
};

const insertInterest = (interest) => {
	var stmt = db.prepare('INSERT INTO interests(name) VALUES ($name)', {
		$name: interest,
	});
	stmt.run();
	stmt.finalize();
};

/* users interests */

const getAllUsersInterests = (req, res) => {
	db.all('SELECT * FROM users_interests', (err, rows) => {
		res.send(rows);
	});
};

// TODO: verify that tuple is not already there
// or modify table to insert only if values do not exists
const insertUserInterest = (user_id, interest_id) => {
	var stmt = db.prepare(
		'INSERT INTO users_interests VALUES ($user_id, $interest_id)',
		{
			$user_id: user_id,
			$interest_id: interest_id,
		}
	);
	stmt.run();
	stmt.finalize();
};

const findAndInsertUserInterest = (user_interest) => {
	db.get(
		'SELECT id FROM interests WHERE name=$name',
		{
			$name: user_interest.interest,
		},
		(err, interest_id) => {
			if (err) {
				console.error(err.message);
			}
			if (!interest_id) {
				insertInterest(user_interest.interest);
				db.get(
					'SELECT id FROM interests WHERE name=$name',
					{
						$name: user_interest.interest,
					},
					(err, row) => {
						if (err) console.error(err.message);
						if (!row)
							console.error(
								'Oups ! Something went wrong when inserting interest: ' +
									user_interest.interest
							);
						insertUserInterest(user_interest.user_id, interest_id);
					}
				);
			} else {
				insertUserInterest(user_interest.user_id, interest_id);
			}
		}
	);
};

const postUserInterest = (req, res) => {
	const user_interest = req.body;
	findAndInsertUserInterest(user_interest);
	res.sendStatus(200);
};

const postUsersInterest = (req, res) => {
	const users_interest = req.body;
	users_interest.map((user_interest) => {
		findAndInsertUserInterest(user_interest);
	});
	res.sendStatus(200);
};

module.exports = {
	getAllUnaryRelations,
	postUnaryRelation,
	getAllInterests,
	getAllUsersInterests,
	postUserInterest,
	postUsersInterest,
};
