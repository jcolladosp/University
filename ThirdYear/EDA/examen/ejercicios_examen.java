1.- Se dispone de un Map m en el que cada clave es el nombre de un tifón y su valor asociado es el año en el que ocurrió.
Para poder conocer cuántos tifones de los registrados en este Map se han producido en cada uno de los años que aparecen
en él, se pide diseñar un método con perfil.

public static Map<Integer, Integer> tifones(Map<String, Integer> m)
tal que, dado m, devuelva un Map en el que cada clave sea un año y su valor asociado sea el número de tifones que
ocurrieron en él. Además, como ambos Maps se implementan con Tablas Hash en las que el coste promedio de insertar y
recuperar es Θ(1), el coste de tifones debe ser estrictamente del orden de la talla de m (Θ(m.talla()). (0.6 puntos)

public static Map<Integer, Integer> tifones(Map<String, Integer> m){
Map<Integer,Integer> sol = new TablaHash<Integer,Integer>(m.talla);
ListaConPI<C> nombres = m.claves();

nombres.inicio();
while(!esFin()){
String name = nombres.recuperar();
Integer year = m.recuperar(name);

Integer frec = sol.recuperar(year);

if(frec == null) sol.insertar(year,1);
else sol.insertar(year,frec++);

}
return sol
}

2.- En la clase TablaHash, se pide diseñar un método colisionanCon que, con el menor coste posible, devuelva una
Lista Con Punto de Interés con todas las claves de una Tabla Hash que colisionan con una dada c. 

public ListaConPI<C> buscadorColision(C c){
	ListaConPI<C> sol = new LEGListaConPI<C>();
	int pos = indiceHash(c);
	ListaConPI<EntradaHash<C,V>> aux = elArray[pos];

	for (aux.inicio();!aux.esFin() ;aux.siguente() ) {
		C clave = aux.recuperar().clave;
		if(clave.equals(c) == false) sol.insertar(clave);

	}

	return sol;
}

Se pide diseñar un método estático, genérico e iterativo abbSortDesc que, usando como estructura de datos auxiliar
un ABB, ordene descendentemente los elementos (Comparable) de un array v de la forma más eficiente posible; para
ello, asúmase que v contiene v.length componentes distintas y completamente desordenadas y que solo se pueden usar
los métodos públicos de la clase ABB (ver Anexo), pues no se tiene acceso a su código.

public static <E extends Comparable <E>> void abbSortDesc(E[] v){
ABB<E> tree = new ABB<E>();
for (int i = 0;i < v.length ;i++ ) {
	tree.insertar(v[i]);
}
E aux = tree.recuperarMax();
v[0] = aux;
for (int i =1 ;i < v.length-1 ;i++ ) {
	aux = tree.predecesor; v[i] = aux;
}

}

1.- Dados dos arrays de palabras (String) no vacíos, v1 y v2, se pide diseñar un método estático que devuelva un
(nuevo) array que contenga aquellas palabras de v1 que no estén en v2, o un array vacío (de longitud 0) si no existe
ninguna palabra que cumpla dicha condición. Para que la implementación de este método sea la más eficiente posible, se
deberá usar como estructura auxiliar un Map implementado mediante una TablaHash. 

public static String[] repes(String[] v1,String[] v2){
	Map<String,String> aux = new TablaHash<String,String>(v1.length);
	for(String s:v1) aux.insertar(s,s);
	for(String s:v1) aux.eliminar(s);

	ListaConPI<String> claves = aux.claves();
	String[] sol = new String[aux.talla()];
	int i =0;
	for (claves.inicio();!claves.esFin() ;claves.siguente() ) {
			sol[i] = claves.recuperar();
			i++;
		}	
		return sol;
}