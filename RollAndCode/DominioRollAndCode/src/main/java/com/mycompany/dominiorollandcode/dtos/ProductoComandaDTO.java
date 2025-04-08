
package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import java.math.BigDecimal;

/**
 * Clase de transporte que representa una relación entre un producto en una comanda registrada.
 * @author victoria
 */
public class ProductoComandaDTO {
    private Long idProducto;
    private Long idComanda;
    private String nombreProducto;
    private BigDecimal precio;
    private ProductoTipos tipo;
    private Integer cantidad;
    private String comentario;
    private BigDecimal subtotal;

    public ProductoComandaDTO() {
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
