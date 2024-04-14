package geoanalytique.model;

import java.awt.Color;
import javax.swing.JPanel;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;
import geoanalytique.exception.VisiteurException;
/**
 * Classe Point
 */
public class Point extends GeoObject{
    
    private static int compteur = 0;
    private double x = 0;
    private double y = 0;

    /**
     * Constructeur de la classe Point
     * @param x abscisse du point
     * @param y ordonnée du point
     */
    public Point (double x, double y) {
        super("P"+ Point.compteur);
        this.x = x;
        this.y = y;
        Point.compteur++;
    }

    /**
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

    /**
     * Methode pour recuperer l'abscisse du point
     * @return l'abscisse du point
     */
    public double getX() {
        return x;
    }

    /**
     * Methode pour recuperer l'ordonnée du point
     * @return l'ordonnée du point
     */
    public double getY() {
        return y;
    }

    /**
     * Methode pour modifier l'abscisse du point
     * @param x la nouvelle abscisse du point
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Methode pour modifier l'ordonnée du point
     * @param y la nouvelle ordonnée du point
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Permet au visiteur de connaiter la classe
     * @param v visiteur
     * @return JPanel
     */
    @Override
    public Graphique accept(GeoObjectVisiteur<Graphique> v) throws VisiteurException {
        return v.visit(this);
    }

    /**
     * Permet au visiteur de connaitre la classe
     * @param v visiteur
     * @return JPanel
     */
    @Override
    public JPanel acceptJPanel(GeoObjectVisiteur<JPanel> v) throws VisiteurException {
        return v.visit(this);
    }

}
