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

    /**
     * Construye un nuevo objeto mesasBO.
     */
    public static IMesasBO crearMesasBO() {
        IMesasDAO mesasDAO = new MesasDAO();
        mesasBO = new MesasBO(mesasDAO);

        return mesasBO;
    }

    /**
     * Construye un nuevo objeto clientesBO
     *
     * @return un clientesBO
     */
    public static IClientesBO crearClientesBO() {
        IClientesDAO clientesDAO = new ClientesDAO();
        clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }

    /**
     * Construye un nuevo objeto ingredientesBO y lo devuelve
     *
     * @return un ingredientesBO
     */
    public static IIngredientesBO crearIngredientesBO() {
        IIngredientesDAO ingredientesDAO = new IngredientesDAO();
        ingredientesBO = new IngredientesBO(ingredientesDAO);

        return ingredientesBO;
    }

    /**
     * Construye un nuevo objeto productosBO y lo devuelve
     *
     * @return un productosBO
     */
    public static IProductosBO crearProductosBO() {
        IProductosDAO productosDAO = new ProductosDAO();
        productosBO = new ProductosBO(productosDAO);
        return productosBO;
    }

    /**
     * Crea un nuevo objeto comandasBO y lo devuelve
     *
     * @return un comandasBO
     */
    public static IComandasBO crearComandasBO() {
        IComandasDAO comandasDAO = new ComandasDAO();
        comandasBO = new ComandasBO(comandasDAO);
        return comandasBO;
    }

}
