package com.mycompany.dominiorollandcode.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * Representa los productos que están incluidos en las comandas en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "productosComandas")
public class ProductoComanda implements Serializable {

    
    @Id
    @Column(name = "idProductoComanda", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "importeProducto", nullable = false)
    private BigDecimal importeProducto;
    
    @Column(name = "cantidadProducto", nullable = false, length = 3)
    private Integer cantidadProducto;
    
    @Column(name = "precioProducto", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioProducto;
    
    @Column(name = "comentario", nullable = false, length = 200)
    private String comentario;
    
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false)
    private Comanda comanda;

    public ProductoComanda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImporteProducto() {
        return importeProducto;
    }

    public void setImporteProducto() {
        this.calcularImporteProducto();
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    @PrePersist
    @PreUpdate
    private void calcularImporteProducto(){
        this.importeProducto = this.precioProducto.multiply(BigDecimal.valueOf(cantidadProducto));
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
}
