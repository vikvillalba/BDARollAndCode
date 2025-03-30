package com.mycompany.persistenciarollandcode.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victoria
 */
public class ManejadorConexiones implements IManejadorConexiones{

    private EntityManagerFactory entityManagerFactory;

    public ManejadorConexiones() {
        try {
            this.entityManagerFactory = Persistence.createEntityManagerFactory("RollAndCode");
        } catch (Exception e) {
            System.err.print("Error." + e.getMessage());
        }
        
    }
      
    @Override
    public EntityManager crearConexion() {
        if (entityManagerFactory == null) {
            throw new IllegalStateException("No está inicializado");
        }
        return entityManagerFactory.createEntityManager();
    }

    
}
