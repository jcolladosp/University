import java.util.*;
public class StockExchange{

public static Stock moreVolatile(Stock s1, Stock s2){
double dif1=((s1.getMaximal()-s1.getMinimal())*100)/s1.getMinimal();
double dif2=((s1.getMaximal()-s1.getMinimal())*100)/s1.getMinimal();
if (dif1>dif2) return s1; else return s2;
}      
public static double randomN(double a, double b){
double max=Math.max(a,b); double min=Math.min(a,b);
return ((max-min)*Math.random())+min;
}
//Stock 1
public static void main(String[] args){
Scanner kbd = new Scanner(System.in).useLocale(Locale.US);
Stock s1 = new Stock("Iberdrola",12.30);
System.out.println(s1);

//Stock 2
System.out.println("Introduce the name of the company");
String cn = kbd.nextLine();
double maxi= Math.random()*100;
double open= Math.random()*maxi;
double mini= Math.random()*open;

Stock s2 = new Stock(cn,open,maxi,mini);

System.out.println("Introduce new current value");
double curr= kbd.nextDouble();
s1.setCurrent(curr);
if(s1.raising()==true) System.out.println(s1+" " + "it is having benefits");
else System.out.println(s1 + " " + "it's not having benefits");

System.out.println("El mas volatil es" + moreVolatile(s1,s2));
}
}