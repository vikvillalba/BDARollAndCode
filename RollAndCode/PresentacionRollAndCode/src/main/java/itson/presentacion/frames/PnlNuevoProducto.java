
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.enums.ProductoTipos;
import com.mycompany.negociorollandcode.IIngredientesBO;
import itson.presentacion.excepciones.PresentacionException;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlNuevoProducto extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IIngredientesBO ingredientesBO;
    
    public PnlNuevoProducto(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.ingredientesBO = pantallaInicio.getIngredientesBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Agregar nuevo producto");
        
        for (ProductoTipos tipo : ProductoTipos.values()) {
            this.cbxCategoriaProducto.addItem(tipo);
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
        cbxCategoriaProducto = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));

        lblCategoria.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(65, 70, 105));
        lblCategoria.setText("Seleccione la categoría:");

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Nuevo producto");

        cbxCategoriaProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        cbxCategoriaProducto.setBorder(null);
        cbxCategoriaProducto.setPreferredSize(new java.awt.Dimension(89, 40));

        btnRegresar.setBackground(new java.awt.Color(247, 242, 239));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnContinuar.setBackground(new java.awt.Color(247, 242, 239));
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnContinuar.png"))); // NOI18N
        btnContinuar.setBorder(null);
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(65, 70, 105));
        lblNombre.setText("Nombre del producto:");

        txtNombreProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtNombreProducto.setBorder(null);

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
                        .addGap(207, 207, 207)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCategoria)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCategoriaProducto, 0, 330, Short.MAX_VALUE)
                            .addComponent(txtNombreProducto)
                            .addComponent(jSeparator1))))
                .addContainerGap(289, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(432, 432, 432)
                    .addComponent(lblTitulo)
                    .addContainerGap(456, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoria)
                    .addComponent(cbxCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreProducto))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
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
         if(txtNombreProducto.getText().isBlank() || txtNombreProducto.getText().isEmpty()){
           try {
               throw new PresentacionException("No se ingresó ningún nombre.");
           } catch (PresentacionException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage(),"Aviso", JOptionPane.OK_OPTION);
               return;
           }
       }
         NuevoProductoDTO nuevoProducto = new NuevoProductoDTO();
         nuevoProducto.setNombre(txtNombreProducto.getText());
         nuevoProducto.setTipo((ProductoTipos) cbxCategoriaProducto.getSelectedItem());
         PnlBuscadorIngredientes buscador = new PnlBuscadorIngredientes(pantallaInicio);
         buscador.setNuevoProductoDTO(nuevoProducto);
         pantallaInicio.pintarPanelPrincipal(buscador);
       
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<ProductoTipos> cbxCategoriaProducto;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
