package geoanalytique.model;

import java.awt.Color;

public class Triangle extends Polygone {
    
    private static int compteur = 0;

    /*
     * Constructeur de la classe Triangle
     * @param p1: premier point du triangle
     * @param p2: deuxième point du triangle
     * @param p3: troisième point du triangle
     * 
     * @description: Crée un triangle avec trois points
     */
    public Triangle (Point p1, Point p2, Point p3) {
        super(new Segment[]{
            new Segment(p1, p2),
            new Segment(p2, p3),
            new Segment(p3, p1)
        });
        this.setNom("T" + Triangle.compteur);
        Triangle.compteur++;
    }

    /*
     * Constructeur de la classe Triangle
     * @param p1: premier point du triangle
     * @param p2: deuxième point du triangle
     * @param p3: troisième point du triangle
     * @param couleur: couleur du triangle
     * 
     * @description: Crée un triangle avec trois points et une couleur
     */
    public Triangle (Point p1, Point p2, Point p3, Color couleur) {
        super(new Segment[]{
            new Segment(p1, p2),
            new Segment(p2, p3),
            new Segment(p3, p1)
        }, couleur);
        this.setNom("T" + Triangle.compteur);
        
        Triangle.compteur++;
    }

    /*
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

    /*
     * @description: Affiche les coordonnées des points du triangle
     * @return: les coordonnées des points du triangle en format texte
     */
    public String afficher() {
        String str = "Triangle " + this.getNom() + " - Couleur: " + this.getCouleur();
        for (Segment cote : cotes) {
            str += "\n" + cote.afficher();
        }
        return str;
    }

    /*
     * @description: modifie la longueur d'un cote du triangle
     * @param dx: nombre de pixels
     * @param pivot: segment pivot qui reste fixe
     */
    
}
