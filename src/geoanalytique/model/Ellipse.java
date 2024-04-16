package geoanalytique.model;

import java.awt.Color;
import javax.swing.JPanel;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisiteur;

/**
 * Classe Ellipses
 */
public class Ellipse extends Surface {
        
    private static int compteur = 0;
    private double demiGrandAxe;
    private double demiPetitAxe;
    private Point centre;
    private Point pointAxes [] = new Point[2];
    
    /**
     * Constructeur de la classe Ellipse
     * @param demiGrandAxe: le demi grand axe de l'ellipse
     * @param demiPetitAxe: le demi petit axe de l'ellipse
     */
    public Ellipse(Point centre, double demiGrandAxe, double demiPetitAxe) {
        super("Ell" + compteur++);
        this.centre = centre;
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
        this.pointAxes[0] = new Point(centre.getX() + demiGrandAxe, centre.getY());
        this.pointAxes[1] = new Point(centre.getX(), centre.getY() + demiPetitAxe);
    }
    
    /**
     * Constructeur de la classe Ellipse
     * @param demiGrandAxe le demi grand axe de l'ellipse
     * @param demiPetitAxe le demi petit axe de l'ellipse
     * @param couleur la couleur de l'ellipse
     */
    public Ellipse(Point centre, double demiGrandAxe, double demiPetitAxe, Color couleur) {
        this(centre, demiGrandAxe, demiPetitAxe);
        this.couleur = couleur;
    }
    
    /**
     * @return: le demi grand axe de l'ellipse
     */
    public String toString() {
        return "Ellipse de demi grand axe " + demiGrandAxe + " et de demi petit axe " + demiPetitAxe;
    }

    /**
     * @return: le centre de l'ellipse
     */
    public Point getCentre() {
        return centre;
    }
    
    /**
     * @return: le demi grand axe de l'ellipse
     */
    public double getDemiGrandAxe() {
        return demiGrandAxe;
    }

    /**
     * @return: le demi petit axe de l'ellipse
     */
    public double getDemiPetitAxe() {
        return demiPetitAxe;
    }
    
    /**
     * Methode qui retourne l'aire de l'ellipse
     * @return l'aire de l'ellipse
     */
    @Override
    public double aire() {
        return Math.PI * this.getDemiGrandAxe() * this.getDemiPetitAxe();
    }

    /**
     * Methode qui le perimetre de l'ellipse
     * @return le perimetre de l'ellipse
     */
    @Override
    public double perimetre() {
        return 2 * Math.PI * Math.sqrt((Math.pow(demiGrandAxe, 2) + Math.pow(demiPetitAxe, 2)) / 2);
    }

    /**
     * Regarde si un point est dans l'ellipse
     * @param p: le point a verifier
     */
    public boolean contient(Point p) {
        return Math.pow(p.getX(), 2) / Math.pow(demiGrandAxe, 2) + Math.pow(p.getY(), 2) / Math.pow(demiPetitAxe, 2) <= 1;
    }

    /**
     * Permet au visiteur de connaiter la classe
     * @param v visiteur
     * @return graphique
     */
    @Override
    public Graphique accept(GeoObjectVisiteur<Graphique> v) throws VisiteurException {
        return v.visit(this);
    }

    /**
     * Permet au visiteur de connaitre la classe
     * @param v visiteur
     * @return pannel 
     */
    @Override
    public JPanel acceptJPanel(GeoObjectVisiteur<JPanel> v) throws VisiteurException {
        return v.visit(this);
    }
}
