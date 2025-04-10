package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.entidades.Usuario;
import com.mycompany.dominiorollandcode.enums.TipoUsuario;
import itson.presentacion.frames.FrmPantallaInicio;
import javax.swing.JFrame;

/**
 * Pantalla que permite al usuario elegir su rol dentro del sistema.
 * @author victoria
 */
public class ModoVista extends JFrame {

    private Usuario usuario;

    public ModoVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnMesero = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlFondo.setBackground(new java.awt.Color(247, 242, 239));

        btnMesero.setBackground(new java.awt.Color(247, 242, 239));
        btnMesero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnMesero.png"))); // NOI18N
        btnMesero.setBorder(null);
        btnMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeseroActionPerformed(evt);
            }
        });

        btnAdmin.setBackground(new java.awt.Color(247, 242, 239));
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnAdmin.png"))); // NOI18N
        btnAdmin.setBorder(null);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Bienvenido");

        lblSubtitulo.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblSubtitulo.setText("Seleccione su rol en el sistema");

        btnSalir.setBackground(new java.awt.Color(247, 242, 239));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/salir.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblTitulo))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblSubtitulo))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnAdmin)
                        .addGap(28, 28, 28)
                        .addComponent(btnMesero))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnSalir)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMesero)
                    .addComponent(btnAdmin))
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        usuario = new Usuario(TipoUsuario.ADMINISTRADOR);
        FrmPantallaInicio frmInicio = new FrmPantallaInicio(usuario);
        frmInicio.setTitle("Roll & code - Modo administrador");
        frmInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeseroActionPerformed
        usuario = new Usuario(TipoUsuario.MESERO);
        FrmPantallaInicio frmInicio = new FrmPantallaInicio(usuario);
        frmInicio.setTitle("Roll & code - Modo mesero");
        frmInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMeseroActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnMesero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
