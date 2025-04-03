package com.mycompany.dominiorollandcode.dtos;

/**
 * Clase de transporte que representa una nueva mesa en el sistema antes de persistirse.
 * @author victoria
 */
public class NuevaMesaDTO {
    private Integer numero;

    public NuevaMesaDTO(Integer numero) {
        this.numero = numero;
    }

    public NuevaMesaDTO() {
    }
    

    public Integer getNumero() {
        return numero;
    }


    
}
