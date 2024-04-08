package geoanalytique.model;

import java.awt.Color;

public abstract class Polygone extends Surface {

    public Segment cotes[];

    public Polygone(String nom, Segment cotes[]) {
        super(nom);
        this.cotes = cotes;
    }

    public Polygone(String nom, Segment cotes[], Color couleur) {
        super(nom, couleur);
        this.cotes = cotes;
        for (int i = 0; i < cotes.length; i++) {
            cotes[i].setCouleur(couleur);
        }
        this.fusionner();
    }

    public Polygone(Segment cotes[]) {
        this.cotes = cotes;
        this.fusionner();
    }

    /*
     * @description: fusionne les cotes du polygone pour avoir les memes references pour les points qui se resemble
     */
    protected void fusionner() {
        for (int i = 0; i < this.cotes.length - 1; i++) {
            this.cotes[i].setPoint2(this.cotes[i + 1].getPoint1());
        }
    }

    /*
     * @return: retourne le perimetre du polygone
     */
    public double perimetre() {
        double perimetre = 0;
        for (Segment cote : cotes) {
            perimetre += cote.longueur();
        }
        return perimetre;
    }
}
