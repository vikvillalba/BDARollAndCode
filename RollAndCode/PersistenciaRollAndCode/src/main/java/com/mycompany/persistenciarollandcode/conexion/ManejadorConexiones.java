package com.mycompany.persistenciarollandcode.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victoria
 */
public class ManejadorConexiones implements IManejadorConexiones {

    @Override
    public static EntityManager getEntityManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("RollAndCode");

        EntityManager em = emFactory.createEntityManager();
        return em;
    }

}
