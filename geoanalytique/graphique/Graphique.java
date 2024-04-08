package geoanalytique.graphique;

import java.awt.Graphics;
import java.awt.Color;
/**
 * Classe abstraite pour représenter un objet graphique
 */
public abstract class Graphique {

    private Color  couleur;

    
    public Graphique() {
        // Constructor
    }
    /**
     * Méthode pour obtenir la couleur
     * @return Color couleur
     */
    public Color getCouleur() {
        return couleur;
    }
    /**
     * Méthode pour définir la couleur
     * @param couleur
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    /**
     * Méthode pour dessiner un objet graphique
     * @param g
     */
    public abstract void dessiner(Graphics g);
}
