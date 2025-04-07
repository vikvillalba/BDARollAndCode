
package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;

/**
 * Interfaz para operaciones de persistencia de comandas.
 * @author victoria
 */
public interface IComandasDAO {
    public abstract Comanda registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws PersistenciaException;
}
