
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.IngredienteProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteProductoExistente;
import java.awt.Dimension;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlDetallesProductoExistente extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private ProductoDTO producto;

    
    public PnlDetallesProductoExistente(FrmPantallaInicio pantallaInicio, ProductoDTO producto) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.producto = producto;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Detalles del producto");
        
        this.lblNombreProducto.setText(producto.getNombre());
        this.lblPrecioProducto.setText(producto.getPrecio().toString());
        this.lblTipoProducto.setText(producto.getTipo().toString());
        
        int filas = (int) Math.ceil(this.producto.getIngredientes().size() / 3.0);
        this.pnlIngredientesProducto.setPreferredSize(new Dimension(pnlIngredientesProducto.getWidth(), filas * 210));
        
        cargarIngredientes();
    }

    private void cargarIngredientes(){
        this.pnlIngredientesProducto.removeAll();
        List<IngredienteProductoDTO> ingredientes = this.producto.getIngredientes();
        for (IngredienteProductoDTO ingrediente : ingredientes) {
            PnlIngredienteProductoExistente pnlIngrediente = new PnlIngredienteProductoExistente(ingrediente);
            pnlIngrediente.eliminarBotonEliminar();
            this.pnlIngredientesProducto.add(pnlIngrediente);
        }
        
        this.pnlIngredientesProducto.revalidate();
        this.pnlIngredientesProducto.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblTipoProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblTipoProducto1 = new javax.swing.JLabel();
        lblPrecioProducto = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        pnlIngredientesProducto = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(null);
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));

        lblTipoProducto.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblTipoProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoProducto.setText("TipoPlatillo");

        lblNombreProducto.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("NombreProducto");

        lblTipoProducto1.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTipoProducto1.setForeground(new java.awt.Color(65, 70, 105));
        lblTipoProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoProducto1.setText("Precio: $");

        lblPrecioProducto.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblPrecioProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblPrecioProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecioProducto.setText("00.00");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoProducto)
                    .addComponent(lblTipoProducto1)
                    .addComponent(lblPrecioProducto))
                .addContainerGap(18, Short.MAX_VALUE))
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

        btnEditarProducto.setBackground(new java.awt.Color(247, 242, 239));
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/editarProducto.png"))); // NOI18N
        btnEditarProducto.setBorder(null);
        btnEditarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(btnRegresar)
                .addGap(150, 150, 150)
                .addComponent(btnEditarProducto)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnRegresar))
                .addGap(19, 19, 19))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlIngredientesProducto.setBackground(new java.awt.Color(247, 242, 239));
        pnlIngredientesProducto.setPreferredSize(null);
        add(pnlIngredientesProducto, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        pantallaInicio.pintarPanelPrincipal(new PnlProductosExistentes(pantallaInicio));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlEditarProductoExistente(pantallaInicio, producto));
    }//GEN-LAST:event_btnEditarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JLabel lblTipoProducto;
    private javax.swing.JLabel lblTipoProducto1;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlIngredientesProducto;
    // End of variables declaration//GEN-END:variables
}
