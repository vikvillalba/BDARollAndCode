package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz para operaciones de persistencia de comandas.
 *
 * @author victoria
 */
public interface IComandasDAO {

    public abstract Comanda registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws PersistenciaException;

    public abstract List<Comanda> obtenerComandasAbiertas() throws PersistenciaException;

    public abstract Comanda actualizar(ComandaDTO comanda) throws PersistenciaException;

    public abstract Comanda cambiarEstado(ComandaDTO comandaDTO) throws PersistenciaException;

    public abstract void actualizarIngredientes(Comanda comanda) throws PersistenciaException;
}
