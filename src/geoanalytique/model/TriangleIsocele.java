package geoanalytique.model;

import java.awt.Color;

/**
 * Classe TriangleIsocele
 */
public class TriangleIsocele extends Triangle {
    
    private static int compteur = 0;

    /**
     * Constructeur
     * @param p1 premier point 
     * @param p2 deuxieme point
     * @param base la base
     */
    public TriangleIsocele (Point p1, Point p2, double base) {
        super(
            p1, p2,
            // on calcule le troisieme point
            new Point( // x = x1 + sqrt(b^2 - (x2 - x1)^2 / 4) | y = y1 + sqrt(b^2 - (x2 - x1)^2 / 4)
                p1.getX() + Math.sqrt(Math.pow(base, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2)),
                p1.getY() + Math.sqrt(Math.pow(base, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2))
            )
        );
        this.setNom("TI" + TriangleIsocele.compteur);
        TriangleIsocele.compteur++;
    }

    /**
     * Constructeur
     * @param p1 premier point
     * @param p2 deuxieme point 
     * @param base la base
     * @param couleur la couleur
     */
    public TriangleIsocele (Point p1, Point p2, double base, Color couleur) {
        super(
            p1, p2,
            new Point(
                p1.getX() + Math.sqrt(Math.pow(base, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2)),
                p1.getY() + Math.sqrt(Math.pow(base, 2) - Math.pow((p2.getX() - p1.getX()) / 2, 2))
            ),
            couleur
        );
        this.setNom("TI" + TriangleIsocele.compteur);
        TriangleIsocele.compteur++;
    }
}
