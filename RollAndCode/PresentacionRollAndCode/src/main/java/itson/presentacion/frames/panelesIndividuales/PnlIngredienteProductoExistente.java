package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.IngredienteProductoDTO;
import itson.presentacion.frames.PnlEditarProductoExistente;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlIngredienteProductoExistente extends javax.swing.JPanel {

    private IngredienteProductoDTO ingrediente;
    private PnlEditarProductoExistente pnlEditarProductoExistente;
    
    public PnlIngredienteProductoExistente(IngredienteProductoDTO ingrediente) {
        initComponents();
        this.ingrediente = ingrediente;
        setDatos();
    }
    
    private void setDatos(){
        this.lblNombreIngrediente.setText(ingrediente.getNombre());
        this.lblUnidadMedida.setText(ingrediente.getUnidadMedida().toString());
        if(ingrediente.getCantidadProducto() == null || ingrediente.getCantidadProducto() == 0){
             this.txtCantidadIngrediente.setText("");
        }
        this.txtCantidadIngrediente.setText(ingrediente.getCantidadProducto().toString());
        this.txtCantidadIngrediente.setEditable(false);
        
    }

    public String getCantidadTxt(){
        return this.txtCantidadIngrediente.getText();
    }

    public IngredienteProductoDTO getIngrediente() {
        return ingrediente;
    }

    public void eliminarBotonEliminar() {
        btnEliminarIngrediente.setVisible(false);

    }

    public void activarEdicionCantidad(){
        this.txtCantidadIngrediente.setEditable(true);
    }
    
    public void setPnlEditarProducto(PnlEditarProductoExistente pnlEditarProductoExistente){
        this.pnlEditarProductoExistente = pnlEditarProductoExistente;   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUnidadMedida = new javax.swing.JLabel();
        txtCantidadIngrediente = new javax.swing.JTextField();
        lblCantidadRequerida = new javax.swing.JLabel();
        lblNombreIngrediente = new javax.swing.JLabel();
        btnEliminarIngrediente = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 205, 204));

        lblUnidadMedida.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblUnidadMedida.setForeground(new java.awt.Color(65, 70, 105));
        lblUnidadMedida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnidadMedida.setText("UnidadMedida");

        txtCantidadIngrediente.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCantidadIngrediente.setBorder(null);

        lblCantidadRequerida.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblCantidadRequerida.setForeground(new java.awt.Color(65, 70, 105));
        lblCantidadRequerida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadRequerida.setText("Cantidad requerida:");

        lblNombreIngrediente.setFont(new java.awt.Font("Avenir Next", 1, 19)); // NOI18N
        lblNombreIngrediente.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreIngrediente.setText("NombreIngrediente");

        btnEliminarIngrediente.setBackground(new java.awt.Color(249, 205, 204));
        btnEliminarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnEliminarIngrediente.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreIngrediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblCantidadRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnEliminarIngrediente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNombreIngrediente)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadRequerida)
                    .addComponent(txtCantidadIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblUnidadMedida)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarIngrediente)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngredienteActionPerformed
       List<IngredienteProductoDTO> ingredientes = pnlEditarProductoExistente.getIngredientes();
       ingredientes.remove(this.ingrediente);
       
       this.pnlEditarProductoExistente.setIngredientes(ingredientes);
       this.pnlEditarProductoExistente.cargarIngredientes(ingredientes);
       this.pnlEditarProductoExistente.getPnlIngredientesProducto().revalidate();
       this.pnlEditarProductoExistente.getPnlIngredientesProducto().repaint();
       
    }//GEN-LAST:event_btnEliminarIngredienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarIngrediente;
    private javax.swing.JLabel lblCantidadRequerida;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JTextField txtCantidadIngrediente;
    // End of variables declaration//GEN-END:variables
}
