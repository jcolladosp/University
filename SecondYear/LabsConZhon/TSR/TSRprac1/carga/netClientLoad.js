var net = require ('net'); 
var pasar = process.argv[3]
var client = net . connect ({port:8000,host:process.argv[2]},
function() { //connect listener
console . log ('client connected');
client . write (pasar);
});

client . on ('data',
function( data ) {
console . log ( data . toString ());
client . end (); //no more data written to the stream

});
client . on ('end',
function() {
console . log ('client disconnected');
});
