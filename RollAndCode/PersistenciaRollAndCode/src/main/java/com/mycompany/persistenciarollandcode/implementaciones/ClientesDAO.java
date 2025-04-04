package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 52644
 */
public class ClientesDAO implements IClientesDAO {

    public ClientesDAO(){}
    
    @Override
    public ClienteFrecuente registrarCliente(RegistrarClienteDTO clienteDTO) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        em.getTransaction().begin();
        ClienteFrecuente cliente = new ClienteFrecuente();
        
        cliente.setNombres(clienteDTO.getNombres());
        cliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        cliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        cliente.setFechaRegistro(clienteDTO.getFechaRegistro());
        cliente.setCantidadVisitas(0);
        cliente.setGastoTotal(BigDecimal.ZERO);
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        
        return cliente;
    }
    
    @Override
    public boolean verificarCorreo(String correo){
        EntityManager em = ManejadorConexiones.getEntityManager();
        return em.find(String.class, correo).equals(correo);
    }
    
    @Override
    public boolean verificarTelefono(String telefono){
        EntityManager em = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        //criteria.
        return false;
    }
    
}
