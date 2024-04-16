package geoanalytique.view;

import javax.swing.*;

import geoanalytique.graphique.Canevas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Classe GeoAnalytiqueView
 * Cette classe est la vue dans laquelle on affiche les graphiques
 */
public class GeoAnalytiqueView extends JPanel {
    
    // private ArrayList<Graphique> graphiques;

    /**
     * variable qui contient le canevas
     */
    private Canevas canevas;

    /**
     * Constructeur de la classe GeoAnalytiqueView
     */
    public GeoAnalytiqueView() {
        super();
        this.init();
    }
    
    /**
     * Methode qui inicialise la vue
     */
    public void init() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.canevas = new Canevas();
        this.add(canevas, BorderLayout.CENTER);
    }

    /**
     * permet de récupérer le canevas
     * @return
     */
    public Canevas getCanevas() {
        return canevas;
    }

    /**
     * permet de modifier le canevas
     * @param canevas
     */
    public void setCanevas(Canevas canevas) {
        this.canevas = canevas;
    }
}
