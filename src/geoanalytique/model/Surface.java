package geoanalytique.model;


import java.awt.Color;

/**
 * Classe Surface
 */
public abstract class Surface extends GeoObject {

    /**
     * Constructeur de la classe Surface
     * @param nom
     */
    public Surface(String nom) {
        super(nom);
    }

    /**
     * Constructeur de la classe Surface
     * @param nom
     * @param couleur
     */
    public Surface(String nom, Color couleur) {
        super(nom, couleur);
    }
    
    /**
     * Methode pour calculer le perimetre de la surface
     * @return
     */
    public abstract double perimetre();

    /**
     * Methode pour calculer l'aire de la surface
     * @return
     */
    public abstract double aire();
}
