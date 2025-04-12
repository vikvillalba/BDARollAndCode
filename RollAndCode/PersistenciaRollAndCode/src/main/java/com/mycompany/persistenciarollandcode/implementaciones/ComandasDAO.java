package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteReporteDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaReporteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.dominiorollandcode.entidades.ProductoComanda;
import com.mycompany.dominiorollandcode.entidades.ProductoIngrediente;
import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import com.mycompany.persistenciarollandcode.IComandasDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Implementación de los métodos de IComandasDAO
 *
 * @author victoria
 */
public class ComandasDAO implements IComandasDAO {

    @Override
    public Comanda registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Comanda comanda = new Comanda();
        comanda.setFechaCreacion(nuevaComandaDTO.getFechaCreacion());
        comanda.setFolio(nuevaComandaDTO.getFolio());

        if (nuevaComandaDTO.getCliente() == null) {
            comanda.setClienteFrecuente(null);
        } else {
            ClienteFrecuente cliente = entityManager.find(ClienteFrecuente.class, nuevaComandaDTO.getCliente().getId());
            comanda.setClienteFrecuente(cliente);
        }
        Mesa mesa = entityManager.find(Mesa.class, nuevaComandaDTO.getMesa().getId());
        comanda.setMesa(mesa);

        List<ProductoComanda> productosComanda = new ArrayList<>();

