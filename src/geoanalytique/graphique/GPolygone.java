package geoanalytique.graphique;

import java.awt.Graphics;
import java.awt.Color;

/**
 * 
 */
public class GPolygone extends Graphique {
    
    private GLigne [] lignes;
    private GCoordonnee [] sommets;
    
    /**
     * Constructeur de la classe GPolygone
     * @param lignes
     */
    public GPolygone(GLigne [] lignes) {
        this.lignes = lignes;
        this.sommets = new GCoordonnee[lignes.length];
        for (int i = 0; i < lignes.length; i++) {
            this.sommets[i] = lignes[i].getP1();
        }
    }

    /**
     * Constructeur de la classe GPolygone
     * @param lignes
     * @param couleur
     */
    public GPolygone(GLigne [] lignes, Color couleur) {
        this.lignes = lignes;
        for (GLigne l : lignes) {
            l.setCouleur(couleur);
        }
    }

    /**
     * permet de récupérer les lignes
     * @return
     */
    public GLigne [] getLignes() {
        return lignes;
    }

    /**
     * permet de récupérer les sommets
     * @return
     */
    public GCoordonnee [] getSommets() {
        return sommets;
    }

    /**
     * permet de modifier les lignes
     */
    @Override
    public void dessiner(Graphics g) {
        g.setColor(this.getCouleur());
        for (GLigne l : lignes) {
            l.dessiner(g);
        }
        for (GCoordonnee c : sommets) {
            c.dessiner(g);
        }
    }
}