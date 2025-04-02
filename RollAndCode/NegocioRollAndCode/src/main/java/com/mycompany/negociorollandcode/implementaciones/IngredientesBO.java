package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.dominiorollandcode.enums.UnidadMedida;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;

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
    public IngredienteDTO registrar(NuevoIngredienteDTO nuevoIngrediente) {
        // TODO: hacer validaciones 
        Ingrediente ingrediente = this.ingredientesDAO.registrar(nuevoIngrediente);
        IngredienteDTO ingredienteDTO = new IngredienteDTO(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getUnidadMedida(), ingrediente.getCantidadStock());
        return ingredienteDTO;
    }
    
}
