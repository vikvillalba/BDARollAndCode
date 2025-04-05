package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.MesaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaMesaDTO;
import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import java.util.List;

/**
 * Clase que implementa la interfaz IMesasBO
 * @author victoria
 */
public class MesasBO implements IMesasBO{
    private IMesasDAO mesasDAO;

    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }
    

    @Override
    public MesaDTO agregar(NuevaMesaDTO nuevaMesa) {
        Mesa mesa = this.mesasDAO.registrar(nuevaMesa);
        MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getNumero());
        return mesaDTO;
    }

    @Override
    public List<MesaDTO> obtenerMesas() {
        return this.mesasDAO.obtenerMesas();
    }

    @Override
    public MesaDTO obtenerMesa(Integer numero) {
        return this.mesasDAO.obtenerMesa(numero);
    }
    
}
