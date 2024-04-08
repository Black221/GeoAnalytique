package geoanalytique.model;

import java.awt.Color;

public class Point extends GeoObject{
    
    private static int compteur = 0;
    private double x = 0;
    private double y = 0;

    /*
     * Constructeur de la classe Point
     * @param x: abscisse du point
     * @param y: ordonnée du point
     */
    public Point (double x, double y) {
        super("P"+ Point.compteur);
        this.x = x;
        this.y = y;
        Point.compteur++;
    }

    /*
     * Constructeur de la classe Point
     * @param x: abscisse du point
     * @param y: ordonnée du point
     * @param couleur: couleur du point
     */
    public Point (double x, double y, Color couleur) {
        super("P"+Point.compteur, couleur);
        this.x = x;
        this.y = y;
        Point.compteur++;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    /**
     * @return: les coordonnées du point en format texte
     */
    @Override
    public String afficher () {
        return ("[Point " + this.getNom() + " : (" + this.x + "|" + this.y + ")]");
    }
}
