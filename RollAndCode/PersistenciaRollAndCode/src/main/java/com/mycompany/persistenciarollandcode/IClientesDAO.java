package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IClientesDAO {
    public abstract ClienteFrecuente registrarCliente(RegistrarClienteDTO cliente);
    public abstract boolean verificarTelefono(String telefono);
    public abstract boolean verificarFormatoCorreo(String correo);
    public abstract boolean verificarCorreoBaseDatos(String correo);
    public abstract List<ClienteDTO> buscarClientes();
    public abstract List<ClienteDTO> buscarClientesNombre(String nombre);
    public abstract List<ClienteDTO> buscarClientesCorreo(String correo);
    public abstract List<ClienteDTO> buscarClientesTelefono(String telefono);
    public abstract List<ClienteDTO> consultarClientes(String nombre, String correo, String telefono);
    public abstract List<ClienteDTO> consultarClientes();
}
