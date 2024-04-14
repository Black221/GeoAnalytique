package geoanalytique.util;

import geoanalytique.exception.ArgumentOperationException;
import geoanalytique.exception.IncorrectTypeOperationException;

/**
 * Interface de base a toutes les operations possibles pour un objet GeoAnalytique
 */
public interface Operation {
	
    /**
     * Permet d'associer un titre a l'operation courante
     * @return Renvoie le titre de l'operation
     */
    String getTitle();
	
   /**
    * Renvoie le nombre d'argument possible pour l'opération en cours
    * @return Renvoie le nombre d'argument possible pour l'opération en cours
    */
    int getArite();
    
    /**
     * Permet d'affecter les arguments en fonction de leur position.
     * @param numero: numero d'argument devant etre modifie
     * @param obj: valeur passer en argument
     * @throws ArgumentOperationException 
     * @throws IncorrectTypeOperationException 
     */
    void setArgument(int numero, Object obj) throws ArgumentOperationException, IncorrectTypeOperationException;
    
    /**
     * Cette fonction permet de connaitre la classe demandee pour l'argument numero.
     * @param numero: numero de l'argument défini dans le type
     * @return Renvoie la classe de l'argument numero
     */
    Class<?> getClassArgument(int numero) throws ArgumentOperationException;
    
    /**
     * Cette fonction est lancee une fois lorsque tous les arguments ont ete defini.
     * @return Renvoie l'objet résultant du calcul de l'opération
     */
    Object calculer();
    
    /**
     * Permet de donner à l'utilisateur la description complète pour l'argument numero
     * @param numero numero de l'argument concerne
     * @return Renvoie la description de l'argument specifie
     */
    String getDescriptionArgument(int num) throws ArgumentOperationException;
}