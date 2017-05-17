/**
 * Class Hour. 
 * 
 *  @author (J.Collado & R.Ruiz) 
 *  @version (Year 2014-15)
 */
public class Hour {
    // ATTRIBUTES:
    private int h;
    private int m;
    private String hour;
    private String minute;
    private int tt;
    
    int tRemaining = (int) (System.currentTimeMillis()  % (24*3600*1000));
    // CONSTRUCTORS
   
    /** Hour corresponding to hh hours and mm minutes.
     * Precondition: 0<=hh<24, 0<=mm<60
     */
    public Hour(int hh, int mm){h=hh; m=mm;}

    /** Current UTC Hour (hours and minutes)
      */
     public Hour(){
          h= tRemaining / (1000*60*60);
          m = (tRemaining - (h*1000*60*60))/60000;}
     
     // CONSULTORS AND MODIFYERS:
   /** Returns hour from current Hour object */
   public int getH(){return h;}


   /** Returns minutes from current Hour object */
  public int getM(){return m;}

   
   /** Modifies hour of current Hour object */
  public void setH(int hh){ h = hh;}

   
   /** Modifies minutes of current Hour object */
   public void setM(int mm){ m=mm;}

   
   // OTHER METHODS:
   /** Returns current Hour object in format "hh:mm"
     */
    public String toString(){
        if (h<10)
        hour= "0" + h;
        else
            hour=""+h;
       if (m<10)
        minute= "0"+m;
        else
            minute=""+m;
       return hour+":"+minute;}     
   
  /** Returns amount of minutes from 00:00 to current Hour object
    */
  public int toMinutes(){
    tt = (h * 60) + m;
    return tt;}

  /** Returns true only if o and current Hour object represent the same hour
    */
   public boolean equals(Object o){
       return o instanceof Hour
       && this.h==((Hour)o).h
       && this.m==((Hour)o).m ;
      
       }
        
  /** Compares chronologically current Hour object and hour; result is:
    *      - negative when current Hour is previous to hour
    *      - zero if they are equal
    *      - positive when current Hour is posterior to hour
    */

   public boolean compareTo(Hour hour){
    return hour instanceof Hour
        && this.h==((Hour)hour).h   
        && this.m==((Hour)hour).m;
        
    
    
    
    
    }

   
   
   
   
  // EXTRA ACTIVITY:      
  /** Returns Hour from textual data
   *  in format "hh:mm".
   */ 
 
}
