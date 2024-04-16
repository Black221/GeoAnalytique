package geoanalytique.graphique;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe Canevas
 */
public class Canevas extends JPanel {

    private ArrayList<Graphique> graphiques;
    private Graphique preview;
    /**
     * Constructeur
     */
    public Canevas() {
        super();
        this.init();
    }
    
    /**
     * Permet l'initialisation
     */
    public void init() {
        this.setBackground(Color.WHITE);
        this.graphiques = new ArrayList<Graphique>();
    }

    /**
     * Ajouter un element
     * @param g
     */
    public void addGraphique (Graphique g) {
        this.graphiques.add(g);
        System.out.println(graphiques.size());
    }

    public void setPreview (Graphique g) {
        this.preview = g;
    }

    public Graphique getPreview () {
        return this.preview;
    }

    /**
     * Supprime tous les elements
     */
    public void clear () {
        this.graphiques.clear();
    }

    /**
     * Enleve un element
     * @param g
     */
    public void removeGraphique (Graphique g) {
        this.graphiques.remove(g);
    }

    /**
     * Permet de tracer le repere
     * @param g
     */
    public void repere (Graphics g) {
        g.setColor(Color.BLACK);

        /* trace une ligne horizontale au milieu du repère */
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);

        /* trace une ligne verticale au milieu du repère */
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());

        /*  Part du milieu du repère trace la graduation par pas de 50 jusqu'à la fin du repère */
        for (int i = this.getWidth()/2; i < this.getWidth(); i += 50) {
            g.drawLine(i, this.getHeight()/2 - 5, i, this.getHeight()/2 + 5);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'au début du repère */
        for (int i = this.getWidth()/2; i > 0; i -= 50) {
            g.drawLine(i, this.getHeight()/2 - 5, i, this.getHeight()/2 + 5);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'en haut du repère */
        for (int i = this.getHeight()/2; i > 0; i -= 50) {
            g.drawLine(this.getWidth()/2 - 5, i, this.getWidth()/2 + 5, i);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'en bas du repère */
        for (int i = this.getHeight()/2; i < this.getHeight(); i += 50) {
            g.drawLine(this.getWidth()/2 - 5, i, this.getWidth()/2 + 5, i);
        }
    }

    /**
     * Permet de tous redissiner apres calcule des points
     * @param g graphic
     */
    public void paint(Graphics g) {
        super.paint(g); // on appelle la méthode paint de la classe mère
        this.repere(g); // on dessine le repère
        for (Graphique graphique : graphiques) {
            graphique.dessiner(g); // on dessine les graphiques
        }
        if (this.preview != null) {
            this.preview.dessiner(g); // on dessine le preview
        }
    };
}
