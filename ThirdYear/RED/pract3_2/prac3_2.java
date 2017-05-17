import java.net.*;
import java.io.*;
import java.util.*;
/**
  * @author Raymon & colli
 * @version 420
 */
public class prac3_2
{
    public static void actividad1(){
            try{
    ServerSocket ss=new ServerSocket(7777);
    Socket s=ss.accept(); // esperoa quelleguen cliente
    PrintWriter salida=new PrintWriter(s.getOutputStream(),true);
    salida.println("Client conected");
    s.close();
   
  
}//try  
catch(IOException e) { 
System.out.println(e); }
}

public static void actividad2(){
try{
    ServerSocket ss=new ServerSocket(7777);
    Socket s=ss.accept(); // espero a quelleguen cliente
    
    Calendar now = Calendar.getInstance();
    int h =  now.get(Calendar.HOUR_OF_DAY);
    int m = now.get(Calendar.MINUTE);
    int ss88 = now.get(Calendar.SECOND);
    
    PrintWriter salida=new PrintWriter(s.getOutputStream(),true);
    salida.println("Hora del server " + h+":"+m+":"+ss88);
    s.close();
   
  
}//try  
catch(IOException e) { 
    System.out.println(e); }
}


public static void actividad3(){
try{
    ServerSocket ss=new ServerSocket(7777);
    int counter = 1;
    while(true){
    Socket s=ss.accept(); // espero a quelleguen cliente
   
    Calendar now = Calendar.getInstance();
    int h =  now.get(Calendar.HOUR_OF_DAY);
    int m = now.get(Calendar.MINUTE);
    int ss88 = now.get(Calendar.SECOND);
    
    PrintWriter salida=new PrintWriter(s.getOutputStream(),true);
    salida.println("Hora del server " + h+":"+m+":"+ss88+"\n"+
    "Eres el cliente: "+counter);
    counter++;
    s.close();
   
}
}//try  
catch(IOException e) { 
    System.out.println(e); }
}

public static void actividad4(){
try{
    ServerSocket ss=new ServerSocket(7777);
    while(true){
    Socket s=ss.accept(); // espero a quelleguen cliente
    Scanner k = new Scanner (s.getInputStream());
   String line = k.nextLine();
    if(line.startsWith("GET")){
    PrintWriter salida=new PrintWriter(s.getOutputStream(),true);
    salida.print("HTTP/1.0 200 OK \r\n");
    salida.flush();
    line = k.nextLine();
    salida.print("Content-Type: text/plain \r\n\r\n");
    salida.flush();
    while(!k.equals("")){
       salida.print()
    }
}
    s.close();
   
}
}//try  
catch(IOException e) { 
    System.out.println(e); }
}
}

