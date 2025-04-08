
package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoComandaDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.dominiorollandcode.entidades.ProductoComanda;
import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import com.mycompany.persistenciarollandcode.IComandasDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Implementación de los métodos de IComandasDAO
 * @author victoria
 */
public class ComandasDAO implements IComandasDAO{

    @Override
    public Comanda registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        Comanda comanda = new Comanda();
        comanda.setFechaCreacion(nuevaComandaDTO.getFechaCreacion());
        comanda.setFolio(nuevaComandaDTO.getFolio());
        
        if(nuevaComandaDTO.getCliente() == null){
            comanda.setClienteFrecuente(null);
        } else {
            ClienteFrecuente cliente = entityManager.find(ClienteFrecuente.class, nuevaComandaDTO.getCliente().getId());
        }
        Mesa mesa = entityManager.find(Mesa.class, nuevaComandaDTO.getMesa().getId());
        comanda.setMesa(mesa);
        
        List<ProductoComanda> productosComanda = new ArrayList<>();
        
        for(NuevoProductoComandaDTO productoComanda : nuevaComandaDTO.getProductos()){
            Producto producto = entityManager.find(Producto.class, productoComanda.getIdProducto());
            
            if(producto != null){
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
                               SELECT c FROM Comanda c LEFT JOIN FETCH c.productos cp WHERE c.estado = :estado
                               """;
            TypedQuery<Comanda> query = entityManager.createQuery(jpqlQuery, Comanda.class);
            query.setParameter("estado", EstadoComanda.ABIERTA);
            return query.getResultList();

        } catch (NoResultException e) {
            throw new PersistenciaException("Error al recuperar las comandas.");
        }

    }
    
}
