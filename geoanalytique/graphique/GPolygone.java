package geoanalytique.graphique;

import java.awt.Graphics;
import java.awt.Color;

public class GPolygone extends Graphique {
    
    private GLine [] lignes;
    private GCoordonnee [] sommets;
    

    public GPolygone(GLine [] lignes) {
        this.lignes = lignes;
        this.sommets = new GCoordonnee[lignes.length];
        for (int i = 0; i < lignes.length; i++) {
            this.sommets[i] = lignes[i].getP1();
        }
    }

    public GPolygone(GLine [] lignes, Color couleur) {
        this.lignes = lignes;
        for (GLine l : lignes) {
            l.setCouleur(couleur);
        }
    }

    public GLine [] getLignes() {
        return lignes;
    }

    public GCoordonnee [] getSommets() {
        return sommets;
    }

    @Override
    public void dessiner(Graphics g) {
        g.setColor(this.getCouleur());
        for (GLine l : lignes) {
            l.dessiner(g);
        }
        for (GCoordonnee c : sommets) {
            c.dessiner(g);
        }
    }
}