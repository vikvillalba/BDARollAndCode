package com.mycompany.dominiorollandcode.dtos;

/**
 * Clase de transporte que representa una mesa existente en el sistema.
 * @author victoria
 */
public class MesaDTO {
    private Long id;
    private Integer numero;

    public MesaDTO(Long id, Integer numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }
    
    public Integer getNumero() {
        return numero;
    }

    
}
