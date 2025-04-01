package itson.presentacion.frames;

/**
 *
 * @author victoria
 */
public class PnlNuevaComanda extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    
    public PnlNuevaComanda(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Nueva Comanda");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        cbxNumeroMesa = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnAsignarCliente = new javax.swing.JButton();
        btnContinuarSinAsignarCliente = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Nueva Comanda");

        lblMesa.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblMesa.setForeground(new java.awt.Color(65, 70, 105));
        lblMesa.setText("Seleccione una mesa:");

        cbxNumeroMesa.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        cbxNumeroMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNumeroMesa.setBorder(null);
        cbxNumeroMesa.setPreferredSize(new java.awt.Dimension(89, 40));

        btnRegresar.setBackground(null);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAsignarCliente.setBackground(null);
        btnAsignarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarClienteComanda.png"))); // NOI18N
        btnAsignarCliente.setBorder(null);
        btnAsignarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnContinuarSinAsignarCliente.setBackground(null);
        btnContinuarSinAsignarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/continuarSinAgregarCliente.png"))); // NOI18N
        btnContinuarSinAsignarCliente.setBorder(null);
        btnContinuarSinAsignarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(lblMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnRegresar)
                        .addGap(57, 57, 57)
                        .addComponent(btnAsignarCliente)
                        .addGap(57, 57, 57)
                        .addComponent(btnContinuarSinAsignarCliente)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblTitulo)
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMesa)
                    .addComponent(cbxNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addComponent(btnAsignarCliente)
                    .addComponent(btnContinuarSinAsignarCliente))
                .addGap(94, 94, 94))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // vuelve a la pantalla de inicio
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarCliente;
    private javax.swing.JButton btnContinuarSinAsignarCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxNumeroMesa;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
