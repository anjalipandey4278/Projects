const express = require('express');
const pool = require("./db/database");

const app = express();

const port = process.env.PORT || 4000;
const bodyParser = require('body-parser');
app.use(bodyParser.json());


app.get('/form', (req, res) => {
  // Execute the query
  pool.query('SELECT * FROM user', (err, results) => {
    if (err) {
      console.error('Error executing query:', err);
      res.status(500).send('Internal Server Error');
      return;
    }

    // Send the retrieved data as a response
    res.json(results);
  });
});
app.use(bodyParser.urlencoded({ extended: true }));


app.post('/form', (req, res) => {
  var PersonID=Math.floor(Math.random() * 100) + 1;
var firstname = req.body.firstname;
var lastname = req.body.lastname;
var email = req.body.femail;
var password = req.body.fpass;

pool.query('INSERT INTO user (PersonID, FirstName, LastName, Email, password) VALUES (?, ?,?,?,?)', [PersonID, firstname, lastname, email, password], (err, result) => {
  if (err) {
    console.error('Error inserting data into the database: ', err);
    res.status(500).json({ error: 'An error occurred' });
    return;
  }

  console.log('Data inserted into the database');
  res.json({ message: 'Data inserted successfully' });
});
});
app.use(express.static('public'));
app.listen(port , ()=>{
  console.log('server is running ${port}');
})

