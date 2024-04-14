package geoanalytique.model;

import geoanalytique.graphique.GCoordonnee;

/**
 * Cette classe constitue un moyen pour convertir les coordonnées réelles du repère en coordonnées
 *  entières de la Vue, et vice versa
 */
public class Viewport {
    
    /**
     * variables d'instance
     */
    private int largeur;
    private int hauteur;
    private int xMax;
    private int yMax;
    private int xMin;
    private int yMin;

    private int dx;
    /**
     * Constructeur
     * @param largeur
     * @param hauteur
     */
    public Viewport(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.xMax = largeur / 2;
        this.yMax = hauteur / 2;
        this.xMin = -this.xMax;
        this.yMin = -this.yMax;
        this.dx = 50;
    }

    /**
     * Méthode pour normaliser une coordonnée réelle
     * @param a
     * @return
     */
    public int normalizer(double a) {
        return (int) (a * this.dx);
    }

    
    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param x
     * @return
     */
    public int convertX (double x) {
        return (int) (x * this.dx + this.xMax);
    }

    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param y
     * @return
     */
    public int convertY (double y) {
        return (int) (this.yMax - y * this.dx);
    }

    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param point
     * @return
     */
    public GCoordonnee convert (Point point) {
        double x = (point.getX() * this.dx + this.xMax);
        double y = (this.yMax - point.getY() * this.dx);
        GCoordonnee g = new GCoordonnee(x, y);
        g.setCouleur(point.getCouleur());
        return g;
    }

    /**
     * Méthode pour convertir une coordonnée graphique en coordonnée réelle
     * @param coordonnee
     * @return
     */
    public Point convert (GCoordonnee coordonnee) {
        double x = (coordonnee.getX() - this.xMax) / this.dx;
        double y = (this.yMax - coordonnee.getY()) / this.dx;
        return new Point(x, y);
    }

    /**
     * Méthode pour convertir un tableau de coordonnées réelles en tableau de coordonnées graphiques
     * @param sommets
     * @return
     */
    public Point [] convert (GCoordonnee [] sommets) {
        Point [] points = new Point[sommets.length];
        for (int i = 0; i < sommets.length; i++) {
            points[i] = this.convert(sommets[i]);
        }
        return points;
    }

    /**
     * Méthode pour convertir un tableau de coordonnées graphiques en tableau de coordonnées réelles
     * @param points
     * @return
     */ 
    public GCoordonnee [] convert (Point [] points) {
        GCoordonnee [] sommets = new GCoordonnee[points.length];
        for (int i = 0; i < points.length; i++) {
            sommets[i] = this.convert(points[i]);
        }
        return sommets;
    }


    /**
     * @return int xMax
     */
    public int getXMax() {
        return xMax;
    }

    /**
     * @return int yMax
     */
    public int getYMax() {
        return yMax;
    }

    /**
     * @return int xMin
     */
    public int getXMin() {
        return xMin;
    }

    /**
     * @return int yMin
     */
    public int getYMin() {
        return yMin;
    }

}
