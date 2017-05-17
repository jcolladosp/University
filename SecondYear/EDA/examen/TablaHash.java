class EntradaHash<C, V> {
	C clave; // Key of the entry
	V valor; // Value of the entry

public EntradaHash(C clave, V valor) {
	this.clave = clave;
	this.valor = valor;
	}
}

public class TablaHash<C, V> implements Map<C, V> {
	// Array of LPIs
	private ListaConPI<EntradaHash<C,V>> elArray[];

	private int talla;

	public TablaHash(int tallaMaximaEstimada) {
		int capacidad = siguientePrimo((int)(tallaMaximaEstimada/0.75));
		elArray = new LEGListaConPI[capacidad];
		
		for (int i = 0; i < elArray.length; i++){
		elArray[i] = new LEGListaConPI<EntradaHash<C,V>>();}
		talla = 0;
}

private int indiceHash(C c) {
	int indiceHash = c.hashCode() % this.elArray.length;
	if (indiceHash < 0)
	indiceHash += this.elArray.length;
	
	return indiceHash;
}

// It adds the entry(c,v) and returns the old value of the given key (or null if the key dis not have
// any associated value)
public V insertar(C c, V v) {
	V oldValue = null;
	int pos = indiceHash(c);
	ListaConPI<EntradaHash<C,V>> bucket= elArray[pos];

//Search for the entry of key c in the bucket
	for (bucket.inicio(); !bucket.esFin() && !bucket.recuperar().clave.equals(c); bucket.siguiente()){
												
	if (bucket.esFin()) {// Insert the entry if there is not
		bucket.insertar(new EntradaHash<C,V>(c, v));
			talla++; // Rehashing depending on LF
			} else {//If the entry was in the bucket, update its value
				oldValue = bucket.recuperar().valor;
				bucket.recuperar().valor = v;
			}
	return oldValue;
	}
}

// It deletes the entry with key c and returns its associated value (or null if there is no entry
// with this key)
public V eliminar(C c) {
	int pos = indiceHash(c);
	ListaConPI<EntradaHash<C,V>> bucket = elArray[pos];
	V value = null;

// Search for the entry of key c in the bucket
	for (bucket.inicio(); !bucket.esFin() && !bucket.recuperar().clave.equals(c);bucket.siguiente()){

	if (!bucket.esFin()) {// If we find it, we delete it
		value = bucket.recuperar().valor;
		bucket.eliminar();
		talla--;
	}
}
return value;
}

public V recuperar(C c) {
	int pos = indiceHash(c);
	ListaConPI<EntradaHash<C,V>> bucket= elArray[pos];
// Search for the entry of key c in the bucket
	for (bucket.inicio(); !bucket.esFin() && !bucket.recuperar().clave.equals(c); bucket.siguiente()){

	if (bucket.esFin()) return null; // Not found
	else return bucket.recuperar().valor; // Found
	}
}

// It returns true if the Map is empty
public boolean esVacio() { return talla == 0; }

// It returns the number of entries in the Map
public int talla() { return talla; }