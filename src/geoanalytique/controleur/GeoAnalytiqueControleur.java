package geoanalytique.controleur;


import javax.swing.*;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.*;
import geoanalytique.gui.*;
import geoanalytique.model.*;
import geoanalytique.util.*;
import geoanalytique.view.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Controleur
 */
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

    private Canevas canevas;
    private Viewport viewport;
    private Dessinateur dessinateur;

    private Usine usine = new Usine();
    private GCoordonnee [] cliques = new GCoordonnee[2];

    /**
     * Constructeur
     */
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


    /**
     * Permet de gérer les événements des boutons
     */
    public void evenements() {
        // recuperer bouton couleur
        this.boutonsCouleurs = panelBouton.getBoutonsCouleurs();
        this.boutonCouleurActif = boutonsCouleurs[0];
        this.boutonCouleurActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        for (JButton jButton : boutonsCouleurs) { // ajouter un evenement sur chaque bouton
            jButton.addActionListener(e -> {
                this.boutonCouleurActif.setBorder(BorderFactory.createEmptyBorder());
                this.boutonCouleurActif = (JButton) e.getSource();
                this.boutonCouleurActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                this.couleur = boutonCouleurActif.getBackground();
            });
        }

        // recuperer bouton Figures
        this.boutonsFigures = panelBouton.getBoutonsFigures();
        this.boutonFormeActif = boutonsFigures[0];
        this.boutonFormeActif.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        this.formSelectionne = boutonFormeActif.getText();

        for (JButton jButton : boutonsFigures) {
            jButton.addActionListener(e -> {
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

        for (JButton jButton : boutonsOutils) {
            jButton.addActionListener(e -> {
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
            this.canevas.clear(); // supprime les objects graphiques
            // recuperer les objets geometriques
            for (GeoObject obj : this.panelInfo.getObject()) {
                this.canevas.addGraphique(
                    obj.accept(dessinateur) // retourne un objet graphique
                );
            }
            this.canevas.repaint(); // redessine les objets
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

    /**
     * Permet de selectionner un objet
     * @param obj: objet à selectionner
     */
    public void selectionner(GeoObject obj) {
        obj.setEstSelectionne(true);
    }

    /**
     * Permet de deselectionner un objet
     */
    public void deselectionner() {

    }

    /**
     * Permet d'effacer les objets
     */
    public void effacer(){
        this.canevas.clear();
        this.panelInfo.clearObject();
        this.recalculePoints();
    }
}
