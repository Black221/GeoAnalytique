package geoanalytique.exception;
/**
 * Classe pour représenter une exception lors d'une opération incorrecte sur un visiteur
 */
public class VisiteurException extends Exception{
   /**
    * Constructeur de l'exception VisiteurException avec un message d'erreur donné en paramètre 
    * @param message    message d'erreur
    */
    public VisiteurException(String message){
        super(message);
    }
    /**
     * Constructeur de l'exception VisiteurException avec un message d'erreur et une cause donnée en paramètre
     * @param message message d'erreur
     * @param cause cause de l'erreur
     */
    public VisiteurException(String message, Throwable cause){
        super(message, cause);
    }
    /**
     * Constructeur de l'exception VisiteurException avec une cause donnée en paramètre
     * @param cause     cause de l'erreur
     */
    public VisiteurException(Throwable cause){
        super(cause);
    }
}
