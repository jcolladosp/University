/** Class Ticket.
 *  Lab activity 4 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Year 2014/15.
 */

public class Ticket {
    
  // Definition of public constant class attibutes for calculating the ticket price
   
  // Base price for the tickets
  private static double BASE_PRICE=7.6;

  // Discount for watcher older than 65
  private static int ELDERLY_AGE=65;
  private static double ELDER=0.3;

  // Discount for watcher's day
  private static double WATCHER=0.8;

  // Discount for holiday
  private static double HOLIDAY=1.2;

  // Discount for holiday eve
  private static double HOLIDAY_EVE=1.1;

  // Discount for client card
  private static double CLIENT_CARD=0.8;

  // Definition of private instance attributes
    private String title;
    private String theater;
    private Hour sessionHour;

  /** Creates a ticket with title t, theather th, session hour and minutes sh:sm
    */
  public Ticket(String t, String th, int sh, int sm) {
    title=t; theater=th; sessionHour = new Hour(sh,sm); 
  }

  /** Get movie title */
  public String getTitle() { return title; }

  /** Get theather name */
  public String getTheater() { return theater; }

  /** Get session hour */
  public Hour getSessionHour() {return sessionHour; }

  /** Set to t the movie title */
  public void setTitle(String t) { title = new String(t); }

  /** Set to th the theather name */
  public void setTheater(String th) { theater = th; }

  /** Set to sh the session hour */
  public void setSessionHour(Hour sh) { sessionHour = sh ;}

  /** Returns a String with ticket data */
  public String toString() {
    return "\""+title+"\", projected in "+theater+", at "+sessionHour+"\nBase price: "+BASE_PRICE+" euros";
  }

  /** Checks if o is a ticket with the same data than current ticket */
  public boolean equals(Object o) {
    return o instanceof Ticket
        && this.title.equals(((Ticket)o).title)
        && this.theater.equals(((Ticket)o).theater)
        && this.sessionHour==((Ticket)o).sessionHour;
  }

  /** Calculate and return final price using base price and the discounts associated
    * to watcher's age, the day of the session (watcher's day, holiday, holiday eve),
    * and the possession of client card 
    */
  public double finalPrice(int age, boolean watcherDay, boolean holiday, boolean holidayEve, boolean clientCard){
    if (age>=ELDERLY_AGE) return BASE_PRICE*ELDER;
    else if (watcherDay == true) return BASE_PRICE*WATCHER;
    else if (holiday==true && clientCard==true)  return (BASE_PRICE*HOLIDAY)*CLIENT_CARD;
    else if (holiday==true && clientCard==false)  return (BASE_PRICE*HOLIDAY);
    else if (holidayEve==true && clientCard==true)  return (BASE_PRICE*HOLIDAY_EVE)*CLIENT_CARD;
    else if (holidayEve==true && clientCard==false)  return (BASE_PRICE*HOLIDAY_EVE);
    else if (clientCard == true) return (BASE_PRICE*CLIENT_CARD);
        return BASE_PRICE;
  }

}

