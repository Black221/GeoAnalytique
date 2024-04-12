package geoanalytique.controleur;


import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.*;
import geoanalytique.gui.*;
import geoanalytique.model.*;
import geoanalytique.view.*;
import geoanalytique.util.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;


public class GeoAnalytiqueControleur implements MouseListener {

    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoActionsView panelBouton;

    private Color couleur = Color.BLACK;
    private Color couleurDefautBtn;
    private JButton [] boutonsCouleurs;
    private JButton boutonCouleurActif;

    private JButton [] boutonsFigures;
    private JButton boutonFormeActif;
    private String formSelectionne;

    private Canevas canevas;
    private Viewport viewport;
    private Dessinateur dessinateur;

    public GeoAnalytiqueControleur() {
        GeoAnalytiqueGUI gui = new GeoAnalytiqueGUI();

        this.panelRepere = gui.getPanelRepere();
        this.panelInfo = gui.getPanelInfo();
        this.panelBouton = gui.getPanelBouton();

        this.viewport = new Viewport(panelRepere.getWidth(), panelRepere.getHeight());
        this.canevas = panelRepere.getCanevas();
        this.dessinateur = new Dessinateur(viewport);

        this.panelRepere.addMouseListener(this);
        this.evenements();
    }

    public void evenements() {
        
        // recuperer bouton couleur
        this.boutonsCouleurs = panelBouton.getBoutonsCouleurs();
        this.couleurDefautBtn = boutonsCouleurs[0].getBackground();
        this.boutonCouleurActif = boutonsCouleurs[0];

        for (int i = 0; i < 8; i++) {
            this.boutonsCouleurs[i].addActionListener(e -> {
                this.boutonCouleurActif.setBorder(BorderFactory.createEmptyBorder());
                this.boutonCouleurActif = (JButton) e.getSource();
                this.boutonCouleurActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                this.couleur = boutonCouleurActif.getBackground();
            });
        }

        // recuperer bouton Figures
        this.boutonsFigures = panelBouton.getBoutonsFigures();
        this.boutonFormeActif = boutonsFigures[0];
        this.boutonFormeActif.setBackground(Color.GREEN);
        this.formSelectionne = boutonFormeActif.getText();

        for (int i = 0; i < 9; i++) {
            this.boutonsFigures[i].addActionListener(e -> {
                this.boutonFormeActif.setBackground(couleurDefautBtn);
                this.boutonFormeActif = (JButton) e.getSource();
                this.boutonFormeActif.setBackground(Color.GREEN);
                this.formSelectionne = boutonFormeActif.getText();
            });
        }
    }

    private Point [] points = new Point[2];
    //mouse pressed
    @Override
    public void mousePressed(MouseEvent e) {
        
        GCoordonnee coord = new GCoordonnee(e.getX(), e.getY());

        if (formSelectionne.equals("POINT")) {
            // convertir les coordonnées graphiques en coordonnées réelles
            Point point = viewport.convert(coord);
            point.setCouleur(couleur);
            this.panelInfo.addGeoObject(point);
        }

        if (formSelectionne.equals("DROITE") || 
            formSelectionne.equals("SEGMENT") || 
            formSelectionne.equals("RECTANGLE") || 
            formSelectionne.equals("CARRE") || 
            formSelectionne.equals("ELLIPSE") || 
            formSelectionne.equals("CERCLE")) {
            points[0] = viewport.convert(coord);
        }

    }

    //mouse released
    @Override
    public void mouseReleased(MouseEvent e) {
        GCoordonnee coord = new GCoordonnee(e.getX(), e.getY());

        if (formSelectionne.equals("DROITE")) {
            points[1] = viewport.convert(coord);

            Droite droite = new Droite(points[0], points[1], couleur);
            this.panelInfo.addGeoObject(droite);
        }

        if (formSelectionne.equals("SEGMENT")) {
            points[1] = viewport.convert(coord);

            Segment segment = new Segment(points[0], points[1], couleur);
            this.panelInfo.addGeoObject(segment);
        }

        if (formSelectionne.equals("RECTANGLE")) {
            points[1] = viewport.convert(coord);

            Rectangle rectangle = new Rectangle(
                points[0],  // point 0
                points[1].getX() - points[0].getX(), // calcul de la taille en x
                points[1].getY() - points[0].getY(), // calcul de la taille en y
                couleur
            );
            this.panelInfo.addGeoObject(rectangle);
        }

        if (formSelectionne.equals("CARRE")) {
            points[1] = viewport.convert(coord);

            Carre carre = new Carre(
                points[0],  // point 0
                points[1].getX() - points[0].getX(), // calcul de la taille
                couleur
            );
            this.panelInfo.addGeoObject(carre);
        }

        if (formSelectionne.equals("ELLIPSE")) {
            points[1] = viewport.convert(coord);

            Ellipse ellipse = new Ellipse(
                points[0], // centre
                (points[1].getX() - points[0].getX()) / 2, // demi grand axe
                (points[1].getY() - points[0].getY()) / 2, // demi petit axe
                couleur
            );
            this.panelInfo.addGeoObject(ellipse);
        }

        if (formSelectionne.equals("CERCLE")) {
            points[1] = viewport.convert(coord);

            Cercle cercle = new Cercle(
                points[0], // centre
                points[1].getX() - points[0].getX(), // rayon
                couleur
            );
        }

        recalculePoints();
    }


    //mouse clicked
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    //mouse entered
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    //mouse clicked
    @Override
    public void mouseClicked(MouseEvent e) {

    }




    /**
     * 
     */
    public void recalculePoints() {
        try {
            this.canevas.clear();
            for (GeoObject obj : this.panelInfo.getObject()) {
                this.canevas.addGraphique(obj.accept(dessinateur));
            }
            this.canevas.repaint();
            this.panelInfo.afficherInfo();
        } catch (VisiteurException e) {
            e.printStackTrace();
        }
    }

    public void ajouterObject(GeoObject obj) {
        //this.objets.add(obj);
    }

    public void selectionner() {

    }

    public void deselectionner() {

    }


}
