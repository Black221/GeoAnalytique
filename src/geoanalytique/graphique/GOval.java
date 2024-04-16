package geoanalytique.graphique;

import java.awt.Graphics;
/**
 * Classe pour représenter un ovale graphique
 */
public class GOval extends Graphique {
    GCoordonnee centre;
    private double demiGrandAxe;
    private double demiPetitAxe;

    /**
     * Constructeur GOval
     * @param centre
     * @param demiGrandAxe
     * @param demiPetitAxe
     */
    public GOval(GCoordonnee centre, double demiGrandAxe, double demiPetitAxe) {
        this.centre = centre;
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
    }
    
    /**
     * Méthode pour obtenir le centre
     * @return
     */
    public GCoordonnee getCentre() {
        return centre;
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
        g.drawOval((int)(this.centre.getX() - demiGrandAxe), (int)(this.centre.getY() - demiPetitAxe), (int)(2 * demiGrandAxe), (int)(2 * demiPetitAxe));
        // dessiner le center
        centre.dessiner(g);
    }
}
