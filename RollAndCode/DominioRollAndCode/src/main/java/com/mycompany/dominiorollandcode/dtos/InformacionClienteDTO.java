/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dominiorollandcode.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author 52644
 */
public class InformacionClienteDTO {
    Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private int telefono;
    private Calendar fechaRegistro;
    private int cantidadVisitas;
    private BigDecimal gastoTotal;
    private int puntosFidelidad;    

    public InformacionClienteDTO(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String email, int telefono, Calendar fechaRegistro, int cantidadVisitas, BigDecimal gastoTotal, int puntosFidelidad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.cantidadVisitas = cantidadVisitas;
        this.gastoTotal = gastoTotal;
        this.puntosFidelidad = puntosFidelidad;
    }
    
    public InformacionClienteDTO(){}
    
}
