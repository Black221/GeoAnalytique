package geoanalytique.exception;
/**
 * Classe pour représenter une exception lors d'une opération incorrecte sur un type
 */
public class IncorrectTypeOperationException extends Exception{
    /**
     * Constructeur de l'exception IncorrectTypeOperationException avec un message d'erreur donné en paramètre 
     * @param message message d'erreur
     */
    public IncorrectTypeOperationException(String message){
        super(message);
    }
    /**
     * Constructeur de l'exception IncorrectTypeOperationException avec un message d'erreur et une cause donnée en paramètre
     * @param message message d'erreur
     * @param cause cause de l'erreur
     */
    public IncorrectTypeOperationException(String message, Throwable cause){
        super(message, cause);
    }
    /**
     * Constructeur de l'exception IncorrectTypeOperationException avec une cause donnée en paramètre
     * @param cause     cause de l'erreur   
     */
    public IncorrectTypeOperationException(Throwable cause){
        super(cause);
    }
}
    
