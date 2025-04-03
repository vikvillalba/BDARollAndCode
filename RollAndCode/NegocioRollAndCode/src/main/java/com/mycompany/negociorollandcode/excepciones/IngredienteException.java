
package com.mycompany.negociorollandcode.excepciones;

/**
 * Excepción para validaciones relacionadas al  manejo de ingredientes.
 * @author victoria
 */
public class IngredienteException extends Exception {

    public IngredienteException() {
    }

    public IngredienteException(String message) {
        super(message);
    }

    public IngredienteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
