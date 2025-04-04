package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.dominiorollandcode.entidades.Producto;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;

/**
 * Interfaz que establece las operaciones de persistencia para los productos.
 * @author victoria
 */
public interface IProductosDAO {
    public abstract Producto registrar(NuevoProductoDTO nuevoProductoDTO) throws PersistenciaException;
    public abstract ProductoDTO obtenerProducto(String nombre);
}
