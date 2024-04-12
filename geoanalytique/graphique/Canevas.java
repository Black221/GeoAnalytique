package geoanalytique.graphique;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canevas extends JPanel {

    private ArrayList<Graphique> graphiques;

    public Canevas() {
        super();
        this.init();
    }
    
    public void init() {
        this.setBackground(Color.WHITE);
        this.graphiques = new ArrayList<Graphique>();
    }

    public void addGraphique (Graphique g) {
        this.graphiques.add(g);
        System.out.println(graphiques.size());
    }

    public void clear () {
        this.graphiques.clear();
    }

    public void removeGraphique (Graphique g) {
        this.graphiques.remove(g);
    }

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
     * 
     */
    public void paint(Graphics g) {
        super.paint(g);
        this.repere(g);
        for (Graphique gr : graphiques) {
            gr.dessiner(g);
        }
    };
}
