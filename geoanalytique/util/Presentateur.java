package geoanalytique.util;

import javax.swing.*;

import geoanalytique.model.*;

public class Presentateur implements GeoObjectVisiteur<JPanel> {
    
    public Presentateur() {}
    /*
    * |   | x | y |
    * |---|---|---|
    * | P | 1 | 2 |
    */

    public JPanel visit(Point p) {
        JTable table = new JTable(
            new Object[][] {
                {"Point", "X", "Y"},
                {p.getNom(), p.getX(), p.getY()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);
        return panel;
    }

    public JPanel visit(Segment s) {
        Object[][] data = new Object[3][4];
        
        JTable table = new JTable(
            new Object[][] {
                {s.getNom(), "X", "Y"},
                {s.getPoint1().getNom(), s.getPoint1().getX(), s.getPoint1().getY()},
                {s.getPoint2().getNom(), s.getPoint2().getX(), s.getPoint2().getY()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);
        return panel;
    }

    public JPanel visit(Droite d) {
        JTable table = new JTable(
            new Object[][] {
                {d.getNom(), "X", "Y"},
                {d.getPoint1().getNom(), d.getPoint1().getX(), d.getPoint1().getY()},
                {d.getPoint2().getNom(), d.getPoint2().getX(), d.getPoint2().getY()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);
        return panel;
    }

    public JPanel visit(Ellipse e) {
        JTable table = new JTable(
            new Object[][] {
                {e.getNom(), "X", "Y", "demi grand axe", "demi petit axe"},
                {e.getCentre().getNom(), e.getCentre().getX(), e.getCentre().getY(), e.getDemiGrandAxe(), e.getDemiPetitAxe()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);
        return panel;
    }

    public JPanel visit(Polygone p) {
        Object[][] data = new Object[p.getSommets().length + 1][4];
        data[0] = new Object[] {p.getNom(), "X", "Y"};

        for (int i = 0; i < p.getSommets().length; i++) {
            data[i + 1] = new Object[] {p.getSommets()[i].getNom(), p.getSommets()[i].getX(), p.getSommets()[i].getY()};
        }
        JTable table = new JTable(
            data,
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);
        return panel;
    }
}
