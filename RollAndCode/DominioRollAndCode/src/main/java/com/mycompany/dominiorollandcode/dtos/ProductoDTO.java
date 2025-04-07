package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase de transporte que representa un producto registrado.
 * @author victoria
 */
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private ProductoTipos tipo;
    private List<IngredienteProductoDTO> ingredientes;

    public ProductoDTO(Long id, String nombre, BigDecimal precio, ProductoTipos tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public ProductoTipos getTipo() {
        return tipo;
    }

    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    
    
}
