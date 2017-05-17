
/**
 * Write a description of class Astro here.
 * 
 * @Jose
 * @version (a version number or a date)
 */
public class Astro
{
   public static final int ESTRELLA = 0;
   public static final int NEBULOSA = 1;
   public static final int GALAXIA = 2;
   
   private String nombre;
   private int tipo;
   private double brillo;
   private double distancia;
   
   public Astro(String Nombre, int Tipo, double Brillo, double Distancia){
       nombre=Nombre; tipo=Tipo; brillo=Brillo; distancia=Distancia;}
   
   public Astro(){nombre="Sirius";tipo=0; brillo=-1.42; distancia=8.7;}
   
   public double getBrillo(){return brillo;}
   public void setBrillo(double Brillo){brillo=Brillo;}
   
   public boolean equals(Object o){
       return o instanceof Astro &&
       nombre.equals(((Astro)o).nombre)
       && brillo==((Astro)o).brillo
       && tipo==((Astro)o).tipo
       && distancia==((Astro)o).distancia;
       }
       
   public String toString(){
       String tempo= new String();
       switch(tipo){
           case ESTRELLA: tempo=nombre+":"+"Estrella"; break;
           case NEBULOSA: tempo=nombre+":"+"Nebulosa"; break;
           case GALAXIA: tempo=nombre+":"+"Estrella"; break; }
       tempo += "(" + (Math.round(brillo*100)/100.0) + "," + (Math.round(distancia*100)/100.0) + ")";
       return tempo;
    }
  
   public double magnitudAbsoluta(){return brillo+(5*Math.log10(distancia));}
   
   public int masBrillante(Astro o){
       if(this.magnitudAbsoluta()==o.magnitudAbsoluta()) return 0;
       else if (this.magnitudAbsoluta()>o.magnitudAbsoluta()) return 1;
       else if (this.magnitudAbsoluta()<o.magnitudAbsoluta()) return -1;
       else return 0;}
   public String visibleCon(){
       if(brillo<5) return "a simple vista";
       else if (brillo>=5 && brillo<7) return "con prismaticos";
       else if (brillo>=7 && brillo<=25) return "con telescopio";
       else if (brillo>25) return "con grandes telescopios";
    return "hola";
    }
  
   
   
}
   

    


