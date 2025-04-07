package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.UnidadMedida;

/**
 * Clase de transporte que representa un ingrediente perteneciente a un producto. Incluye los datos del ingrediente y la cantidad necesaria para el producto.
 *
 * @author victoria
 */
public class IngredienteProductoDTO {

    private Long id;
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;
    private Integer cantidadProducto;

    public IngredienteProductoDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer cantidadStock, Integer cantidadProducto) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
        this.cantidadProducto = cantidadProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    
    
}
