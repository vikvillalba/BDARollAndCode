package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import com.mycompany.persistenciarollandcode.IClientesDAO;

/**
 * @author 52644
 */
public class ClientesBO implements IClientesBO {

    private IClientesDAO clientesDAO;
    
    
    public ClientesBO(IClientesDAO clienteDAO){
        this.clientesDAO = clienteDAO;
    }
 
    public ClientesBO(){}
    
   @Override
   public  ClienteDTO registrarNuevoCliente(RegistrarClienteDTO cliente)throws ClienteException{
       if(cliente.getCorreoElectronico().isBlank())
           cliente.setCorreoElectronico("Sin Correo");
       if(cliente.getNombres().isBlank() || cliente.getApellidoMaterno().isBlank() || cliente.getApellidoPaterno().isBlank() || cliente.getTelefono().isBlank()){
           throw new ClienteException("Solo el correo puede permanecer en blanco");
       }
       ClienteFrecuente clienteF = this.clientesDAO.registrarCliente(cliente);
       return new ClienteDTO(clienteF.getId(), clienteF.getNombres(), clienteF.getApellidoPaterno(),
               clienteF.getApellidoMaterno(), clienteF.getTelefono(), clienteF.getCorreoElectronico(), clienteF.getFechaRegistro());  
   }
}
