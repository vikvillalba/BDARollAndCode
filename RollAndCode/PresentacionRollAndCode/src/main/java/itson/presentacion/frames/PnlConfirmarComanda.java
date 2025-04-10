
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlProductoComandaSeleccionado;
import itson.presentacion.frames.panelesIndividuales.PnlProductoSeleccionado;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlConfirmarComanda extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private List<PnlProductoSeleccionado> productos;
    private PnlBuscadorProductos buscador;
    private List<NuevoProductoComandaDTO> productosComanda;
    private List<PnlProductoComandaSeleccionado> pnlProductosSeleccionados;
    private ClienteDTO cliente;
    private NuevaComandaDTO comanda;
    private IComandasBO comandasBO;
     
    public PnlConfirmarComanda(FrmPantallaInicio pantallaInicio, List<PnlProductoSeleccionado> productos, PnlBuscadorProductos buscador, NuevaComandaDTO comanda) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.productos = productos;
        this.buscador = buscador;
        this.comanda = comanda;
        this.comandasBO = FabricaObjetosNegocio.crearComandasBO();
        this.cliente = comanda.getCliente();
        
        this.productosComanda = new ArrayList<>();
        this.pnlProductosSeleccionados = new ArrayList<>();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Confirmar comanda");
        cargarProductos();
        calcularTotal();
        
    }
    
    public void cargarProductos() {
        this.pnlProductos.removeAll();

        for (PnlProductoSeleccionado producto : productos) {
            PnlProductoComandaSeleccionado productoComanda = new PnlProductoComandaSeleccionado(producto, this);
            this.pnlProductos.add(productoComanda);
            this.pnlProductosSeleccionados.add(productoComanda);
        }

        this.buscador.setPnlProductosCantidad(productos);
        this.pnlProductos.revalidate();
        this.pnlProductos.repaint();
    }

    public void calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (PnlProductoSeleccionado pnlProducto : productos) {
            ProductoDTO producto = pnlProducto.getProductoDTO();
            int cantidad = pnlProducto.obtenerCantidad(); 
            BigDecimal precio = producto.getPrecio(); 
            BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(cantidad));
            total = total.add(subtotal);
        }
        total = total.setScale(2, RoundingMode.HALF_UP);
        lblTotal.setText(total.toPlainString());
        
    }

    public List<PnlProductoSeleccionado> getProductos() {
        return productos;
    }

    public void setProductos(List<PnlProductoSeleccionado> productos) {
        this.productos = productos;
    }

    public List<ProductoDTO> obtenerProductosSeleccionados(){
        return this.buscador.getProductosSeleccionados();
    }

    public PnlBuscadorProductos getBuscador() {
        return buscador;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscador = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();
        btnCrearComanda = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        pnlProductos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));
        setLayout(new java.awt.BorderLayout());

        pnlBuscador.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));
        pnlHeader.setPreferredSize(new java.awt.Dimension(572, 140));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Confirmar comanda");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(lblTitulo)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pnlBuscador.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlFooter.setBackground(new java.awt.Color(247, 242, 239));

        lblTotal.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(65, 70, 105));
        lblTotal.setText("00.00");

        lblTexto.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(65, 70, 105));
        lblTexto.setText("TOTAL: $");

        btnCrearComanda.setBackground(new java.awt.Color(247, 242, 239));
        btnCrearComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/crearComanda.png"))); // NOI18N
        btnCrearComanda.setBorder(null);
        btnCrearComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearComandaActionPerformed(evt);
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
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                        .addComponent(lblTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(38, 38, 38)
                        .addComponent(btnCrearComanda)
                        .addGap(316, 316, 316))))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTexto)))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearComanda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23))
        );

        pnlBuscador.add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlProductos.setBackground(new java.awt.Color(247, 242, 239));
        pnlProductos.setPreferredSize(null);
        pnlBuscador.add(pnlProductos, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.pantallaInicio.pintarPanelPrincipal(buscador);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCrearComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearComandaActionPerformed
        for (PnlProductoComandaSeleccionado producto : pnlProductosSeleccionados) {
            NuevoProductoComandaDTO nuevoProductoComandaDTO = new NuevoProductoComandaDTO();
            nuevoProductoComandaDTO.setIdProducto(producto.getProductoDTO().getId());
            nuevoProductoComandaDTO.setCantidadProducto(producto.getCantidadProducto());
            nuevoProductoComandaDTO.setComentario(producto.getComentario());
            nuevoProductoComandaDTO.setPrecioProducto(producto.getProductoDTO().getPrecio());
            
            productosComanda.add(nuevoProductoComandaDTO);
        }
        
        this.comanda.setProductos(productosComanda);
        this.comanda.setCliente(cliente);
        
        try {
            this.comandasBO.registrarComanda(comanda);
            JOptionPane.showMessageDialog(null, "Comanda creada correctamente", "Comanda registrada", JOptionPane.INFORMATION_MESSAGE);
            this.pantallaInicio.pintarPanelPrincipal(new PnlNuevaComanda(pantallaInicio));
        } catch (ComandaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCrearComandaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearComanda;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBuscador;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlProductos;
    // End of variables declaration//GEN-END:variables
}
