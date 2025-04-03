package com.mycompany.negociorollandcode.fabrica;

import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.implementaciones.ClientesBO;
import com.mycompany.negociorollandcode.implementaciones.IngredientesBO;
import com.mycompany.negociorollandcode.implementaciones.MesasBO;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import com.mycompany.persistenciarollandcode.implementaciones.ClientesDAO;
import com.mycompany.persistenciarollandcode.implementaciones.IngredientesDAO;
import com.mycompany.persistenciarollandcode.implementaciones.MesasDAO;

/**
 *
 * @author victoria
 */
public class FabricaObjetosNegocio {
    
    private static IMesasBO mesasBO;
    private static IIngredientesBO ingredientesBO;
    private static IClientesBO clientesBO;

    // implementando el patron singleton
    public static IMesasBO crearMesasBO() {
        if (mesasBO == null) {
            IMesasDAO mesasDAO = new MesasDAO();
            mesasBO = new MesasBO(mesasDAO);
        }

        return mesasBO;
    }

    public static IClientesBO crearClientesBO() {
        if (clientesBO == null) {
            IClientesDAO clientesDAO = new ClientesDAO();
            clientesBO = new ClientesBO(clientesDAO);
        }

        return clientesBO;
    }

    public static IIngredientesBO crearIngredientesBO() {
        if (ingredientesBO == null) {
            IIngredientesDAO ingredientesDAO = new IngredientesDAO();
            ingredientesBO = new IngredientesBO(ingredientesDAO);
        }

        return ingredientesBO;
    }
}
