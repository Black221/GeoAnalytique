package geoanalytique.model;
import java.awt.Color;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;

public class Carre extends Rectangle{
    
    private static int compteur = 0;

    /**
     * Constructeur de la classe Carre
     * @param x: abscisse du point en haut à gauche du carre
     * @param y: abscisse du point en haut à gauche du carre
     * @param cote: longueur du cote du carre
     */
    public Carre(Point p, double cote) {
        super(p, cote, cote);
        this.setNom("Car" + Carre.compteur);
        Carre.compteur++;
    }

    /**
     * Constructeur de la classe Carre
     * @param x: abscisse du point en haut à gauche du carre
     * @param y: abscisse du point en haut à gauche du carre
     * @param cote: longueur du cote du carre
     * @param couleur: couleur du carre
     */
    public Carre(Point p, double cote, Color couleur) {
        super(p, cote, cote, couleur);
        this.setNom("Car" + Carre.compteur);
        Carre.compteur++;
    }

    /**
     * @return: la longueur du carre
     */
    public double getCote() {
        return super.getLongueur();
    }
}
