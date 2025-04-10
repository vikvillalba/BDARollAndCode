
package com.mycompany.dominiorollandcode.entidades;

import com.mycompany.dominiorollandcode.enums.TipoUsuario;

/**
 *
 * @author victoria
 */
public class Usuario {
    private TipoUsuario tipoUsuario;

    public Usuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    
}
