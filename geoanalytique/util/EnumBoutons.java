
package geoanalytique.util;

import java.awt.Color;

public class EnumBoutons {

    public enum Outils {
        DESSINER, SELECTIONNER, ZOOMAVANT, ZOOMARRIERE
    }

    public enum Figures {
        POINT, SEGMENT, DROITE, TRIANGLE, CARRE, RECTANGLE, LOSANGE, CERCLE, ELLIPSE
    }

    public enum Couleurs {
        BLANC, NOIR, GRIS, MARRON, ROUGE, JAUNE, VERT, BLEU;

        
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
    
    public EnumBoutons() {
    }

}