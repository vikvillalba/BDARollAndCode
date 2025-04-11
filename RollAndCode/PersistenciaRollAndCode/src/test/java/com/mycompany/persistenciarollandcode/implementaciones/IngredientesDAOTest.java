package com.mycompany.persistenciarollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.entidades.Ingrediente;
import com.mycompany.dominiorollandcode.enums.UnidadMedida;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author victoria
 */
public class IngredientesDAOTest {

    public IngredientesDAOTest() {
    }

    @Test
    public void testRegistrarOK() {
        IngredientesDAO dao = new IngredientesDAO();
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO("HARINA", UnidadMedida.GRAMOS, 1500);
        Ingrediente ingredienteRegistrado = dao.registrar(nuevoIngrediente);

        assertNotNull(ingredienteRegistrado.getId());
        assertEquals(nuevoIngrediente.getNombre(), ingredienteRegistrado.getNombre());
        assertEquals(nuevoIngrediente.getUnidadMedida(), ingredienteRegistrado.getUnidadMedida());

    }

    @Test
    public void testActualizarStockLanzaExcepcion() {
        IngredientesDAO dao = new IngredientesDAO();
        IngredienteDTO ingredienteActualizar = new IngredienteDTO(99L, "café", UnidadMedida.PIEZA, 90);

        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> dao.actualizarStock(ingredienteActualizar));
        String mensajeExcepcionEsperado = "No se encontró el ingrediente.";
        assertEquals(mensajeExcepcionEsperado, ex.getMessage());
    }

    @Test
    public void testActualizarStockOK() throws PersistenciaException {
        IngredientesDAO dao = new IngredientesDAO();
        IngredienteDTO ingrediente = new IngredienteDTO(1L, "MATCHA EN POLVO", UnidadMedida.GRAMOS, 90);
        IngredienteDTO ingredienteActualizar = dao.actualizarStock(ingrediente);
        assertNotNull(ingredienteActualizar.getId());

    }

    @Test
    public void obtenerIngredientesExistentes() {
        IngredientesDAO dao = new IngredientesDAO();

        final int NUMERO_INGREDIENTES = 7; // cambiar dependiendo de la bd sobre la que se esta probando
        List<IngredienteDTO> ingredientes = dao.obtenerIngredientesExistentes();
        assertNotNull(ingredientes);
        assertEquals(NUMERO_INGREDIENTES, ingredientes.size());

    }

    @Test
    public void obtenerIngredientesExistentesNombre() throws PersistenciaException {
        IngredientesDAO dao = new IngredientesDAO();

        final String FILTRO = "MATCHA"; // cambiar dependiendo de la bd sobre la que se esta probando
        final int NUMERO_INGREDIENTES = 1; // cambiar dependiendo de la bd sobre la que se esta probando
        List<IngredienteDTO> ingredientes = dao.obtenerIngredientesFiltradosNombre(FILTRO);
        assertNotNull(ingredientes);
        assertEquals(NUMERO_INGREDIENTES, ingredientes.size());

    }

    @Test
    public void obtenerIngredientesExistentesUnidadMedida() throws PersistenciaException {
        IngredientesDAO dao = new IngredientesDAO();

        final String FILTRO = "GRAMOS"; // cambiar dependiendo de la bd sobre la que se esta probando
        final int NUMERO_INGREDIENTES = 4; // cambiar dependiendo de la bd sobre la que se esta probando
        List<IngredienteDTO> ingredientes = dao.obtenerIngredientesFiltradosUnidadMedida(FILTRO);
        assertNotNull(ingredientes);
        assertEquals(NUMERO_INGREDIENTES, ingredientes.size());

    }

    @Test
    public void obtenerIngrediente() throws PersistenciaException {
        IngredientesDAO dao = new IngredientesDAO();
        IngredienteDTO ingrediente = new IngredienteDTO(1L, "MATCHA EN POLVO", UnidadMedida.GRAMOS, 90); // cambiar dependiendo de la bd sobre la que se esta probando
        
        IngredienteDTO ingredienteObtenido = dao.obtenerIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida().toString());
        assertNotNull(ingredienteObtenido);
        assertEquals(ingrediente.getNombre(), ingredienteObtenido.getNombre());
        assertEquals(ingrediente.getUnidadMedida(), ingredienteObtenido.getUnidadMedida());
        

    }
}
