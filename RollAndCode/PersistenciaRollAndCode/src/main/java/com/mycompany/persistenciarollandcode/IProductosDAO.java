package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que establece las operaciones de persistencia para los productos.
 * @author victoria
 */
public interface IProductosDAO {
    public abstract Producto registrar(NuevoProductoDTO nuevoProductoDTO) throws PersistenciaException;
    public abstract ProductoDTO obtenerProducto(String nombre);
    public abstract List<ProductoDTO>obtenerProductosExistentes()throws PersistenciaException;
    public abstract List<ProductoDTO>obtenerProductosFiltradosNombre(String filtro)throws PersistenciaException;
    public abstract List<ProductoDTO>obtenerProductosFiltradosTipo(String filtro)throws PersistenciaException;
    
    
}
