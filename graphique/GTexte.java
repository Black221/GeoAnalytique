package graphique;

import java.awt.Graphics;

public class GTexte extends Graphique {
    private String texte;
    private GCoordonnee position;

    public GTexte(String texte, GCoordonnee position) {
        this.texte = texte;
        this.position = position;
    }

    public String getTexte() {
        return texte;
    }

    public GCoordonnee getPosition() {
        return position;
    }

    @Override
    public void dessiner(Graphics g) {
        // Dessiner le texte à la position spécifiée si nécessaire
    }
}
