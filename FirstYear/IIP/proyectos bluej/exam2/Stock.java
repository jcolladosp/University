public class Stock{
  
    private String company;
    private double opening;
    private double minimal;
    private double maximal;
    private double current;
    
    public Stock(String Company,double Opening){
    company=new String(Company); opening=Opening; minimal=Opening; maximal=Opening; current=Opening; 
    }
    public Stock(String Company, double Opening, double Maximal, double Minimal){
    company=Company; opening=Opening; maximal=Maximal; minimal=Minimal; current=Opening;}
    
    public String getCompany(){return company;}
    public double getMinimal(){return minimal;}
    public double getMaximal(){return maximal;}
    public double getOpening(){return opening;}
    public double getCurrent(){return current;}
    
    public void setCurrent(double Current){
        current=Current;
        if(Current>maximal)
            maximal=Current;
        else if(Current<minimal)
            minimal=Current;
    }
   
    public boolean raising(){return current>opening;}
    public boolean equals(Object o){
        return o instanceof Stock
        && this.company.equals(((Stock)o).company);}
    public String toString(){return company+":"+" "+current+" "+minimal+" "+maximal;}    
  
}
