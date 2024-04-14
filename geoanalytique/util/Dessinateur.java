package geoanalytique.util;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.*;
import geoanalytique.model.*;

public class Dessinateur implements GeoObjectVisiteur<Graphique> {
    
    private Viewport viewport;

    /**
     * Constructeur
     * @param v viewport
     */
    public Dessinateur(Viewport v) {
        this.viewport = v;
    }

    /**
     * Permet de convertir un point en GCoordonnee
     * @param p Point
     */
    public Graphique visit(Point p) throws VisiteurException {
        return this.viewport.convert(p);
    }

    /**
     * Permet de convertir un segment en GLigne
     * @param s Segment
     */
    public Graphique visit(Segment s) throws VisiteurException {
        GLigne gligne = new GLigne(
            this.viewport.convert(s.getPoint1()), // converti en GCoordonee
            this.viewport.convert(s.getPoint2()) // converti en GCoordonee
        );
        gligne.setCouleur(s.getCouleur());
        return gligne;
    }

    /**
     * Permet de convertir une droite en GLigne
     * @param d Droite
     */
    public Graphique visit(Droite d) throws VisiteurException {

        // y = ax + b
        Point p1 = new Point(
            this.viewport.getXMin(),
            d.getY(this.viewport.getXMin())
        );

        Point p2 = new Point(
            this.viewport.getXMax(),
            d.getY(this.viewport.getXMax())
        );

        GLigne gligne = new GLigne(
            this.viewport.convert(p1),
            this.viewport.convert(p2)
        );
        gligne.setCouleur(d.getCouleur());
        return gligne;
    }

    /**
     * Permet de convertir un ellipse en GOval
     * @param e Ellipse
     */
    public Graphique visit(Ellipse e) throws VisiteurException {
        GCoordonnee centre = this.viewport.convert(e.getCentre());

        double demiGrandAxe = this.viewport.normalizer(e.getDemiGrandAxe());
        double demiPetitAxe = this.viewport.normalizer(e.getDemiPetitAxe());

        GOval goval = new GOval(centre, demiGrandAxe, demiPetitAxe);
        goval.setCouleur(e.getCouleur());
        return goval;
    }

    /**
     * Permet de convertir un Polygone en GPolygone
     * @param p Polygone
     */
    public Graphique visit(Polygone p) throws VisiteurException {
        Point [] sommets = p.getSommets();

        GLigne [] lignes = new GLigne[p.getCotes().length];
        for (int i = 0; i < p.getCotes().length; i++) {
            lignes[i] = new GLigne(
                viewport.convert(sommets[i]), 
                viewport.convert(sommets[(i + 1) % p.getCotes().length])
            );
            lignes[i].setCouleur(p.getCouleur());
        }
        return new GPolygone(lignes);
    }
}
