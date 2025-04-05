package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.MesaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    @Override
    public List<MesaDTO> obtenerMesas() {
       EntityManager entityManager = ManejadorConexiones.getEntityManager();
       String jpqlQuery = """
                          SELECT new com.mycompany.dominiorollandcode.dtos.MesaDTO (M.id, M.numero)
                          FROM Mesa M
                          """;
       
        TypedQuery<MesaDTO> query = entityManager.createQuery(jpqlQuery, MesaDTO.class);
        return query.getResultList();
    }

    @Override
    public MesaDTO obtenerMesa(Integer numero) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
       String jpqlQuery = """
                          SELECT new com.mycompany.dominiorollandcode.dtos.MesaDTO (M.id, M.numero)
                          FROM Mesa M
                          WHERE M.numero = :numero
                          """;
       
        TypedQuery<MesaDTO> query = entityManager.createQuery(jpqlQuery, MesaDTO.class);
        query.setParameter("numero", numero);
        return query.getSingleResult();
    }
    
}
