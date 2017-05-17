

	import java.io.*;
	import java.util.*;
	public class Deriverable52 {
		


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
		
			
		NodeInt firstPositive = null;
		NodeInt lastPositive = null;
		NodeInt firstNegative = null;
		NodeInt lastNegative = null;
		
		//coloca todos los numeros en dos colas, positivos y negativos
			int numero;
			try{
				while(scan.hasNext()) {
				numero = scan.nextInt();
				if(numero >= 0) {
					NodeInt newNode = new NodeInt(numero);
				 	if (lastPositive!=null){
				 	lastPositive.setPrevious(lastPositive);	
				 	lastPositive.setNext(newNode);}
				 	else firstPositive = newNode;
				 	lastPositive = newNode;
				}
				else {
					NodeInt newNode = new NodeInt(numero);
				 	if (lastNegative!=null){
				 		lastNegative.setPrevious(lastPositive);	
					 	lastNegative.setNext(newNode);}
				 	else firstNegative = newNode;
				 	lastNegative = newNode;}
					
					
				}

			}	
			catch(NoSuchElementException e){}
				
			scan.close();
		
			
		//imprime en un archivo, negativos a la izquiera y positivos a la derecha
		try {
			PrintWriter pw = new PrintWriter(new File(salida));
			
			NodeInt pos = firstPositive;
			NodeInt nega = firstNegative;
			do {
				if(nega==null){
				pw.print("    ");}
				else {
				pw.print(nega.getValue());
				nega = nega.getNext();
				}
				pw.print("            ");
				if(pos==null){
					pw.println("");}
					else {pw.println(pos.getValue());
					pos = pos.getNext();
					}
				
			}while(pos!=null || nega!=null);
		
			
			pw.close();
			} catch (FileNotFoundException e) { System.err.println("Error opening or creating ");}
		
		}
		}

