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
        super("P");
        this.x = x;
        this.y = y;
        this.setNom("P-" + Point.compteur);
        Point.compteur++;
    }

    /*
     * Constructeur de la classe Point
     * @param x: abscisse du point
     * @param y: ordonnée du point
     * @param couleur: couleur du point
     */
    public Point (double x, double y, Color couleur) {
        super("P", couleur);
        this.x = x;
        this.y = y;
        this.setnom("P-" + Point.compteur);
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

    /*
     * Constructeur de la classe
     * @param coordonnee: coordonnées de type GCoordonnee
     * 
     * @description: Déplace le point aux coordonnées spécifiées
     */
    // @Override
    // public void deplacer (GCoordonnee coordonnee) {
    //     this.x = coordonnee.getX();
    //     this.y = coordonnee.getY();
    // }

    /*
     * @description: Affiche les coordonnées du point
     * @return: les coordonnées du point en format texte
     */
    @Override
    public String afficher () {
        return ("[Point " + this.getNom() + " : (" + this.x + "|" + this.y + ")]");
    }
}
