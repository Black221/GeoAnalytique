package geoanalytique.util;

import java.awt.Color;

import geoanalytique.model.*;

/**
 * Cette classe permet de creer les objets geometriques suivant leur definition mathematique.
 */
public class Usine {
    
    public Usine() {}

    /**
     * Produit un objet geometrique a partir de deux points, d'un type et d'une couleur.
     * @param p1
     * @param p2
     * @param type
     * @param couleur
     * @return un objet geometrique
     */
    public GeoObject produire(Point p1, Point p2, String type, int couleur) {
        GeoObject obj = null;
        Color color = new Color(couleur);

        double l1 = p2.getX() - p1.getX(); // delta x -> entre les deux points
        double l2 = p2.getY() - p1.getY(); // delta y -> entre les deux points

        // Point en haut a gauche
        Point p3 = new Point(
            Math.min(p1.getX(), p2.getX()),
            Math.min(p1.getY(), p2.getY())
        );

        switch (type) {
            case "POINT":
                obj = new Point(p1.getX(), p1.getY());
                break;
            case "DROITE":
                obj = new Droite(p1, p2);
                break;
            case "SEGMENT":
                obj = new Segment(p1, p2);
                break;
            case "RECTANGLE":
                obj = new Rectangle(p1, l1, l2);
                break;
            case "CARRE":
                obj = new Carre(
                    p3, // point en haut a gauche
                    Math.max(Math.abs(l1), Math.abs(l2)) // cote = maximum entre l1 et l2
                );
                break;
            case "ELLIPSE":
                obj = new Ellipse(
                    // centre de l'ellipse
                    new Point(
                        (p1.getX() + p2.getX()) / 2, // moyenne des x
                        (p1.getY() + p2.getY()) / 2 // moyenne des y
                    ),
                    Math.abs(l1) / 2, // demi grand axe
                    Math.abs(l2) / 2 // demi petit axe
                );
                break;
            case "CERCLE":
                obj = new Cercle(
                    // centre du cercle
                    new Point(
                        (p1.getX() + p2.getX()) / 2, // moyenne des x
                        (p1.getY() + p2.getY()) / 2 // moyenne des y
                    ),
                    Math.max(Math.abs(l1), Math.abs(l2)) / 2 // rayon du cercle
                );
                break;
            case "TRIANGLE":
                obj = new Triangle(
                    p1, // point 1 du triangle
                    new Point(p1.getX() - l1, p2.getY()), // point 3 du triangle (x1 - l1, y2)
                    p2 // point 2 du triangle
                );
                break;
            case "LOSANGE":
                obj = new Losange(
                    new Point(
                        (p1.getX() + p2.getX()) / 2 - Math.abs(l1) / 2,
                        (p1.getY() + p2.getY()) / 2
                    ),
                    Math.abs(l1),
                    Math.abs(l2)
                );
                break;
            default:
                break;
        }
        obj.setCouleur(color); // on definit la couleur de l'objet
        return obj;
    }

}
