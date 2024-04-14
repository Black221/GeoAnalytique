package geoanalytique.graphique;

import java.awt.Graphics;
/**
    * Classe pour représenter une coordonnée graphique
 */
public class GCoordonnee extends Graphique {
    private double x;
    private double y;
    /**
     * Constructeur 
     * @param x absisse
     * @param y ordonnée
     */
    public GCoordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode pour obtenir la coordonnée x
     * @return double x
     */
    public double getX() {
        return x;
    }
    /**
     * Méthode pour obtenir la coordonnée y
     * @return double y
     */
    public double getY() {
        return y;
    }
    /**
     * Méthode pour définir la coordonnée x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Méthode pour définir la coordonnée y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Méthode pour dessiner une coordonnée graphique
     * @param g
     */
    @Override
    public void dessiner(Graphics g) {
        // Dessiner une représentation graphique pour une coordonnée si nécessaire
        g.setColor(this.getCouleur());
        g.fillOval((int)x - 4,(int)y - 4, 8, 8); // center le point
    }
}
