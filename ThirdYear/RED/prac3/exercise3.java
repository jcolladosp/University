import java.net.*;
import java.io.*;
import java.util.*;
public class exercise3 extends Thread{
  Socket s;
  public exercise3 (Socket s){this.s = s;}
  public void run(){
    try{
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        while(true){
            Scanner kbd = new Scanner(s.getInputStream());
            String k = kbd.nextLine();
            if(k.equals("QUIT")){s.close();break;}
            else out.println(k);
        }
    }
    catch(Exception e){}
  }
  public static void main(String[]args) throws IOException{
    ServerSocket ss = new ServerSocket (7777);
    while (true){
        Socket s = ss.accept();
        exercise3 x = new exercise3(s);
        x.start();
    }
  }
}
