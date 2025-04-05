package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import itson.presentacion.frames.PnlBuscadorProductos;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlProductoSeleccionado extends javax.swing.JPanel {

    private ProductoDTO productoDTO;
    private PnlBuscadorProductos buscadorProductos;
    
    public PnlProductoSeleccionado(ProductoDTO productoDTO, PnlBuscadorProductos buscadorProductos) {
        initComponents();
        this.productoDTO = productoDTO;
        this.buscadorProductos = buscadorProductos;
        
        this.lblNombreProducto.setText(productoDTO.getNombre());
        this.txtCantidad.setText("1");
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreProducto = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnSumarCantidad = new javax.swing.JButton();
        btnRestarCantidad = new javax.swing.JButton();
        lblTextoCantidad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(300, 90));

        lblNombreProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("NombreProducto");

        txtCantidad.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCantidad.setBorder(null);

        btnSumarCantidad.setBackground(new java.awt.Color(249, 205, 204));
        btnSumarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnMas.png"))); // NOI18N
        btnSumarCantidad.setBorder(null);
        btnSumarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarCantidadActionPerformed(evt);
            }
        });

        btnRestarCantidad.setBackground(new java.awt.Color(249, 205, 204));
        btnRestarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnMenos.png"))); // NOI18N
        btnRestarCantidad.setBorder(null);
        btnRestarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarCantidadActionPerformed(evt);
            }
        });

        lblTextoCantidad.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblTextoCantidad.setForeground(new java.awt.Color(65, 70, 105));
        lblTextoCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoCantidad.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestarCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSumarCantidad)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSumarCantidad)
                    .addComponent(btnRestarCantidad)
                    .addComponent(lblTextoCantidad))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarCantidadActionPerformed
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad > 1) {
                cantidad--;
                txtCantidad.setText(String.valueOf(cantidad));
            } else {
                List<ProductoDTO> productos = this.buscadorProductos.getProductosSeleccionados();
                productos.remove(this.productoDTO);
                this.buscadorProductos.setProductosSeleccionados(productos);

                System.out.println("Eliminando producto: " + productoDTO.getNombre());

                this.buscadorProductos.getPnlProductosSeleccionados().remove(this);
                this.buscadorProductos.getPnlProductosSeleccionados().revalidate();
                this.buscadorProductos.getPnlProductosSeleccionados().repaint();
            }
        } catch (NumberFormatException e) {
            txtCantidad.setText("1"); 
        }
    }//GEN-LAST:event_btnRestarCantidadActionPerformed

    private void btnSumarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarCantidadActionPerformed

        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            cantidad++;
            txtCantidad.setText(String.valueOf(cantidad));
        } catch (NumberFormatException e) {
            txtCantidad.setText("1");
        }

    }//GEN-LAST:event_btnSumarCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestarCantidad;
    private javax.swing.JButton btnSumarCantidad;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblTextoCantidad;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
