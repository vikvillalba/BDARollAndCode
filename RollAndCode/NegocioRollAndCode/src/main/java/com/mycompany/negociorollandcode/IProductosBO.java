package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import java.util.List;

/**
 * Interfaz para objetos de negocio de productos.
 * @author victoria
 */
public interface IProductosBO {
    public abstract ProductoDTO registrar(NuevoProductoDTO nuevoProductoDTO) throws ProductoException;
    public abstract List<ProductoDTO> obtenerProductosExistentes()throws ProductoException;
    public abstract List<ProductoDTO> obtenerProductosFiltradosNombre(String filtro)throws ProductoException;
    public abstract List<ProductoDTO> obtenerProductosFiltradosTipo(String filtro)throws ProductoException;
    public List<ProductoDTO> obtenerProductosDisponibles(List<ProductoDTO> productos)throws ProductoException;
    
}
