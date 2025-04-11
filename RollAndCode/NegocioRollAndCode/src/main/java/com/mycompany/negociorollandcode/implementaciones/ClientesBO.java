package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria.Utileria;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author 52644
 */
public class ClientesBO implements IClientesBO {

    private IClientesDAO clientesDAO;

    public ClientesBO(IClientesDAO clienteDAO) {
        this.clientesDAO = clienteDAO;

    }

    public ClientesBO() {
    }

    @Override
    public ClienteDTO registrarNuevoCliente(RegistrarClienteDTO cliente) throws ClienteException {
        String correo = cliente.getCorreoElectronico().toLowerCase();
        if (!correo.isBlank()) {
            if (this.clientesDAO.verificarFormatoCorreo(correo)) {
                if (!this.clientesDAO.verificarCorreoBaseDatos(correo)) {
                    cliente.setCorreoElectronico(correo);
                } else {
                    throw new ClienteException("Correo ya registrado");
                }
            } else {
                throw new ClienteException("Formato de correo inválido");
            }
        } else {
            cliente.setCorreoElectronico("Sin Correo");
        }

        if (cliente.getNombres().isBlank() || cliente.getApellidoMaterno().isBlank()
                || cliente.getApellidoPaterno().isBlank() || cliente.getTelefono().isBlank()) {
            throw new ClienteException("Solo el correo puede permanecer en blanco");
        }
        if (cliente.getTelefono().length() > 10 || cliente.getTelefono().length() < 10) {
            throw new ClienteException("El largo del teléfono debe ser de 10 caracteres");
        }
        String telefono = cliente.getTelefono();
        try {
            String numTelefonoEncriptado = Utileria.encriptar(telefono);
            if (this.clientesDAO.verificarTelefono(numTelefonoEncriptado)) {
                throw new ClienteException("Telefono ya registrado");
            }
            cliente.setTelefono(numTelefonoEncriptado);
            ClienteFrecuente clienteF = this.clientesDAO.registrarCliente(cliente);
            return new ClienteDTO(clienteF.getId(), clienteF.getNombres(), clienteF.getApellidoPaterno(),
                    clienteF.getApellidoMaterno(), telefono, clienteF.getCorreoElectronico(),
                    clienteF.getFechaRegistro(), BigDecimal.ZERO);
        } catch (Exception e) {
            throw new ClienteException("No se ha podido registrar" + e.getMessage());
        }

    }

    @Override
    public List<ClienteDTO> buscarClientes() {
        List<ClienteDTO> clientes = clientesDAO.buscarClientes();
        try {
            for (ClienteDTO c : clientes) {
                c.setNumeroTelefono(Utileria.desencriptar(c.getTelefono()));
            }
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los clientes");
            return null;
        }
        
    }

    @Override
    public List<ClienteDTO> buscarClientesNombre(String nombre) {
        return clientesDAO.buscarClientesNombre(nombre);
    }

    @Override
    public List<ClienteDTO> buscarClientesCorreo(String correo) {
        return clientesDAO.buscarClientesCorreo(correo);
    }

    @Override
    public List<ClienteDTO> buscarClientesTelefono(String telefono) {
        try {
            String numTelefonoEncriptado = Utileria.encriptar(telefono);
            List<ClienteDTO> clientes = clientesDAO.buscarClientesTelefono(numTelefonoEncriptado);
            return clientes;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los clientes");
            return null;
        }
    }

    @Override
    public List<ClienteDTO> consultarClientes(String parametro) {
        try {
            String nombre = parametro;
            String correo = parametro;
            String numTelefonoEncriptado = Utileria.encriptar(parametro);
            List<ClienteDTO> clientes = clientesDAO.consultarClientes(nombre, correo, numTelefonoEncriptado);
            for (ClienteDTO c : clientes) {
                c.setNumeroTelefono(Utileria.desencriptar(c.getTelefono()));
            }
            return clientes;
        } catch (Exception ex) {
            Logger.getLogger(ClientesBO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al mostrar los clientes");
            return null;
        }
    }

}
