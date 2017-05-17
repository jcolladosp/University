import java.util.Scanner;
import java.util.Locale; 
/**
 * Clase GestorBanco: clase que prueba las clases Banco y Cuenta. Utiliza un sistema de menús para
 * permitir al usuario probar e interactuar con dichas clases.
 * @author PRG 
 * @version Curso 2014/15
 */
public class GestorBanco {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);        
        Banco banco = new Banco();              
        Cuenta cuenta = null, enc = null;
        int op, numCuenta;
        double cantidad;
        
        do {
            op = menu(tec);
            switch(op) {
                case 1: // Crear una nueva cuenta
                    do {
                        numCuenta = getNumCuenta(tec);
                        enc = banco.getCuenta(numCuenta);
                        if (enc != null)                         
                            System.out.println("\n***ERROR***: Cuenta " + numCuenta + " ya existe!\n"); 
                    } while (enc != null);
                    cantidad = getCantidad(tec);             
                    cuenta = new Cuenta(numCuenta, cantidad);
                    banco.añadir(cuenta);
                    System.out.println("Información de la cuenta: " + cuenta + "\n");                
                    break;
                   
                case 2: // Ingresar en la cuenta activa
                try{
                    cantidad = getCantidad(tec);
                    cuenta.ingresar(cantidad);
                    System.out.println("Información de la cuenta: " + cuenta + "\n");   
                }catch (NullPointerException e){
                    System.out.println("ERROR: ¡No hay ninguna cuenta activa! Primero búscala o crea una nueva cuenta");
                }
                break;
                               
            
                case 3: // Retirar de la cuenta activa
                  try{
                    cantidad = getCantidad(tec);
                    cuenta.retirar(cantidad);         
                    System.out.println("Información de la cuenta: " + cuenta + "\n");  }                  
                catch (NullPointerException e){
                    System.out.println("ERROR: ¡No hay ninguna cuenta activa! Primero búscala o crea una nueva cuenta");
                }
                  catch (SaldoInsuficienteException e){
                    System.out.println(e.getMessage());}
                    break;
                
                case 4: // Buscar cuenta
                    numCuenta = getNumCuenta(tec);
                    enc = banco.getCuenta(numCuenta);
                    if (enc != null) {
                        cuenta = enc;
                        System.out.println("Información de la cuenta: " + cuenta + "\n");
                    } else 
                        System.out.println("\n***ERROR***: Cuenta " + numCuenta + " no encontrada!\n");                
                    break;
            
                case 5: // Mostrar la cuenta activa
                    try{
                    String c = cuenta.toString();
                    System.out.println("Información de la cuenta: " + c + "\n") ;}
                    catch (NullPointerException e){
                    System.out.println("ERROR: ¡No hay ninguna cuenta activa! Primero búscala o crea una nueva cuenta");} 
                   
                    break;
                
                case 6: // Mostrar todas las cuentas
                    System.out.print("\n\nTODAS LAS CUENTAS: \n" + banco + "\n\n");
                    break;
            
                case 0: // Terminar  
                    System.out.println("\n\nFin!");
            }
        }while(op!=0);
    }

    /**
     * Muestra un menú de opciones por pantalla y permite 
     * que el usuario elija una de ellas.
     * @param tec Scanner para realizar la lectura.
     * @return int, entero que representa la opción elegida.
     */
    private static int menu(Scanner tec) {
        System.out.println("------------- MENU --------------");
        System.out.println(" 0) Terminar");
        System.out.println(" 1) Crear una nueva cuenta");
        System.out.println(" 2) Ingresar en la cuenta activa");
        System.out.println(" 3) Retirar de la cuenta activa");
        System.out.println(" 4) Buscar cuenta");
        System.out.println(" 5) Mostrar la cuenta activa");
        System.out.println(" 6) Mostrar todas las cuentas");
        System.out.println("---------------------------------");        
        int opcion = LecturaValida.leerInt(tec, "    Elige una opción (0 - 6): ", 0, 6);         
        return opcion;
    }
 
    /**
     * Realiza la lectura de una cantidad válida (un valor real >=0).
     * @param tec Scanner para realizar la lectura.
     * @return double, real >=0 que representa la cantidad leída.
     */
    private static double getCantidad(Scanner tec) {        
        double cantidad = LecturaValida.leerDoublePos(tec, "\nIntroduce la cantidad: "); 
        return cantidad;
    }
  
    /**
     * Realiza la lectura de un número de cuenta válido (un valor entero de 5 dígitos).
     * @param tec Scanner para realizar la lectura.
     * @return int, entero de 5 dígitos que representa el número de cuenta leído.
     */
    private static int getNumCuenta(Scanner tec) {        
        int numCuenta = LecturaValida.leerInt(tec, "\nIntroduce el número de cuenta (de 5 dígitos): ", 10000, 99999); 
        return numCuenta;
    }
       
}
