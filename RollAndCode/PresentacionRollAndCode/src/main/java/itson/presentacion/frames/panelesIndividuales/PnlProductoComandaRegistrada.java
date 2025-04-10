package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import itson.presentacion.frames.PnlEditarComanda;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Representa un producto registrado en una comanda
 *
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

    public void setDatos() {
        lblNombreProducto.setText(producto.getNombreProducto());
        String cantidadTexto = producto.getCantidad() != null ? producto.getCantidad().toString() : "1";
        txtCantidadProducto.setText(cantidadTexto);
        txtCantidadProducto.setEditable(false);
        this.txtComentario.setEditable(false);
        this.btnSumarCantidad.setVisible(false);
        this.btnRestarCantidad.setVisible(false);
        lblSubtotal.setText(producto.getSubtotal().toString());
        txtComentario.setText(producto.getComentario());
    }

    public void eliminarBotonEliminar() {
        btnEliminarProducto.setVisible(false);

    }

    public void activarBotonEliminar() {
        btnEliminarProducto.setVisible(true);
    }

    public void activarEdicionCantidad() {
        this.txtCantidadProducto.setEditable(true);
    }

    public void setDetalles(PnlEditarComanda detalles) {
        this.detalles = detalles;
    }

    public void activarComentarios() {
        this.txtComentario.setEditable(true);
    }

    public void activarBotonesCantidad() {
        this.btnSumarCantidad.setVisible(true);
        this.btnRestarCantidad.setVisible(true);
    }

    public ProductoComandaDTO getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        String textoCantidad = txtCantidadProducto.getText().trim();
        if (textoCantidad.isEmpty()) {
            return 1;
        }
        try {
            return Integer.valueOf(textoCantidad);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private void actualizarProductoEnLista(ProductoComandaDTO productoActualizado) {
        List<ProductoComandaDTO> productos = detalles.getProductos();

        for (int i = 0; i < productos.size(); i++) {
            ProductoComandaDTO p = productos.get(i);
            if (p.getIdProducto().equals(productoActualizado.getIdProducto())) {
                productos.set(i, productoActualizado);
                break;
            }
        }

        detalles.setProductos(productos);
        detalles.cargarProductos(productos);
        detalles.revalidate();
        detalles.repaint();
    }

    public String getComentario() {
        return txtComentario.getText();
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
        txtCantidadProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        btnRestarCantidad = new javax.swing.JButton();
        btnSumarCantidad = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(1291, 121));

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

        txtCantidadProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtCantidadProducto.setBorder(null);

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        btnRestarCantidad.setBackground(new java.awt.Color(249, 205, 204));
        btnRestarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnMenos.png"))); // NOI18N
        btnRestarCantidad.setBorder(null);
        btnRestarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarCantidadActionPerformed(evt);
            }
        });

        btnSumarCantidad.setBackground(new java.awt.Color(249, 205, 204));
        btnSumarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnMas.png"))); // NOI18N
        btnSumarCantidad.setBorder(null);
        btnSumarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTextoCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestarCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSumarCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(lblTextoSubtotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTextoComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addComponent(btnEliminarProducto)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTextoComentario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTextoSubtotal)
                        .addComponent(lblSubtotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRestarCantidad)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTextoCantidad)
                            .addComponent(lblNombreProducto))
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSumarCantidad)))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarProducto)
                .addGap(30, 30, 30))
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
                detalles.actualizarTotal();
                detalles.revalidate();
                detalles.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "La comanda no puede quedar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        detalles.setProductosPantallaDetalles(productos);
        detalles.getDetallesComanda().revalidate();
        detalles.getDetallesComanda().repaint();
        detalles.repaint();

    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnRestarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarCantidadActionPerformed
        try {
            int cantidad = Integer.parseInt(txtCantidadProducto.getText());
            if (cantidad > 1) {
                cantidad--;
                txtCantidadProducto.setText(String.valueOf(cantidad));
                BigDecimal subtotal = producto.getSubtotal().subtract(producto.getPrecio());

                txtCantidadProducto.setText(String.valueOf(cantidad));

                producto.setCantidad(cantidad);
                BigDecimal nuevoSubtotal = producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
                producto.setSubtotal(nuevoSubtotal);
                lblSubtotal.setText(nuevoSubtotal.toString());

                detalles.actualizarTotal();
                actualizarProductoEnLista(producto);
            } else {

                txtCantidadProducto.setText("1");
                producto.setCantidad(1);
                detalles.actualizarTotal();
            }
        } catch (NumberFormatException e) {
            txtCantidadProducto.setText("1");
        }
    }//GEN-LAST:event_btnRestarCantidadActionPerformed

    private void btnSumarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarCantidadActionPerformed
        try {
            int cantidad = Integer.parseInt(txtCantidadProducto.getText());
            cantidad++;
            txtCantidadProducto.setText(String.valueOf(cantidad));

            producto.setCantidad(cantidad);
            BigDecimal nuevoSubtotal = producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
            producto.setSubtotal(nuevoSubtotal);
            lblSubtotal.setText(nuevoSubtotal.toString());

            detalles.actualizarTotal();
            actualizarProductoEnLista(producto);
        } catch (NumberFormatException e) {
            txtCantidadProducto.setText("1");
        }
    }//GEN-LAST:event_btnSumarCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnRestarCantidad;
    private javax.swing.JButton btnSumarCantidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTextoCantidad;
    private javax.swing.JLabel lblTextoComentario;
    private javax.swing.JLabel lblTextoSubtotal;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextArea txtComentario;
    // End of variables declaration//GEN-END:variables
}
