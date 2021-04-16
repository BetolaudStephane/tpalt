const models = require('./src/models');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }));

// parse application/json
app.use(bodyParser.json());

app.get('/unary-relations', (req, res) => {
	models.getAllUnaryRelations(req, res);
});

app.post('/unary-relation', (req, res) => {
	models.postUnaryRelation(req, res);
});

app.get('/interests', (req, res) => {
	models.getAllInterests(req, res);
});

app.get('/users-interests', (req, res) => {
	models.getAllUsersInterests(req, res);
});

app.post('/user-interests', (req, res) => {
	models.postUserInterests(req, res);
});

app.post('/users-interests', (req, res) => {
	models.postUsersInterests(req, res);
});

app.listen(port, () => {
	console.log(`Example app listening at http://localhost:${port}`);
});
