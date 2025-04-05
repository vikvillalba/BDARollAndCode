package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria.Key;
import com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria.Utileria;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import org.eclipse.persistence.jpa.jpql.tools.model.query.KeywordExpressionStateObject;

/**
 * @author 52644
 */
public class ClientesBO implements IClientesBO {

    private IClientesDAO clientesDAO;
    private Key key;

    public ClientesBO(IClientesDAO clienteDAO, Key key) {
        this.clientesDAO = clienteDAO;
        this.key = key;
    }

    public ClientesBO() {
    }

    @Override
    public ClienteDTO registrarNuevoCliente(RegistrarClienteDTO cliente) throws ClienteException {
        if (cliente.getCorreoElectronico().isBlank()) {
            cliente.setCorreoElectronico("Sin Correo");
        }
        if (this.clientesDAO.verificarFormatoCorreo(cliente.getCorreoElectronico()) || this.clientesDAO.verificarCorreoBaseDatos(cliente.getCorreoElectronico())) {
            throw new ClienteException("Correo invalido para el registro");
        }
        if (cliente.getNombres().isBlank() || cliente.getApellidoMaterno().isBlank() || cliente.getApellidoPaterno().isBlank() || cliente.getTelefono().isBlank()) {
            throw new ClienteException("Solo el correo puede permanecer en blanco");
        }
        if (cliente.getTelefono().length() > 10 || cliente.getTelefono().length() < 10) {
            throw new ClienteException("El largo del teléfono debe ser de 10 caracteres");
        }
        try {
            String numTelefonoEncriptado = Utileria.encrypt(cliente.getTelefono(), key.getKeyBytes());
            if (this.clientesDAO.verificarTelefono(numTelefonoEncriptado)) {
                throw new ClienteException("Telefono ya registrado");
            }
            ClienteFrecuente clienteF = this.clientesDAO.registrarCliente(cliente);
            return new ClienteDTO(clienteF.getId(), clienteF.getNombres(), clienteF.getApellidoPaterno(),
                    clienteF.getApellidoMaterno(), numTelefonoEncriptado, clienteF.getCorreoElectronico(), clienteF.getFechaRegistro());
        } catch (Exception e) {
            throw new ClienteException("No se ha podido obtener la Key");
        }

    }
}
