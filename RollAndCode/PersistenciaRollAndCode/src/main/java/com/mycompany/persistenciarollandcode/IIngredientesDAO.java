package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que especifica las acciones de persistencia para los ingredientes.
 * @author victoria
 */
public interface IIngredientesDAO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
    public abstract List<IngredienteDTO> obtenerIngredientesExistentes();
    public abstract IngredienteDTO actualizarStock(IngredienteDTO ingredienteActualizar) throws PersistenciaException;
}
