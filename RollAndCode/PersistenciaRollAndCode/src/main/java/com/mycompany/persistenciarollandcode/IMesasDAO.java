package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;

/**
 * Interfaz que especifica las acciones de persistencia para las mesas.
 * @author victoria
 */
public interface IMesasDAO {
    public abstract Mesa registrar(NuevaMesaDTO nuevaMesa);
}
