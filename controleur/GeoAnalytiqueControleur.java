package controleur;

import gui.GeoAnalytiqueGUI;
import view.GeoActionsView;
import view.GeoAnalytiqueView;
import view.GeoInfoView;

import javax.swing.*;
import java.awt.*;

public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoActionsView panelBouton;
    
    public GeoAnalytiqueControleur() {
        GeoAnalytiqueGUI gui = new GeoAnalytiqueGUI();

        panelRepere = gui.getPanelRepere();
        panelInfo = gui.getPanelInfo();
        panelBouton = gui.getPanelBouton();

        this.evenements();
    }

    public void evenements() {

        // recuperer champs text dans le repere
        JTextField tf = panelRepere.field;

        // recuperer bouton selectionner et ajouter evenement
        panelBouton
        .getBSelectionner()
        .addActionListener(e -> {
            
        });

        // recuperer bouton deplacement et ajouter evenement
        panelBouton
        .getBDeplacement()
        .addActionListener(e -> {
            
        });

        // recuperer bouton zoom avant et ajouter evenement
        panelBouton
        .getBZoomAvant()
        .addActionListener(e -> {
            
        });

        // recuperer bouton zoom arriere et ajouter evenement
        panelBouton
        .getBZoomArriere()
        .addActionListener(e -> {
            
        });


        // recuperer bouton point et ajouter evenement
        panelBouton
        .getBPoint()
        .addActionListener(e -> {
            
        });

        // recuperer bouton segment et ajouter evenement
        panelBouton
        .getBSegment()
        .addActionListener(e -> {
            
        });

        // recuperer bouton droite
        panelBouton
        .getBDroite()
        .addActionListener(e -> {
            
        });

        // recuperer bouton triangle et ajouter evenement
        panelBouton
        .getBTriangle()
        .addActionListener(e -> {
            
        });

        // recuperer bouton carre
        panelBouton
        .getBCarre()
        .addActionListener(e -> {
            
        });

        // recuperer bouton rectangle et ajouter evenement
        panelBouton
        .getBRectangle()
        .addActionListener(e -> {
            
        });

        // recuperer bouton losange et ajouter evenement
        panelBouton
        .getBLosange()
        .addActionListener(e -> {
            
        });

        // recuperer bouton cercle et ajouter evenement
        panelBouton
        .getBCercle()
        .addActionListener(e -> {
            
        });

        // recuperer bouton ellipse et ajouter evenement
        panelBouton
        .getBEllipse()
        .addActionListener(e -> {
            
        });
    }

    public void ajouterObject() {

    }

    public void selectionner() {

    }

    public void deselectionner() {

    }

}
