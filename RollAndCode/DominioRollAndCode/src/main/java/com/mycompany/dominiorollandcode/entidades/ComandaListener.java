
package com.mycompany.dominiorollandcode.entidades;

import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import java.io.Serializable;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Listener para actualizar el stock de los ingredientes cuando su comanda se marque como entregada.
 * @author victoria
 */

public class ComandaListener implements Serializable {

    /** Se ejecuta cuando una comanda se agrega a la bd o se actualiza.
     * Notifica solamente cuando la comanda se marca como entregada.
     */
  @PostUpdate
  public void notificarComandaEntregada(Comanda comanda){
      if(EstadoComanda.ENTREGADA.equals(comanda.getEstado())){
          actualizarIngredientes(comanda);
      }
  }
  
  public void actualizarIngredientes(Comanda comanda){
      for(ProductoComanda productoComanda : comanda.getProductos()){
          Producto producto = productoComanda.getProducto();
          
          for(ProductoIngrediente productoIngrediente : producto.getIngredientes()){
              Ingrediente ingrediente = productoIngrediente.getIngrediente();
              
              Integer stockRestante = ingrediente.getCantidadStock() - (productoIngrediente.getCantidad() * productoComanda.getCantidadProducto());
              if (stockRestante < 0) {
                    throw new RuntimeException("No hay suficiente stock del ingrediente: " + ingrediente.getNombre());
                }
              
              ingrediente.setCantidadStock(stockRestante);
          }
      }
  }
  
    
}
