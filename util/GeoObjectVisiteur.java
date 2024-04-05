package util;

import exception.VisiteurException;
import model.Droite;
import model.Ellipse;
import model.Point;
import model.Polygone;
import model.Segment;

public interface GeoObjectVisiteur<T> {
    public T visitPoint(Point p) throws VisiteurException;
	public T visitSegment(Segment s) throws VisiteurException;
	public T visitDroite(Droite d) throws VisiteurException;
	public T visitEllipse(Ellipse e) throws VisiteurException;
	public T visitPolygone(Polygone p) throws VisiteurException;
}