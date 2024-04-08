package geoanalytique.model;

import java.awt.Color;
public class Rectangle extends Polygone {

    private static int compteur = 0;

    /**
     * Constructeur de la classe Rectangle
     * @param x: abscisse du point en haut à gauche du rectangle
     * @param y: abscisse du point en haut à gauche du rectangle
     */
    public Rectangle(double x, double y, double l1, double l2) {
        super(
            "Rec"+ compteur,
            new Segment[]{
                new Segment(new Point(x, y), new Point(x + l1, y)),
                new Segment(new Point(x + l1, y), new Point(x + l1, y + l2)),
                new Segment(new Point(x + l1, y + l2), new Point(x, y + l2)),
                new Segment(new Point(x, y + l2), new Point(x, y))
            }
        );
        this.setNom("Rec" + Rectangle.compteur);
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
     * @param x: abscisse du point en haut à gauche du rectangle
     * @param y: abscisse du point en haut à gauche du rectangle
     * @param couleur: couleur du rectangle
     */
    public Rectangle(double x, double y, double l1, double l2, Color couleur) {
        super("Rec"+ compteur,
            new Segment[]{
            new Segment(new Point(x, y), new Point(x + l1, y)), // 1er cote horizontal
            new Segment(new Point(x + l1, y), new Point(x + l1, y + l2)), // 1er cote vertical
            new Segment(new Point(x + l1, y + l2), new Point(x, y + l2)), // 2er cote horizontal
            new Segment(new Point(x, y + l2), new Point(x, y)) // 2er cote vertical
        }, couleur);
        this.setNom("Rec" + Rectangle.compteur);
        
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
     * @param dx: nombre de pixels
     * @param pivot: segment pivot qui reste fixe
     * @description: modifie la longueur du rectangle
     */
    public void setCotes(double dx, int pivot) {

        if (pivot > 3 || pivot < 0) {
            return;
        }
        //si pivot = 0 on translate 2 de dx
        if (pivot == 0) {
            this.cotes[2].getPoint1().setX(
                this.cotes[2].getPoint1().getX() + dx
            );
            this.cotes[2].getPoint2().setX(
                this.cotes[2].getPoint2().getX() + dx
            );

        } else {
            this.cotes[pivot % 2].getPoint1().setX(this.cotes[pivot % 2].getPoint1().getX() + dx);
            this.cotes[pivot % 2].getPoint2().setX(this.cotes[pivot % 2].getPoint2().getX() + dx);
        }
    }


    /**
     * @Return: retourne l'aire du rectangle
     */
    public double aire() {
        return this.getLongueur() * this.getLargeur();
    }

    /**
     * Affiche les coordonnées des points du rectangle
     * @return les coordonnées des points du rectangle en format texte
     */
    @Override
    public String afficher() {
        String str = "Rectangle " + this.getNom() + " - Longueur: " + this.getLongueur() + " - Largeur: " + this.getLargeur() + " - Couleur: " + this.getCouleur();
        for (Segment cote : cotes) {
            str += "\n" + cote.afficher();
        }
        return str;
    }

}
