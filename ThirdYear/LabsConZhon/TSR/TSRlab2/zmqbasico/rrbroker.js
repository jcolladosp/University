// Simple request-reply broker in Node.js
if(process.argv.length != 4){
	console.log('uso: node rrbroker.js client_port workers_port')
	process.exit(0);
}
var port1 = process.argv[2];
var port2 = process.argv[3];
var zmq      = require('zmq')
  , frontend = zmq.socket('router')
  , backend  = zmq.socket('dealer');

frontend.bindSync('tcp://*:'+port1);
backend.bindSync('tcp://*:'+port2);

frontend.on('message', function() {
  // Note that separate message parts come as function arguments.
  var args = Array.apply(null, arguments);
  // Pass array of strings/buffers to send multipart messages.
  backend.send(args);
});

backend.on('message', function() {
  var args = Array.apply(null, arguments);
  frontend.send(args);
});
