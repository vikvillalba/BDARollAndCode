
package com.mycompany.persistenciarollandcode.excepciones;

/**
 * Excepciones para operaciones de persistencia.
 * @author victoria
 */
public class PersistenciaException extends Exception{

    public PersistenciaException() {
    }

    public PersistenciaException(String message) {
        super(message);
    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
