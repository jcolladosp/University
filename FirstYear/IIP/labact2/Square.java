/** Class Square: defines a square of a given side, color, and center
 * position, with the following functionality
 * @author IIP-PRG English group
 * @version 2011
 */ 
public class Square {
    private double side;
    private String color;
    private int centerX;
    private int centerY;
        
    
    /** Create Square of side 50, black and center in (100,100) */
    public Square() {
        side = 50; 
        color = "black"; 
        centerX = 100; 
        centerY = 100;
    }    
    
    /** Create a Square of side l, color c and center in (cx, cy) */
    public Square(double l, String c, int cx, int cy) {
        side = l; 
        color = c; 
        centerX = cx; 
        centerY = cy;
    }

    /** consult side of Square. */
    public double getSide(){ return side; }
    
    /** consult color of Square. */
    public String getColor(){ return color; }
    
    /** consult abscissa of center of Square. */
    public int getCenterX(){ return centerX; }
    
    /** consult ordenate of center of Square. */
    public int getCenterY(){ return centerY; }
    
    /** update side of Square to newSide. */
    public void setSide(double newSide){ side = newSide; }
    
    /** update color of Square to newColor. */
    public void setColor(String newColor){ color = newColor; }
    
    /** update center of Square to position (cx,cy). */
    public void setCenter(int cx, int cy){ centerX = cx; centerY = cy; }
    
    /** calculate area of Square. */
    public double area(){ return side * side; }
    
    /** calculate perimeter of Square. */
    public double perimeter(){ return 4*side; }    
    
    /** obtain String with the components of Square. */
    public String toString(){
        String res = "Square of side "+ side;
        res += ", color "+color+" and center ("+centerX+","+centerY+")";
        return res;
    }
    
}  // of Square
