import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
/**
 * Clase LecturaValida: clase de utilidades para realizar la lectura válida de datos primitivos
 * desde la entrada estándar.
 * 
 * @author PRG 
 * @version Curso 2014/15
 */
public class LecturaValida {

    /**
     * Lee desde un Scanner y devuelve un valor real positivo.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @return double, real positivo leído.
     */    
    public static double leerDoublePos(Scanner tec, String mensaje) {
        double res = 0.0;
        boolean hayError2 = true;
        do {
            try {
           System.out.print(mensaje);
           res = tec.nextDouble();    
          
           hayError2 = false;}
           catch(InputMismatchException e) {
                System.out.println("¡Asegúrate de introducir un double válido! Inténtalo de nuevo ...");}
            finally {
                tec.nextLine();}
        } while (res < 0 && hayError2);
        return res;
    }

    /**
     * Lee desde un Scanner y devuelve un valor entero.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @return int, entero leído.
     */
    public static int leerInt(Scanner tec, String mensaje) {
        int res = 0;
        boolean hayError = true; 
        do {
           try {
                System.out.print(mensaje);
                res = tec.nextInt();
                hayError = false;
           } catch(InputMismatchException e) {
                System.out.println("¡Asegúrate de introducir un entero válido! Inténtalo de nuevo ...");
           } finally {
                tec.nextLine();
           }
        } while (hayError);
        return res;
    }

    /**
     * Lee desde un Scanner y devuelve un valor entero en el intervalo [lInferior..lSuperior] 
     * tal que Integer.MIN_VALUE<=lInferior y lSuperior<=Integer.MAX_VALUE.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @param lInferior int que indica el límite inferior del intervalo de lectura.
     * @param lSuperior int que indica el límite superior del intervalo de lectura.
     * @return int, entero leído en el intervalo [lInferior..lSuperior].
     */    
    public static int leerInt(Scanner tec, String mensaje, int lInferior, int lSuperior) {
        int res = 0;   
         boolean hayError=true;
        do{
        try{
        hayError = false;
        System.out.print(mensaje);
        res = tec.nextInt();
        if(res>lSuperior || res<lInferior){throw new IllegalArgumentException("Introduce un numero dentro del rango permitido."); }
    }catch(InputMismatchException e){
        System.out.println("¡Asegúrate de introducir un entero válido! Inténtalo de nuevo ..."); hayError=true;
    }catch(IllegalArgumentException e){
        System.out.println(e.getMessage()); hayError=true;
    }finally{
        tec.nextLine();
    }
   }while(hayError);
        return res;
    }  
   
}