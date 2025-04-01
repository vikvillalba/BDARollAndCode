package com.mycompany.negociorollandcode.fabrica;

import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.implementaciones.MesasBO;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import com.mycompany.persistenciarollandcode.implementaciones.MesasDAO;

/**
 *
 * @author victoria
 */
public class FabricaObjetosNegocio {
    public static IMesasBO crearMesasBO(){
        IMesasDAO mesasDAO = new MesasDAO();
        IMesasBO mesasBO = new MesasBO(mesasDAO);
        return mesasBO;
    }
}
