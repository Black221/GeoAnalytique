package geoanalytique.model;

import java.awt.Color;

public class Segment extends  Droite{
    
    private static int compteur = 0;

    /**
     * Constructeur de la classe Segment
     * @param p1: premier point du segment
     * @param p2: deuxième point du segment
     * 
     * @description: Crée un segment avec deux points
     */
    public Segment (Point p1, Point p2) {
        super(p1, p2);
        this.setNom("S" + Segment.compteur);
        Segment.compteur++;
    }

    /*
     * Constructeur de la classe Segment
     * @param p1: premier point du segment
     * @param p2: deuxième point du segment
     * @param couleur: couleur du segment
     * 
     * @description: Crée un segment avec deux points et une couleur
     */
    public Segment (Point p1, Point p2, Color couleur) {
        super(p1, p2, couleur);
        this.setNom("S" + Segment.compteur);

        this.getPoint1().setCouleur(couleur);
        this.getPoint2().setCouleur(couleur);
        Segment.compteur++;
    }

    /**
     * Change la couleur du segment
     * @param couleur 
     */
    public void setCouleur(Color couleur) {
        super.setCouleur(couleur);
        this.getPoint1().setCouleur(couleur);
        this.getPoint2().setCouleur(couleur);
    }

    /*
     * @return: la longueur du segment avec deux points
     */
    public double longueur() {
        return Math.sqrt(
            Math.pow(super.getPoint2().getX() - super.getPoint1().getX(), 2) 
            + 
            Math.pow(super.getPoint2().getY() - super.getPoint1().getY(), 2)
        );
    }

    /*
     * @return: le milieu du segment
     */
    public Point getMilieu() {
        return new Point(
            (super.getPoint1().getX() + super.getPoint2().getX()) / 2, 
            (super.getPoint1().getY() + super.getPoint2().getY()) / 2
        );
    }

    /*
     * @description: Affiche les coordonnées des points du segment
     * @return: les coordonnées des points du segment en format texte
     */
    @Override
    public String afficher() {
        return "- Segment " + this.getNom() + " : \n" + this.getPoint1().afficher() + "\n" + this.getPoint2().afficher();
    }
}
