package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.ClienteReporteDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaReporteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz para objetos de negocio de comandas.
 *
 * @author victoria
 */
public interface IComandasBO {

    public abstract ComandaDTO registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws ComandaException;

    public abstract List<ComandaDTO> obtenerComandasAbiertas() throws ComandaException;

    public abstract ComandaDTO actualizar(ComandaDTO comanda) throws ComandaException;

    public abstract ComandaDTO entregar(ComandaDTO comanda) throws ComandaException;

    public abstract ComandaDTO cancelar(ComandaDTO comanda) throws ComandaException;

    public abstract List<ComandaReporteDTO> obtenerComandasReporte(Calendar fechaInicio, Calendar fechaFin);

    public abstract List<ClienteReporteDTO> obtenerReporteClientesFrecuentes(String nombreFiltro, Integer minVisitas);
}
