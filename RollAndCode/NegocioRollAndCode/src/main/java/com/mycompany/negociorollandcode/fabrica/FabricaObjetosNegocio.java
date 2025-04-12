package com.mycompany.negociorollandcode.fabrica;

import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.implementaciones.ClientesBO;
import com.mycompany.negociorollandcode.implementaciones.ComandasBO;
import com.mycompany.negociorollandcode.implementaciones.IngredientesBO;
import com.mycompany.negociorollandcode.implementaciones.MesasBO;
import com.mycompany.negociorollandcode.implementaciones.ProductosBO;
import com.mycompany.persistenciarollandcode.IClientesDAO;
import com.mycompany.persistenciarollandcode.IComandasDAO;
import com.mycompany.persistenciarollandcode.IIngredientesDAO;
import com.mycompany.persistenciarollandcode.IMesasDAO;
import com.mycompany.persistenciarollandcode.IProductosDAO;
import com.mycompany.persistenciarollandcode.implementaciones.ClientesDAO;
import com.mycompany.persistenciarollandcode.implementaciones.ComandasDAO;
import com.mycompany.persistenciarollandcode.implementaciones.IngredientesDAO;
import com.mycompany.persistenciarollandcode.implementaciones.MesasDAO;
import com.mycompany.persistenciarollandcode.implementaciones.ProductosDAO;

/**
 *
 * @author victoria
 */
public class FabricaObjetosNegocio {

    private static IMesasBO mesasBO;
    private static IIngredientesBO ingredientesBO;
    private static IClientesBO clientesBO;
    private static IProductosBO productosBO;
    private static IComandasBO comandasBO;

    public static IMesasBO crearMesasBO() {
        IMesasDAO mesasDAO = new MesasDAO();
        mesasBO = new MesasBO(mesasDAO);

        return mesasBO;
    }

    public static IClientesBO crearClientesBO() {
        IClientesDAO clientesDAO = new ClientesDAO();
        clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }

    public static IIngredientesBO crearIngredientesBO() {
        IIngredientesDAO ingredientesDAO = new IngredientesDAO();
        ingredientesBO = new IngredientesBO(ingredientesDAO);

        return ingredientesBO;
    }

    public static IProductosBO crearProductosBO() {
        IProductosDAO productosDAO = new ProductosDAO();
        productosBO = new ProductosBO(productosDAO);
        return productosBO;
    }

    public static IComandasBO crearComandasBO() {
        IComandasDAO comandasDAO = new ComandasDAO();
        comandasBO = new ComandasBO(comandasDAO);
        return comandasBO;
    }

}
