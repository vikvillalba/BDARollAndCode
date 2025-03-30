package itson.presentacion;

import itson.presentacion.frames.FrmPantallaInicio;

/**
 *
 * @author victoria
 */
public class ControlNavegacion {
    private static FrmPantallaInicio frmInicio;
    
    public static void mostrarPantallaInicio(){
       frmInicio = new FrmPantallaInicio();
       frmInicio.setVisible(true);
    }
}