        for (NuevoProductoComandaDTO productoComanda : nuevaComandaDTO.getProductos()) {
            Producto producto = entityManager.find(Producto.class, productoComanda.getIdProducto());

            if (producto != null) {
                ProductoComanda productoRelacion = new ProductoComanda();
                productoRelacion.setProducto(producto);
                productoRelacion.setCantidadProducto(productoComanda.getCantidadProducto());
                productoRelacion.setComentario(productoComanda.getComentario());
                productoRelacion.setPrecioProducto(productoComanda.getPrecioProducto());
                productoRelacion.setImporteProducto();
                productoRelacion.setComanda(comanda);
                productosComanda.add(productoRelacion);

            } else {
                throw new PersistenciaException("Error al recuperar productos");
            }
        }
        comanda.setProductos(productosComanda);
        comanda.setEstado(nuevaComandaDTO.getEstado());
        entityManager.persist(comanda);
        entityManager.getTransaction().commit();
        return comanda;
    }

    @Override
    public List<Comanda> obtenerComandasAbiertas() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            String jpqlQuery = """
                               SELECT DISTINCT c FROM Comanda c LEFT JOIN FETCH c.productos cp WHERE c.estado = :estado
                               """;
            TypedQuery<Comanda> query = entityManager.createQuery(jpqlQuery, Comanda.class);
            query.setParameter("estado", EstadoComanda.ABIERTA);
            return query.getResultList();

        } catch (NoResultException e) {
            throw new PersistenciaException("Error al recuperar las comandas.");
        }

    }

    @Override
    public Comanda actualizar(ComandaDTO comandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        try {
            Comanda comanda = entityManager.find(Comanda.class, comandaDTO.getId());
            if (comanda == null) {
                throw new PersistenciaException("No se encontró la comanda especificada.");
            }
            List<ProductoComanda> productos = comanda.getProductos();

            // Elimina los productos que ya no están en la comanda
            for (int i = 0; i < productos.size(); i++) {
                boolean encontrado = false;
                for (ProductoComandaDTO nuevoProducto : comandaDTO.getProductos()) {
                    if (productos.get(i).getProducto().getId().equals(nuevoProducto.getIdProducto())) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    entityManager.remove(productos.get(i));
                    productos.remove(i);
                    i--;
                }
            }

            // Agrega los nuevos productos a la comanda
            for (ProductoComandaDTO nuevoProducto : comandaDTO.getProductos()) {
                boolean encontrado = false;
                for (ProductoComanda producto : productos) {
                    if (producto.getProducto().getId().equals(nuevoProducto.getIdProducto())) {
                        encontrado = true;
                        producto.setCantidadProducto(nuevoProducto.getCantidad());
                        producto.setImporteProducto();
                        break;
                    }
                }

                if (!encontrado) {
                    Producto productoExistente = entityManager.find(Producto.class, nuevoProducto.getIdProducto());
                    ProductoComanda productoComanda = new ProductoComanda();
                    productoComanda.setProducto(productoExistente);
                    productoComanda.setPrecioProducto(nuevoProducto.getPrecio());
                    productoComanda.setComentario(nuevoProducto.getComentario() != null ? nuevoProducto.getComentario() : "");
                    productoComanda.setComanda(comanda);
                    productoComanda.setCantidadProducto(nuevoProducto.getCantidad());
                    productoComanda.setImporteProducto();

                    productos.add(productoComanda);
                }
            }

            comanda.setTotalAcumulado();
            entityManager.merge(comanda);
            entityManager.getTransaction().commit();
            return comanda;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar la comanda: " + e.getMessage(), e);
        }

    }

    @Override
    public Comanda cambiarEstado(ComandaDTO comandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            Comanda comanda = entityManager.find(Comanda.class, comandaDTO.getId());
            if (comanda == null) {
                throw new PersistenciaException("Comanda no encontrada.");
            }
            comanda.setEstado(comandaDTO.getEstado());
            entityManager.merge(comanda);

            if (comanda.getEstado() == EstadoComanda.ENTREGADA) {
                actualizarIngredientes(comanda);
            }
            entityManager.getTransaction().commit();

            return comanda;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

            throw new PersistenciaException("Error al actualizar la comanda: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizarIngredientes(Comanda comanda) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        for (ProductoComanda productoComanda : comanda.getProductos()) {
            Producto producto = productoComanda.getProducto();

            for (ProductoIngrediente productoIngrediente : producto.getIngredientes()) {
                Ingrediente ingrediente = productoIngrediente.getIngrediente();

                Integer stockRestante = ingrediente.getCantidadStock() - (productoIngrediente.getCantidad() * productoComanda.getCantidadProducto());
                if (stockRestante < 0) {
                    entityManager.getTransaction().rollback();
                    throw new PersistenciaException("No hay suficiente stock del ingrediente: " + ingrediente.getNombre());

                }

                ingrediente.setCantidadStock(stockRestante);
                entityManager.merge(ingrediente);
            }
        }
        entityManager.getTransaction().commit();
    }

    public List<ComandaReporteDTO> obtenerComandasReporte(Calendar fechaInicio, Calendar fechaFin) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpql = """
                      SELECT new com.mycompany.dominiorollandcode.dtos.ComandaReporteDTO 
                      (c.folio, c.fechaCreacion, c.estado, c.totalAcumulado, m.numero, cf.nombres, cf.apellidoPaterno, cf.apellidoMaterno)               
                      FROM Comanda c 
                      JOIN c.mesa m
                      LEFT JOIN c.clienteFrecuente cf
                      WHERE c.fechaCreacion BETWEEN :fechaInicio AND :fechaFin
                      """;

        return entityManager.createQuery(jpql, ComandaReporteDTO.class).setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).getResultList();

    }

    public List<ClienteReporteDTO> obtenerReporteClientesFrecuentes(String nombreFiltro, int minVisitas) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        String jpql = """
        SELECT new com.mycompany.dominiorollandcode.dtos.ClienteReporteDTO(
            cf.nombres,
            cf.apellidoPaterno,
            cf.apellidoMaterno,
            COUNT(c.id),
            SUM(c.totalAcumulado),
            MAX(c.fechaCreacion)
        )
        FROM ClienteFrecuente cf
        JOIN cf.comandas c
        WHERE CONCAT(cf.nombres, ' ', cf.apellidoPaterno, ' ', cf.apellidoMaterno) LIKE :nombreFiltro
        GROUP BY cf.nombres, cf.apellidoPaterno, cf.apellidoMaterno
        HAVING COUNT(c.id) >= :minVisitas
    """;

        return em.createQuery(jpql, ClienteReporteDTO.class)
                .setParameter("nombreFiltro", "%" + nombreFiltro + "%")
                .setParameter("minVisitas", (long) minVisitas) // Ojo: COUNT es Long
                .getResultList();
    }

}
