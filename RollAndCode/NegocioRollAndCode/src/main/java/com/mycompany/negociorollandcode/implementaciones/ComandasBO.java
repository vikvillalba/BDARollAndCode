package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.persistenciarollandcode.IComandasDAO;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

/**
 * Clase que implementa la interfaz IComandasBO
 *
 * @author victoria
 */
public class ComandasBO implements IComandasBO {

    private IComandasDAO ComandasDAO;

    public ComandasBO(IComandasDAO ComandasDAO) {
        this.ComandasDAO = ComandasDAO;
    }

    @Override
    public ComandaDTO registrarComanda(NuevaComandaDTO nuevaComandaDTO) throws ComandaException {
        Random random = new Random();

        int consecutivo = random.nextInt(999) + 1;
        LocalDate fecha = LocalDate.now();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String consecutivoFormateado = String.format("%03d", consecutivo);

        String folio = "OB-" + fechaFormateada + "-" + consecutivoFormateado;
        Calendar fechaComanda = Calendar.getInstance();

        nuevaComandaDTO.setFolio(folio);
        nuevaComandaDTO.setFechaCreacion(fechaComanda);
        nuevaComandaDTO.setEstado(EstadoComanda.ABIERTA);

        try {
            Comanda comanda = this.ComandasDAO.registrarComanda(nuevaComandaDTO);

            ComandaDTO comandaRegistrada = new ComandaDTO();
            comandaRegistrada.setId(comanda.getId());
            comandaRegistrada.setEstado(comanda.getEstado());
            comandaRegistrada.setFechaHora(comanda.getFechaCreacion());
            comandaRegistrada.setFolio(comanda.getFolio());
            comandaRegistrada.setTotalAcumulado(comanda.getTotalAcumulado());

            return comandaRegistrada;

        } catch (PersistenciaException ex) {
            throw new ComandaException(ex.getMessage());
        }
    }

}
