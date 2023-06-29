const {
    createPool
 } = require('mysql2');

 const pool = createPool({
    host: "localhost",
    user: "root",
    password: "your_current_password",
    database: "users",
    connectionLimit: 10
 })
 pool.query('select * from user', (err, result, fields)=>{
    if(err){
        return console.log(err);
    }
    return console.log(result);
 })

 module.exports = pool;