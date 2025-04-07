package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlProductoExistenteComanda;
import itson.presentacion.frames.panelesIndividuales.PnlProductoSeleccionado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victoria
 */
public class PnlBuscadorProductos extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IProductosBO productosBO;
    private List<ProductoDTO> productosSeleccionados;
    private List<PnlProductoExistenteComanda> pnlProductosExistentes;
    private List<PnlProductoSeleccionado> pnlProductosCantidad;
    private ButtonGroup opcionesBusqueda;
    private NuevaComandaDTO comanda;
     
    public PnlBuscadorProductos(FrmPantallaInicio pantallaInicio, NuevaComandaDTO comanda) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.comanda = comanda;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Buscar Productos");
        
        this.pnlProductosExistentes = new ArrayList<>();
        this.productosSeleccionados = new ArrayList<>();
        this.pnlProductosCantidad = new ArrayList<>();
        this.productosBO = FabricaObjetosNegocio.crearProductosBO();
        
        opcionesBusqueda = new ButtonGroup();
        opcionesBusqueda.add(rbNombreProducto);
        opcionesBusqueda.add(rbTipoProducto);
        
        try {
            List<ProductoDTO> productosExistentes = productosBO.obtenerProductosExistentes();
            cargarProductos(productosBO.obtenerProductosDisponibles(productosExistentes));
        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar los productos", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void cargarProductos(List<ProductoDTO> productos) {
 
        this.pnlProductos.removeAll();
        this.pnlProductosExistentes.clear();

        for (ProductoDTO producto : productos) {
            PnlProductoExistenteComanda pnlProducto = new PnlProductoExistenteComanda(producto, this);
            this.pnlProductos.add(pnlProducto);
            this.pnlProductosExistentes.add(pnlProducto);
        }
        this.pnlProductos.revalidate();
        this.pnlProductos.repaint();

        pantallaInicio.getScrollPane().revalidate();
        pantallaInicio.getScrollPane().repaint();

    }

    public List<ProductoDTO> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(List<ProductoDTO> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public List<PnlProductoExistenteComanda> getPnlProductosExistentes() {
        return pnlProductosExistentes;
    }
    
   public void cargarProductosSeleccionados() {
    List<PnlProductoSeleccionado> anteriores = new ArrayList<>(pnlProductosCantidad);

    pnlProductosSeleccionados.removeAll();
    pnlProductosCantidad.clear();

    for (ProductoDTO producto : productosSeleccionados) {
        PnlProductoSeleccionado nuevoPanel = new PnlProductoSeleccionado(producto, this);

        for (PnlProductoSeleccionado panelAnterior : anteriores) {
            if (panelAnterior.getProductoDTO().getId().equals(producto.getId())) {
                nuevoPanel.setCantidad(panelAnterior.obtenerCantidad());
                break;
            }
        }

        pnlProductosSeleccionados.add(nuevoPanel);
        pnlProductosCantidad.add(nuevoPanel);
    }

    pnlProductosSeleccionados.revalidate();
    pnlProductosSeleccionados.repaint();
}


    public JPanel getPnlProductos() {
        return pnlProductos;
    }

    public JPanel getPnlProductosSeleccionados() {
        return pnlProductosSeleccionados;
    }

    public void setPnlProductosCantidad(List<PnlProductoSeleccionado> pnlProductosCantidad) {
        this.pnlProductosCantidad = pnlProductosCantidad;
    }

    public List<PnlProductoSeleccionado> getPnlProductosCantidad() {
        return pnlProductosCantidad;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRight = new javax.swing.JPanel();
        pnlHeader2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        btnContinuar = new javax.swing.JButton();
        pnlProductosSeleccionados = new javax.swing.JPanel();
        pnlBuscador = new javax.swing.JPanel();
        pnlHeader1 = new javax.swing.JPanel();
        rbTipoProducto = new javax.swing.JRadioButton();
        rbNombreProducto = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        txtBuscadorProducto = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        btnBorrarSeleccion = new javax.swing.JButton();
        pnlProductos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        pnlRight.setBackground(new java.awt.Color(249, 205, 204));
        pnlRight.setPreferredSize(new java.awt.Dimension(300, 518));
        pnlRight.setLayout(new java.awt.BorderLayout());

        pnlHeader2.setBackground(new java.awt.Color(249, 205, 204));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Productos");

        lblTitulo2.setFont(new java.awt.Font("STHeiti", 1, 30)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("seleccionados");

        javax.swing.GroupLayout pnlHeader2Layout = new javax.swing.GroupLayout(pnlHeader2);
        pnlHeader2.setLayout(pnlHeader2Layout);
        pnlHeader2Layout.setHorizontalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        pnlHeader2Layout.setVerticalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRight.add(pnlHeader2, java.awt.BorderLayout.PAGE_START);

        pnlFooter.setBackground(new java.awt.Color(249, 205, 204));

        btnContinuar.setBackground(new java.awt.Color(249, 205, 204));
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/seleccionContinuar.png"))); // NOI18N
        btnContinuar.setBorder(null);
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(btnContinuar)
                .addGap(40, 40, 40))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnContinuar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlRight.add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlProductosSeleccionados.setBackground(new java.awt.Color(249, 205, 204));
        pnlProductosSeleccionados.setPreferredSize(null);
        pnlRight.add(pnlProductosSeleccionados, java.awt.BorderLayout.CENTER);

        add(pnlRight, java.awt.BorderLayout.LINE_END);

        pnlBuscador.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.setLayout(new java.awt.BorderLayout());

        pnlHeader1.setBackground(new java.awt.Color(247, 242, 239));

        rbTipoProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbTipoProducto.setText("Tipo");

        rbNombreProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbNombreProducto.setText("Nombre");

        btnBuscar.setBackground(new java.awt.Color(247, 242, 239));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
<<<<<<< Updated upstream
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
=======
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
>>>>>>> Stashed changes

        txtBuscadorProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtBuscadorProducto.setBorder(null);

        lblTitulo1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo1.setText("Productos");

        btnBorrarSeleccion.setBackground(new java.awt.Color(247, 242, 239));
        btnBorrarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/eliminarIngrediente.png"))); // NOI18N
        btnBorrarSeleccion.setBorder(null);
        btnBorrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeader1Layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHeader1Layout.createSequentialGroup()
                                .addComponent(rbNombreProducto)
                                .addGap(68, 68, 68)
                                .addComponent(rbTipoProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTitulo1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarSeleccion)
                .addGap(27, 27, 27))
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar)
                    .addGroup(pnlHeader1Layout.createSequentialGroup()
                        .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNombreProducto)
                            .addComponent(rbTipoProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBorrarSeleccion))
                .addContainerGap())
        );

        pnlBuscador.add(pnlHeader1, java.awt.BorderLayout.PAGE_START);

        pnlProductos.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.add(pnlProductos, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlConfirmarComanda(pantallaInicio, this.pnlProductosCantidad, this, this.comanda));
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnBorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionActionPerformed

        try {
            List<ProductoDTO> productosExistentes = productosBO.obtenerProductosExistentes();
            cargarProductos(productosBO.obtenerProductosDisponibles(productosExistentes));

        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBorrarSeleccionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         String filtro = txtBuscadorProducto.getText().trim();
        this.txtBuscadorProducto.setText(""); 

        List<ProductoDTO> productos = new ArrayList<>();

        if (filtro.isEmpty()) {
             try {
                 productos = this.productosBO.obtenerProductosExistentes();
                 productos = this.productosBO.obtenerProductosDisponibles(productos);
             } catch (ProductoException ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
        } else if (rbNombreProducto.isSelected()) {
            try {
                productos = this.productosBO.obtenerProductosFiltradosNombre(filtro);
                productos = this.productosBO.obtenerProductosDisponibles(productos);
            } catch (ProductoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbTipoProducto.isSelected()) {
            try {
                productos = this.productosBO.obtenerProductosFiltradosTipo(filtro);
                productos = this.productosBO.obtenerProductosDisponibles(productos);

            } catch (ProductoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        cargarProductos(productos);
        this.opcionesBusqueda.clearSelection();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarSeleccion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlBuscador;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JPanel pnlHeader2;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlProductosSeleccionados;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JRadioButton rbNombreProducto;
    private javax.swing.JRadioButton rbTipoProducto;
    private javax.swing.JTextField txtBuscadorProducto;
    // End of variables declaration//GEN-END:variables
}
