var net = require ('net');
var server = net . createServer (
  
  function( c ) { //connection listener
    console . log ('server: client connected');
c . on ('end',
	function() {
	  console . log ('server: client disconnected');
	});
	c . on ('data',
	function( data ) {
	 var person = JSON.parse(data);
	  console.log(person.name); //mkyong
	  console.log(person.address.street); //8nd Street
	  console.log(person.address.city); //New York
	  console.log(person.phone[0].number); //111-1111
	  console.log(person.phone[1].type); //fax
	});
	  });
	  
	  server . listen (8001,
			   function() { //listening listener
			     console . log ('server bound');
	  });
	  
