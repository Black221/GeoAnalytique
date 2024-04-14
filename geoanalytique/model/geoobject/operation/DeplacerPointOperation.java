package geoanalytique.model.geoobject.operation;

import geoanalytique.util.Operation;
import geoanalytique.exception.*;
import geoanalytique.model.*;

public class DeplacerPointOperation implements Operation{
    
    private Point nouveaupoint;

    /**
     * Permet d'associer un titre a l'operation courante
     * @return Renvoie le titre de l'operation
     */
    public String getTitle() {
        return "Déplacer Point";
    } 
    
    /**
     * Renvoie le nombre d'argument possible pour l'opération en cours
     * @return Renvoie le nombre d'argument possible pour l'opération en cours
     */
    public int getArite() {
        return 1;
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
            if(numero == 0){
                this.nouveaupoint = (Point) obj;
            }else{
                throw new ArgumentOperationException("Numéro argument invalide");
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
    public Class<?> getClassArgument(int numero) throws ArgumentOperationException{
        if(numero == 0){
            return nouveaupoint.getClass();
        }else{
            throw new ArgumentOperationException("Numéro argument invalide");
        }
    }

    /**
     * Cette fonction est lancee une fois lorsque tous les arguments ont ete defini.
     * @return Renvoie l'objet résultant du calcul de l'opération
     */
    public Object calculer() {
        return this.nouveaupoint;
    }

    /**
     * Donne la description
     */
    public String getDescriptionArgument(int numero) throws ArgumentOperationException {
        if(numero == 0){
            return "Nouveau point";
        }else{
            throw new ArgumentOperationException("Numéro argument invalide");
        }
    }
}
