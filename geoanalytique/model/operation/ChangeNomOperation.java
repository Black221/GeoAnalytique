package geoanalytique.model.operation;

import geoanalytique.model.GeoObject;

/**
 * Cette classe permet de changer le nom d'un objet
 */
public class ChangeNomOperation extends Operation {
    
    private GeoObject [] arguments;
    /**
     * Constructeur
     */
    public ChangeNomOperation() {
        super();
    }

    /**
     * Permet d'associer un titre a l'operation courante
     * @return Renvoie le titre de l'operation
     */
    public String getTitle() {
        return "Changer le nom";
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
        if (numero == 0) {
            if (obj instanceof String) {
                this.arguments.add(obj);
            } else {
                throw new IncorrectTypeOperationException("Le type de l'argument est incorrect");
            }
        } else {
            throw new ArgumentOperationException("Il n'y a qu'un seul argument pour cette opération");
        }
    }

    /**
     * Cette fonction permet de connaitre la classe demandee pour l'argument numero.
     * @param numero: numero de l'argument défini dans le type
     * @return Renvoie la classe de l'argument numero
     */
    public Class<?> getClassArgument(int numero) {
        return String.class;
    }

    /**
     * Cette fonction est lancee une fois lorsque tous les arguments ont ete defini.
     * @return Renvoie l'objet résultant du calcul de l'opération
     */
    public Object calculer() {
        return this.arguments.get(0);
    }
}
