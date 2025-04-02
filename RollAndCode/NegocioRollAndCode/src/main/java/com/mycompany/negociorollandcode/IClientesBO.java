/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;

/**
 *
 * @author 52644
 */
public interface IClientesBO {
    public abstract ClienteDTO registrarNuevoCliente(RegistrarClienteDTO cliente) throws ClienteException;
}
