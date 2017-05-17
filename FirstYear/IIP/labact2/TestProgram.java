/**
 * Program class to test all the defined shapes
 * 
 * Can be executed from BlueJ <B>workbench</B> 
 * 
 * @author IIP-PRG English group
 * @version (2011)
 */
public class TestProgram {

    public static void main (String args[]) {
        
        // Init blackboard given name and dimensions
        Blackboard bb = new Blackboard("WINDOW TO THE WORLD",500,300);
                
        // Yellow circle
        Circle c1 = new Circle(50,"yellow",100,100);
        // put it on the drawing space
        bb.add(c1);
        
        // Blue square
        Square q1 = new Square(30,"blue",125,125);
        // put it on the drawing space
        bb.add(q1);  
        
        // Long and red rectangle
        Rectangle r1 = new Rectangle(100,10,"red",50,155);
        // put it on the drawing space
        bb.add(r1); 
        
        // Green ellipse
        Ellipse e1 = new Ellipse(70,40,"green",180,90);
        // put it on the drawing space
        bb.add(e1); 
        
        // Black isosceles triangle
        TrIsosceles t1 = new TrIsosceles(30,60,"black",210,60);
        // put it on the drawing space
        bb.add(t1);
        
        // Orange rhombus
        Rhombus ro1 = new Rhombus(60,20,"orange",170,80);
        // put it on the drawing space
        bb.add(ro1);        
        
    }
} // of TestProgram

