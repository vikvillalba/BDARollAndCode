package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import java.util.List;

/**
 * Interfaz para objetos de negocio de productos.
 * @author victoria
 */
public interface IProductosBO {
    public abstract ProductoDTO registrar(NuevoProductoDTO nuevoProductoDTO);
    public abstract List<ProductoDTO> obtenerProductosExistentes();
    public abstract List<ProductoDTO> buscarProductosFiltrados(String filtro);
    
}
