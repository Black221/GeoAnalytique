package geoanalytique.model;
import java.awt.Color;

/**
 * Classe cercle
 */
public class Cercle extends Ellipse {
    
    /**
     * Constructeur
     * @param centre
     * @param rayon
     */
    public Cercle(Point centre, double rayon) {
        super(centre, rayon, rayon);
    }

    /**
     *  Constructeur
     * @param centre
     * @param rayon
     * @param couleur
     */
    public Cercle(Point centre, double rayon, Color couleur) {
        super(centre, rayon, rayon, couleur);
    }

}
