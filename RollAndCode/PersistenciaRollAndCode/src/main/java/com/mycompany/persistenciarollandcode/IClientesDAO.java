package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;

/**
 *
 * @author 52644
 */
public interface IClientesDAO {
    public abstract ClienteFrecuente registrarCliente(RegistrarClienteDTO cliente);
    public abstract boolean verificarTelefono(String telefono);
    public abstract boolean verificarCorreo(String correo);
}
