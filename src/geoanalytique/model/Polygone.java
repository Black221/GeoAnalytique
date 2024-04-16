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

    public Segment cotes[]; // Liste des cotes du polygone

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

    /**
     * Permet de connaitre la liste de cotes du polygone
     * @return: retourne la liste des cotes du polygone
     */
    public Segment[] getCotes() {
        return cotes;
    }

    /**
     * Permet de connaitre la liste des sommets du polygone
     * @return retourne la liste des sommets du polygone
     */
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
     * Permet de calculer le perimetre de l'objet
     * @return: retourne le perimetre du polygone
     */
    public double perimetre() {
        double perimetre = 0;
        for (Segment cote : cotes) {
            perimetre += cote.longueur();
        }
        return perimetre;
    }

    /**
     * Permet au visiteur de connaitre la classe
     * @param v visiteur
     * @return Graphique
     */
    @Override
    public Graphique accept(GeoObjectVisiteur<Graphique> v) throws VisiteurException {
        return v.visit(this);
    }

    /**
     * Permet au visiteur de connaitre la classe
     */
    @Override
    public JPanel acceptJPanel(GeoObjectVisiteur<JPanel> v) throws VisiteurException {
        return v.visit(this);
    }
}
