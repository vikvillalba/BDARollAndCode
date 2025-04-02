/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dominiorollandcode.dtos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 52644
 */
public class RegistrarClienteDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String telefono;
    private Calendar fechaRegistro;

    public RegistrarClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = email;
        this.telefono = telefono;
        this.fechaRegistro = new GregorianCalendar();
    }
    
    public RegistrarClienteDTO(){}

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public Calendar getFechaRegistro(){
        return fechaRegistro;
    }
    
    public void setCorreoElectronico(String email){
        this.correoElectronico = email;
    }
    
    
}
