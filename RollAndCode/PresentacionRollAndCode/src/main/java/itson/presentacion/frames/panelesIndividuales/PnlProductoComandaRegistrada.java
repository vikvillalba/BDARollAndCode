package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import itson.presentacion.frames.PnlEditarComanda;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Representa un producto registrado en una comanda
 * @author victoria
 */
public class PnlProductoComandaRegistrada extends javax.swing.JPanel {

    private ProductoComandaDTO producto;
    private PnlEditarComanda detalles;
    
    public PnlProductoComandaRegistrada(ProductoComandaDTO producto) {
        initComponents();
        this.producto = producto;
        setDatos();
    }

    public void setDatos(){
        lblNombreProducto.setText(producto.getNombreProducto());
        txtCantidadProducto.setText(producto.getCantidad().toString());
        txtCantidadProducto.setEditable(false);
        lblSubtotal.setText(producto.getSubtotal().toString());
        lblComentario.setText(producto.getComentario());
    }
    
     public void eliminarBotonEliminar() {
        btnEliminarProducto.setVisible(false);

    }

    public void activarBotonEliminar(){
        btnEliminarProducto.setVisible(true);
    }
     
     
     
    public void activarEdicionCantidad(){
        this.txtCantidadProducto.setEditable(true);
    }

    public void setDetalles(PnlEditarComanda detalles) {
        this.detalles = detalles;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreProducto = new javax.swing.JLabel();
        btnEliminarProducto = new javax.swing.JButton();
        lblTextoComentario = new javax.swing.JLabel();
        lblTextoCantidad = new javax.swing.JLabel();
        lblTextoSubtotal = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblComentario = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(1200, 121));

        lblNombreProducto.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("NombreProducto");

        btnEliminarProducto.setBackground(new java.awt.Color(249, 205, 204));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnEliminarProductoComanda.png"))); // NOI18N
        btnEliminarProducto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        lblTextoComentario.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblTextoComentario.setForeground(new java.awt.Color(65, 70, 105));
        lblTextoComentario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoComentario.setText("Comentarios:");

        lblTextoCantidad.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblTextoCantidad.setForeground(new java.awt.Color(65, 70, 105));
        lblTextoCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoCantidad.setText("Cantidad:");

        lblTextoSubtotal.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblTextoSubtotal.setForeground(new java.awt.Color(65, 70, 105));
        lblTextoSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoSubtotal.setText("Subtotal: $");

        lblSubtotal.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(65, 70, 105));
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSubtotal.setText("0.00");

        lblComentario.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblComentario.setForeground(new java.awt.Color(65, 70, 105));
        lblComentario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComentario.setText("Comentarios");

        txtCantidadProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCantidadProducto.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTextoCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTextoSubtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblTextoComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarProducto)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminarProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTextoComentario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblComentario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProducto)
                            .addComponent(lblTextoCantidad)
                            .addComponent(lblTextoSubtotal)
                            .addComponent(lblSubtotal)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        List<ProductoComandaDTO> productos = detalles.getProductos();

        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar el producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            productos.remove(producto);
            if (!productos.isEmpty()) {
                detalles.setProductos(productos);
                detalles.cargarProductos(productos);
                detalles.revalidate();
                detalles.repaint();
                
            } else {
                JOptionPane.showMessageDialog(null, "La comanda no puede quedar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            }
           

        }
        detalles.repaint();

    }//GEN-LAST:event_btnEliminarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTextoCantidad;
    private javax.swing.JLabel lblTextoComentario;
    private javax.swing.JLabel lblTextoSubtotal;
    private javax.swing.JTextField txtCantidadProducto;
    // End of variables declaration//GEN-END:variables
}
