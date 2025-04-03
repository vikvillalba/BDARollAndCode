
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.negociorollandcode.excepciones.IngredienteException;
import java.util.List;

/**
 * Interfaz para objetos de negocio de ingredientes.
 * @author victoria
 */
public interface IIngredientesBO {
    
    public abstract IngredienteDTO registrar(NuevoIngredienteDTO nuevoIngrediente) throws IngredienteException;
    public abstract List<IngredienteDTO> obtenerIngredientesExistentes();
    public abstract IngredienteDTO actualizarStock(IngredienteDTO ingredienteDTO, Integer stockIngresado) throws IngredienteException;
    public abstract List<IngredienteDTO> obtenerIngredientesFiltradosNombre(String filtro) throws IngredienteException;
    public abstract List<IngredienteDTO> obtenerIngredientesFiltradosUnidadMedida(String filtro) throws IngredienteException;
}
