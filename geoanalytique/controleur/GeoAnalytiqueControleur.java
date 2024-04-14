package geoanalytique.controleur;


import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.*;
import geoanalytique.gui.*;
import geoanalytique.model.*;
import geoanalytique.view.*;
import geoanalytique.util.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class GeoAnalytiqueControleur implements MouseListener {

    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoBoutonsView panelBouton;

    private Color couleur = Color.BLACK;
    private JButton [] boutonsCouleurs;
    private JButton boutonCouleurActif;

    private JButton [] boutonsFigures;
    private JButton boutonFormeActif;
    private String formSelectionne;

    private JButton [] boutonsOutils;
    private JButton boutonOutilActif;
    private String outilSelectionne;

    private JButton [] boutonsActifs = new JButton[3];

    private Canevas canevas;
    private Viewport viewport;
    private Dessinateur dessinateur;

    private Usine usine = new Usine();

    class MyBoutonListener implements ActionListener {

        private JButton button;
        public MyBoutonListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.button.setBorder(BorderFactory.createEmptyBorder());
            this.button = (JButton) e.getSource();
            this.button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        }
    }

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

    public void evenements2() {

        JButton [][] boutons = this.panelBouton.getBoutons();

        for (int i = 0; i < boutons.length; i++) {
            this.boutonsActifs[i] = boutons[i][0];
            this.boutonsActifs[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

            for (int j = 0; j < boutons[i].length; j++) {
                boutons[i][j].addActionListener(new MyBoutonListener(this.boutonsActifs[i]));
            }
        }
    }


    /**
     * Permet de gérer les événements des boutons
     */
    public void evenements() {
        // recuperer bouton couleur
        this.boutonsCouleurs = panelBouton.getBoutonsCouleurs();
        this.boutonCouleurActif = boutonsCouleurs[0];
        this.boutonCouleurActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        for (int i = 0; i < 8; i++) {
            this.boutonsCouleurs[i].addActionListener(e -> {
                this.boutonCouleurActif.setBorder(BorderFactory.createEmptyBorder());
                this.boutonCouleurActif = (JButton) e.getSource();
                this.boutonCouleurActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                this.couleur = (Color) boutonCouleurActif.getBackground();
                System.out.println(this.couleur);
            });
        }

        // recuperer bouton Figures
        this.boutonsFigures = panelBouton.getBoutonsFigures();
        this.boutonFormeActif = boutonsFigures[0];
        this.boutonFormeActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        this.formSelectionne = boutonFormeActif.getText();

        for (int i = 0; i < 9; i++) {
            this.boutonsFigures[i].addActionListener(e -> {
                this.boutonFormeActif.setBorder(BorderFactory.createEmptyBorder());
                this.boutonFormeActif = (JButton) e.getSource();
                this.boutonFormeActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                this.formSelectionne = boutonFormeActif.getText();
            });
        }

        // recuperer bouton Outils
        this.boutonsOutils = panelBouton.getBoutonsOutils();
        this.boutonOutilActif = boutonsOutils[0];
        this.boutonOutilActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        this.outilSelectionne = boutonOutilActif.getText();

        for (int i = 0; i < 4; i++) {
            this.boutonsOutils[i].addActionListener(e -> {
                this.boutonOutilActif.setBorder(BorderFactory.createEmptyBorder());
                this.boutonOutilActif = (JButton) e.getSource();
                this.boutonOutilActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                this.outilSelectionne = boutonOutilActif.getText();
            });
        }

        this.panelBouton.getEffacer().addActionListener(e -> {
            this.effacer();
        });
    }

    private GCoordonnee [] cliques = new GCoordonnee[2];

    /**
     * Permet de recuperer les cordoonnées de la souris pressée
     * @param e Evenement souris
     */
    @Override
    public void mousePressed(MouseEvent e) {
        cliques[0] = new GCoordonnee(e.getX(), e.getY());
    }

    /**
     * Permet de recuperer les cordoonnées de la souris relachée
     * @param e Evenement souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        cliques[1] = new GCoordonnee(e.getX(), e.getY());
        ajouterObject();
        recalculePoints();
    }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    /**
     * Permet de recalculer les points et de les dessiner
     */
    public void recalculePoints() {
        try {
            this.canevas.clear();
            for (GeoObject obj : this.panelInfo.getObject()) {
                this.canevas.addGraphique(
                    obj.accept(dessinateur)
                );
            }
            this.canevas.repaint();
            this.panelInfo.afficherInfo();
        } catch (VisiteurException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet d'ajouter un objet géométrique
     */
    public void ajouterObject() {
        Point p1 = viewport.convert(cliques[0]);
        Point p2 = viewport.convert(cliques[1]);

        this.panelInfo.addGeoObject(
            usine.produire(p1, p2, formSelectionne, this.couleur.getRGB())
        );
    }

    public void selectionner(GeoObject obj) {
        obj.setEstSelectionne(true);
    }

    public void deselectionner() {

    }

    public void effacer(){
        this.canevas.clear();
        this.panelInfo.clearObject();
        this.recalculePoints();
    }
}
