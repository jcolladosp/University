import javax.swing.*;
import java.awt.*;

/**
 * Class Blackboard: define a Blackboard on which elements can be drawn
 * of type Circle, Rectangle, Square, Ellipse, TrIsosceles and Rhombus.
 * 
 * @author IIP-PRG English group
 * @version 2011
 */
public class Blackboard extends JFrame {

    // Default elements for Blackboard
    private static int DIM_X = 200;
    private static int DIM_Y = 200;
    private static int NUM_MIN = 8;
    
    // Atributes for storing graphical objects
    private Object gOL[] = new Object[NUM_MIN];
    private int numGO = 0;
    
    // Constants for shapes 
    private final static int UNK = -1;
    private final static int CIRCLE = 0;
    private final static int RECTANGLE = 1;
    private final static int SQUARE = 2;
    private final static int ELLIPSE = 3;
    private final static int ISOSCELES = 4;
    private final static int RHOMBUS = 5;    
      
    // Constant array for colors
    private static final String NAME_COLS[] = 
            {"red","yellow","green","blue","orange","black","white",
             "gray","pink"};
            
    private static final Color COLS[] = 
            {Color.red, Color.yellow, Color.green, Color.blue,
             Color.orange, Color.black, Color.white, Color.gray,
             Color.pink};
             
    private static final Color DEFAULT_COLOR = Color.black;         
    
             
    /**
     * Build a default Blackboard where graphical elements 
     * can be situated.
     */         
    public Blackboard() {
        super("Default blackboard");
        setSize(DIM_X,DIM_Y);
        setContentPane(initPanel());
        setVisible(true);
        
    }

    /**
     * Build a Blackboard with a given title and size where 
     * graphical elements can be situated.
     * 
     * @argh title title of the Blackboard
     * @argh dimX horizontal size in pixels of Blackboard
     * @argh dimY vertical size in pixels of Blackboard
     */    
    public Blackboard(String title,int dimX, int dimY) {
        super(title);
        setSize(dimX,dimY);
        setContentPane(initPanel());    
        setVisible(true);
        
    }

    /**
     * Add graphical object to Blackboard and draw it
     * @argh o graphical objecto to be shown.
     */
    public void add(Object o) {
        if (numGO == gOL.length) dupMem();
        gOL[numGO++] = o;
        repaint();
    }
    
    /**
     * Redraw all graphical elements added to the Blackboard.
     */
    public void drawAll() {
        repaint();
    }
    
    private void dupMem() {
        Object aux[] = new Object[2*gOL.length];
        for (int i=0; i<gOL.length; i++) aux[i]=gOL[i];
        gOL = aux;
    }
           
    private JPanel initPanel() {
        JPanel jp = new JPanel() {           
            // override paintComponent
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                for (int i=0;i<numGO;i++) {
                    int type = classType(gOL[i]);
                                        
                    switch (type) {
                        case CIRCLE: drawCircle(gOL[i],g); break;
                        case SQUARE: drawSquare(gOL[i],g); break;
                        case RECTANGLE: drawRectangle(gOL[i],g); break;
                        case ELLIPSE: drawEllipse(gOL[i],g); break;
                        case ISOSCELES: drawIsosceles(gOL[i],g); break;
                        case RHOMBUS: drawRhombus(gOL[i],g); break;
                        
                        default: break;
                    } 
                    
                }                
            };            
        };
        return jp;
    } 
    
    
    private int classType(Object o) {
        if (o instanceof Circle) return CIRCLE;
        else if (o instanceof Rectangle) return RECTANGLE;
        else if (o instanceof Square) return SQUARE;
        else if (o instanceof Ellipse) return ELLIPSE;
        else if (o instanceof TrIsosceles) return ISOSCELES;  
        else if (o instanceof Rhombus) return RHOMBUS;        
        else return UNK;
    }
    
    private Color theColor(String c) {
        int i=0;
        for (; i<NAME_COLS.length && !NAME_COLS[i].equalsIgnoreCase(c); i++);
        
        if (i>=NAME_COLS.length) return DEFAULT_COLOR;
        else return COLS[i];
    }    
    
    /* ***************************************************************** */
    /*             Methods for drawing the different shapes.             */
    /* ***************************************************************** */    
    
    private void drawCircle(Object o, Graphics g) {
        Circle c = (Circle) o;
        
        int rad = (int) Math.round(c.getRadius());
        int diam =(int) Math.round(c.getRadius() * 2.0);
        int cX = c.getCenterX();
        int cY = c.getCenterY();
        
        g.setColor(theColor(c.getColor()));        
        g.fillOval(cX - rad, cY - rad, diam, diam); 
    }
        
    private void drawSquare(Object o, Graphics g) {
        Square c = (Square)o;
        
        int side = (int)Math.round(c.getSide());
        int halfside = (int)Math.round(c.getSide()/2.0);
        int corX = c.getCenterX() - halfside;
        int corY = c.getCenterY() - halfside;
        
        g.setColor(theColor(c.getColor()));    
        g.fillRect(corX, corY, side, side);
    }  
       
    private void drawRectangle(Object o, Graphics g) {
        Rectangle r = (Rectangle)o;
        
        int width = (int)Math.round(r.getWidth());
        int height = (int)Math.round(r.getHeight());
        int halfWidth = (int)Math.round(r.getWidth()/2.0);
        int halfHeight = (int)Math.round(r.getHeight()/2.0);        
        
        int corX = r.getCenterX() - halfWidth;
        int corY = r.getCenterY() - halfHeight;
        
        g.setColor(theColor(r.getColor()));
        g.fillRect(corX, corY, width, height);
    }  
    
    private void drawEllipse(Object o, Graphics g) {
       Ellipse e = (Ellipse) o;
       
        int axisH = (int) Math.round(e.getAxisH());
        int axisV = (int) Math.round(e.getAxisV()); 
        
        int halfH = (int) Math.round(e.getAxisH()/2.0);
        int halfV = (int) Math.round(e.getAxisV()/2.0);        

        int cX = e.getCenterX();
        int cY = e.getCenterY();
        
        g.setColor(theColor(e.getColor()));        
        g.fillOval(cX - halfH, cY - halfV, axisH, axisV); 
    } 
    
    private void drawIsosceles(Object o, Graphics g) {
        TrIsosceles t = (TrIsosceles) o;
        
        int cX = t.getCenterX();
        int cY = t.getCenterY();
        
        int halfbase = (int) Math.round(t.getBase()/2.0);
        int thirdheight = (int) Math.round(t.getHeight()/3.0);
        int twothird = (int) Math.round(t.getHeight()/3.0 * 2.0);
        
        // vertex arrays
        int xpts[] = {cX-halfbase,cX,cX+halfbase};
        int ypts[] = {cY+thirdheight,cY-twothird,cY+thirdheight};
        g.setColor(theColor(t.getColor()));
        g.fillPolygon(xpts,ypts,3);      
    }

    private void drawRhombus(Object o, Graphics g) {
        Rhombus r = (Rhombus) o;
        
        int cX = r.getCenterX();
        int cY = r.getCenterY();
        
        int semiDH = (int) Math.round(r.getDiagH()/2.0);
        int semiDV = (int) Math.round(r.getDiagV()/2.0);
        
        // vertex arrays 
        int xpts[] = {cX-semiDH,cX,cX+semiDH,cX};
        int ypts[] = {cY,cY-semiDV,cY,cY+semiDV};
        g.setColor(theColor(r.getColor()));
        g.fillPolygon(xpts,ypts,4);      
    }  
    
} // of Blackboard
