package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.UnidadMedida;

/**
 * Clase de transporte que representa un ingrediente existente en los registros.
 * @author victoria
 */
public class IngredienteDTO {
    private Long id;
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;

    public IngredienteDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
    }

    public Long getId() {
        return id;
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
