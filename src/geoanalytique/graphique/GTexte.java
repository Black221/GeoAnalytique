package geoanalytique.graphique;

import java.awt.Graphics;
/**
 * Classe pour représenter un texte graphique
 */
public class GTexte extends Graphique {
    private String texte;
    private GCoordonnee position;
    /**
     * Constructeur GTexte
     * @param texte
     * @param position
     */
    public GTexte(String texte, GCoordonnee position) {
        this.texte = texte;
        this.position = position;
    }

    /**
     * Méthode pour obtenir le texte
     * @return String texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Méthode pour obtenir la position
     * @return GCoordonnee position
     */
    public GCoordonnee getPosition() {
        return position;
    }

    /**
     * Méthode pour définir le texte
     * @param texte
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * Méthode pour dessiner un texte graphique
     * @param g
     */
    @Override
    public void dessiner(Graphics g) {
        // Dessiner le texte à la position spécifiée si nécessaire

        g.setColor(this.getCouleur());
        g.drawString(texte, (int)position.getX(),(int) position.getY());
    }
}
