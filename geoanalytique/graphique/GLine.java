package geoanalytique.graphique;

import java.awt.Graphics;
/**
 * Classe pour représenter une ligne graphique
 */

public class GLine extends Graphique {
    private GCoordonnee p1;
    private GCoordonnee p2;
    /**
     * Constructeur
     * @param p1
     * @param p2
     */
    public GLine(GCoordonnee p1, GCoordonnee p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    /**
     * Méthode pour obtenir le point p1
     * @return GCoordonnee p1
     */
    public GCoordonnee  getP1(){
		return p1;
	}
    /**
     * Méthode pour obtenir le point p2
     * @return GCoordonnee p2
     */
	public GCoordonnee getP2() {
		return p2;
	}
    /**
     * Méthode pour dessiner une ligne graphique
     * @param g
     */
    @Override
    public void dessiner(Graphics g) {
        // Dessiner une ligne entre les points (x1, y1) et (x2, y2) si nécessaire
        g.setColor(this.getCouleur());
        g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
        //Dessiner les points p1 et p2
        // p1.dessiner(g);
        // p2.dessiner(g);
    }
}
