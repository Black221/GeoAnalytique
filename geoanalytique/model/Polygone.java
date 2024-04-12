package geoanalytique.model;

import java.awt.Color;
import javax.swing.JPanel;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;


/**
 * Classe Polygone
 */
public abstract class Polygone extends Surface {

    public Segment cotes[];

    /**
     * Constructeur de la classe Polygone
     * @param nom
     * @param cotes
     */
    public Polygone(String nom, Segment cotes[]) {
        super(nom);
        this.cotes = cotes;
        this.fusionner();
    }

    /**
     * Constructeur de la classe Polygone
     * @param nom
     * @param cotes
     * @param couleur
     */
    public Polygone(String nom, Segment cotes[], Color couleur) {
        super(nom, couleur);
        this.cotes = cotes;
        for (int i = 0; i < cotes.length; i++) {
            cotes[i].setCouleur(couleur);
        }
        this.fusionner();
    }

    public Segment[] getCotes() {
        return cotes;
    }

    public Point[] getSommets() {
        Point[] sommets = new Point[this.cotes.length];
        for (int i = 0; i < this.cotes.length; i++) {
            sommets[i] = this.cotes[i].getPoint1();
        }
        return sommets;
    }
    /**
     * Methode pour fusionner les points des cotes du polygone
     */
    protected void fusionner() {
        for (int i = 0; i < this.cotes.length - 1; i++) {
            this.cotes[i].setPoint2(
                this.cotes[i + 1].getPoint1()
            );
        }
    }

    /**
     * @return: retourne le perimetre du polygone
     */
    public double perimetre() {
        double perimetre = 0;
        for (Segment cote : cotes) {
            perimetre += cote.longueur();
        }
        return perimetre;
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
