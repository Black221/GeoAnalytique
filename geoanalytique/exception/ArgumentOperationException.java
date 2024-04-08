package geoanalytique.exception;
/**
 * Classe pour représenter une exception lors d'une opération incorrecte sur un argument
 */
public class ArgumentOperationException extends Exception {
    /**
     * Constructeur de l'exception ArgumentOperationException avec un message d'erreur donné en paramètre 
     * @param message
     */
    public ArgumentOperationException(String message){
        super(message);
    }
    /**
     * Constructeur de l'exception ArgumentOperationException avec un message d'erreur et une cause donnée en paramètre
     * @param message
     * @param cause
     */
    public ArgumentOperationException(String message, Throwable cause){
        super(message, cause);
    }
    /**
     * Constructeur de l'exception ArgumentOperationException avec une cause donnée en paramètre
     * @param cause
     */
    public ArgumentOperationException(Throwable cause){
        super(cause);
    }
}
