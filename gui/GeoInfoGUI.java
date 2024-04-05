package gui;

import java.awt.*;
import javax.swing.*;

public class GeoInfoGUI extends JPanel {
    
    public GeoInfoGUI() {
        super();
        this.init();
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);        
        this.setPreferredSize(new Dimension(400, 0));
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawString("Information", 10, 20);
    }
}
