package geoanalytique.graphique;

import java.awt.Graphics;
/**
 * Classe pour représenter un ovale graphique
 */
public class GOval extends Graphique {
    private double x;
    private double y;
    private double demiGrandAxe;
    private double demiPetitAxe;

    /**
     * Constructeur GOval
     * @param x
     * @param y
     * @param demiGrandAxe
     * @param demiPetitAxe
     */
    public GOval(double x, double y, double demiGrandAxe, double demiPetitAxe) {
        this.x = x;
        this.y = y;
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
    }
    /**
     * Méthode pour obtenir la coordonnée x
     * @return
     */
    public double getX() {
        return x;
    }
    /**
     * Méthode pour obtenir la coordonnée y
     * @return
     */
    public  double getY() {
        return y;
    }   
    /**
     * Méthode pour obtenir le demi-grand axe
     * @return
     */
    public double getDemiGrandAxe() {
        return demiGrandAxe;
    }
    /**
     * Méthode pour obtenir le demi-petit axe
     * @return
     */
    public double getDemiPetitAxe() {
        return demiPetitAxe;
    }

    @Override
    public void dessiner(Graphics g) {
        // Dessiner une ellipse avec le centre (x, y) et les demi-axes spécifiés si nécessaire

        g.setColor(this.getCouleur());
        g.drawOval((int)(x - demiGrandAxe), (int)(y - demiPetitAxe), (int)(2 * demiGrandAxe), (int)(2 * demiPetitAxe));
    }
}
