package geoanalytique.view;

import geoanalytique.model.GeoObject;

import java.awt.Color;

import geoanalytique.model.*;

public class Usine {
    
    public Usine() {}

    public GeoObject produire(Point p1, Point p2, String type, int couleur) {
        GeoObject obj = null;
        Color color = new Color(couleur);
        System.out.println(color);

        double l1 = p2.getX() - p1.getX();
        double l2 = p2.getY() - p1.getY();
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
                    p3,
                    Math.max(Math.abs(l1), Math.abs(l2))
                );
                break;
            case "ELLIPSE":
                obj = new Ellipse(
                    new Point(
                        (p1.getX() + p2.getX()) / 2,
                        (p1.getY() + p2.getY()) / 2
                    ),
                    Math.abs(l1) / 2,
                    Math.abs(l2) / 2
                );
                break;
            case "CERCLE":
                obj = new Cercle(
                    new Point(
                        (p1.getX() + p2.getX()) / 2,
                        (p1.getY() + p2.getY()) / 2
                    ),
                    Math.max(Math.abs(l1), Math.abs(l2)) / 2
                );
                break;
            case "TRIANGLE":
                obj = new Triangle(
                    p1,
                    new Point(p1.getX(), p2.getY()),
                    p2
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
        obj.setCouleur(color);
        return obj;
    }

}
