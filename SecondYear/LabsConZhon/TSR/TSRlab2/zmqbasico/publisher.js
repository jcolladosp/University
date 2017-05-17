var zmq = require('zmq')
var publisher = zmq.socket('pub')

if(process.argv.length != 6){
	console.log('uso: node publisher.js port nºmessages 1stype 2ndtype')
	process.exit(0);
}

var port = process.argv[2];
var nmessages = process.argv[3];
var ftype = process.argv[4];
var stype = process.argv[5];

publisher.bind('tcp://*:'+port, function(err) {
  if(err)
    console.log(err)
  else
    console.log("Listening on "+port+"...")
})

for (var i=1 ; i<nmessages ; i++)
    setTimeout(function() {
        console.log('sent');
        publisher.send(ftype+': Hello to news')
		publisher.send(stype+': chollo unico, minimo historico')
    }, 1000 * i)

process.on('SIGINT', function() {
  publisher.close()
  console.log('\nClosed')
})
