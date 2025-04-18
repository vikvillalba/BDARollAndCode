
package com.mycompany.dominiorollandcode.dtos;

import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import java.util.Calendar;
import java.util.List;

/**
 * Clase de transporte para una nueva comanda que se va a registrar.
 * @author victoria
 */
public class NuevaComandaDTO {
    private String folio;
    private EstadoComanda estado;
    private Calendar fechaCreacion;
    private List<NuevoProductoComandaDTO> productos;
    private MesaDTO mesa;
    private ClienteDTO cliente;

    public NuevaComandaDTO() {
        this.estado = EstadoComanda.ABIERTA;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<NuevoProductoComandaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<NuevoProductoComandaDTO> productos) {
        this.productos = productos;
    }

    public MesaDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

   
    
}
