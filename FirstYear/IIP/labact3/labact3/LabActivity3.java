/**
 *  Class LabActivity3.
 *  A first class with keyboard input and
 *  operations with int, long, Math and String.
 *  Contains three compilation errors.
 *  @author (IIP. Compute Science Degree. ETSINF, UPV) 
 *  @version (Year 2014-15)
 */
import java.util.*;

 public class LabActivity3{

   public static void main(String[] args){
       Scanner kbd = new Scanner(System.in);
       String hour, minutes;
       int tRemaining = (int) (System.currentTimeMillis()  % (24*3600*1000));
       int tConH;
       int tConM;
       System.out.println("Reading one hour from the keyboard");
       System.out.print("  -> Input hour (between 0 and 23): ");
       int h = kbd.nextInt();
       System.out.print("  -> Input minutes (between 0 and 59): ");
       int m = kbd.nextInt();
       System.out.println("Inputed hour: " + h + " and " + m + "."); 
       if (h<10)
        hour= "0" + h;
        else
            hour=""+h;
       if (m<10)
        minutes= "0"+m;
        else
            minutes=""+m;
       
       System.out.println(hour + ":" + minutes);
       System.out.println(tRemaining);
       tConH= tRemaining / (1000*60*60);
       tConM = (tRemaining - (tConH*1000*60*60))/60000;
       System.out.println("Current time "+ tConH + ":" + tConM + "(UTC)");
    
    
    }    
 
}
