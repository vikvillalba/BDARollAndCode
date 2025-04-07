
package com.mycompany.negociorollandcode.excepciones;

/**
 * Excepciones para operaciones de negocio relacionadas a las comandas
 * @author victoria
 */
public class ComandaException extends Exception{

    public ComandaException() {
    }

    public ComandaException(String message) {
        super(message);
    }
    
}
