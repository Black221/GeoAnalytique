package geoanalytique.view;

import javax.swing.*;
import java.awt.*;

public class GeoActionsView extends JPanel {

    private JPanel panelOutils;
    private JPanel panelFigures;
    private JPanel panelCouleurs;

    //Boutton outils
    private JButton boutonSelection;
    private JButton boutonDeplacement;
    private JButton boutonZoomAvant;
    private JButton boutonZoomArriere;

    //Boutton figures
    private JButton boutonPoint;
    private JButton boutonSegment;
    private JButton boutonDroite;
    private JButton boutonTriangle;
    private JButton boutonCarre;
    private JButton boutonRectangle;
    private JButton boutonLosange;
    private JButton boutonCercle;
    private JButton boutonEllipse;

    //Boutton couleurs
    private JButton boutonCouleurBlanc;
    private JButton boutonCouleurNoir;
    private JButton boutonCouleurGris;
    private JButton boutonCouleurMarron;

    private JButton boutonCouleurRouge;
    private JButton boutonCouleurJaune;
    private JButton boutonCouleurVert;
    private JButton boutonCouleurBleu;
    

    
    public GeoActionsView() {
        super();
        this.init();
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);        
        this.setPreferredSize(new Dimension(0, 120));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel pb;
        JTextField tf;
        

        /* -----------------------Outils---------------------------- */
        this.panelOutils = new JPanel();
        // this.panelOutils.setBackground(Color.RED);
        this.panelOutils.setLayout(new BorderLayout());
        pb = new JPanel();
        pb.setLayout(new GridLayout(2, 2));

        this.boutonSelection = new JButton("Selection");
        this.boutonDeplacement = new JButton("Deplacement");
        this.boutonZoomAvant = new JButton("Zoom Avant");
        this.boutonZoomArriere = new JButton("Zoom Arriere");

        pb.add(this.boutonSelection);
        pb.add(this.boutonDeplacement);
        pb.add(this.boutonZoomAvant);
        pb.add(this.boutonZoomArriere);

        this.panelOutils.add(pb, BorderLayout.CENTER);
        tf = new JTextField("Outils", 10);
        //centrer le texte
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setEditable(false);
        this.panelOutils.add(tf, BorderLayout.SOUTH);
        /* ----------------------------------------------------------- */

        /* ---------------------------Figures------------------------- */
        this.panelFigures = new JPanel();
        // this.panelFigures.setBackground(Color.GREEN);
        this.panelFigures.setLayout(new BorderLayout());

        pb = new JPanel();
        pb.setLayout(new GridLayout(3, 3));

        this.boutonPoint = new JButton("Point");
        this.boutonSegment = new JButton("Segment");
        this.boutonDroite = new JButton("Droite");
        this.boutonTriangle = new JButton("Triangle");
        this.boutonCarre = new JButton("Carre");
        this.boutonRectangle = new JButton("Rectangle");
        this.boutonLosange = new JButton("Losange");
        this.boutonCercle = new JButton("Cercle");
        this.boutonEllipse = new JButton("Ellipse");

        //ligne 1
        pb.add(this.boutonPoint);
        pb.add(this.boutonSegment);
        pb.add(this.boutonDroite);

        //ligne 2
        pb.add(this.boutonTriangle);
        pb.add(this.boutonCarre);
        pb.add(this.boutonRectangle);

        //ligne 3
        pb.add(this.boutonLosange);
        pb.add(this.boutonCercle);
        pb.add(this.boutonEllipse);

        this.panelFigures.add(pb, BorderLayout.CENTER);
        tf = new JTextField("Figures", 10);
        //centrer le texte
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setEditable(false);
        this.panelFigures.add(tf, BorderLayout.SOUTH);
        /* ----------------------------------------------------------- */

        /* -------------------------Couleurs-------------------------- */
        this.panelCouleurs = new JPanel();
        // this.panelCouleurs.setBackground(Color.BLUE);
        this.panelCouleurs.setLayout(new BorderLayout());

        pb = new JPanel();
        pb.setLayout(new GridLayout(2, 4));

        this.boutonCouleurBlanc = new JButton("Blanc");
        this.boutonCouleurNoir = new JButton("Noir");
        this.boutonCouleurGris = new JButton("Gris");
        this.boutonCouleurMarron = new JButton("Marron");
        this.boutonCouleurRouge = new JButton("Rouge");
        this.boutonCouleurVert = new JButton("Vert");
        this.boutonCouleurBleu = new JButton("Bleu");
        this.boutonCouleurJaune = new JButton("Jaune");

        //ligne 1
        pb.add(this.boutonCouleurBlanc);
        pb.add(this.boutonCouleurNoir);
        pb.add(this.boutonCouleurGris);
        pb.add(this.boutonCouleurMarron);

        //ligne 2
        pb.add(this.boutonCouleurRouge);
        pb.add(this.boutonCouleurVert);
        pb.add(this.boutonCouleurBleu);
        pb.add(this.boutonCouleurJaune);

        this.panelCouleurs.add(pb, BorderLayout.CENTER);
        tf = new JTextField("Couleurs", 10);
        //centrer le texte
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setEditable(false);
        this.panelCouleurs.add(tf, BorderLayout.SOUTH);
        /* ----------------------------------------------------------- */

        this.add(this.panelOutils);
        this.add(this.panelFigures);
        this.add(this.panelCouleurs);

    }

    public JButton getBSelectionner() {
        return this.boutonSelection;
    }

    public JButton getBDeplacement(){
        return this.boutonDeplacement;
    }

    public JButton getBZoomAvant(){
        return this.boutonZoomAvant;
    }

    public JButton getBZoomArriere(){
        return this.boutonZoomArriere;
    }

    public JButton getBPoint(){
        return this.boutonPoint;
    }

    public JButton getBSegment(){
        return this.boutonSegment;
    }

    public JButton getBDroite(){
        return this.boutonDroite;
    }

    public JButton getBTriangle(){
        return this.boutonTriangle;
    }

    public JButton getBCarre(){
        return this.boutonCarre;
    }

    public JButton getBRectangle(){
        return this.boutonRectangle;
    }

    public JButton getBLosange(){
        return this.boutonLosange;
    }

    public JButton getBCercle(){
        return this.boutonCercle;
    }

    public JButton getBEllipse(){
        return this.boutonEllipse;
    }

    public JButton getBCouleurBlanc(){
        return this.boutonCouleurBlanc;
    }

    public JButton getBCouleurNoir(){
        return this.boutonCouleurNoir;
    }

    public JButton getBCouleurGris(){
        return this.boutonCouleurGris;
    }

    public JButton getBCouleurMarron(){
        return this.boutonCouleurMarron;
    }

    public JButton getBCouleurRouge(){
        return this.boutonCouleurRouge;
    }

    public JButton getBCouleurJaune(){
        return this.boutonCouleurJaune;
    }

    public JButton getBCouleurVert(){
        return this.boutonCouleurVert;
    }

    public JButton getBCouleurBleu(){
        return this.boutonCouleurBleu;
    }
}
