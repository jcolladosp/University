import java.net.*;
import java.util.*;
import java.io.*;
public class lab6{
        public static void ex1(){
           try{
           InetAddress IPAdress = InetAddress.getByName("localhost");
           System.out.println(IPAdress);
        }
        catch (Exception e){System.out.print("fuck you");}
        }
        
        public static void ex2(){
        try{
           InetAddress [] listIPs = InetAddress.getAllByName("www.google.es");
           System.out.println(Arrays.toString(listIPs));
        }
        catch (Exception e){System.out.print("fuck you");}
        }
        
        public static void ex3(){
        try{
           DatagramSocket clientSocket = new DatagramSocket();
           int p = clientSocket.getLocalPort();
           System.out.println("The local port is: "+p);
        }
        catch (Exception e){System.out.print("fuck you");}
        }
        
        public static void ex4(){
        try{
           DatagramSocket clientSocket = new DatagramSocket();
           Scanner kbd = new Scanner(System.in);
           System.out.println("Introduce your name: ");
           InetAddress IPAddress = InetAddress.getByName("zoltar.redes.upv.es");
           String sentence = kbd.nextLine();
           DatagramPacket sendPacket = new DatagramPacket(sentence.getBytes(), sentence.getBytes().length, IPAddress, 7777);
           clientSocket.send(sendPacket);
           clientSocket.close();
        }
        catch (Exception e){System.out.print("fuck you");}
        }
        public static void ex5(){
        try{
           DatagramSocket clientSocket = new DatagramSocket();
           Scanner kbd = new Scanner(System.in);
           System.out.println("Introduce data: ");
           InetAddress IPAddress = InetAddress.getByName("localhost");
           String sentence = kbd.nextLine();
           DatagramPacket sendPacket = new DatagramPacket(sentence.getBytes(), sentence.getBytes().length, IPAddress, 7777);
           clientSocket.send(sendPacket);
     
           byte[] receiveDataBuffer = new byte[512];
           DatagramPacket receivePacket = new DatagramPacket(receiveDataBuffer, receiveDataBuffer.length);
           clientSocket.receive(receivePacket);
           String modifiedSentence = new String(receivePacket.getData(), 0,receivePacket.getLength()) ;
           System.out.println(modifiedSentence);
           clientSocket.close();
        }
        catch (Exception e){System.out.print("fuck you");}
        }
        
}