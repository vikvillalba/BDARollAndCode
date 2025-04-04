package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.UnidadMedida;
import java.util.Objects;

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

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.unidadMedida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IngredienteDTO other = (IngredienteDTO) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return this.unidadMedida == other.unidadMedida;
    }
    
    
    
    
}
