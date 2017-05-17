// Hello World client
// Connects REQ socket to tcp://localhost:8000
// Sends "Hello" to server.

var zmq = require('zmq');

if(process.argv.length != 5){
	console.log('uso: node hwclient.js url requests text')
	process.exit(0);
}


// socket to talk to server
console.log("Connecting to hello world server...");
var requester = zmq.socket('req');

var x = 0;
var url = process.argv[2];
var requests = process.argv[3];
var text = process.argv[4];
requester.on("message", function(reply) {
  console.log("Received reply", x, ": [", reply.toString(), ']');
  x += 1;
  if (x === requests) {
    requester.close();
    process.exit(0);
  }
});

requester.connect(url);

for (var i = 0; i < requests; i++) {
  console.log("Sending request", i, '...');
  requester.send(text);
}

process.on('SIGINT', function() {
  requester.close();
});
