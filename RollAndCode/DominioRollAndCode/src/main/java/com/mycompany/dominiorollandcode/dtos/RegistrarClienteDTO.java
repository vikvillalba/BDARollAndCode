/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dominiorollandcode.dtos;

/**
 *
 * @author 52644
 */
public class RegistrarClienteDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private int telefono;

    public RegistrarClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String email, int telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }
    
    
    
}
