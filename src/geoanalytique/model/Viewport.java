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

    private int echelle;
    /**
     * Constructeur
     * @param largeur
     * @param hauteur
     */
    public Viewport(int largeur, int hauteur) {
        this.largeur = largeur; // largeur de la vue
        this.hauteur = hauteur; // hauteur de la vue
        this.xMax = largeur / 2; // xMax = largeur / 2
        this.yMax = hauteur / 2; // yMax = hauteur / 2
        this.xMin = -this.xMax; // xMin = -xMax
        this.yMin = -this.yMax; // yMin = -yMax
        this.echelle = 50; // echelle = 50
    }

    /**
     * Méthode pour normaliser une coordonnée réelle
     * @param a coordonnée réelle
     * @return coordonnée normalisée
     */
    public int normalizer(double a) {
        return (int) (a * this.echelle);
    }

    
    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param x coordonnée réelle
     * @return coordonnée graphique
     */
    public int convertX (double x) {
        return (int) (x * this.echelle + this.xMax);
    }

    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param y coordonnée réelle
     * @return coordonnée graphique
     */
    public int convertY (double y) {
        return (int) (this.yMax - y * this.echelle);
    }

    /**
     * Méthode pour convertir une coordonnée réelle en coordonnée graphique
     * @param point coordonnée réelle
     * @return coordonnée graphique
     */
    public GCoordonnee convert (Point point) {
        double x = (point.getX() * this.echelle + this.xMax);
        double y = (this.yMax - point.getY() * this.echelle);
        GCoordonnee g = new GCoordonnee(x, y);
        g.setCouleur(point.getCouleur());
        return g;
    }

    /**
     * Méthode pour convertir une coordonnée graphique en coordonnée réelle
     * @param coordonnee coordonnée graphique
     * @return coordonnée réelle
     */
    public Point convert (GCoordonnee coordonnee) {
        // x = (x - xMax) / echelle
        double x = (coordonnee.getX() - this.xMax) / this.echelle;
        double y = (this.yMax - coordonnee.getY()) / this.echelle;
        return new Point(x, y);
    }

    /**
     * Méthode pour convertir un tableau de coordonnées réelles en tableau de coordonnées graphiques
     * @param sommets tableau de coordonnées graphiques
     * @return tableau de coordonnées réelles
     */
    public Point [] convert (GCoordonnee [] sommets) {
        Point [] points = new Point[sommets.length];
        // on convertit chaque sommet
        for (int i = 0; i < sommets.length; i++) {
            points[i] = this.convert(sommets[i]);
        }
        return points;
    }

    /**
     * Méthode pour convertir un tableau de coordonnées graphiques en tableau de coordonnées réelles
     * @param points tableau de coordonnées réelles
     * @return tableau de coordonnées graphiques
     */ 
    public GCoordonnee [] convert (Point [] points) {
        GCoordonnee [] sommets = new GCoordonnee[points.length];
        // on convertit chaque sommet
        for (int i = 0; i < points.length; i++) {
            sommets[i] = this.convert(points[i]);
        }
        return sommets;
    }


    /**
     * @return int largeur
     */
    public int getXMax() {
        return xMax;
    }

    /**
     * @return int hauteur
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
