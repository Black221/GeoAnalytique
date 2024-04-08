package graphique;

import java.awt.Graphics;

public abstract class Graphique {
    
    public Graphique() {
        // Constructor
    }
    
    public abstract void dessiner(Graphics g);
    // Abstract method to draw the graphical object using a Graphics object
    
}
