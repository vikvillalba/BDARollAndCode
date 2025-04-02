package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.UnidadMedida;

/**
 * Clase de transporte que representa un ingrediente que se va a persistir.
 *
 * @author victoria
 */
public class NuevoIngredienteDTO {

    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;

    public NuevoIngredienteDTO(String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }
}
