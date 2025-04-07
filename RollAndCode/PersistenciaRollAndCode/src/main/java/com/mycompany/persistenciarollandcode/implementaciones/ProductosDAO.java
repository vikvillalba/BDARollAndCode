package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoIngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.dominiorollandcode.entidades.ProductoIngrediente;
import com.mycompany.persistenciarollandcode.IProductosDAO;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz para persistir productos.
 *
 * @author victoria
 */
public class ProductosDAO implements IProductosDAO {

    @Override
    public Producto registrar(NuevoProductoDTO nuevoProductoDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Producto producto = new Producto();
        producto.setNombre(nuevoProductoDTO.getNombre());
        producto.setPrecio(nuevoProductoDTO.getPrecio());
        producto.setTipo(nuevoProductoDTO.getTipo());

        List<ProductoIngrediente> ingredientesRelacion = new ArrayList<>();
        for (NuevoProductoIngredienteDTO ingredienteProducto : nuevoProductoDTO.getIngredientesRelacion()) {
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteProducto.getIdIngrediente());

            if (ingrediente != null) {
                ProductoIngrediente ingredienteRelacion = new ProductoIngrediente();
                ingredienteRelacion.setIngrediente(ingrediente);
                ingredienteRelacion.setCantidad(ingredienteProducto.getCantidad());
                ingredienteRelacion.setProducto(producto);

                ingredientesRelacion.add(ingredienteRelacion);

            } else {
                throw new PersistenciaException("Error al recuperar ingredientes");
            }
        }
        producto.setIngredientes(ingredientesRelacion);
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
        return producto;
    }

    @Override
    public ProductoDTO obtenerProducto(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            String jpqlQuery = """
                       SELECT p FROM Producto p LEFT JOIN FETCH p.ingredientes pi WHERE UPPER(p.nombre) = UPPER(:nombre)
                       """;

            TypedQuery<Producto> query = entityManager.createQuery(jpqlQuery, Producto.class);
            query.setParameter("nombre", nombre);
            List<Producto> productos = query.getResultList();

            if (!productos.isEmpty()) {
                Producto producto = productos.get(0);
                ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getTipo());
                List<IngredienteDTO> ingredientes = producto.getIngredientes().stream()
                        .map(pi -> new IngredienteDTO(pi.getIngrediente().getId(), pi.getIngrediente().getNombre(), pi.getIngrediente().getUnidadMedida(), pi.getIngrediente().getCantidadStock()))
                        .collect(Collectors.toList());
                productoDTO.setIngredientes(ingredientes);
                return productoDTO;
            }

        } catch (NoResultException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<ProductoDTO> obtenerProductosExistentes() throws PersistenciaException{
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            String jpqlQuery = """
                            SELECT DISTINCT p FROM Producto p LEFT JOIN FETCH p.ingredientes pi 
                           """;
            TypedQuery<Producto> query = entityManager.createQuery(jpqlQuery, Producto.class);
            List<Producto> productos = query.getResultList();

            if (!productos.isEmpty()) {
                List<ProductoDTO> productosDTO = new ArrayList<>();

                for (Producto producto : productos) {
                    ProductoDTO productoDTO = new ProductoDTO(
                            producto.getId(),
                            producto.getNombre(),
                            producto.getPrecio(),
                            producto.getTipo()
                    );

                    List<IngredienteDTO> ingredientes = new ArrayList<>();
                    for (ProductoIngrediente pi : producto.getIngredientes()) {
                        IngredienteDTO ingredienteDTO = new IngredienteDTO(
                                pi.getIngrediente().getId(),
                                pi.getIngrediente().getNombre(),
                                pi.getIngrediente().getUnidadMedida(),
                                pi.getIngrediente().getCantidadStock()
                        );
                        ingredientes.add(ingredienteDTO);
                    }
                    productoDTO.setIngredientes(ingredientes);
                    productosDTO.add(productoDTO);
                }

                return productosDTO;
            }

        } catch (NoResultException e) {
            throw new PersistenciaException("Error al recuperar los productos.");
        }
        return null;
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosNombre(String filtro) throws PersistenciaException {
                EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            String jpqlQuery = """
                            SELECT DISTINCT p FROM Producto p LEFT JOIN FETCH p.ingredientes pi 
                            WHERE UPPER (p.nombre) LIKE UPPER(:filtro)
                           """;
            TypedQuery<Producto> query = entityManager.createQuery(jpqlQuery, Producto.class);
            query.setParameter("filtro", "%" + filtro + "%");  
            List<Producto> productos = query.getResultList();

            if (!productos.isEmpty()) {
                List<ProductoDTO> productosDTO = new ArrayList<>();

                for (Producto producto : productos) {
                    ProductoDTO productoDTO = new ProductoDTO(
                            producto.getId(),
                            producto.getNombre(),
                            producto.getPrecio(),
                            producto.getTipo()
                    );

                    List<IngredienteDTO> ingredientes = new ArrayList<>();
                    for (ProductoIngrediente pi : producto.getIngredientes()) {
                        IngredienteDTO ingredienteDTO = new IngredienteDTO(
                                pi.getIngrediente().getId(),
                                pi.getIngrediente().getNombre(),
                                pi.getIngrediente().getUnidadMedida(),
                                pi.getIngrediente().getCantidadStock()
                        );
                        ingredientes.add(ingredienteDTO);
                    }
                    productoDTO.setIngredientes(ingredientes);
                    productosDTO.add(productoDTO);
                }

                return productosDTO;
            }

        } catch (NoResultException e) {
            throw new PersistenciaException("Error al recuperar los productos.");
        }
        return null;
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosTipo(String filtro) throws PersistenciaException {
                        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            String jpqlQuery = """
                            SELECT DISTINCT p FROM Producto p LEFT JOIN FETCH p.ingredientes pi 
                            WHERE UPPER (p.tipo) LIKE :filtro
                           """;
            TypedQuery<Producto> query = entityManager.createQuery(jpqlQuery, Producto.class);
            query.setParameter("filtro", "%" + filtro + "%");  
            List<Producto> productos = query.getResultList();

            if (!productos.isEmpty()) {
                List<ProductoDTO> productosDTO = new ArrayList<>();

                for (Producto producto : productos) {
                    ProductoDTO productoDTO = new ProductoDTO(
                            producto.getId(),
                            producto.getNombre(),
                            producto.getPrecio(),
                            producto.getTipo()
                    );

                    List<IngredienteDTO> ingredientes = new ArrayList<>();
                    for (ProductoIngrediente pi : producto.getIngredientes()) {
                        IngredienteDTO ingredienteDTO = new IngredienteDTO(
                                pi.getIngrediente().getId(),
                                pi.getIngrediente().getNombre(),
                                pi.getIngrediente().getUnidadMedida(),
                                pi.getIngrediente().getCantidadStock()
                        );
                        ingredientes.add(ingredienteDTO);
                    }
                    productoDTO.setIngredientes(ingredientes);
                    productosDTO.add(productoDTO);
                }

                return productosDTO;
            }

        } catch (NoResultException e) {
            throw new PersistenciaException("Error al recuperar los productos.");
        }
        return null;
    }

}
