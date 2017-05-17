import java.io.*;
import java.util.*;
public class Deriverable51 {
	public static void main(String[] args) {
		String entrada = "entrada.txt"; //ruta del fichero de entrada
		String salida = "salida.txt";	//ruta del fichero de salida
	Scanner scan = null;
	//inicializancion del scanner
	try{
		scan = new Scanner(new File(entrada));
	}
	catch( FileNotFoundException ex ){ 
		System.err.println( "File doesn’t exist." + ex.getMessage()); 
		System.exit(0);}
	int[] numeros = new int[100]; //array donde se guardaran todos los numeros
	int[] positivos = new int[100];	//array donde se guardaran los positivos
	int[] negativos = new int[100];	//array donde se guardaran los negativos
	boolean quedan = true;
	
	//coloca todos los numeros en una array
		for (int i=0;quedan==true ;i++ ) {
		try{
			numeros[i] = scan.nextInt();
		}	
		catch(NoSuchElementException e){quedan=false;}
			}
		scan.close();
	//separa los numeros en positivos y negativos	
		int countpos=0;
		int countnega=0;
	for (int i = 0; i < numeros.length; i++) {
		if(numeros[i] >= 0){positivos[countpos]=numeros[i]; countpos++;}
		else {negativos[countnega]=numeros[i]; countnega++;}
	}
		
	//imprime en un archivo, negativos a la izquiera y positivos a la derecha
	try {
		PrintWriter pw = new PrintWriter(new File(salida));
		int impri;
		if(positivos.length > negativos.length )impri=positivos.length;
		else impri=negativos.length;
		for (int i = 0; i < impri-1; i++) {
			if(negativos[i]== 0){
			pw.print("    ");}
			else {pw.print(negativos[i]);}
			pw.print("            ");
			if(positivos[i]== 0){
				pw.println("");}
				else {pw.println(positivos[i]);}
		}
		
		pw.close();
		} catch (FileNotFoundException e) { System.err.println("Error opening or creating ");}
	
	}
	}
