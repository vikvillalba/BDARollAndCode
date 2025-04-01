package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import javax.persistence.EntityManager;

/**
 *
 * @author victoria
 */
public class MesasDAO implements IMesasDAO{

    @Override
    public Mesa registrar(NuevaMesaDTO nuevaMesa) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Mesa mesa = new Mesa();
        mesa.setNumero(nuevaMesa.getNumero());
        
        entityManager.persist(mesa);
        entityManager.getTransaction().commit();
        
        return mesa; 
    }
    
}
