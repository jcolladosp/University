// Hello World server in Node.js
// Connects REP socket to tcp://*:5560
// Expects "Hello" from client, replies with "World"
if(process.argv.length != 5){
	console.log('uso: node rrworker.js url seconds text')
	process.exit(0);
}
var url = process.argv[2];
var seconds = process.argv[3];
var text = process.argv[4];

var zmq = require('zmq')
  , responder = zmq.socket('rep');

responder.connect(url);
responder.on('message', function(msg) {
  console.log('received request:', msg.toString());
  setTimeout(function() {
    responder.send(text);
  }, seconds*1000);
});
