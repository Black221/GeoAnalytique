package geoanalytique.gui;

import javax.swing.*;

import geoanalytique.view.*;

import java.awt.*;

/**
 * Classe qui represente la fenetre principale de l'application
 */
public class GeoAnalytiqueGUI extends JFrame {
    
    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoBoutonsView panelBouton;
    /*
     * Constructeur de la classe GeoAnalytiqueGUI
     * 
     */
    public GeoAnalytiqueGUI() {
        super("GeoAnalytique");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cette ligne permet de tuer le processus
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Fichier");
        JMenuItem menuItem = new JMenuItem("Quitter");
        JMenuItem menuItem2 = new JMenuItem("Ouvrir");
        // menuItem.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         System.exit(0);
        //     }
        // });
        menu.add(menuItem);
        menu.add(menuItem2);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //Panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Panneau haut
        panelBouton = new GeoBoutonsView();
        panel.add(panelBouton, BorderLayout.NORTH);

        //Panneau de gauche
        panelRepere = new GeoAnalytiqueView();
        panel.add(panelRepere, BorderLayout.CENTER);


        //Panneau de droite
        panelInfo = new GeoInfoView();
        panel.add(panelInfo, BorderLayout.EAST);

       
        this.add(panel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public GeoAnalytiqueView getPanelRepere() {
        return panelRepere;
    }

    public GeoInfoView getPanelInfo() {
        return panelInfo;
    }

    public GeoBoutonsView getPanelBouton() {
        return panelBouton;
    }


    public void paint(Graphics g) {
        super.paint(g);
    };
}
