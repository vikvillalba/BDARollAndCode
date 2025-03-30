package com.mycompany.dominiorollandcode.entidades;

import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa un producto en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

 
    @Id
    @Column(name = "idProducto", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;
    
    @Column(name = "precio", nullable = false, precision = 8, scale = 2)
    private BigDecimal precio;
    
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductoTipos tipo;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST)
    private List<ProductoComanda> comandas;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST)
    private List<ProductoIngrediente> ingredientes;

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public ProductoTipos getTipo() {
        return tipo;
    }

    public void setTipo(ProductoTipos tipo) {
        this.tipo = tipo;
    }
    
   
    
}
