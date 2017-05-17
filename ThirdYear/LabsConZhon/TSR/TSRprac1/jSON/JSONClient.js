var net = require('net');
var client = net.connect({port:8001},

 function() { //connect listener
 console.log('client connected');
 var msg = JSON.stringify(
{
 "name": "Zhonskate",
 "age": 20,
 "address": {
 "street": "Calle lol",
 "city": "Sagunto City"
 },
 "phone": [
 {
 "type": "home",
 "number": "111-1111"
 },
 {
 "type": "fax",
 "number": "222-2222"
 }
 ]
});
 client.write(msg);
 });

 
client.on('end',
 function() {
 console.log('client disconnected');
 });
