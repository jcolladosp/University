public interface Map<C, V> {
	V insert(C c, V v);
	V delete(C c);
	V retrieve(C c);
	boolean isEmpty();
	int size();
	ListaConPI<C> keys();
}

class EntradaMap<C extends Comparable<C>,E>
	implements Comparable<EntradaMap<C,E>> {

	C key;
	E value;

	public EntradaMap(C c, E e) {key = c; value = e;}
	public EntradaMap(C c) { this(c, null); }
	
	public boolean equals(Object x) {
	return ((EntradaMap<C,E>)x).key.equals(this.key);}
			
	public int compareTo(EntradaMap<C,E> x) {
		return this.key.compareTo(x.key);}
		
	public String toString() {
	return this.key + " => " + this.value;}

}

public class ABBMap<C extends Comparable<C>,V>
	implements Map<C,V> {
private ABB<EntradaMap<C,V>> abb;
public ABBMap() { abb = new ABB<EntradaMap<C,V>>(); }
public V retrieve(C c) {
EntradaMap<C,V> e;
e = abb.retrieve(new EntradaMap<C,V>(c));
return e == null ? null : e.value;
}
public V insert(C c, V v) {
EntradaMap<C,V> newentry = new EntradaMap<C,V>(c,v);
EntradaMap<C,V> prev = abb.retrieve(newentry);
return prev == null ? null : prev.value;
}
public V delete(C c) {
EntradaMap<C,V> prev = abb.delete(new EntradaMap<C,V>(c));
return prev == null ? null : prev.value;
}