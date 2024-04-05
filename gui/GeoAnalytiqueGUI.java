package gui;

import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeoAnalytiqueGUI extends JFrame {
    
    private GeoAnalytiqueView panelRepere;
    private GeoInfoView panelInfo;
    private GeoActionsView panelBouton;
    /*
     * Constructeur de la classe GeoAnalytiqueGUI
     * 
     */
    public GeoAnalytiqueGUI() {
        super("GeoAnalytique");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Fichier");
        JMenuItem menuItem = new JMenuItem("Quitter");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //Panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Panneau haut
        panelBouton = new GeoActionsView();
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

    public GeoActionsView getPanelBouton() {
        return panelBouton;
    }


    public void paint(Graphics g) {
        super.paint(g);
    };
}
