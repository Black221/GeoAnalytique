package graphique;

import java.awt.Graphics;

public class GLine extends Graphique {
    private GCoordonnee p1;
    private GCoordonnee p2;

    public GLine(GCoordonnee p1, GCoordonnee p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public GCoordonnee  getP1(){
		return p1;
	}
	public GCoordonnee getP2() {
		return p2;
	}

    @Override
    public void dessiner(Graphics g) {
        // Dessiner une ligne entre les points (x1, y1) et (x2, y2) si nécessaire
    }
}
