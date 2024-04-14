package geoanalytique.graphique;

import java.awt.Graphics;
import java.awt.Color;

public class GPolygone extends Graphique {
    
    private GLigne [] lignes;
    private GCoordonnee [] sommets;
    

    public GPolygone(GLigne [] lignes) {
        this.lignes = lignes;
        this.sommets = new GCoordonnee[lignes.length];
        for (int i = 0; i < lignes.length; i++) {
            this.sommets[i] = lignes[i].getP1();
        }
    }

    public GPolygone(GLigne [] lignes, Color couleur) {
        this.lignes = lignes;
        for (GLigne l : lignes) {
            l.setCouleur(couleur);
        }
    }

    public GLigne [] getLignes() {
        return lignes;
    }

    public GCoordonnee [] getSommets() {
        return sommets;
    }

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