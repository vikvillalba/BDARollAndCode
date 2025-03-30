package com.mycompany.dominiorollandcode.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa una mesa en la base de datos.
 * @author victoria
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

  
    @Id
    @Column(name = "idMesa", nullable = false, unique = true)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true, length = 3)
    private Integer numero;
    
    @OneToMany(mappedBy = "mesa", cascade = CascadeType.PERSIST)
    private List<Comanda> comandas;

    public Mesa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
    
}
