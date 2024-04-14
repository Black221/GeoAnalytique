package geoanalytique.model;

import java.awt.Color;

public class Triangle extends Polygone {
    
    private static int compteur = 0;

    /**
     * Constructeur de la classe Triangle
     * @param p1: premier point du triangle
     * @param p2: deuxième point du triangle
     * @param p3: troisième point du triangle
     */
    public Triangle (Point p1, Point p2, Point p3) {
        super("Tri"+ Triangle.compteur, // "Tri" pour "Triangle"
            new Segment[]{
            new Segment(p1, p2),
            new Segment(p2, p3),
            new Segment(p3, p1)
        });
        Triangle.compteur++;
    }

    /**
     * Constructeur de la classe Triangle
     * @param p1: premier point du triangle
     * @param p2: deuxième point du triangle
     * @param p3: troisième point du triangle
     * @param couleur: couleur du triangle
     */
    public Triangle (Point p1, Point p2, Point p3, Color couleur) {
        super("Tri"+ Triangle.compteur, // "Tri" pour "Triangle"
            new Segment[]{
            new Segment(p1, p2),
            new Segment(p2, p3),
            new Segment(p3, p1)
        }, couleur);
        Triangle.compteur++;
    }

    /**
     * @return: l'aire du triangle
     */
    @Override
    public double aire() {
        double p = this.perimetre() / 2;
        double aire = Math.sqrt(
            p * (p - cotes[0].longueur()) * (p - cotes[1].longueur()) * (p - cotes[2].longueur())
        );
        return aire;
    }
}
