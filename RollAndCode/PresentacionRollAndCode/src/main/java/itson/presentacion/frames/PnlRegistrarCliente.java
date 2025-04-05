package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.RegistrarClienteDTO;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.excepciones.ClienteException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import javax.swing.JOptionPane;

/**
 *
 * @author 52644
 */
public class PnlRegistrarCliente extends javax.swing.JPanel {

    private FrmPantallaInicio frame;
    private IClientesBO clientesBO;

    /**
     * Creates new form PnlRegistrarCliente
     */
    public PnlRegistrarCliente(FrmPantallaInicio frame) throws Exception {
        initComponents();
        this.frame = frame;
        frame.pintarPanelPrincipal(this);
        frame.setTitle("Registrar Cliente Frecuente");
        this.clientesBO = FabricaObjetosNegocio.crearClientesBO(this.frame.getKey());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        lblApellidoPat = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidoMat = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Registrar cliente");

        lblApellidoPat.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblApellidoPat.setForeground(new java.awt.Color(65, 70, 105));
        lblApellidoPat.setText("Apellido paterno:");

        lblTelefono.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(65, 70, 105));
        lblTelefono.setText("Teléfono:");

        lblNombres.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(65, 70, 105));
        lblNombres.setText("Nombres:");

        lblApellidoMat.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblApellidoMat.setForeground(new java.awt.Color(65, 70, 105));
        lblApellidoMat.setText("Apellido materno:");

        lblCorreo.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(65, 70, 105));
        lblCorreo.setText("Correo electrónico:");

        txtNombres.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtNombres.setBorder(null);

        txtCorreo.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCorreo.setBorder(null);

        txtApellidoPaterno.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtApellidoPaterno.setBorder(null);

        txtApellidoMaterno.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtApellidoMaterno.setBorder(null);

        txtTelefono.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtTelefono.setBorder(null);

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/registrarCliente.png"))); // NOI18N
        btnRegistrarCliente.setBorder(null);
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(438, 438, 438))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellidoPat)
                            .addComponent(lblTelefono)
                            .addComponent(lblNombres)
                            .addComponent(lblApellidoMat)
                            .addComponent(lblCorreo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidoPaterno)
                            .addComponent(txtNombres)
                            .addComponent(txtCorreo)
                            .addComponent(txtApellidoMaterno)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(84, 84, 84)
                        .addComponent(btnRegistrarCliente)
                        .addGap(270, 270, 270))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblTitulo)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblApellidoPat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidoPaterno))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMat)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnRegresar))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frame.pintarPanelPrincipal(new PnlPantallaPrincipal(frame, frame.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        RegistrarClienteDTO cliente = new RegistrarClienteDTO(txtNombres.getText(), txtApellidoPaterno.getText(),
                txtApellidoMaterno.getText(), txtCorreo.getText(), txtTelefono.getText());
        try {
            ClienteDTO clienteDTO = clientesBO.registrarNuevoCliente(cliente);
            JOptionPane.showMessageDialog(null, clienteDTO.toString(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombres.setText(null);
            txtApellidoMaterno.setText(null);
            txtApellidoPaterno.setText(null);
            txtCorreo.setText(null);
            txtTelefono.setText(null);
            
        } catch (ClienteException e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                    "Aviso", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblApellidoMat;
    private javax.swing.JLabel lblApellidoPat;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
