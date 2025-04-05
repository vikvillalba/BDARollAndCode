package com.mycompany.dominiorollandcode.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa un cliente frecuente en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "clientesFrecuentes")
public class ClienteFrecuente implements Serializable {

  
    @Id
    @Column(name = "idClienteFrecuente", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "correoElectronico", nullable = true, unique = true, length = 120)
    private String correoElectronico;
    
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    
    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;
   
    @Column(name = "telefono", nullable = false, length = 44, unique = true)
    private String telefono;
    
    @Column(name = "fechaRegistro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRegistro;
    
    @Column(name = "cantidadVisitas", nullable = true, length = 6)
    private Integer cantidadVisitas;
    
    @Column(name = "gastoTotal", nullable = true, precision = 8, scale = 2)
    private BigDecimal gastoTotal;
    
    @Column(name = "puntosFidelidad", nullable = true, length = 5)
    private Integer puntosFidelidad;
    
    @OneToMany(mappedBy = "clienteFrecuente", cascade = CascadeType.PERSIST)
    private List<Comanda> comandas;

    public ClienteFrecuente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(Integer cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public BigDecimal getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(BigDecimal gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }
    
    @PrePersist
    @PreUpdate
    private void calcularPuntosFidelidad(){
        if (gastoTotal != null) {
            this.puntosFidelidad = gastoTotal.divide(BigDecimal.valueOf(20), RoundingMode.DOWN).intValue();
        } else {
            this.puntosFidelidad = 0;
        }
    }
}
