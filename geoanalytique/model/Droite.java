package geoanalytique.model;

import java.awt.Color;

/**
 * Classe Droite
 */
public class Droite extends GeoObject{
    
    private static int compteur = 0;
    private Point [] points = new Point[2];

    /**
     * Constructeur de la classe Droite
     * @param p1: premier point de la droite
     * @param p2: deuxième point de la droite
     */
    public Droite (Point p1, Point p2) {
        super("D" + Droite.compteur);
        this.points[0] = p1;
        this.points[1] = p2;

        Droite.compteur++;
    }

    /**
     * Constructeur de la classe Droite
     * @param p1: premier point de la droite
     * @param p2: deuxième point de la droite
     * @param couleur: couleur de la droite
     */
    public Droite (Point p1, Point p2, Color couleur) {
        super("D" + Droite.compteur, couleur);
        this.points[0] = p1;
        this.points[1] = p2;

        Droite.compteur++;
    }

    /**
     * Methode pour recuperer premier point de la droite
     * @return le premier point de la droite
     */
    public Point getPoint1() {
        return points[0];
    }

    /**
     * Methode pour recuperer deuxième point de la droite
     * @return le deuxième point de la droite
     */
    public Point getPoint2() {
        return points[1];
    }

    /**
     * Methode pour recuperer calculer le coefficient directeur de la droite
     * @return: le coefficient directeur de la droite
     */
    public double getCoefficientDirecteur() {
        return 
        (points[1].getY() - points[0].getY()) / 
        (points[1].getX() - points[0].getX());
    }

    /**
     * Methode pour recuperer calculer l'ordonnée à l'origine de la droite
     * @return: l'ordonnée à l'origine de la droite
     * // y = ax + b => b = y - ax
     */
    public double getOrdonneeOrigine() {
        return points[0].getY() - (this.getCoefficientDirecteur() * points[0].getX());
    }

    /**
     * Methode pour afficher l'équation de la droite
     * @return: equation de la droite
     */
    public String getEquation() {
        return "y = " + this.getCoefficientDirecteur() + "x + " + this.getOrdonneeOrigine();
    }


    /**
     * Methode pour recuperer tous les points de la droite
     * @return: tous les points de la droite
     */
    public Point [] getPoints() {
        return points;
    }


    /**
     * Modifie le premier point de la droite
     * @param p1 le premier point de la droite
     */
    public void setPoint1(Point p1) {
        this.points[0] = p1;
    }

    /**
     * Modifie le deuxième point de la droite
     * @param p2 le deuxième point de la droite
     */
    public void setPoint2(Point p2) {
        this.points[1] = p2;
    }

    /**
     * Regarde si un point est sur la droite
     * @param p un point de la droite
     * @return vrai si le point est sur la droite, faux sinon
     */
    public boolean contient (Point p) {
        return (p.getY() == (this.getCoefficientDirecteur() * p.getX() + this.getOrdonneeOrigine()));
    }

    /**
     * 
     * @param s: le segment avec lequel on veut trouver l'intersection
     * @return le point d'intersection entre deux segments
     */
    public Point getIntersection(Droite d) {
        double a1 = this.getCoefficientDirecteur();
        double b1 = this.getOrdonneeOrigine();

        double a2 = d.getCoefficientDirecteur();
        double b2 = d.getOrdonneeOrigine();

        // y1 = a1 * x1 + b1 | y2 = a2 * x2 + b2
        // a1 * x + b1 = a2 * x + b2
        // x = (b2 - b1) / (a1 - a2)
        if (a1 == a2) { // droite parallèle
            return null;
        }
        double x = (b2 - b1) / (a1 - a2);
        double y = a1 * x + b1;

        return new Point(x, y);
    }

    /**
     * Methode pour afficher les coordonnées des points de la droite
     * @return: les coordonnées des points de la droite
     */
    @Override
    public String afficher () {
        return "- Droite " + this.getNom() + " : \n" + this.points[0].afficher() + "\n" + this.points[1].afficher();
    }
}
