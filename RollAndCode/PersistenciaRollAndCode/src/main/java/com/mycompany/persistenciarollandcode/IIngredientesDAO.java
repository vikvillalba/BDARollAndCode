package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;

/**
 * Interfaz que especifica las acciones de persistencia para los ingredientes.
 * @author victoria
 */
public interface IIngredientesDAO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
}
