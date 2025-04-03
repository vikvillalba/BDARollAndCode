package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;

/**
 * Representa un ingrediente registrado, con la opción de añadir stock
 * @author victoria
 */
public class PnlIngredienteStock extends javax.swing.JPanel {

    private IIngredientesBO ingredientesBO;
    private IngredienteDTO ingredienteDTO;
    
    public PnlIngredienteStock(IngredienteDTO ingrediente) {
        initComponents();
        this.ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();
        this.ingredienteDTO = ingrediente;
    }

    public void setDatosIngrediente(String nombreIngrediente, String stock, String unidadMedida){
        this.lblNombreIngrediente.setText(nombreIngrediente);
        this.lblStock.setText(stock);
        this.lblUnidadMedida.setText(unidadMedida);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreIngrediente = new javax.swing.JLabel();
        btnAgregarStock = new javax.swing.JButton();
        lblUnidadMedida = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(1200, 73));

        lblNombreIngrediente.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblNombreIngrediente.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreIngrediente.setText("NombreIngrediente");

        btnAgregarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarStock.png"))); // NOI18N
        btnAgregarStock.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarStockActionPerformed(evt);
            }
        });

        lblUnidadMedida.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblUnidadMedida.setForeground(new java.awt.Color(65, 70, 105));
        lblUnidadMedida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnidadMedida.setText("UnidadMedida");

        lblStock.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblStock.setForeground(new java.awt.Color(65, 70, 105));
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnAgregarStock)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregarStock))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreIngrediente)
                            .addComponent(lblUnidadMedida)
                            .addComponent(lblStock))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarStockActionPerformed
        AgregarStock popUpAgregarStock = new AgregarStock(this, ingredientesBO, ingredienteDTO);
        popUpAgregarStock.setVisible(true);

    }//GEN-LAST:event_btnAgregarStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarStock;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
