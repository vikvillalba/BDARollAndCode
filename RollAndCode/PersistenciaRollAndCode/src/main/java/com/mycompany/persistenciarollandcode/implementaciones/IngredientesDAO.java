package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 * Implementación de los métodos de la interfaz IIngredientesDAO
 * @author victoria
 */
public class IngredientesDAO implements IIngredientesDAO{

    @Override
    public Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nuevoIngrediente.getNombre());
        ingrediente.setUnidadMedida(nuevoIngrediente.getUnidadMedida());
        ingrediente.setCantidadStock(nuevoIngrediente.getCantidadStock());
        
        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();
        return ingrediente;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesExistentes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        String jpqlQuery = """
                           SELECT new com.mycompany.dominiorollandcode.dtos.IngredienteDTO
                           (I.id, I.nombre, I.unidadMedida, I.cantidadStock)
                           FROM Ingrediente I
                           """;
        
        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpqlQuery, IngredienteDTO.class);
        return query.getResultList();
    }

    @Override
    public IngredienteDTO actualizarStock(IngredienteDTO ingredienteActualizar) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        IngredienteDTO ingredienteActualizado = null;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Ingrediente> update = cb.createCriteriaUpdate(Ingrediente.class);
        Root<Ingrediente> rootIngrediente = update.from(Ingrediente.class);

        update.set(rootIngrediente.get("cantidadStock"), ingredienteActualizar.getCantidadStock()).
                where(cb.equal(rootIngrediente.get("nombre"), ingredienteActualizar.getNombre()));

        Query query = entityManager.createQuery(update);
        int filasActualizadas = query.executeUpdate();
        entityManager.getTransaction().commit();
        
        if(filasActualizadas > 0){
            ingredienteActualizado = new IngredienteDTO(
                    ingredienteActualizar.getId(), 
                    ingredienteActualizar.getNombre(),
                    ingredienteActualizar.getUnidadMedida(), 
                    ingredienteActualizar.getCantidadStock()
                );
        } else {
            throw new PersistenciaException("No se encontró el ingrediente con el nombre: " + ingredienteActualizar.getNombre());
        }
        
        return ingredienteActualizado;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesFiltradosNombre(String filtro) throws PersistenciaException{
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT new com.mycompany.dominiorollandcode.dtos.IngredienteDTO "
                + "(I.id, I.nombre, I.unidadMedida, I.cantidadStock) "
                + "FROM Ingrediente I "
                + "WHERE I.nombre LIKE :filtro";

        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpqlQuery, IngredienteDTO.class);
        query.setParameter("filtro", "%" + filtro + "%");  

        List<IngredienteDTO> ingredientes = query.getResultList();
        if(ingredientes.isEmpty()){
            throw new PersistenciaException("No se encontraron resultados.");
        }
        return ingredientes;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesFiltradosUnidadMedida(String filtro) throws PersistenciaException{
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT new com.mycompany.dominiorollandcode.dtos.IngredienteDTO "
                + "(I.id, I.nombre, I.unidadMedida, I.cantidadStock) "
                + "FROM Ingrediente I "
                + "WHERE I.unidadMedida LIKE :filtro";

        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpqlQuery, IngredienteDTO.class);
        query.setParameter("filtro", "%" + filtro + "%");
        List<IngredienteDTO> ingredientes = query.getResultList();
        if(ingredientes.isEmpty()){
            throw new PersistenciaException("No se encontraron resultados.");
        }
        return ingredientes;
    }

    @Override
    public IngredienteDTO obtenerIngrediente(String nombre, String unidadMedida) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT new com.mycompany.dominiorollandcode.dtos.IngredienteDTO "
                + "(I.id, I.nombre, I.unidadMedida, I.cantidadStock) "
                + "FROM Ingrediente I "
                + "WHERE UPPER(I.unidadMedida) LIKE :unidadMedida "
                + "AND I.nombre LIKE :nombre";

        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpqlQuery, IngredienteDTO.class);
        query.setParameter("unidadMedida", "%" + unidadMedida + "%");
        query.setParameter("nombre", "%" + nombre + "%");
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
    }
}
