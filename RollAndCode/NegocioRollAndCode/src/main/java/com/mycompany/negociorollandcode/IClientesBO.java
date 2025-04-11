/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IClientesBO {
    public abstract ClienteDTO registrarNuevoCliente(RegistrarClienteDTO cliente) throws ClienteException;
    public abstract List<ClienteDTO> buscarClientes();
    public abstract List<ClienteDTO> buscarClientesNombre(String nombre);
    public abstract List<ClienteDTO> buscarClientesCorreo(String correo);
    public abstract List<ClienteDTO> buscarClientesTelefono(String telefono);
    public abstract List<ClienteDTO> consultarClientes(String parametro);
    public abstract List<ClienteDTO> consultarClientes();
}
