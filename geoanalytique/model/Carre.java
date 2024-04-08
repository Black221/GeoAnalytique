package geoanalytique.model;
import java.awt.Color;

public class Carre extends Rectangle{
    
    private static int compteur = 0;

    /**
     * Constructeur de la classe Carre
     * @param x: abscisse du point en haut à gauche du carre
     * @param y: abscisse du point en haut à gauche du carre
     * @param cote: longueur du cote du carre
     */
    public Carre(double x, double y, double cote) {
        super(x, y, cote, cote);
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
    public Carre(double x, double y, double cote, Color couleur) {
        super(x, y, cote, cote, couleur);
        this.setNom("Car" + Carre.compteur);
        Carre.compteur++;
    }

    /**
     * @return: la longueur du carre
     */
    public double getCote() {
        return super.getLongueur();
    }

    /**
     * Affiche les coordonnées des points du carre
     * @return: les coordonnées des points du carre en format texte
     */
    public String afficher() {
        String str = "Carre " + this.getNom() + " - Longueur: " + this.getLongueur() + " - Largeur: " + this.getLargeur() + " - Couleur: " + this.getCouleur();
        for (Segment cote : cotes) {
            str += "\n" + cote.afficher();
        }
        return str;
    }
}