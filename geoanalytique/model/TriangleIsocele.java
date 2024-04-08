package geoanalytique.model;

import java.awt.Color;

public class TriangleIsocele extends Triangle {
    
    private static int compteur = 0;
    private double base;
    private double cote;

    /*
     * Constructeur de la classe TriangleIsocele
     * @param base: base
     * @param cote: cote
     * @description: Crée un triangle isocèle avec trois points
     */
    public TriangleIsocele (Point p1, Point p2, double cote) {
        super(
            p1, p2,
            new Point(
                p1.getX() + Math.sqrt(Math.pow(cote, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2)),
                p1.getY() + Math.sqrt(Math.pow(cote, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2))
            )
        );
        this.setNom("TI" + TriangleIsocele.compteur);
        TriangleIsocele.compteur++;
    }

    /*
     * Constructeur de la classe TriangleIsocele
     * @param base: base
     * @param cote: cote
     * @param couleur: couleur du triangle
     * @description: Crée un triangle isocèle avec trois points et une couleur
     */
    public TriangleIsocele (Point p1, Point p2, double cote, Color couleur) {
        super(
            p1, p2,
            new Point(
                p1.getX() + Math.sqrt(Math.pow(cote, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2)),
                p1.getY() + Math.sqrt(Math.pow(cote, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2))
            ),
            couleur
        );
        this.setNom("TI" + TriangleIsocele.compteur);
        TriangleIsocele.compteur++;
    }
}
