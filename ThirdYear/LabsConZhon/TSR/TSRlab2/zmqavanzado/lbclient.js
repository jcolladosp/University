// Hello World client in Node.js
// Connects REQ socket to tcp://localhost:5559
// Sends "Hello" to server, expects "World" back
if(process.argv.length != 5){
	console.log('uso: node lbclient.js url id  text')
	process.exit(0);
}
var url = process.argv[2];
var id = process.argv[3];
var text = process.argv[4];


var zmq       = require('zmq')
  , requester = zmq.socket('req');
requester.identity = id;
requester.connect(url);
var replyNbr = 0;
requester.on('message', function(msg) {
  console.log('got reply', replyNbr, msg.toString());
  replyNbr += 1;
	if(replyNbr >= 1){ process.exit(0); }	
});

for (var i = 0; i < 1; ++i) {
  requester.send(text);
}


