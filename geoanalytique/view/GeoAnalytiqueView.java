package geoanalytique.view;

import javax.swing.*;

import geoanalytique.graphique.Canevas;

import java.awt.*;
import java.awt.event.*;

public class GeoAnalytiqueView extends JPanel {
    
    private Canevas canevas;

    public GeoAnalytiqueView() {
        super();
        this.init();
    }

    
    public void init() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.canevas = new Canevas();
        this.add(canevas, BorderLayout.CENTER);
    }

    public Canevas getCanevas() {
        return canevas;
    }

    public void setCanevas(Canevas canevas) {
        this.canevas = canevas;
    }
}
