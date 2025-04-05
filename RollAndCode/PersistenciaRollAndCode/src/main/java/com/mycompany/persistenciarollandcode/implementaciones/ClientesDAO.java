package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 52644
 */
public class ClientesDAO implements IClientesDAO {

    public ClientesDAO() {
    }

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
    public boolean verificarCorreoBaseDatos(String correo) {
        if (correo.equals("Sin Correo")) {
            return false;
        }
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            String jpql = "SELECT c FROM ClientesFrecuente c WHERE c.correoElectronico = :correo";
            ClienteFrecuente cliente = em.createQuery(jpql, ClienteFrecuente.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean verificarTelefono(String telefono) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ClienteFrecuente> criteria = builder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> root = criteria.from(ClienteFrecuente.class);

        criteria.select(root).where(builder.equal(root.get("telefono"), telefono));
        try {
            ClienteFrecuente clienteFrecuente = em.createQuery(criteria).getSingleResult();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    @Override
    public boolean verificarFormatoCorreo(String correo) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(correo);
        return matcher.matches();
    }
}
