package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.MesaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import java.util.List;

/**
 * Interfaz que especifica las acciones de persistencia para las mesas.
 * @author victoria
 */
public interface IMesasDAO {
    public abstract Mesa registrar(NuevaMesaDTO nuevaMesa);
    public abstract List<MesaDTO> obtenerMesas();
}
