var zmq = require('zmq')
var subscriber = zmq.socket('sub')

if(process.argv.length != 4){
	console.log('uso: node subscriber.js url filter')
	process.exit(0);
}
var url = process.argv[2];
var filter = process.argv[3];

subscriber.on("message", function(reply) {
  console.log('Received message: ', reply.toString());
})

subscriber.connect(url)
subscriber.subscribe(filter)

process.on('SIGINT', function() {
  subscriber.close()
  console.log('\nClosed')
})
