import java.io.*;
public class Deriverable{
public static void main(String[] args) {
	String entrada = "entrada.txt";
	String salida = "salida.txt";
Scanner scan = null;
try{
	scan = new Scanner(new File(entrada));
}
catch( FileNotFoundException ex ){ 
	System.err.println( "File doesn’t exist." + ex.getMessage()); 
	System.exit(0);}
int[] numeros = new int[100];
int[] positivos = new int[100];
int[] negativos = new int[100];
boolean quedan = true;
//coloca todos los numeros en una array
for (int i=0;quedan==true ;i++ ) {
	try{
		numeros[i] = scan.nextInt();
	}	
	catch(InputMismatchException e){quedan=false;}
}
	
}
}
