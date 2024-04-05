package util;

import exception.VisiteurException;
import graphique.Graphique;
import model.*;

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
