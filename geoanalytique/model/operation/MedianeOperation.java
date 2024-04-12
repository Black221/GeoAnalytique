package geoanalytique.model.operation;

/**
 * Cette classe permet de calculer la mediane de l'objet GeoAnalytique
 */
public class MedianeOperation extends Operation {

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
        return 0;
    }

    /**
     * Permet d'affecter les arguments en fonction de leur position.
     * @param numero: numero d'argument devant etre modifie
     * @param obj: valeur passer en argument
     * @throws ArgumentOperationException 
     * @throws IncorrectTypeOperationException 
     */
    public void setArgument(int numero, Object obj) throws ArgumentOperationException, IncorrectTypeOperationException {
        throw new ArgumentOperationException("Pas d'argument pour cette opération");
    }

    /**
     * Cette fonction permet de connaitre la classe demandee pour l'argument numero.
     * @param numero: numero de l'argument défini dans le type
     * @return Renvoie la classe de l'argument numero
     */
    public Class<?> getClassArgument(int numero) {
        return null;
    }

    /**
     * Cette fonction est lancee une fois lorsque tous les arguments ont ete defini.
     * @return Renvoie l'objet résultant du calcul de l'opération
     */
    public Object calculer() {
        return null;
    }
}
