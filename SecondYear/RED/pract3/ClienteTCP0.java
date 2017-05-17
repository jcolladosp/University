
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ClienteTCP0 {
public static void main(String args[]) 

throws UnknownHostException, IOException {

try{
    Socket s=new Socket("www.upv.es", 80);
    System.out.println("Connected again!");
    s.close();
    System.out.println("Disconnected");
 }catch (UnknownHostException e) {
     System.out.println("unknown host mah niggi");
     System.out.println(e); 
} catch (IOException e) {
     System.out.println("cant connect  u faggot");
     System.out.println(e); 
}

}

public static  void ejercicio3(){
try{
    Socket t=new Socket("smtp.upv.es", 25);
    Scanner inFromSocket=new Scanner(t.getInputStream());
    System.out.println(inFromSocket.nextLine());}
catch (UnknownHostException e) {
    System.out.println("unknown host mah niggi");
    System.out.println(e); 
} catch (IOException e) {
    System.out.println("cant connect  u faggot");
    System.out.println(e); 
}
}

public static void ejercicio4(){
try{
    Socket t=new Socket("ntp.upv.es", 13);
    Scanner inFromSocket=new Scanner(t.getInputStream());
    System.out.println(inFromSocket.nextLine());}
catch (UnknownHostException e) {
    System.out.println("unknown host mah niggi");
    System.out.println(e); 
} catch (IOException e) {
    System.out.println("cant connect  u faggot");
    System.out.println(e); 
}
}

public static void ejercicio5(){
try{
    Socket t=new Socket("www.upv.es", 80);

    System.out.println("Connected");
    PrintWriter outToSocket= new PrintWriter(t.getOutputStream());
    outToSocket.print("GET / HTTP/1.0\r\n\r\n");
     outToSocket.flush();
    Scanner inFromSocket=new Scanner(t.getInputStream());
    
    while(inFromSocket.hasNext()){
        System.out.println(inFromSocket.nextLine()); 
   }
    
    t.close();
    System.out.println("Disconnected");
    
    }
catch (UnknownHostException e) {
    System.out.println("unknown host mah niggi");
    System.out.println(e); 
} catch (IOException e) {
    System.out.println("cant connect u faggot");
    System.out.println(e); 
}
}

public static void ejercicio6(String smtp2,int port){
try{
    
InetAddress smtp = InetAddress.getByName(smtp2);
Socket r = new Socket(smtp,port);
System.out.print("local IP:"); System.out.println(r.getLocalAddress().getHostAddress());
System.out.print("local Port:"); System.out.println (r.getLocalPort());
System.out.print("remote IP:"); System.out.println(r.getInetAddress().getHostAddress());
System.out.print("remote Port:"); System.out.println(r.getPort());

}
catch (UnknownHostException e) {
    System.out.println("unknown host mah niggi");
    System.out.println(e); 
} catch (IOException e) {
    System.out.println("cant connect u faggot");
    System.out.println(e); 
}

}

}
