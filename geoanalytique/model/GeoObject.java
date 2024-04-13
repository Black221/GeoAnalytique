package geoanalytique.model;

import java.awt.Color;
import javax.swing.JPanel;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;
import geoanalytique.exception.VisiteurException;
/**
 * Represents a geometric object.
 */
public abstract class GeoObject {

    String nom;
    Color couleur;
    boolean estSelectionne = false;

    /**
     * Constructeur de la classe GeoObject
     * @param nom nom de la classe
     * @param couleur couleur de l'objet
     */
    public GeoObject(String nom, Color couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Constructeur de la classe GeoObject
     * @param nom nom de la classe
     */
    public GeoObject(String nom) {
        this(nom, Color.BLACK);
    }

    /**
     * Methode pour recuperer le nom de l'objet
     * @return le nom de l'objet
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode pour recuperer la couleur de l'objet
     * @return la couleur de l'objet
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Methode pour modifier le nom de l'objet
     * @param nom le nouveau nom de l'objet
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Methode pour modifier la couleur de l'objet
     * @param couleur la nouvelle couleur de l'objet
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * Methode pour savoir si l'objet est selectionne
     * @return true si l'objet est selectionne, false sinon
     */
    public boolean estSelectionne() {
        return estSelectionne;
    }

    /**
     * Methode pour modifier l'etat de selection de l'objet
     * @param estSelectionne true si l'objet est selectionne, false sinon
     */
    public void setEstSelectionne(boolean estSelectionne) {
        this.estSelectionne = estSelectionne;
    }

    public abstract Graphique accept(GeoObjectVisiteur<Graphique> v) throws VisiteurException;
    public abstract JPanel acceptJPanel(GeoObjectVisiteur<JPanel> v) throws VisiteurException;
}