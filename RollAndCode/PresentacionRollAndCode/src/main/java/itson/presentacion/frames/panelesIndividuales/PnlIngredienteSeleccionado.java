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
        lblNombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
                .addContainerGap()
                .addComponent(lblNombreIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(19, 19, 19)
                        .addComponent(lblNombreIngrediente)))
                .addGap(0, 2, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngredienteActionPerformed
        List<IngredienteDTO> ingredientes = this.buscadorIngredientes.getIngredientesSeleccionados();
        List<PnlIngredienteExistente> ingredientesExistentes = this.buscadorIngredientes.getPnlIngredientesExistentes();

        ingredientes.remove(this.ingredienteDTO);
        this.buscadorIngredientes.setIngredientesSeleccionados(ingredientes);

        this.buscadorIngredientes.cargarIngredientesSeleccionados();
        for (PnlIngredienteExistente panelExistente : ingredientesExistentes) {
            if (panelExistente.getIngredienteDTO().equals(this.ingredienteDTO)) {
                panelExistente.activarBotonSeleccion();
                panelExistente.setVisible(true);
                panelExistente.revalidate();
                panelExistente.repaint();
                break; 
            }
        }

        this.buscadorIngredientes.getPnlIngredientes().revalidate();
        this.buscadorIngredientes.getPnlIngredientes().repaint();
    }//GEN-LAST:event_btnEliminarIngredienteActionPerformed

    public IngredienteDTO getIngredienteDTO() {
        return ingredienteDTO;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarIngrediente;
    private javax.swing.JLabel lblNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}
