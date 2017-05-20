bool botonesAscensor[4];
bool botonPlanta[4];
int planta = 0;
mtype = { arriba, parado, abajo, abiertas, cerradas };
mtype puertas = cerradas;
mtype direccion = parado;
mtype aux = parado;
init{
	botonesAscensor[0] = false;
	botonesAscensor[1] = true;
	botonesAscensor[2] = false;
	botonesAscensor[3] = false;

	botonPlanta[0] = false;
	botonPlanta[1] = false;
	botonPlanta[2] = false;
	botonPlanta[3] = true;

	do
		::planta == 0 && puertas == cerradas ->
			direccion = arriba;
		::planta == 3 && puertas == cerradas ->
			direccion = abajo;
		::direccion == arriba && !botonPlanta[planta] && !botonesAscensor[planta]->
			planta = planta + 1;
		::direccion == abajo && !botonPlanta[planta] && !botonesAscensor[planta]->
			planta = planta - 1;
		::botonPlanta[planta] || botonesAscensor[planta] && direccion != parado ->
			aux = direccion;
			direccion = parado		

		::puertas == cerradas && direccion == parado && (botonesAscensor[planta] || botonPlanta[planta]) ->
			puertas = abiertas;
			botonesAscensor[planta] = false;
			botonPlanta[planta] = false;

		::puertas == abiertas && direccion == parado ->
			puertas = cerradas;
			direccion = aux; 		
		
	od;
}