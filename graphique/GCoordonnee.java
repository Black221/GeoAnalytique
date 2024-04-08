package graphique;

import java.awt.Graphics;

public class GCoordonnee extends Graphique {
    private int x;
    private int y;

    public GCoordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Méthodes pour obtenir les coordonnées x et y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void dessiner(Graphics g) {
        // Dessiner une représentation graphique pour une coordonnée si nécessaire
    }
}
