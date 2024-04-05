package gui;

import javax.swing.*;
import java.awt.*;

public class GeoBoutonGUI extends JPanel {

    public JPanel panelOutils;
    public JPanel panelFigures;
    public JPanel panelCouleurs;
    
    public GeoBoutonGUI() {
        super();
        this.init();
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);        
        this.setPreferredSize(new Dimension(0, 120));

        this.setLayout(new FlowLayout());

        this.panelOutils = new JPanel();
    }


}
