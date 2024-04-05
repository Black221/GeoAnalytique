package view;

import javax.swing.*;
import java.awt.*;

public class GeoAnalytiqueView extends JPanel {
    
    public JTextField field;

    public GeoAnalytiqueView() {
        super();
        this.init();
    }
    
    public void init() {
        this.setBackground(Color.WHITE);

        field = new JTextField();
        field.setPreferredSize(new Dimension(100, 20));
        field.setText("0");
        this.add(field);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);

        /* trace une ligne horizontale au milieu du repère */
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);

        /* trace une ligne verticale au milieu du repère */
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());

        /*  Part du milieu du repère trace la graduation par pas de 50 jusqu'à la fin du repère */
        for (int i = this.getWidth()/2; i < this.getWidth(); i += 50) {
            g.drawLine(i, this.getHeight()/2 - 5, i, this.getHeight()/2 + 5);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'au début du repère */
        for (int i = this.getWidth()/2; i > 0; i -= 50) {
            g.drawLine(i, this.getHeight()/2 - 5, i, this.getHeight()/2 + 5);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'en haut du repère */
        for (int i = this.getHeight()/2; i > 0; i -= 50) {
            g.drawLine(this.getWidth()/2 - 5, i, this.getWidth()/2 + 5, i);
        }

        /* Part du milieu du repère trace la graduation par pas de 50 jusqu'en bas du repère */
        for (int i = this.getHeight()/2; i < this.getHeight(); i += 50) {
            g.drawLine(this.getWidth()/2 - 5, i, this.getWidth()/2 + 5, i);
        }
    };
    
}
