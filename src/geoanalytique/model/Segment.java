package geoanalytique.model;

import java.awt.Color;
import javax.swing.JPanel;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;

/**
 * Classe Segment
 */
public class Segment extends  Droite{
    
    private static int compteur = 0;

    /**
     * Constructeur de la classe Segment
     * @param p1 premier point du segment
     * @param p2 deuxième point du segment
     */
    public Segment (Point p1, Point p2) {
        super(p1, p2);
        this.setNom("S" + Segment.compteur);
        Segment.compteur++;
    }

    /**
     * Constructeur de la classe Segment
     * @param p1 premier point du segment
     * @param p2 deuxième point du segment
     * @param couleur couleur du segment
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

    /**
     * Retourne la longueur du segment
     * @return la longueur du segment avec deux points
     */
    public double longueur() {
        return Math.sqrt(
            Math.pow(this.getPoint2().getX() - this.getPoint1().getX(), 2) 
            + 
            Math.pow(this.getPoint2().getY() - this.getPoint1().getY(), 2)
        );
    }

    /**
     * Retourne le milieu du segment
     * @return le milieu du segment
     */
    public Point getMilieu() {
        return new Point(
            (this.getPoint1().getX() + this.getPoint2().getX()) / 2, 
            (this.getPoint1().getY() + this.getPoint2().getY()) / 2
        );
    }

    @Override
    public Graphique accept(GeoObjectVisiteur<Graphique> v) throws VisiteurException {
        return v.visit(this);
    }

    @Override
    public JPanel acceptJPanel(GeoObjectVisiteur<JPanel> v) throws VisiteurException {
        return v.visit(this);
    }
}
