package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.PnlBuscadorIngredientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victoria
 */
public class PnlIngredienteExistente extends javax.swing.JPanel {

    private IIngredientesBO ingredientesBO;
    private IngredienteDTO ingredienteDTO;
    private PnlBuscadorIngredientes buscadorIngredientes;

    public PnlIngredienteExistente(IngredienteDTO ingrediente, PnlBuscadorIngredientes buscadorIngredientes) {
        initComponents();
        this.buscadorIngredientes = buscadorIngredientes;
        this.ingredienteDTO = ingrediente;
        this.ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();
        setDatosIngrediente();
    }

    public void setDatosIngrediente() {
        this.lblNombreIngrediente.setText(ingredienteDTO.getNombre());
        this.lblUnidadMedida.setText(ingredienteDTO.getUnidadMedida().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreIngrediente = new javax.swing.JLabel();
        btnAgregarIngrediente = new javax.swing.JButton();
        lblUnidadMedida = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(750, 73));

        lblNombreIngrediente.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblNombreIngrediente.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreIngrediente.setText("NombreIngrediente");

        btnAgregarIngrediente.setBackground(new java.awt.Color(249, 205, 204));
        btnAgregarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarIngrediente.png"))); // NOI18N
        btnAgregarIngrediente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIngredienteActionPerformed(evt);
            }
        });

        lblUnidadMedida.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblUnidadMedida.setForeground(new java.awt.Color(65, 70, 105));
        lblUnidadMedida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUnidadMedida.setText("Unidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(68, 68, 68)
                .addComponent(btnAgregarIngrediente)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnidadMedida)
                            .addComponent(lblNombreIngrediente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnAgregarIngrediente)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredienteActionPerformed
        List<IngredienteDTO> ingredientes = this.buscadorIngredientes.getIngredientesSeleccionados();
        ingredientes.add(this.ingredienteDTO);
        this.btnAgregarIngrediente.setEnabled(false);
        this.buscadorIngredientes.cargarIngredientesSeleccionados();
        this.buscadorIngredientes.setIngredientesSeleccionados(ingredientes);

    }//GEN-LAST:event_btnAgregarIngredienteActionPerformed

    public void activarBotonSeleccion(){
        this.btnAgregarIngrediente.setEnabled(true);
    }

    public IngredienteDTO getIngredienteDTO() {
        return ingredienteDTO;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarIngrediente;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
