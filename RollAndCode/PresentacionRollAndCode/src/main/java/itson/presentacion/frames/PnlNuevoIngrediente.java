
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.NuevoIngredienteDTO;
import com.mycompany.dominiorollandcode.enums.UnidadMedida;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.excepciones.IngredienteException;
import itson.presentacion.excepciones.PresentacionException;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlNuevoIngrediente extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IIngredientesBO ingredientesBO;
    
    public PnlNuevoIngrediente(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.ingredientesBO = this.pantallaInicio.getIngredientesBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Agregar nuevo producto");

        for (UnidadMedida unidad : UnidadMedida.values()) {
            this.cbxUnidadMedida.addItem(unidad);
        }

    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategoria = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        cbxUnidadMedida = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombreIngrediente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblNombre1 = new javax.swing.JLabel();
        txtCantidadstock = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));

        lblCategoria.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(65, 70, 105));
        lblCategoria.setText("Seleccione la unidad de medida:");

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Nuevo Ingrediente");

        cbxUnidadMedida.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        cbxUnidadMedida.setBorder(null);
        cbxUnidadMedida.setPreferredSize(new java.awt.Dimension(89, 40));

        btnRegresar.setBackground(new java.awt.Color(247, 242, 239));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnContinuar.setBackground(new java.awt.Color(247, 242, 239));
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnContinuar.png"))); // NOI18N
        btnContinuar.setBorder(null);
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(65, 70, 105));
        lblNombre.setText("Cantidad de stock:");

        txtNombreIngrediente.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtNombreIngrediente.setBorder(null);

        lblNombre1.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(65, 70, 105));
        lblNombre1.setText("Nombre del ingrediente:");

        txtCantidadstock.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCantidadstock.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnRegresar)
                        .addGap(76, 76, 76)
                        .addComponent(btnContinuar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre1)
                            .addComponent(lblCategoria)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadstock, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(432, 432, 432)
                    .addComponent(lblTitulo)
                    .addContainerGap(407, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombre1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCantidadstock, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombre))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(btnContinuar))
                .addGap(82, 82, 82))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(lblTitulo)
                    .addContainerGap(587, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       // vuelve a la pantalla de inicio
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
       // obtiene los valores ingresados en los textfields
        String nombreIngrediente = txtNombreIngrediente.getText();
       UnidadMedida unidadMedida = (UnidadMedida) cbxUnidadMedida.getSelectedItem();
       
       // valida que se haya ingresado un valor para el stock
       if(txtCantidadstock.getText().isBlank() || txtCantidadstock.getText().isEmpty()){
           try {
               throw new PresentacionException("La cantidad de stock no puede estar vacía.");
           } catch (PresentacionException ex) {
               txtCantidadstock.setText("");
               JOptionPane.showMessageDialog(null, ex.getMessage(),"Aviso", JOptionPane.OK_OPTION);
               return;
           }
       }
       
       Integer stock = Integer.valueOf(txtCantidadstock.getText());
       
       // arma la dto
        NuevoIngredienteDTO nuevoIngredienteDTO = new NuevoIngredienteDTO(nombreIngrediente, unidadMedida, stock);
        try {
            // llama al metodo del BO y le envia la dto
            this.ingredientesBO.registrar(nuevoIngredienteDTO);
            JOptionPane.showInternalMessageDialog(null, "El ingrediente se registró correctamente", "Confirmación", JOptionPane.OK_OPTION);
            // limpia los campos de texto
            txtCantidadstock.setText("");
            txtNombreIngrediente.setText("");
        } catch (IngredienteException ex) {
            txtCantidadstock.setText("");
            txtNombreIngrediente.setText("");
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Aviso", JOptionPane.OK_OPTION);
        }
        
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<UnidadMedida> cbxUnidadMedida;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCantidadstock;
    private javax.swing.JTextField txtNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}
