package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeoAnalytiqueGUI extends JFrame {
    
    GeoRepereGUI panelRepere;
    GeoInfoGUI panelInfo;
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

        //Panneau de gauche
        panelRepere = new GeoRepereGUI();
        panel.add(panelRepere, BorderLayout.CENTER);


        //Panneau de droite
        panelInfo = new GeoInfoGUI();

        panel.add(panelInfo, BorderLayout.EAST);

       
        this.add(panel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }


    public void paint(Graphics g) {
        super.paint(g);
    };
}
