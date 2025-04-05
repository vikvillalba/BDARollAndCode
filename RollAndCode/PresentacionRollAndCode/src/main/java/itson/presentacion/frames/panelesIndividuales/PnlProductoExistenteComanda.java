package itson.presentacion.frames.panelesIndividuales;

import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IProductosBO;
import itson.presentacion.frames.PnlBuscadorProductos;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlProductoExistenteComanda extends javax.swing.JPanel {

 private IProductosBO productosBO;
    private ProductoDTO productoDTO;
    private PnlBuscadorProductos buscadorProductos;
    private boolean seleccionado;
    
    
    public PnlProductoExistenteComanda(ProductoDTO productoDTO, PnlBuscadorProductos buscadorProductos) {
        initComponents();
        this.productoDTO = productoDTO;
        this.buscadorProductos = buscadorProductos;
        this.seleccionado = false;
        setDatosProducto();
    }

    private void setDatosProducto(){
        this.lblNombreProducto.setText(productoDTO.getNombre());
        this.lblPrecio.setText(productoDTO.getPrecio().toString());
        this.lblTipoProducto.setText(productoDTO.getTipo().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblTextoPrecio = new javax.swing.JLabel();
        lblSigno = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 205, 204));
        setPreferredSize(new java.awt.Dimension(200, 200));

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

        btnAgregarProducto.setBackground(new java.awt.Color(249, 205, 204));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnAgregar.png"))); // NOI18N
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnAgregarProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSigno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTipoProducto)
                .addGap(33, 33, 33)
                .addComponent(lblNombreProducto)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoPrecio)
                    .addComponent(lblSigno)
                    .addComponent(lblPrecio))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarProducto)
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        List<ProductoDTO> productos = this.buscadorProductos.getProductosSeleccionados();
        
            productos.add(this.productoDTO);

            this.revalidate();
            this.repaint();

            this.buscadorProductos.setProductosSeleccionados(productos);
            this.buscadorProductos.cargarIngredientesSeleccionados();

    }//GEN-LAST:event_btnAgregarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSigno;
    private javax.swing.JLabel lblTextoPrecio;
    private javax.swing.JLabel lblTipoProducto;
    // End of variables declaration//GEN-END:variables
}
