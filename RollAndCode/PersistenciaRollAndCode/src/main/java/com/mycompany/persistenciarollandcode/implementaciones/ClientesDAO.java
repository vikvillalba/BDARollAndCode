package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            String jpql = "SELECT COUNT(c) FROM ClienteFrecuente c WHERE c.correoElectronico = :correo";

            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
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
        } catch (NoResultException e) {
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

    @Override
    public List<ClienteDTO> buscarClientes() {
        EntityManager em = ManejadorConexiones.getEntityManager();
        String jpql = """
                      SELECT NEW com.mycompany.dominiorollandcode.dtos.ClienteDTO(
                      c.id,
                      c.nombres,
                      c.apellidoPaterno,
                      c.correoElectronico,
                      c.telefono,
                      c.gastoTotal
                      )
                      FROM ClienteFrecuente c
                      """;
        TypedQuery<ClienteDTO> query = em.createQuery(jpql, ClienteDTO.class);
        return query.getResultList();
    }

    @Override
    public List<ClienteDTO> buscarClientesNombre(String nombre) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        String jpql = """
                      SELECT NEW com.mycompany.dominiorollandcode.dtos.ClienteDTO(
                      c.id,
                      c.nombres,
                      c.apellidoPaterno,
                      c.correoElectronico,
                      c.telefono,
                      c.gastoTotal
                      )
                      FROM ClienteFrecuente c 
                      WHERE c.nombres LIKE :nombres
                      """;
        TypedQuery<ClienteDTO> query = em.createQuery(jpql, ClienteDTO.class);
        query.setParameter("nombres", "%"+nombre+"%");
        return query.getResultList();
    }

    @Override
    public List<ClienteDTO> buscarClientesCorreo(String correo) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        String jpql = """
                      SELECT NEW com.mycompany.dominiorollandcode.dtos.ClienteDTO(
                      c.id,
                      c.nombres,
                      c.apellidoPaterno,
                      c,correoElectronico,
                      c.telefono,
                      c.gastoTotal
                      )
                      FROM ClienteFrecuente c
                      """;
        TypedQuery<ClienteDTO> query = em.createQuery(jpql, ClienteDTO.class);
        return query.getResultList();

    }

    @Override
    public List<ClienteDTO> buscarClientesTelefono(String telefono) {

    }
}
