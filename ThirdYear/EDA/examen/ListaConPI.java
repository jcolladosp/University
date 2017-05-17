public interface ListaConPI<E> {

/** insert e before the PI, that does not move **/
void insertar(E e); // Q(1)

/** !esFin(): if PI is not after the last element,
it deletes the element at PI **/
void eliminar(); // Q(1)

/**!esFin(): it returns the the element at PI **/
E recuperar(); // Q(1)

/** PI is moved at the beginning **/
void inicio(); // Q(1)

/** !esFin(): PI is moved to the next position **/
void siguiente(); // Q(1)

/** it checks if PI is after the last element **/
boolean esFin(); // Q(1)

/** it checks if ListaConPI is empty **/
boolean esVacia(); // Q(1)

/** it moves PI after the last element **/
void fin(); // Q(1)

/** it returns the size of ListaConPI **/
int talla(); // Q(1)
}