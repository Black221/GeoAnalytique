package geoanalytique.controleur;


import geoanalytique.gui.*;
import geoanalytique.view.*;

import javax.swing.*;
import java.awt.*;

public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoActionsView panelBouton;

    private Color couleur = Color.BLACK;
    private Color couleurDefautBtn;
    private JButton [] boutonsCouleurs;
    private JButton boutonCouleurActif;

    public enum Outils {
        SELECTION, DEPLACEMENT, ZOOMAVANT, ZOOMARRIERE
    }

    public enum Figures {
        POINT, SEGMENT, DROITE, TRIANGLE, CARRE, RECTANGLE, LOSANGE, CERCLE, ELLIPSE
    }

    public enum Couleurs {
        BLANC, NOIR, GRIS, MARRON, ROUGE, JAUNE, VERT, BLEU
    }
    
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
        
        // recuperer bouton couleur
        boutonsCouleurs = panelBouton.getBoutonsCouleurs();
        couleurDefautBtn = boutonsCouleurs[0].getBackground();
        boutonCouleurActif = boutonsCouleurs[0];
        boutonCouleurActif.setBackground(Color.GREEN);

        for (int i = 0; i < 8; i++) {
            boutonsCouleurs[i].addActionListener(e -> {
                boutonCouleurActif.setBackground(couleurDefautBtn);
                boutonCouleurActif = (JButton) e.getSource();
                boutonCouleurActif.setBackground(Color.GREEN);
                couleur = Color.getColor(boutonCouleurActif.getText());
            });
        }
    }

    public void ajouterObject() {

    }

    public void selectionner() {

    }

    public void deselectionner() {

    }

}
