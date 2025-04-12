package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author victoria
 */
public class ComandaReporteDTO {
    private String folio;
    private Calendar fechaHora;
    private Integer numeroMesa;
    private BigDecimal totalVenta;
    private EstadoComanda estadoComanda;
    private String nombreCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public ComandaReporteDTO(String folio, Calendar fechaHora,  EstadoComanda estadoComanda,  BigDecimal totalVenta, Integer numeroMesa, String nombreCliente, String apellidoPaterno, String apellidoMaterno) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.numeroMesa = numeroMesa;
        this.totalVenta = totalVenta;
        this.estadoComanda = estadoComanda;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public ComandaReporteDTO() {
    }

    
    
    public Calendar getFechaHora() {
        return fechaHora;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }


    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public EstadoComanda getEstadoComanda() {
        return estadoComanda;
    }

    public void setEstadoComanda(EstadoComanda estadoComanda) {
        this.estadoComanda = estadoComanda;
    }
    
   public String getNombreCompleto(){
       if(this.nombreCliente == null){
           return "Sin cliente asociado";
       }
       
       return this.nombreCliente + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
   }
    
}
