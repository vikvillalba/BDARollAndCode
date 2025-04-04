
package com.mycompany.dominiorollandcode.dtos;

/**
 * Clase de transporte para guardar la relación entre los ingredientes que componen a un producto.
 * @author victoria
 */
public class NuevoProductoIngredienteDTO {
    private Long idProducto;
    private Long idIngrediente;
    private Integer cantidad;

    public NuevoProductoIngredienteDTO() {
    }


    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
