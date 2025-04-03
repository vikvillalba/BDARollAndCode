package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import itson.presentacion.frames.PnlBuscadorIngredientes;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlIngredienteSeleccionado extends javax.swing.JPanel {

    private IngredienteDTO ingredienteDTO;
    private PnlBuscadorIngredientes buscadorIngredientes;
    private PnlIngredienteExistente ingredienteExistente;

    public PnlIngredienteSeleccionado(IngredienteDTO ingredienteDTO, PnlBuscadorIngredientes buscadorIngredientes ) {
        initComponents();
        this.ingredienteDTO = ingredienteDTO;
        this.buscadorIngredientes = buscadorIngredientes;
        this.lblNombreIngrediente.setText(ingredienteDTO.getNombre());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreIngrediente = new javax.swing.JLabel();
        btnEliminarIngrediente = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(300, 56));

        lblNombreIngrediente.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblNombreIngrediente.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreIngrediente.setText("NombreIngrediente");

        btnEliminarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/eliminarIngrediente.png"))); // NOI18N
        btnEliminarIngrediente.setBorder(null);
        btnEliminarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIngredienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnEliminarIngrediente)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEliminarIngrediente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreIngrediente)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngredienteActionPerformed
        List<IngredienteDTO> ingredientes = this.buscadorIngredientes.getIngredientesSeleccionados();
        ingredientes.remove(ingredienteDTO);

        this.buscadorIngredientes.setIngredientesSeleccionados(ingredientes);
        this.buscadorIngredientes.cargarIngredientesSeleccionados();

        PnlIngredienteExistente panelIngredienteExistente = this.buscadorIngredientes.getPanelIngredienteExistente(ingredienteDTO);
        if (panelIngredienteExistente != null) {
            panelIngredienteExistente.activarBotonSeleccion();
        }

    }//GEN-LAST:event_btnEliminarIngredienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarIngrediente;
    private javax.swing.JLabel lblNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}
