package geoanalytique.model;
import java.awt.Color;

public class Cercle extends Ellipse {
    
    public Cercle(Point centre, double rayon) {
        super(centre, rayon, rayon);
    }

    public Cercle(Point centre, double rayon, Color couleur) {
        super(centre, rayon, rayon, couleur);
    }

    public String toString() {
        return "Cercle de rayon " + demiGrandAxe;
    }
}
