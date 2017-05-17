public class NodoABB<E> {

E data; // data
NodoABB<E> left, right; // children
int size; // size of node (optional)



public NodoABB(E data, NodoABB<E> l,NodoABB<E> r) {
	this.data = data;
	this.left = l;
	this.right = r;
	size = 1;

	if (left != null) size += left.size;
	if (right != null) size += right.size;
	}
}