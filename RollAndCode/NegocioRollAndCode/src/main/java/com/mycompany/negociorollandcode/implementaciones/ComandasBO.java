package com.mycompany.negociorollandcode.implementaciones;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.ClienteReporteDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ComandaReporteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import com.mycompany.dominiorollandcode.entidades.ClienteFrecuente;
import com.mycompany.dominiorollandcode.entidades.Comanda;
import com.mycompany.dominiorollandcode.entidades.ProductoComanda;
import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.persistenciarollandcode.IComandasDAO;
import com.mycompany.persistenciarollandcode.excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
        if (nuevaComandaDTO.getProductos().isEmpty()) {
            throw new ComandaException("La comanda debe de contener al menos un producto");
        }
        Random random = new Random();

        int consecutivo = random.nextInt(999) + 1;
        LocalDate fecha = LocalDate.now();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
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

    @Override
    public List<ComandaDTO> obtenerComandasAbiertas() throws ComandaException {
        try {
            List<Comanda> comandas = this.ComandasDAO.obtenerComandasAbiertas();
            List<ComandaDTO> comandasDTO = new ArrayList<>();

            for (Comanda comanda : comandas) {
                ComandaDTO comandaDTO = new ComandaDTO();
                comandaDTO.setId(comanda.getId());
                comandaDTO.setFolio(comanda.getFolio());
                comandaDTO.setFechaHora(comanda.getFechaCreacion());
                comandaDTO.setEstado(comanda.getEstado());
                comandaDTO.setTotalAcumulado(comanda.getTotalAcumulado());

                List<ProductoComandaDTO> productos = new ArrayList<>();
                for (ProductoComanda producto : comanda.getProductos()) {
                    ProductoComandaDTO productoComandaDTO = new ProductoComandaDTO();

                    productoComandaDTO.setIdProducto(producto.getProducto().getId());
                    productoComandaDTO.setIdComanda(comanda.getId());
                    productoComandaDTO.setNombreProducto(producto.getProducto().getNombre());
                    productoComandaDTO.setCantidad(producto.getCantidadProducto());
                    productoComandaDTO.setPrecio(producto.getProducto().getPrecio());
                    productoComandaDTO.setTipo(producto.getProducto().getTipo());
                    productoComandaDTO.setComentario(producto.getComentario());
                    productoComandaDTO.setSubtotal(producto.getImporteProducto());

                    productos.add(productoComandaDTO);
                }

                ClienteFrecuente clienteFrecuente = comanda.getClienteFrecuente();
                if (clienteFrecuente != null) {
                    ClienteDTO cliente = new ClienteDTO(clienteFrecuente.getId(),
                            clienteFrecuente.getNombres(),
                            clienteFrecuente.getApellidoPaterno(),
                            clienteFrecuente.getApellidoMaterno(),
                            clienteFrecuente.getTelefono(),
                            clienteFrecuente.getCorreoElectronico(),
                            clienteFrecuente.getFechaRegistro(),
                            clienteFrecuente.getGastoTotal());
                    comandaDTO.setCliente(cliente);
                }

                comandaDTO.setCliente(null);
                comandaDTO.setProductos(productos);
                comandaDTO.setNumeroMesa(comanda.getMesa().getNumero());
                comandasDTO.add(comandaDTO);
            }

            return comandasDTO;
        } catch (PersistenciaException ex) {
            throw new ComandaException(ex.getMessage());
        }
    }

    @Override
    public ComandaDTO actualizar(ComandaDTO comanda) throws ComandaException {
        if (!comanda.getEstado().equals(EstadoComanda.ABIERTA)) {
            throw new ComandaException("Solamente se pueden editar comandas abiertas.");
        }

        try {
            Comanda comandaActualizada = this.ComandasDAO.actualizar(comanda);

            ComandaDTO comandaDTO = new ComandaDTO();
            comandaDTO.setId(comandaActualizada.getId());
            comandaDTO.setFolio(comandaActualizada.getFolio());
            comandaDTO.setFechaHora(comandaActualizada.getFechaCreacion());
            comandaDTO.setEstado(comandaActualizada.getEstado());
            comandaDTO.setTotalAcumulado(comandaActualizada.getTotalAcumulado());

            List<ProductoComandaDTO> productos = new ArrayList<>();
            for (ProductoComanda producto : comandaActualizada.getProductos()) {
                ProductoComandaDTO productoComandaDTO = new ProductoComandaDTO();

                productoComandaDTO.setIdProducto(producto.getProducto().getId());
                productoComandaDTO.setIdComanda(comandaActualizada.getId());
                productoComandaDTO.setNombreProducto(producto.getProducto().getNombre());
                productoComandaDTO.setCantidad(producto.getCantidadProducto());
                productoComandaDTO.setPrecio(producto.getProducto().getPrecio());
                productoComandaDTO.setTipo(producto.getProducto().getTipo());
                productoComandaDTO.setComentario(producto.getComentario());
                productoComandaDTO.setSubtotal(producto.getImporteProducto());

                productos.add(productoComandaDTO);
            }

            ClienteFrecuente clienteFrecuente = comandaActualizada.getClienteFrecuente();
            if (clienteFrecuente != null) {
                ClienteDTO cliente = new ClienteDTO(clienteFrecuente.getId(),
                        clienteFrecuente.getNombres(),
                        clienteFrecuente.getApellidoPaterno(),
                        clienteFrecuente.getApellidoMaterno(),
                        clienteFrecuente.getTelefono(),
                        clienteFrecuente.getCorreoElectronico(),
                        clienteFrecuente.getFechaRegistro(),
                        clienteFrecuente.getGastoTotal());
                comandaDTO.setCliente(cliente);
            }

            comandaDTO.setCliente(null);
            comandaDTO.setProductos(productos);
            comandaDTO.setNumeroMesa(comandaActualizada.getMesa().getNumero());

            return comandaDTO;

        } catch (PersistenciaException ex) {
            throw new ComandaException(ex.getMessage());
        }
    }

    @Override
    public ComandaDTO entregar(ComandaDTO comandaDTO) throws ComandaException {
        if (comandaDTO.getEstado() == EstadoComanda.CANCELADA) {
            throw new ComandaException("No se puede entregar una comanda que ya se marcó como cancelada.");
        }

        try {
            comandaDTO.setEstado(EstadoComanda.ENTREGADA);
            Comanda comanda = ComandasDAO.cambiarEstado(comandaDTO);
            comandaDTO.setEstado(comanda.getEstado());

            if (comandaDTO.getEstado() != EstadoComanda.ENTREGADA) {
                throw new ComandaException("La comanda no se pudo entregar correctamente.");
            }
            return comandaDTO;
        } catch (PersistenciaException ex) {
            throw new ComandaException(ex.getMessage());
        }
    }

    @Override
    public ComandaDTO cancelar(ComandaDTO comandaDTO) throws ComandaException {
        if (comandaDTO.getEstado() == EstadoComanda.ENTREGADA) {
            throw new ComandaException("No se puede cancelar una comanda que ya se marcó como entregada.");
        }

        try {
            comandaDTO.setEstado(EstadoComanda.CANCELADA);
            Comanda comanda = ComandasDAO.cambiarEstado(comandaDTO);
            comandaDTO.setEstado(comanda.getEstado());

            if (comandaDTO.getEstado() != EstadoComanda.CANCELADA) {
                throw new ComandaException("La comanda no se pudo cancelar correctamente.");
            }
            return comandaDTO;
        } catch (PersistenciaException ex) {
            throw new ComandaException(ex.getMessage());
        }
    }

    public List<ComandaReporteDTO> obtenerComandasReporte(Calendar fechaInicio, Calendar fechaFin) {
        return ComandasDAO.obtenerComandasReporte(fechaInicio, fechaFin);
    }
    
    public List<ClienteReporteDTO> obtenerReporteClientesFrecuentes(String nombreFiltro, Integer minVisitas){
        return ComandasDAO.obtenerReporteClientesFrecuentes(nombreFiltro, minVisitas);
    }
}
