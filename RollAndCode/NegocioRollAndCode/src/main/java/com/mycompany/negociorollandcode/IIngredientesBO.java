
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;

/**
 * Interfaz para objetos de negocio de ingredientes.
 * @author victoria
 */
public interface IIngredientesBO {
    
    public abstract IngredienteDTO registrar(NuevoIngredienteDTO nuevoIngrediente);
}
