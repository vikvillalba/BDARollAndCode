package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.persistenciarollandcode.IProductosDAO;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.math.BigDecimal;
import java.util.List;

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
    public List<ProductoDTO> obtenerProductosExistentes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDTO> buscarProductosFiltrados(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
