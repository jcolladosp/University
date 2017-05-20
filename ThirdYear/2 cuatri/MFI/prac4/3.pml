mtype = { vacio, cero, uno };
mtype enviaA = cero;
mtype enviaB = vacio;
mtype recibeA = vacio;
mtype recibeB = vacio;


proctype sender() {
do
	::atomic
	{ (recibeA == enviaA && recibeA != vacio & enviaA==cero) -> 	enviaA = uno }
	::atomic
	{ (recibeA == enviaA && recibeA != vacio & enviaA==uno) -> enviaA = cero }
od
}

proctype receiver() {
	do
	::atomic
	{ (recibeB == enviaB && recibeB != vacio & enviaA==cero) -> 	recibeA = cero }
	::atomic
	{ (recibeB == enviaB && recibeB != vacio & enviaA==uno) -> recibeA = uno }
	od
}

proctype channel(mtype input; mtype output) {
	do
		:: output = input;
		:: output = vacio;
	od
	}
init {atomic {run sender(); run receiver(); run channel(..., ...); run channel(..., ...); }}