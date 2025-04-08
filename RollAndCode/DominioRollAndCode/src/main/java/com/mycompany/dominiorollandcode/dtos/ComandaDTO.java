
package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Clase de transporte que representa una comanda existente 
 * @author victoria
 */
public class ComandaDTO {
    private Long id;
    private String folio;
    private Calendar fechaHora;
    private EstadoComanda estado;
    private BigDecimal totalAcumulado;
    private List<ProductoComandaDTO> productos;
    private Integer numeroMesa;

    public ComandaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public BigDecimal getTotalAcumulado() {
        return totalAcumulado;
    }

    public void setTotalAcumulado(BigDecimal totalAcumulado) {
        this.totalAcumulado = totalAcumulado;
    }

    public List<ProductoComandaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoComandaDTO> productos) {
        this.productos = productos;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    
    
}
