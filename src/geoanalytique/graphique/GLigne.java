package geoanalytique.graphique;

import java.awt.Graphics;
/**
 * Classe pour représenter une ligne graphique
 */

public class GLigne extends Graphique {
    private GCoordonnee p1;
    private GCoordonnee p2;
    /**
     * Constructeur
     * @param p1
     * @param p2
     */
    public GLigne(GCoordonnee p1, GCoordonnee p2) {
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
        g.setColor(this.getCouleur());
        //line weight
        g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
    }
}
