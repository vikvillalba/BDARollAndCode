/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciarollandcode;

import com.mycompany.dominiorollandcode.entidades.Mesa;
import com.mycompany.persistenciarollandcode.conexion.IManejadorConexiones;
import com.mycompany.persistenciarollandcode.conexion.ManejadorConexiones;
import javax.persistence.EntityManager;

/**
 *
 * @author victoria
 */
public class PersistenciaRollAndCode {

    public static void main(String[] args) {
        IManejadorConexiones conexion = new ManejadorConexiones();
        EntityManager em = conexion.crearConexion();
        
        try {
        em.getTransaction().begin();
        Mesa mesa = new Mesa();
        mesa.setNumero(1);
        em.persist(mesa);
        em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
    }
}
