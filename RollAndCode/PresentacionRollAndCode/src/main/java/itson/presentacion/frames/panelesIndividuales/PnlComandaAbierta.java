package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.enums.EstadoComanda;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.FrmPantallaInicio;
import itson.presentacion.frames.PnlDetallesComanda;
import javax.swing.JOptionPane;

/**
 * Representa gráficamente una comanda abierta en el sistema
 * @author victoria
 */
public class PnlComandaAbierta extends javax.swing.JPanel {

    private ComandaDTO comanda;
    private FrmPantallaInicio pantallaInicio;
    private IComandasBO comandasBO;
    
    
    public PnlComandaAbierta(ComandaDTO comanda, FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.comanda = comanda;
        this.pantallaInicio = pantallaInicio;
        this.comandasBO = FabricaObjetosNegocio.crearComandasBO();
        setDatosComanda();
        
    }

    public void setDatosComanda(){
       this.lblFolioComanda.setText(comanda.getFolio());
       this.lblNumeroMesa.setText(comanda.getNumeroMesa().toString());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMesaComanda = new javax.swing.JLabel();
        btnDetallesComanda = new javax.swing.JButton();
        lblFolioComanda = new javax.swing.JLabel();
        lblNombreComanda = new javax.swing.JLabel();
        lblNumeroMesa = new javax.swing.JLabel();
        btnCancelarComanda = new javax.swing.JButton();
        btnEntregarComanda = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(779, 250));

        lblMesaComanda.setFont(new java.awt.Font("Avenir Next", 1, 24)); // NOI18N
        lblMesaComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblMesaComanda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMesaComanda.setText("Mesa: ");

        btnDetallesComanda.setBackground(new java.awt.Color(249, 205, 204));
        btnDetallesComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnDetallesComanda.png"))); // NOI18N
        btnDetallesComanda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDetallesComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesComandaActionPerformed(evt);
            }
        });

        lblFolioComanda.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblFolioComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblFolioComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFolioComanda.setText("OB-YYYYMMDD-XXX");

        lblNombreComanda.setFont(new java.awt.Font("Avenir Next", 1, 24)); // NOI18N
        lblNombreComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreComanda.setText("Comanda");

        lblNumeroMesa.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblNumeroMesa.setForeground(new java.awt.Color(65, 70, 105));
        lblNumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumeroMesa.setText("XX");

        btnCancelarComanda.setBackground(new java.awt.Color(249, 205, 204));
        btnCancelarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnCamcelarComanda.png"))); // NOI18N
        btnCancelarComanda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCancelarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarComandaActionPerformed(evt);
            }
        });

        btnEntregarComanda.setBackground(new java.awt.Color(249, 205, 204));
        btnEntregarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnEntregarComanda.png"))); // NOI18N
        btnEntregarComanda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEntregarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarComandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblMesaComanda)
                            .addGap(18, 18, 18)
                            .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(lblFolioComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblNombreComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetallesComanda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelarComanda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEntregarComanda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblNombreComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFolioComanda)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesaComanda)
                    .addComponent(lblNumeroMesa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnDetallesComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntregarComanda)
                .addGap(12, 12, 12)
                .addComponent(btnCancelarComanda)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesComandaActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlDetallesComanda(pantallaInicio, comanda));

    }//GEN-LAST:event_btnDetallesComandaActionPerformed

    private void btnCancelarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarComandaActionPerformed

    private void btnEntregarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarComandaActionPerformed
        
        this.comanda.setEstado(EstadoComanda.ENTREGADA);
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea marcar la comanda como entregada?",
                "Confirmar entrega",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
           
            try {
                ComandaDTO comandaActualizada = this.comandasBO.entregar(this.comanda);
                JOptionPane.showMessageDialog(null, "La comanda se ha marcado como entregada.", "Comanda entregada", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (ComandaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al entregar comanda.", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnEntregarComandaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarComanda;
    private javax.swing.JButton btnDetallesComanda;
    private javax.swing.JButton btnEntregarComanda;
    private javax.swing.JLabel lblFolioComanda;
    private javax.swing.JLabel lblMesaComanda;
    private javax.swing.JLabel lblNombreComanda;
    private javax.swing.JLabel lblNumeroMesa;
    // End of variables declaration//GEN-END:variables
}
