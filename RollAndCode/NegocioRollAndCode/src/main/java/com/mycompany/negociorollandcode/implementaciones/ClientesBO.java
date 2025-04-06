package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria.Utileria;
import com.mycompany.persistenciarollandcode.IClientesDAO;
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
        String correo = cliente.getCorreoElectronico();
        if (!correo.isBlank()) {
            if (this.clientesDAO.verificarFormatoCorreo(correo)) {
                if (!this.clientesDAO.verificarCorreoBaseDatos(correo)) {
                } else {
                    throw new ClienteException("Correo ya registrado");
                }
            } else {
                throw new ClienteException("Formato de correo inválido");
            }
        } else {
            cliente.setCorreoElectronico("Sin Correo");
        }

        if (cliente.getNombres().isBlank() || cliente.getApellidoMaterno().isBlank() || cliente.getApellidoPaterno().isBlank() || cliente.getTelefono().isBlank()) {
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
                    clienteF.getApellidoMaterno(), telefono, clienteF.getCorreoElectronico(), clienteF.getFechaRegistro());
        } catch (Exception e) {
            throw new ClienteException("No se ha podido registrar");
        }

    }
}
