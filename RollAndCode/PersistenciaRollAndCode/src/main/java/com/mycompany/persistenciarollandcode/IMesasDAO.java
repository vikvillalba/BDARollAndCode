package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;

/**
 *
 * @author victoria
 */
public interface IMesasDAO {
    public abstract Mesa registrar(NuevaMesaDTO nuevaMesa);
}
