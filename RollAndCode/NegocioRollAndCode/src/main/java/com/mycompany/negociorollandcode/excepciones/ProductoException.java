package com.mycompany.negociorollandcode.excepciones;

/**
 * Excepcion que se llama al realizar operaciones de negocio para productos.
 * @author victoria
 */
public class ProductoException extends Exception{

    public ProductoException() {
    }

    public ProductoException(String message) {
        super(message);
    }
    
}
