package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.persistenciarollandcode.IProductosDAO;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz para operaciones de negocio de productos.
 * @author victoria
 */
public class ProductosBO implements IProductosBO{
    private IProductosDAO productosDAO;

    public ProductosBO(IProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }

    @Override
    public ProductoDTO registrar(NuevoProductoDTO nuevoProductoDTO) throws ProductoException {

        if (nuevoProductoDTO.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductoException("El precio no puede ser una cantidad negativa.");
        }
        try {
            ProductoDTO productoExistente = this.productosDAO.obtenerProducto(nuevoProductoDTO.getNombre());
            if (productoExistente != null) {
                throw new ProductoException("Ya existe un producto registrado con el mismo nombre. Inicie el proceso nuevamente.");
            }
            Producto producto = this.productosDAO.registrar(nuevoProductoDTO);
            ProductoDTO productoRegistrado = new ProductoDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getTipo()
            );
            return productoRegistrado;
        } catch (PersistenciaException ex) {
            throw new ProductoException("Ocurrió un error al registrar el producto. Inicie el proceso nuevamente.");
        }
    }


    @Override
    public List<ProductoDTO> obtenerProductosExistentes() throws ProductoException {
        try {
            return this.productosDAO.obtenerProductosExistentes();
        } catch (PersistenciaException ex) {
            throw new ProductoException(ex.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosNombre(String filtro) throws ProductoException {
        if(filtro.isBlank()){
            throw new ProductoException("No se ingresó ningún valor para realizar la búsqueda.");
        }
        
        List<ProductoDTO> productos;
        
        try {
            productos = this.productosDAO.obtenerProductosFiltradosNombre(filtro.toUpperCase());
            if(productos == null){
                   throw new ProductoException("No existen productos con las especificaciones dadas.");
               }
               return productos;
        } catch (PersistenciaException ex) {
            throw new ProductoException(ex.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosTipo(String filtro) throws ProductoException {
        filtro = filtro.toUpperCase().trim();
        for (ProductoTipos tipo : ProductoTipos.values()) {
            if (tipo.name().equals(filtro)) {
                try {
                    List<ProductoDTO> productos = this.productosDAO.obtenerProductosFiltradosTipo(filtro);
                    return productos;

                } catch (PersistenciaException ex) {

                    throw new ProductoException(ex.getMessage());
                }
            }
        }
        throw new ProductoException("Filtro de búsqueda inválido");
    }

    @Override
    public List<ProductoDTO> obtenerProductosDisponibles(List<ProductoDTO> productos) throws ProductoException {
        List<ProductoDTO> productosDisponibles = new ArrayList<>();
        for (ProductoDTO producto : productos) {
            try {
                boolean disponible = true;
                List<ProductoIngredienteDTO> ingredientes = this.productosDAO.obtenerProductosIngrediente(producto.getId());
                List<IngredienteDTO> ingredientesNecesarios = producto.getIngredientes();

                for (ProductoIngredienteDTO ingrediente : ingredientes) {
                    for (IngredienteDTO ingredienteNecesario : ingredientesNecesarios) {
                        if (ingredienteNecesario.getId().equals(ingrediente.getIdIngrediente())) {
                            if (ingrediente.getCantidad() > ingredienteNecesario.getCantidadStock()) {
                                disponible = false;
                                break;

                            }
                        }
                    }
                    if (!disponible) {
                        break;
                    }

                }
                if (disponible) {
                    productosDisponibles.add(producto);
                }

            } catch (PersistenciaException ex) {
                throw new ProductoException(ex.getMessage());
            }

        }
        return productosDisponibles;
    }


}
