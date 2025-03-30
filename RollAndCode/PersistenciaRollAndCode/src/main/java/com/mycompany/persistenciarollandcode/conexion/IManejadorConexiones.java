
package com.mycompany.persistenciarollandcode.conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author victoria
 */
public interface IManejadorConexiones {
    public abstract EntityManager crearConexion();
}
