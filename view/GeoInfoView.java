package view;

import javax.swing.*;
import java.awt.*;

public class GeoInfoView extends JPanel {
    
    public GeoInfoView() {
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
