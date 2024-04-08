package geoanalytique.model;


import java.awt.Color;
public abstract class Surface extends GeoObject {
    
    public Surface(String nom, Color couleur) {
        super(nom, couleur);
    }

    public Surface(String nom) {
        super(nom);
    }
    
    public abstract double perimetre();
    public abstract double aire();
}