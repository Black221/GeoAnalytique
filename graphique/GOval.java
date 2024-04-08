package graphique;

import java.awt.Graphics;

public class GOval extends Graphique {
    private int x;
    private int y;
    private int demiGrandAxe;
    private int demiPetitAxe;

    public GOval(int x, int y, int demiGrandAxe, int demiPetitAxe) {
        this.x = x;
        this.y = y;
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
    }

    public int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }   

    public int getDemiGrandAxe() {
        return demiGrandAxe;
    }

    public int getDemiPetitAxe() {
        return demiPetitAxe;
    }

    @Override
    public void dessiner(Graphics g) {
        // Dessiner une ellipse avec le centre (x, y) et les demi-axes spécifiés si nécessaire
    }
}
