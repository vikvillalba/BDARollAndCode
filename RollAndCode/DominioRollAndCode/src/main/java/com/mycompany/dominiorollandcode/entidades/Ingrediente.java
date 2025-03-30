package com.mycompany.dominiorollandcode.entidades;

import com.mycompany.dominiorollandcode.enums.UnidadMedida;
import java.io.Serializable;
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
 * Representa un ingrediente en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

   
    @Id
    @Column(name = "idIngrediente", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Column(name = "nombre", nullable = false,  length = 50)
    private String nombre;
    
    @Column(name = "unidadMedida", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;
    
    @Column(name = "cantidadStock", nullable = false, length = 6)
    private Integer cantidadStock;
    
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.PERSIST)
    private List<ProductoIngrediente> productos;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dominiorollandcode.entidades.Ingrediente[ id=" + id + " ]";
    }
    
}
