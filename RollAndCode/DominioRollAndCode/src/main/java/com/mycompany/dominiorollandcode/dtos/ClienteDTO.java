package com.mycompany.dominiorollandcode.dtos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 52644
 */
public class ClienteDTO {

    private long id;
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String telefono;
    private String correoElectronico;
    private Calendar fechaRegistro;
    private double gastoTotal;

    public ClienteDTO(long id, String nombres, String ApellidoP, String apellidoM, String telefono, String email, Calendar fechaRegistro, double gastoTotal) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoM;
        this.apellidoPaterno = ApellidoP;
        this.telefono = telefono;
        this.correoElectronico = email;
        this.fechaRegistro = fechaRegistro;
        this.gastoTotal = gastoTotal;
    }

    public ClienteDTO() {
    }

    public long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    @Override
    public String toString() {

        return "Cliente Registrado: " + "\nId = " + id + "\nNombre = " + nombres + "\nApellido Paterno = " + apellidoPaterno
                + "\nApellido Materno = " + apellidoMaterno + "\nNumero Telefono = " + telefono + "\nCorreo = " + correoElectronico;

    }

    public Calendar getFechaRegistro() {
        return this.fechaRegistro;
    }
    public double getGastoTotal(){
        return this.gastoTotal;
    }

}
