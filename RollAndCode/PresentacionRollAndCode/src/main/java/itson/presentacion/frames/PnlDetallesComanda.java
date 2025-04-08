
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import itson.presentacion.frames.panelesIndividuales.PnlProductoComandaRegistrada;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Detalles de la comanda como sus productos y comentarios.
 * @author victoria
 */
public class PnlDetallesComanda extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private ComandaDTO comanda;
    

    
    public PnlDetallesComanda(FrmPantallaInicio pantallaInicio, ComandaDTO comanda) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.comanda = comanda;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Detalles de la comanda");
        
        this.lblFolioComanda.setText(comanda.getFolio());
        
        if(comanda.getCliente() != null){
            this.lblCliente.setText(comanda.getCliente().getNombres() + comanda.getCliente().getApellidoPaterno());
        }
    
        this.lblCliente.setText("No asignado");
        this.lblNumeroMesa.setText(comanda.getNumeroMesa().toString());
        this.lblTotalComanda.setText(comanda.getTotalAcumulado().toString());
        
        pnlProductosComanda.setLayout(new BoxLayout(pnlProductosComanda, BoxLayout.Y_AXIS));
        this.pnlProductosComanda.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        List<ProductoComandaDTO> productos = comanda.getProductos();
        cargarProductos(productos);
    }

    private void cargarProductos(List<ProductoComandaDTO> productos){
      this.pnlProductosComanda.removeAll();
  
        for (ProductoComandaDTO producto : productos) {
            PnlProductoComandaRegistrada pnlProducto = new PnlProductoComandaRegistrada(producto);
            pnlProductosComanda.add(Box.createVerticalStrut(10));
            pnlProductosComanda.setPreferredSize(new Dimension(1200, 121));
            pnlProductosComanda.setMaximumSize(new Dimension(1200, 121));

        }
      
      this.pnlProductosComanda.revalidate();
      this.pnlProductosComanda.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblNombreComanda = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblFolioComanda = new javax.swing.JLabel();
        lblNumeroMesa = new javax.swing.JLabel();
        lblNombreMesa = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnEditarComanda = new javax.swing.JButton();
        lblTotalComanda = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlProductosComanda = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));

        lblNombreComanda.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombreComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreComanda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreComanda.setText("Comanda ");

        lblNombreCliente.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreCliente.setText("Cliente:");

        lblCliente.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(65, 70, 105));
        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCliente.setText("NombreCliente");

        lblFolioComanda.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblFolioComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblFolioComanda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFolioComanda.setText("OB-YYYYMMDD-XXXX");

        lblNumeroMesa.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNumeroMesa.setForeground(new java.awt.Color(65, 70, 105));
        lblNumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumeroMesa.setText("XX");

        lblNombreMesa.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblNombreMesa.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreMesa.setText("Mesa:");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblFolioComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblNombreComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblNombreComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFolioComanda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCliente)
                    .addComponent(lblCliente))
                .addGap(18, 18, 18)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroMesa)
                    .addComponent(lblNombreMesa))
                .addGap(28, 28, 28))
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

        btnEditarComanda.setBackground(new java.awt.Color(247, 242, 239));
        btnEditarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnEditarComanda.png"))); // NOI18N
        btnEditarComanda.setBorder(null);
        btnEditarComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarComandaActionPerformed(evt);
            }
        });

        lblTotalComanda.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTotalComanda.setForeground(new java.awt.Color(65, 70, 105));
        lblTotalComanda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalComanda.setText("0.00");

        lblTotal.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(65, 70, 105));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("Total $");

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnRegresar)
                        .addGap(127, 127, 127)
                        .addComponent(btnEditarComanda))
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addGap(506, 506, 506)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalComanda)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarComanda)
                    .addComponent(btnRegresar))
                .addGap(19, 19, 19))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlProductosComanda.setBackground(new java.awt.Color(247, 242, 239));
        pnlProductosComanda.setPreferredSize(null);
        add(pnlProductosComanda, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        pantallaInicio.pintarPanelPrincipal(new PnlComandasActivas(pantallaInicio));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarComandaActionPerformed

    }//GEN-LAST:event_btnEditarComandaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarComanda;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFolioComanda;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreComanda;
    private javax.swing.JLabel lblNombreMesa;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalComanda;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlProductosComanda;
    // End of variables declaration//GEN-END:variables
}
