package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase de transporte que representa un nuevo producto antes de persistirse.
 * @author victoria
 */
public class NuevoProductoDTO {
    private String nombre;
    private BigDecimal precio;
    private ProductoTipos tipo;
    private List<IngredienteDTO> ingredientes;
    private List<NuevoProductoIngredienteDTO> ingredientesRelacion;

    public NuevoProductoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public ProductoTipos getTipo() {
        return tipo;
    }

    public void setTipo(ProductoTipos tipo) {
        this.tipo = tipo;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public List<NuevoProductoIngredienteDTO> getIngredientesRelacion() {
        return ingredientesRelacion;
    }

    public void setIngredientesRelacion(List<NuevoProductoIngredienteDTO> ingredientesRelacion) {
        this.ingredientesRelacion = ingredientesRelacion;
    }
    
    
}
