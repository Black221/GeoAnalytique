package geoanalytique.util;

import javax.swing.*;

import geoanalytique.model.*;

/**
 * Classe permettant d'afficher les objets géométriques sous  forme de tableau
 */
public class Afficheur implements GeoObjectVisiteur<JPanel> {
    
    public Afficheur() {} // Constructeur

    public JPanel visit(Point p) {
        
        JTable table = new JTable(
            new Object[][] {
                {"Point", "X", "Y"},
                {p.getNom(), p.getX(), p.getY()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder( // Ajout d'une bordure
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);// On ajoute le tableau au panel
        return panel;
    }

    public JPanel visit(Segment s) {
        Object[][] data = new Object[3][4];
        
        JTable table = new JTable(
            new Object[][] {
                {s.getNom(), "X", "Y"}, // Nom, X, Y
                // on recupere les coordonnees des points
                {s.getPoint1().getNom(), s.getPoint1().getX(), s.getPoint1().getY()},
                {s.getPoint2().getNom(), s.getPoint2().getX(), s.getPoint2().getY()}
            },
            new Object[] {"Nom", "X", "Y"} 
        );
        JPanel panel = new JPanel();
        panel.setBorder(// Ajout d'une bordure
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);// On ajoute le tableau au panel
        return panel;
    }

    public JPanel visit(Droite d) {
        JTable table = new JTable(
            new Object[][] {
                {d.getNom(), "X", "Y"},
                // on recupere les coordonnees des points
                {d.getPoint1().getNom(), d.getPoint1().getX(), d.getPoint1().getY()},
                {d.getPoint2().getNom(), d.getPoint2().getX(), d.getPoint2().getY()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(// Ajout d'une bordure
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);// On ajoute le tableau au panel
        return panel;
    }

    public JPanel visit(Ellipse e) {
        JTable table = new JTable(
            new Object[][] {
                {e.getNom(), "X", "Y", "demi grand axe", "demi petit axe"},
                // on recupere les coordonnees du centre et les demi axes
                {e.getCentre().getNom(), e.getCentre().getX(), e.getCentre().getY(), e.getDemiGrandAxe(), e.getDemiPetitAxe()}
            },
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(// Ajout d'une bordure
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table);// On ajoute le tableau au panel
        return panel;
    }

    public JPanel visit(Polygone p) {
        Object[][] data = new Object[p.getSommets().length + 1][4];
        data[0] = new Object[] {p.getNom(), "X", "Y"};

        // On parcours les sommets du polygone pour creer les lignes du tableau
        for (int i = 0; i < p.getSommets().length; i++) {
            data[i + 1] = new Object[] {p.getSommets()[i].getNom(), p.getSommets()[i].getX(), p.getSommets()[i].getY()};
        }
        JTable table = new JTable(
            data,
            new Object[] {"Nom", "X", "Y"}
        );
        JPanel panel = new JPanel();
        panel.setBorder(// Ajout d'une bordure
            javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        panel.add(table); // On ajoute le tableau au panel
        return panel;
    }
}
