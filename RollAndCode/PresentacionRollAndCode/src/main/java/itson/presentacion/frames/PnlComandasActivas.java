
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlComandaAbierta;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlComandasActivas extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private IComandasBO comandasBO;
  
    
    public PnlComandasActivas(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.comandasBO = FabricaObjetosNegocio.crearComandasBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Comandas activas");
        
        
        pnlComandas.setLayout(new BoxLayout(pnlComandas, BoxLayout.Y_AXIS));
        this.pnlComandas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        
        cargarComandas();
    }


    private void cargarComandas(){
        this.pnlComandas.removeAll();
        try {
            List<ComandaDTO> comandas = this.comandasBO.obtenerComandasAbiertas();

            for (ComandaDTO comanda : comandas) {
                PnlComandaAbierta pnlComanda = new PnlComandaAbierta(comanda, pantallaInicio);
                pnlComandas.add(Box.createVerticalStrut(10));
                pnlComanda.setPreferredSize(new Dimension(779, 250));
                pnlComanda.setMaximumSize(new Dimension(779, 250));
                pnlComandas.add(pnlComanda);
            }

            
            this.pnlComandas.revalidate();
            this.pnlComandas.repaint();
            
        } catch (ComandaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblNombreProducto = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        pnlComandas = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));

        lblNombreProducto.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("Comandas Activas");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNombreProducto)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlFooter.setBackground(new java.awt.Color(247, 242, 239));

        btnRegresar.setBackground(new java.awt.Color(247, 242, 239));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(488, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(485, 485, 485))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(19, 19, 19))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlComandas.setBackground(new java.awt.Color(247, 242, 239));
        pnlComandas.setRequestFocusEnabled(false);
        pnlComandas.setLayout(new javax.swing.BoxLayout(pnlComandas, javax.swing.BoxLayout.Y_AXIS));
        add(pnlComandas, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JPanel pnlComandas;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
