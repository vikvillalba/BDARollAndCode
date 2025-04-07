
package com.mycompany.negociorollandcode;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;

/**
 * Interfaz para objetos de negocio de comandas.
 * @author victoria
 */
public interface IComandasBO {
    public abstract ComandaDTO registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws ComandaException;
}
