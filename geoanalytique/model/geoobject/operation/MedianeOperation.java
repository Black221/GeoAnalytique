package geoanalytique.model.geoobject.operation;

import geoanalytique.util.Operation;
import geoanalytique.exception.*;
import geoanalytique.model.*;

/**
 * Cette classe permet de calculer la mediane de l'objet GeoAnalytique
 */
public class MedianeOperation implements Operation {

    private Point point1;
    private Point point2;
    /**
     * Constructeur
     */
    public MedianeOperation() {
        super();
    }

    /**
     * Permet d'associer un titre a l'operation courante
     * @return Renvoie le titre de l'operation
     */
    public String getTitle() {
        return "Calculer la médiane";
    }

    /**
     * Renvoie le nombre d'argument possible pour l'opération en cours
     * @return Renvoie le nombre d'argument possible pour l'opération en cours
     */
    public int getArite() {
        return 2;
    }

    /**
     * Permet d'affecter les arguments en fonction de leur position.
     * @param numero: numero d'argument devant etre modifie
     * @param obj: valeur passer en argument
     * @throws ArgumentOperationException 
     * @throws IncorrectTypeOperationException 
     */
    public void setArgument(int numero, Object obj) throws ArgumentOperationException, IncorrectTypeOperationException {
        if (obj instanceof Point) {
            if (numero == 0) {
                this.point1 = (Point) obj;
            }else if (numero == 1) {
                this.point2 = (Point) obj;
            }else{
                throw new ArgumentOperationException("Pas d'argument pour cette opération");
            }
        }else{
            throw new IncorrectTypeOperationException("Le type de l'argument est incorrect");
        }
    }

    /**
     * Cette fonction permet de connaitre la classe demandee pour l'argument numero.
     * @param numero: numero de l'argument défini dans le type
     * @return Renvoie la classe de l'argument numero
     */
    public Class<?> getClassArgument(int numero) throws ArgumentOperationException {
        if ((numero == 0) || (numero == 1)){
            return point1.getClass();
        }
        throw new ArgumentOperationException("Cet argument n'existe pas");
    }

    /**
     * Cette fonction est lancee une fois lorsque tous les arguments ont ete defini.
     * @return Renvoie l'objet résultant du calcul de l'opération
     */
    public Object calculer() {
        return new Point(
            (point1.getX() + point2.getX()) / 2,
            (point1.getY() + point2.getY()) / 2
        );
    }

    /**
     * Donne la desription
     * @return numero
     */
    public String getDescriptionArgument(int numero) throws ArgumentOperationException{
        if (numero == 0) {
            return "Premier point";
        }else if (numero == 1) {
            return "Deuxieme point";
        }else{
            throw new ArgumentOperationException("Pas d'argument pour cette opération");
        }
    }; 
}
