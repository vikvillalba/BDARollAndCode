/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.ClienteRegistradoDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;

/**
 *
 * @author 52644
 */
public interface IClienteBO {
    public abstract ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO cliente);
}
