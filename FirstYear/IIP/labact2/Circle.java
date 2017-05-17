/** 
 * Class Circle: defines a circle of a given radius, color, center position,
 * with the following functionalities.
 * @author IIP-PRG English group
 * @version 2011
 */ 
public class Circle  {
    private double radius; 
    private String color; 
    private int centerX, centerY;   
    
    /** create a Circle of radius 50, black and center in (100,100). */
    public Circle() {
        radius = 50; color = "black"; centerX = 100;  centerY = 100; }
    
    /** create a Circle of radius r, color c and center in (px,py). */
    public Circle(double r, String c, int px, int py){
        radius = r;  color = c; centerX = px; centerY = py; }

    /** consult radius of Circle. */
    public double getRadius(){ return radius; }    

    /** consult the color of Circle.*/
    public String getColor(){return color; }  

    /** consult the abscissa of the center of Circle. */
    public int getCenterX(){return centerX; }  

    /** consult the ordenate of the center of Circle. */
    public int getCenterY(){return centerY; }
 
    /** update radius of Circle to newRadius. */
    public void setRadius(double newRadius){ radius = newRadius; }   

    /** update color of Circle to newColor. */
    public void setColor(String newColor){ color = newColor; }   
 
    /** update center of Circle to position (px,py). */
    public void setCenter(int px, int py){ centerX=px; centerY=py; }
    
    /** calculate area of Circle.*/
    public double area(){ return Math.PI * radius * radius; }
    
    /** calculate perimeter of Circle.*/
    public double perimeter(){return 2 * Math.PI * radius;}
    
    /** obtain a String with the components of Circle. */
    public String toString() { String res = "Circle of radius "+ radius;
        res += ", color "+color+" and center ("+centerX+","+centerY+")";
        return res; 
    }
        
} // of Circle
