function fib ( n ) {
return ( n <2)? 1: fib ( n -2)+ fib ( n -1);
}
console.log ("iniciando ejecucion...");
setTimeout ( //espera 10 seg y ejecuta la funcion
function() {
console . log ('M1: Quiero escribir ...');
}, 10);
var j = fib (40); // cuesta mas de 1seg
function otherMsg ( m , u ) {
console . log ( m + ": El resultado es "+ u );
}
otherMsg ("M2", j ); //M2 se escribe antes que M1 porque el hilo principal rara vez se suspende

setTimeout ( // M3 se escribe tras M1
function() { otherMsg ('M3', j );},
1);
