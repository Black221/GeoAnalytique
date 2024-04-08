package geoanalytique.model;

import java.awt.Color;

/*
 * @Description: Represents a geometric object.
 */
public abstract class GeoObject {

    String nom;
    Color couleur;
    boolean estSelectionne = false;

    /**
     * Constructeur de la 
     * @param nom
     * @param couleur
     */
    public GeoObject(String nom, Color couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Constructeur de la classe GeoObject
     * @param nom
     */
    public GeoObject(String nom) {
        this(nom, Color.BLACK);
    }

    /**
     * Constructeur de la classe GeoObject
     * @param couleur
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @return
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @param couleur
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * 
     * @return
     */
    public boolean estSelectionne() {
        return estSelectionne;
    }

    /**
     * 
     * @param estSelectionne
     */
    public void setEstSelectionne(boolean estSelectionne) {
        this.estSelectionne = estSelectionne;
    }

    //public abstract void deplacer (GCoordonnee coordonnee);
    /**
     * 
     * @return
     */
    public abstract String afficher ();
}