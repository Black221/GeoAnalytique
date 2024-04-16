
package geoanalytique.util;

import java.awt.Color;

public class EnumBoutons {

    /**
     * Class enumerer pour les outils
     */
    public enum Outils {
        DESSINER, SELECTIONNER, ZOOMAVANT, ZOOMARRIERE
    }

    /**
     * Class enumerer pour les figures
     */
    public enum Figures {
        POINT, SEGMENT, DROITE, TRIANGLE, CARRE, RECTANGLE, LOSANGE, CERCLE, ELLIPSE
    }

    /**
     * Class enumerer pour les types de boutons
     */
    public enum Couleurs {
        BLANC, NOIR, GRIS, MARRON, ROUGE, JAUNE, VERT, BLEU;

        /**
         * Retourne la couleur correspondante
         * @return
         */
        public Color getColor() {
            switch (this) {
                case BLANC:
                    return Color.WHITE;
                case NOIR:
                    return Color.BLACK;
                case GRIS:
                    return Color.GRAY;
                case MARRON:
                    return new Color(139, 69, 19);
                case ROUGE:
                    return Color.RED;
                case JAUNE:
                    return Color.YELLOW;
                case VERT:
                    return Color.GREEN;
                case BLEU:
                    return Color.BLUE;
                default:
                    return Color.BLACK;
            }
        }
    }
    
    /**
     * Constructeur de la classe EnumBoutons
     */
    public EnumBoutons() {
    }
}