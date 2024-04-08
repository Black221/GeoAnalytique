package geoanalytique.util;

import geoanalytique.exception.VisiteurException;
import geoanalytique.graphique.Graphique;
import geoanalytique.model.*;

public class Dessinateur implements GeoObjectVisiteur<Graphique>{
    public Graphique visitPoint(Point p) throws VisiteurException{
        return null;
    }

    public Graphique visitSegment(Segment p) throws VisiteurException{
        return null;
    }

    public Graphique visitDroite(Droite p) throws VisiteurException{
        return null;
    }

    public Graphique visitEllipse(Ellipse p) throws VisiteurException{
        return null;
    }

    public Graphique visitPolygone(Polygone p) throws VisiteurException{
        return null;
    }
}