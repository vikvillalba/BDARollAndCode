package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.excepciones.IngredienteException;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author victoria
 */
public class IngredientesBO implements IIngredientesBO{
    private IIngredientesDAO ingredientesDAO;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }
    
    

    @Override
    public IngredienteDTO registrar(NuevoIngredienteDTO nuevoIngrediente) throws IngredienteException {
        if(nuevoIngrediente.getNombre() == "" || nuevoIngrediente.getNombre().isEmpty()){
            throw new IngredienteException("No se registró ningún nombre.");
            
        }
        if(nuevoIngrediente.getCantidadStock() < 0){
            throw new IngredienteException("El stock no puede ser negativo.");
        }
        // validar que el ingrediente no exista (mismo nombre y mismo tipo)
        // 
       IngredienteDTO ingredienteExistente = this.ingredientesDAO.obtenerIngrediente(nuevoIngrediente.getNombre(), nuevoIngrediente.getUnidadMedida().toString());
       if(ingredienteExistente != null){
           throw new IngredienteException("Ya existe un ingrediente registrado con el mismo nombre y unidad de medida");
       }
        
        Ingrediente ingrediente = this.ingredientesDAO.registrar(nuevoIngrediente);
        IngredienteDTO ingredienteDTO = new IngredienteDTO(ingrediente.getId(), ingrediente.getNombre().toUpperCase(), ingrediente.getUnidadMedida(), ingrediente.getCantidadStock());
        return ingredienteDTO;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesExistentes() {
        return this.ingredientesDAO.obtenerIngredientesExistentes();
    }

    @Override
    public IngredienteDTO actualizarStock(IngredienteDTO ingredienteDTO, Integer stockIngresado) throws IngredienteException {
        if(stockIngresado < 0){
            throw new IngredienteException("El stock no puede ser una cantidad negativa.");
        }
        Integer stockActualizado = ingredienteDTO.getCantidadStock() + stockIngresado;
        ingredienteDTO.setCantidadStock(stockActualizado);
        
        try {
            ingredienteDTO = this.ingredientesDAO.actualizarStock(ingredienteDTO);
        } catch (PersistenciaException ex) {
            throw new IngredienteException(ex.getMessage());
        }
        
        return ingredienteDTO;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesFiltradosNombre(String filtro) throws IngredienteException {
        if(filtro.isBlank()){
            throw new IngredienteException("No se ingresó ningún valor para realizar la búsqueda.");
        }
        
        List<IngredienteDTO> ingredientes;
        try {
            ingredientes = this.ingredientesDAO.obtenerIngredientesFiltradosNombre(filtro.toUpperCase());
            if(ingredientes == null){
                   throw new IngredienteException("No existen ingredientes con las especificaciones dadas.");
               }
               return ingredientes;
        } catch (PersistenciaException ex) {
            throw new IngredienteException(ex.getMessage());
        }
               
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesFiltradosUnidadMedida(String filtro) throws IngredienteException {
        filtro = filtro.toUpperCase().trim();
        for (ProductoTipos tipo : ProductoTipos.values()) {

            if (tipo.name().equalsIgnoreCase(filtro)) {
                
                try {
                    List<IngredienteDTO> ingredientes = this.ingredientesDAO.obtenerIngredientesFiltradosUnidadMedida(filtro.toUpperCase());

                } catch (PersistenciaException ex) {
                    throw new IngredienteException(ex.getMessage());
                }

            }
        }
        throw new IngredienteException("Filtro de búsqueda inválido");
    }

}
