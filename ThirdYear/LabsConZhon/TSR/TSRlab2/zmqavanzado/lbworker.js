// Hello World server in Node.js
// Connects REP socket to tcp://*:5560
// Expects "Hello" from client, replies with "World"
if(process.argv.length != 7){
	console.log('uso: node lbworker.js url id text_available text_message verbose')
	process.exit(0);
}
var url = process.argv[2];
var id = process.argv[3];
var text_available = process.argv[4];
var text_message = process.argv[5];
var verbose = process.argv[6];

var zmq = require('zmq')
  , requester = zmq.socket('req');
requester.identity = id;
requester.connect(url);
requester.send(text_available);

requester.on('message', function(msg) {
  console.log('received request:', msg.toString());
  setTimeout(function() {
    requester.send(text);
  }, seconds*1000);
});
