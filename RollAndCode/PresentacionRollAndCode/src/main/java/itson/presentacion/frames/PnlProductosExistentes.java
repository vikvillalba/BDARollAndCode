
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlProductoExistente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlProductosExistentes extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IProductosBO productosBO;
    private ButtonGroup opcionesBusqueda;
    
     
    public PnlProductosExistentes(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.productosBO = FabricaObjetosNegocio.crearProductosBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Productos existentes");
        
        opcionesBusqueda = new ButtonGroup();
        opcionesBusqueda.add(rbNombreProducto);
        opcionesBusqueda.add(rbTipoProducto);
        
        
        try {
            cargarProductos(productosBO.obtenerProductosExistentes());
        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar los productos", JOptionPane.ERROR_MESSAGE);
        }
    }


     public void cargarProductos(List<ProductoDTO> productos) {
 
        this.pnlProductos.removeAll();

        for (ProductoDTO producto : productos) {
            PnlProductoExistente pnlProducto = new PnlProductoExistente(producto);
            this.pnlProductos.add(pnlProducto);

        }
        this.pnlProductos.revalidate();
        this.pnlProductos.repaint();

        pantallaInicio.getScrollPane().revalidate();
        pantallaInicio.getScrollPane().repaint();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscador = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        rbTipoProducto = new javax.swing.JRadioButton();
        rbNombreProducto = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscadorProducto = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnBorrarSeleccion = new javax.swing.JButton();
        pnlProductos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setLayout(new java.awt.BorderLayout());

        pnlBuscador.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.setLayout(new java.awt.BorderLayout());

        pnlFooter.setBackground(new java.awt.Color(247, 242, 239));

        btnAgregarProducto.setBackground(new java.awt.Color(247, 242, 239));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarNuevoProducto.png"))); // NOI18N
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(247, 242, 239));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(49, 49, 49)
                .addComponent(btnAgregarProducto)
                .addGap(317, 317, 317))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnRegresar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlBuscador.add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));

        rbTipoProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbTipoProducto.setText("Tipo");

        rbNombreProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbNombreProducto.setText("Nombre");

        txtBuscadorProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtBuscadorProducto.setBorder(null);

        lblTitulo1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo1.setText("Productos");

        btnBuscar.setBackground(new java.awt.Color(247, 242, 239));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBorrarSeleccion.setBackground(new java.awt.Color(247, 242, 239));
        btnBorrarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/eliminarIngrediente.png"))); // NOI18N
        btnBorrarSeleccion.setBorder(null);
        btnBorrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                            .addGap(294, 294, 294)
                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlHeaderLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(rbNombreProducto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbTipoProducto)
                                    .addGap(109, 109, 109))
                                .addComponent(lblTitulo1))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarSeleccion)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarSeleccion)
                    .addComponent(btnBuscar)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNombreProducto)
                            .addComponent(rbTipoProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBuscador.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlProductos.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.add(pnlProductos, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
       pantallaInicio.pintarPanelPrincipal(new PnlNuevoProducto(pantallaInicio));
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = txtBuscadorProducto.getText().trim();
        this.txtBuscadorProducto.setText("");

        List<ProductoDTO> productos = new ArrayList<>();

        if (filtro.isEmpty()) {
            try {
                productos = this.productosBO.obtenerProductosExistentes();
            } catch (ProductoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbNombreProducto.isSelected()) {
            try {
                productos = this.productosBO.obtenerProductosFiltradosNombre(filtro);
            } catch (ProductoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbTipoProducto.isSelected()) {
            try {
                productos = this.productosBO.obtenerProductosFiltradosTipo(filtro);

            } catch (ProductoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        cargarProductos(productos);
        this.opcionesBusqueda.clearSelection();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionActionPerformed
        List<ProductoDTO> productos;
        try {
            productos = this.productosBO.obtenerProductosExistentes();
            cargarProductos(productos);
        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBorrarSeleccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBorrarSeleccion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlBuscador;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JRadioButton rbNombreProducto;
    private javax.swing.JRadioButton rbTipoProducto;
    private javax.swing.JTextField txtBuscadorProducto;
    // End of variables declaration//GEN-END:variables
}
