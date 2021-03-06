var express = require("express");
var mysql = require("mysql");
var bodyParser= require("body-parser");
var app = express();
app.use(bodyParser.urlencoded({ extended: true }));

// par défaut le mot de passe est ''
var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : '',
    database:'database'
});
connection.connect();

app.get('/', (req, res) => res.send('Hello World!'))
app.get('/getmovie',function(req,res){  
    var query = "select * from movie";
    connection.query(query,function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})

});


app.get('/getactor',function(req,res){
    var query = "select * from actor";
    connection.query(query,function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})

});

app.get('/getmovie/:name',function(req,res){  
    var query = "select * from movie where name=?";
    connection.query(query,[req.params.name],function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results[0]));
})

});

app.post('/addmovie',function(req,res){
    var movie= req.body
    var query = "insert into movie (id,name,year,language) value (?,?,?,?)";
    connection.query(query,[movie.id,movie.name,movie.year,movie.language],function(error,results){
        if(error){throw(error)}
        res.send(JSON.stringify("Success"));
    })

}) ;


app.post('/addactor',function(req,res){
    var actor= req.body
    console.log(actor)
    var query = "insert into actor (firstname,lastname,gender) value (?,?,?)";
    connection.query(query,[actor.firstname,actor.lastname,actor.gender],function(error,results){
        if(error){throw(error)}
        res.send(JSON.stringify("Success"));
    })

}) ;

var server = app.listen(8082,function(){

    var host = server.address().address
    var port = server.address().port
    console.log('Node server running on port 8082');
});