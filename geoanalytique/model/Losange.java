package geoanalytique.model;

import java.awt.Color;

public class Losange extends Polygone {

    private static int compteur = 0;

    /**
     * Constructeur de la classe Losange
     * @param p: point en haut à gauche du losange
     * @param l1: longueur du losange
     * @param l2: largeur du losange
     */
    public Losange(Point p, double l1, double l2) {
        super("Los"+ compteur,
            new Segment[]{
                new Segment(
                    p, // p1
                    new Point(p.getX() + l1/2, p.getY() + l2/2) // p2
                ), // p1 p2
                new Segment(
                    new Point(p.getX() + l1/2, p.getY() + l2/2),  // p2
                    new Point(p.getX() + l1, p.getY()) // p3
                ),// p2 p3
                new Segment(
                    new Point(p.getX() + l1, p.getY()),  // p3
                    new Point(p.getX() + l1/2, p.getY() - l2/2) // p4
                ),// p3 p4
                new Segment(
                    new Point(p.getX() + l1/2, p.getY() - l2/2),  // p4
                    p // p1
                )// p4 p1
            }
        );
        Losange.compteur++;
    }

    /**
     * Constructeur de la classe Losange
     * @param p: point en haut à gauche du losange
     * @param l1: longueur du losange
     * @param l2: largeur du losange
     * @param couleur: couleur du losange
     */
    public Losange(Point p, double l1, double l2, Color couleur) {
        super("Los"+ compteur,
            new Segment[]{
                new Segment(p, new Point(p.getX() + l1/2, p.getY() + l2/2)),
                new Segment(new Point(p.getX() + l1/2, p.getY() + l2/2), new Point(p.getX() + l1, p.getY())),
                new Segment(new Point(p.getX() + l1, p.getY()), new Point(p.getX() + l1/2, p.getY() - l2/2)),
                new Segment(new Point(p.getX() + l1/2, p.getY() - l2/2), p)
            },
            couleur
        );
        Losange.compteur++;
    }

    /**
     * Methode pour calculer l'aire du losange
     * @return l'aire du losange
     */
    public double aire() {
        return 0;
    }

    public String afficher() {
        return "Losange " + this.getNom();
    }
}
