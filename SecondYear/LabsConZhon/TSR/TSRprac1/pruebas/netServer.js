var net = require ('net');
var server = net . createServer (

function( c ) { //connection listener
console . log ('server: client connected');
c . on ('end',
function() {
console . log ('server: client disconnected');
});
c . on ('data',
function( data ) {
c.write ('Hello\r\n'+ data.toString ()); // send response

c.end (); // close socket
});
});

server . listen (8000,
function() { //listening listener
console . log ('server bound');
});
