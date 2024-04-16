package geoanalytique.util;

import geoanalytique.exception.*;
import geoanalytique.model.*;

/**
 * Visiteur pour les objets géométriques
 */
public interface GeoObjectVisiteur<T> {

    public T visit(Point p) throws VisiteurException; // Visite un point
	public T visit(Segment s) throws VisiteurException; // Visite un segment
	public T visit(Droite d) throws VisiteurException; // Visite un droite
	public T visit(Ellipse e) throws VisiteurException; // Visite un ellipse
	public T visit(Polygone p) throws VisiteurException; // Visite un polygon
}