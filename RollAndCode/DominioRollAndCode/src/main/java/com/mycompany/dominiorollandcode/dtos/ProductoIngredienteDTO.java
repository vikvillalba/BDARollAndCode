package com.mycompany.dominiorollandcode.dtos;
/**
 * Clase de transporte que contiene la relación entre los ingredientes que componen a un producto.
 * @author victoria
 */
public class ProductoIngredienteDTO {
    private Long id;
    private Long idProducto;
    private Long idIngrediente;
    private Integer cantidad;

    public ProductoIngredienteDTO(Long id, Long idProducto, Long idIngrediente, Integer cantidad) {
        this.id = id;
        this.idProducto = idProducto;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }


    
}