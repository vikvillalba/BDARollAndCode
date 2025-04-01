package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.MesaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;

/**
 * Interfaz para objetos de negocio de mesas.
 * @author victoria
 */
public interface IMesasBO {
    public abstract MesaDTO agregar(NuevaMesaDTO nuevaMesa);
    
}
