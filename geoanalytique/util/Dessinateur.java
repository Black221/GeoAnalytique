package geoanalytique.util;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.*;
import geoanalytique.model.*;

public class Dessinateur implements GeoObjectVisiteur<Graphique>{
    
    private Viewport viewport;

    public Dessinateur(Viewport v) {
        this.viewport = v;
    }

    public Graphique visit(Point p) throws VisiteurException {
        return this.viewport.convert(p);
    }

    public Graphique visit(Segment s) throws VisiteurException {
        return new GLine(
            this.viewport.convert(s.getPoint1()),
            this.viewport.convert(s.getPoint2())
        );
    }

    public Graphique visit(Droite d) throws VisiteurException {
        Point p1 = new Point(
            this.viewport.getXMin(),
            d.getY(this.viewport.getXMin())
        );

        Point p2 = new Point(
            this.viewport.getXMax(),
            d.getY(this.viewport.getXMax())
        );

        return new GLine(
            this.viewport.convert(p1),
            this.viewport.convert(p2)
        );
    }

    public Graphique visit(Ellipse e) throws VisiteurException {
        GCoordonnee centre = this.viewport.convert(e.getCentre());
        double rayonX = this.viewport.convertX(e.getDemiGrandAxe());
        double rayonY = this.viewport.convertY(e.getDemiPetitAxe());

        return new GOval(centre, rayonX, rayonY);
    }

    public Graphique visit(Polygone p) throws VisiteurException {
        Point [] sommets = p.getSommets();

        GLine [] lignes = new GLine[p.getCotes().length];
        for (int i = 0; i < p.getCotes().length; i++) {
            lignes[i] = new GLine(
                viewport.convert(sommets[i]), 
                viewport.convert(sommets[(i + 1) % p.getCotes().length])
            );
            lignes[i].setCouleur(p.getCouleur());
        }
        return new GPolygone(lignes);
    }
}
