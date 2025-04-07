
package com.mycompany.dominiorollandcode.dtos;

import java.math.BigDecimal;

/**
 * Clase de transporte para guardar la relación entre los productos que están en una comanda.
 * @author victoria
 */
public class NuevoProductoComandaDTO {
    private Long idComanda;
    private Long idProducto;
    private BigDecimal precioProducto;
    private Integer cantidadProducto;
    private String comentario;

    public NuevoProductoComandaDTO() {
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "NuevoProductoComandaDTO{" + "idComanda=" + idComanda + ", idProducto=" + idProducto + ", precioProducto=" + precioProducto + ", cantidadProducto=" + cantidadProducto + ", comentario=" + comentario + '}';
    }
    
    
    
}
