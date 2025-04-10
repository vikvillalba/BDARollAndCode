package com.mycompany.dominiorollandcode.entidades;

import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa una comanda en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

   
    @Id
    @Column(name = "idComanda", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "folio", nullable = false, unique = true, length = 30)
    private String folio;
    
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoComanda estado;
    
    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCreacion;

    @Column(name = "totalAcumulado", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalAcumulado;
    
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.PERSIST)
    private List<ProductoComanda> productos;
    
    @ManyToOne
    @JoinColumn(name = "idMesa", nullable = false)
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "idClienteFrecuente", nullable = true)
    private ClienteFrecuente clienteFrecuente;

    public Comanda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getTotalAcumulado() {
        return totalAcumulado;
    }

    public void setTotalAcumulado() {
        calcularImporteTotal();
    }
    @PrePersist
    @PreUpdate
    private void calcularImporteTotal(){
        BigDecimal total = BigDecimal.ZERO;
        if (productos != null) {
            for (ProductoComanda producto : productos) {
                total = total.add(producto.getImporteProducto());
            }
        }
        this.totalAcumulado = total;
    }

    public void setProductos(List<ProductoComanda> productos) {
        this.productos = productos;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setClienteFrecuente(ClienteFrecuente clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
    }

    public List<ProductoComanda> getProductos() {
        return productos;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public ClienteFrecuente getClienteFrecuente() {
        return clienteFrecuente;
    }
    
    
}
