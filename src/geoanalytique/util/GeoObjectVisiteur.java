package geoanalytique.util;

import geoanalytique.exception.*;
import geoanalytique.model.*;

public interface GeoObjectVisiteur<T> {
    public T visit(Point p) throws VisiteurException;
	public T visit(Segment s) throws VisiteurException;
	public T visit(Droite d) throws VisiteurException;
	public T visit(Ellipse e) throws VisiteurException;
	public T visit(Polygone p) throws VisiteurException;
}