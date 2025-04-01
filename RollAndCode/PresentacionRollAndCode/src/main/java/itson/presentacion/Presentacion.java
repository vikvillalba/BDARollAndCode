package itson.presentacion;

import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.FrmPantallaInicio;

/**
 *
 * @author victoria
 */
public class Presentacion {

    public static void main(String[] args) {
        IMesasBO mesasBO = FabricaObjetosNegocio.crearMesasBO();
        FrmPantallaInicio frmInicio = new FrmPantallaInicio(mesasBO);
        frmInicio.setVisible(true);
    }
}
