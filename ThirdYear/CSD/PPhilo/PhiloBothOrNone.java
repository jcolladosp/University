// CSD Mar 2013 Jose Collado
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class PhiloBothOrNone extends Philo { //Both or None. Table3
	public PhiloBothOrNone(int id, int cycles, int delay, Table table) {super(id,cycles,delay,table);}

    public void run() {
        table.begin(id);
        for (int i = 0; i < cycles; i++) {
            table.takeLR(id);

            delay(table.eat(id));

            table.dropR(id);
            table.dropL(id);
            delay(table.ponder(id));
        }
        table.end(id);
    }

}