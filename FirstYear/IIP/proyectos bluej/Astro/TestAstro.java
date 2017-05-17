
/**
 * Write a description of class TestAstro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TestAstro
{
   public static void main(String[] args){
       Scanner kbd= new Scanner(System.in).useLocale(Locale.US);
       Astro astro1= new Astro("Alfa Centauri",0,4.6,4.3);
       System.out.println(astro1);
       
       System.out.println("Introduce el nombre del astro.");
       String n = kbd.nextLine();
       System.out.println("Introduce el tipo del astro.");
       int t = kbd.nextInt();
       System.out.println("Introduce el brillo del astro.");
       double b = kbd.nextDouble();
       System.out.println("Introduce la distancia del astro.");
       double d = kbd.nextDouble();
       Astro astro2 = new Astro(n,t,b,d);
       System.out.println(astro2.visibleCon());
       
       System.out.println("Astro mas brillante:");
       int br = astro1.masBrillante(astro2);
       switch(br){
           case 0: System.out.println("Brillan igual"); break;
           case 1: System.out.println("Astro 1 brilla mas"); break;
           case -1: System.out.println("Astro 2 brilla mas"); break;
        }
    }
}
