/** Class TicketSale.
 *  Lab activiy 4 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Year 2014/15.
 */

import java.util.*;

public class TicketSale {

  public static void main(String [] args) {
    Scanner kbd = new Scanner(System.in).useLocale(Locale.US);

    // Vars for ticket creation
    Ticket t;
    String title, theater;
    int h, m;

    // Vars for final price calculation
    int age;
    boolean hol=false, holeve=false, watche=false, client=false;

    // Aux vars
    String ans;

    // Ask for ticket features and creates it
    System.out.println("Ticket features: ");
    System.out.print("   Title: ");
    title=kbd.nextLine();
    System.out.println("Theater: ");
    theater=kbd.nextLine();
    System.out.println("Hour: ");
    h=kbd.nextInt();
    System.out.println("Minute: ");
    m=kbd.nextInt();
    
    // Create ticket
    t= new Ticket(title,theater,h,m)  ;

    // Ask for client and day features
    
    System.out.print("Your age? ");
    age=kbd.nextInt(); kbd.nextLine();

    System.out.print("It is watcher's day? "); 
    ans=kbd.next(); ans=ans.toUpperCase();
    if (ans.equals("YES")) watche=true;
    
    System.out.print("It is holiday? "); 
    ans=kbd.next(); ans=ans.toUpperCase();
    if (ans.equals("YES")) hol=true;
    
     System.out.print("It is holiday eve? "); 
    ans=kbd.next(); ans=ans.toUpperCase();
    if (ans.equals("YES")) holeve=true;

     System.out.print("Hay you got client card? "); 
    ans=kbd.next(); ans=ans.toUpperCase();
    if (ans.equals("YES")) client=true;
    
    // Calculate final price
    double fPrice= t.finalPrice(age,watche,hol,holeve,client) ;

    System.out.println("The final price for the ticket is: "+String.format("%.2f",fPrice)+" euros");

  }

}
