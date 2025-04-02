package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import javax.persistence.EntityManager;

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
    
}
