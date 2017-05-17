// Hello World server
// Binds REP socket to tcp://*:5555
// Expects "Hello" from client, replies with "world"

var zmq = require('zmq');

if(process.argv.length != 5){
	console.log('uso: node hwclient.js port delay text')
	process.exit(0);
}

// socket to talk to clients
var responder = zmq.socket('rep');
var port = process.argv[2];
var delay = process.argv[3];
var text = process.argv[4];

responder.on('message', function(request) {
  console.log("Received request: [", request.toString(), "]");

  // do some 'work'
  setTimeout(function() {

    // send reply back to client.
    responder.send(request.toString() + text);
  }, delay);
});

responder.bind('tcp://*:' + port, function(err) {
  if (err) {
    console.log(err);
  } else {
    console.log("Listening on" + port + "...");
  }
});

process.on('SIGINT', function() {
  responder.close();
});
