package geoanalytique.model;
import java.awt.Color;
public class Rectangle extends Polygone {

    private static int compteur = 0;

    /**
     * Constructeur de la classe Rectangle
     * @param p: point en haut à gauche du rectangle
     * @param l1: longueur du rectangle
     * @param l2: largeur du rectangle
     */
    public Rectangle(Point p, double l1, double l2) {
        super("Rec"+ compteur,
            new Segment[]{
                new Segment(p, new Point(p.getX() + l1, p.getY())),
                new Segment(new Point(p.getX() + l1, p.getY()), new Point(p.getX() + l1, p.getY() + l2)),
                new Segment(new Point(p.getX() + l1, p.getY() + l2), new Point(p.getX(), p.getY() + l2)),
                new Segment(new Point(p.getX(), p.getY() + l2), p)
            }
        );
        Rectangle.compteur++;
    }
    /*
     public Rect() {
        super(nom, new Segment[4]);

        Point p1 = ...
        Point p2 = ...
        Point p3 = ...
        Point p4 = ...

        this.setCotes(
            new Segment(p1, p2), 
            new Segment(p2, p3), 
            new Segment(p3, p4), 
            new Segment(p4, p1)
        );
     }
     */

    /**
     * Constructeur de la classe Rectangle
     * @param p: point en haut à gauche du rectangle
     * @param l1: longueur du rectangle
     * @param l2: largeur du rectangle
     * @param couleur: couleur du rectangle
     */
    public Rectangle(Point p, double l1, double l2, Color couleur) {
        super("Rec"+ compteur,
            new Segment[]{
                new Segment(p, new Point(p.getX() + l1, p.getY())),
                new Segment(new Point(p.getX() + l1, p.getY()), new Point(p.getX() + l1, p.getY() + l2)),
                new Segment(new Point(p.getX() + l1, p.getY() + l2), new Point(p.getX(), p.getY() + l2)),
                new Segment(new Point(p.getX(), p.getY() + l2), p)
            },
            couleur
        );
        Rectangle.compteur++;
    }

    /**
     * @return: la longueur du rectangle
     */
    public double getLongueur() {
        return Math.max(
            cotes[0].longueur(),
            cotes[1].longueur() 
        );
    }

    /**
     * @return: la largeur du rectangle
     */
    public double getLargeur() {
        return Math.min(
            cotes[0].longueur(),
            cotes[1].longueur() 
        );
    }

    /**
     * @Return: retourne l'aire du rectangle
     */
    public double aire() {
        return this.getLongueur() * this.getLargeur();
    }
}
