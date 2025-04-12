package com.mycompany.dominiorollandcode.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author victoria
 */
public class ClienteReporteDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer numeroVisitas;
    private BigDecimal totalGastado;
    private Integer puntosFidelidad;
    private Calendar fechaUltimaComanda;

    public ClienteReporteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, Integer numeroVisitas, BigDecimal totalGastado, Integer puntosFidelidad, Calendar fechaUltimaComanda) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.puntosFidelidad = puntosFidelidad;
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Integer getNumeroVisitas() {
        return numeroVisitas;
    }

    public BigDecimal getTotalGastado() {
        return totalGastado;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public Calendar getFechaUltimaComanda() {
        return fechaUltimaComanda;
    }
    
    
    
}
