package geoanalytique.view;

import javax.swing.*;
import java.awt.*;

public class GeoActionsView extends JPanel {

    private JPanel panelOutils;
    private JPanel panelFigures;
    private JPanel panelCouleurs;

    /**
     * 
     */
    public enum Outils {
        SELECTION, DEPLACEMENT, ZOOMAVANT, ZOOMARRIERE
    }

    private JButton boutonsOutils[] = new JButton[4];

    public enum Figures {
        POINT, SEGMENT, DROITE, TRIANGLE, CARRE, RECTANGLE, LOSANGE, CERCLE, ELLIPSE
    }
    private JButton boutonsFigures[] = new JButton[9];

    public enum Couleurs {
        BLANC, NOIR, GRIS, MARRON, ROUGE, JAUNE, VERT, BLEU
    }
    //Boutton couleurs
    private JButton [] boutonsCouleurs = new JButton[8];
    
    
    public GeoActionsView() {
        super();
        this.init();
    }

    /**
     * Initialisation de la vue
     */
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

        for (int i = 0; i < 4; i++) {
            this.boutonsOutils[i] = new JButton(Outils.values()[i].toString());
            pb.add(this.boutonsOutils[i]);
        }

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

        for (int i = 0; i < 9; i++) {
            this.boutonsFigures[i] = new JButton(Figures.values()[i].toString());
            pb.add(this.boutonsFigures[i]);
        }

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

        for (int i = 0; i < 8; i++) {
            this.boutonsCouleurs[i] = new JButton(Couleurs.values()[i].toString());
            pb.add(this.boutonsCouleurs[i]);
        }

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

    /**
     * 
     * @return
     */
    public JButton [] getBoutonsOutils() {
        return this.boutonsOutils;
    }

    public JButton [] getBoutonsFigures() {
        return this.boutonsFigures;
    }

    public JButton [] getBoutonsCouleurs() {
        return this.boutonsCouleurs;
    }
}
