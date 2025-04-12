package com.mycompany.dominiorollandcode.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author victoria
 */
public class ClienteReporteDTO {
   private String nombreCompleto;
    private Long numeroVisitas;
    private BigDecimal totalGastado;
    private Integer puntosFidelidad;
    private Calendar ultimaComanda;

     public ClienteReporteDTO(String nombres, String apellidoPaterno, String apellidoMaterno,
                                      Long numeroVisitas, BigDecimal totalGastado, Calendar ultimaComanda) {
        this.nombreCompleto = nombres + " " + apellidoPaterno + " " + apellidoMaterno;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.ultimaComanda = ultimaComanda;
        this.puntosFidelidad = totalGastado != null ? totalGastado.divide(new BigDecimal(20), 0, BigDecimal.ROUND_DOWN).intValue() : 0;
    }

    public ClienteReporteDTO() {
    }

    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(Long numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public BigDecimal getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(BigDecimal totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public Calendar getUltimaComanda() {
        return ultimaComanda;
    }

    public void setUltimaComanda(Calendar ultimaComanda) {
        this.ultimaComanda = ultimaComanda;
    }


    
    
}
