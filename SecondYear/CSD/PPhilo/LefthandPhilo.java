// CSD Mar 2013 Jose Collado
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class LefthandPhilo extends Philo { //ASSIMETRY
    
	public LefthandPhilo(int id, int cycles, int delay, Table table) {super(id,cycles,delay,table);}
	
	public void run() {
		table.begin(id);
		for (int i=0; i<cycles; i++) {
			table.takeL(id); delay(msegDelay); table.takeR(id); //take first the left
			delay(table.eat(id));
			table.dropR(id); table.dropL(id);
			delay(table.ponder(id));
		}
		table.end(id);
	}
	
}