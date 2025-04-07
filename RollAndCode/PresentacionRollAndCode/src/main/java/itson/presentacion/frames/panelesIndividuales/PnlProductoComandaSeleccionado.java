package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import itson.presentacion.frames.PnlConfirmarComanda;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlProductoComandaSeleccionado extends javax.swing.JPanel {

    private ProductoDTO productoDTO;
    private PnlProductoSeleccionado pnlProductoSeleccionado;
    private PnlConfirmarComanda pantalla;
    private String comentario;
    
    public PnlProductoComandaSeleccionado(PnlProductoSeleccionado pnlProductoSeleccionado, PnlConfirmarComanda pantalla) {
        initComponents();
        this.pnlProductoSeleccionado = pnlProductoSeleccionado;
        this.pantalla = pantalla;
        this.productoDTO = pnlProductoSeleccionado.getProductoDTO();
        this.lblNombreProducto.setText(productoDTO.getNombre());
        this.lblPrecio.setText(productoDTO.getPrecio().toString());
        this.lblTipoProducto.setText(productoDTO.getTipo().toString());
        this.lblCantidad.setText(pnlProductoSeleccionado.obtenerCantidad().toString());
        this.comentario = "";
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }
    
    public Integer getCantidadProducto(){
        return pnlProductoSeleccionado.obtenerCantidad();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblTextoPrecio = new javax.swing.JLabel();
        lblSigno = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        btnAgregarComentario = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        lblCantidadTexto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(241, 264));

        lblTipoProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblTipoProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoProducto.setText("TIPO:");

        lblNombreProducto.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("NombreProducto");

        lblTextoPrecio.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblTextoPrecio.setForeground(new java.awt.Color(65, 70, 105));
        lblTextoPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoPrecio.setText("Precio:");

        lblSigno.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblSigno.setForeground(new java.awt.Color(65, 70, 105));
        lblSigno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSigno.setText("$");

        lblPrecio.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(65, 70, 105));
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio.setText("0.00");

        btnAgregarComentario.setBackground(new java.awt.Color(249, 205, 204));
        btnAgregarComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnComentario.png"))); // NOI18N
        btnAgregarComentario.setBorder(null);
        btnAgregarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComentarioActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(249, 205, 204));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/eliminarProducto.png"))); // NOI18N
        btnEliminarProducto.setBorder(null);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        lblCantidadTexto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblCantidadTexto.setForeground(new java.awt.Color(65, 70, 105));
        lblCantidadTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadTexto.setText("Cantidad:");

        lblCantidad.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(65, 70, 105));
        lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCantidad.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSigno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblCantidadTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnEliminarProducto)))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnAgregarComentario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTipoProducto)
                .addGap(29, 29, 29)
                .addComponent(lblNombreProducto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoPrecio)
                    .addComponent(lblSigno)
                    .addComponent(lblPrecio))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadTexto)
                    .addComponent(lblCantidad))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarComentario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarProducto)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        List<ProductoDTO> productosSeleccionadosDTO = pantalla.obtenerProductosSeleccionados();
        List<PnlProductoSeleccionado> productosSeleccionados = pantalla.getProductos();

        ProductoDTO productoDTOAEliminar = this.productoDTO;

        PnlProductoSeleccionado panelAEliminar = null;
        for (PnlProductoSeleccionado pnl : productosSeleccionados) {
            if (pnl.getProductoDTO().equals(productoDTOAEliminar)) {
                panelAEliminar = pnl;
                break;
            }
        }

        if (panelAEliminar != null) {
            int cantidadActual = panelAEliminar.obtenerCantidad();

            if (cantidadActual > 1) {
                panelAEliminar.setCantidad(cantidadActual - 1);
            } else {
                productosSeleccionados.remove(panelAEliminar);
                productosSeleccionadosDTO.removeIf(p -> p.equals(productoDTOAEliminar));

                pantalla.getBuscador().getPnlProductosCantidad().removeIf(
                        pnl -> pnl.getProductoDTO().equals(productoDTOAEliminar)
                );
            }

            pantalla.setProductos(productosSeleccionados);
            pantalla.getBuscador().setProductosSeleccionados(productosSeleccionadosDTO);

            pantalla.getBuscador().cargarProductosSeleccionados();
            pantalla.cargarProductos();
            pantalla.calcularTotal();
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnAgregarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComentarioActionPerformed
        AgregarComentario frmComentario = new AgregarComentario(this);
        frmComentario.setVisible(true);
    }//GEN-LAST:event_btnAgregarComentarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComentario;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadTexto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSigno;
    private javax.swing.JLabel lblTextoPrecio;
    private javax.swing.JLabel lblTipoProducto;
    // End of variables declaration//GEN-END:variables
}
