package itson.presentacion.excepciones;

/**
 * Exepción para operaciones de presentación.
 * @author victoria
 */
public class PresentacionException extends Exception{

    public PresentacionException() {
    }

    public PresentacionException(String message) {
        super(message);
    }

    public PresentacionException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
