
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoComandaDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.excepciones.ComandaException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlProductoComandaRegistrada;
import java.awt.Component;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

/**
 *Edición de la comanda.
 * @author victoria
 */
public class PnlEditarComanda extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private ComandaDTO comanda;
    private List<ProductoComandaDTO> productos;
    private PnlDetallesComanda detalles;
    private IComandasBO comandasBO;
    BigDecimal totalAcumulado;
    

    
    public PnlEditarComanda(FrmPantallaInicio pantallaInicio, ComandaDTO comanda, PnlDetallesComanda detalles) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.comanda = comanda;
        this.detalles = detalles;
        this.totalAcumulado = BigDecimal.ZERO;
        this.comandasBO = FabricaObjetosNegocio.crearComandasBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Editar comanda");
        
        this.lblFolioComanda.setText(comanda.getFolio());
        
        if(comanda.getCliente() != null){
            this.lblCliente.setText(comanda.getCliente().getNombres() + comanda.getCliente().getApellidoPaterno());
        }
    
        this.lblCliente.setText("No asignado");
        this.lblNumeroMesa.setText(comanda.getNumeroMesa().toString());
        
        pnlProductosComanda.setLayout(new BoxLayout(pnlProductosComanda, BoxLayout.Y_AXIS));
        this.pnlProductosComanda.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        this.productos = comanda.getProductos();
        cargarProductos(productos);
    }

    public void cargarProductos(List<ProductoComandaDTO> productos){
      this.pnlProductosComanda.removeAll();
  
        for (ProductoComandaDTO producto : productos) {
            PnlProductoComandaRegistrada pnlProducto = new PnlProductoComandaRegistrada(producto);
            pnlProductosComanda.add(Box.createVerticalStrut(10));
            pnlProducto.setPreferredSize(new Dimension(1200, 121));
            pnlProducto.setMaximumSize(new Dimension(1200, 121));
            pnlProducto.setMinimumSize(new Dimension(1200, 121));
            pnlProducto.setDetalles(this);
            pnlProducto.activarEdicionCantidad();
            pnlProducto.activarComentarios();
            pnlProducto.activarBotonesCantidad();
            pnlProductosComanda.add(pnlProducto);
            producto.setCantidad(pnlProducto.getCantidad());
            actualizarTotal();

        }
      this.lblTotalComanda.setText(totalAcumulado.toString());
      this.pnlProductosComanda.revalidate();
      this.pnlProductosComanda.repaint();
    }

    public List<ProductoComandaDTO> getProductos() {
        return comanda.getProductos();
    }

    public void setProductos(List<ProductoComandaDTO> productos) {
        this.comanda.setProductos(productos);
    }

    public void setDetalles(PnlDetallesComanda detalles) {
        this.detalles = detalles;
    }
    
    public void actualizarTotal() {
        totalAcumulado = BigDecimal.ZERO; 
        for (ProductoComandaDTO producto : comanda.getProductos()) {
            totalAcumulado = totalAcumulado.add(producto.getSubtotal());
        }
        lblTotalComanda.setText(totalAcumulado.toString());
        comanda.setTotalAcumulado(totalAcumulado);
    }

    public void setProductosPantallaDetalles(List<ProductoComandaDTO> productos){
        this.detalles.setProductos(productos);
    }

    public PnlDetallesComanda getDetallesComanda() {
        return detalles;
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
        btnGuardarCambios = new javax.swing.JButton();
        lblTotalComanda = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAgregarProductos = new javax.swing.JButton();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnGuardarCambios.setBackground(new java.awt.Color(247, 242, 239));
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnGuardarCambios.png"))); // NOI18N
        btnGuardarCambios.setBorder(null);
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
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

        btnAgregarProductos.setBackground(new java.awt.Color(247, 242, 239));
        btnAgregarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnAgregarProductos.png"))); // NOI18N
        btnAgregarProductos.setBorder(null);
        btnAgregarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(40, 40, 40)
                        .addComponent(btnAgregarProductos)
                        .addGap(33, 33, 33)
                        .addComponent(btnGuardarCambios)
                        .addGap(136, 136, 136))
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(405, 405, 405))))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalComanda))
                .addGap(18, 18, 18)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarCambios)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgregarProductos))
                .addGap(19, 19, 19))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlProductosComanda.setBackground(new java.awt.Color(247, 242, 239));
        pnlProductosComanda.setPreferredSize(null);
        add(pnlProductosComanda, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        pantallaInicio.pintarPanelPrincipal(detalles);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        List<ProductoComandaDTO> productosActualizados = new ArrayList<>();

        for (Component comp : pnlProductosComanda.getComponents()) {
            if (comp instanceof PnlProductoComandaRegistrada pnlProducto) {
                ProductoComandaDTO producto = pnlProducto.getProducto();
                producto.setComentario(pnlProducto.getComentario());
                productosActualizados.add(producto);
            }
        }

        comanda.setProductos(productosActualizados);
        comanda.setTotalAcumulado(totalAcumulado);

        try {
            ComandaDTO comandaActualizada = this.comandasBO.actualizar(comanda);
            JOptionPane.showMessageDialog(null, "La comanda: " + comandaActualizada.getFolio() + " se actualizó correctamente",
                    "Comanda actualizada", JOptionPane.INFORMATION_MESSAGE);

            detalles.setProductos(comandaActualizada.getProductos());
            detalles.revalidate();
            detalles.repaint();
            pantallaInicio.pintarPanelPrincipal(new PnlDetallesComanda(pantallaInicio, comanda));

        } catch (ComandaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al actualizar comanda", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        List<ProductoDTO> productos = new ArrayList<>();

        for (ProductoComandaDTO productoComanda : this.productos) {
            ProductoDTO productoDTO = new ProductoDTO(
                    productoComanda.getIdProducto(),
                    productoComanda.getNombreProducto(),
                    productoComanda.getPrecio(),
                    productoComanda.getTipo()
            );
            productos.add(productoDTO);
       }
        
        PnlBuscadorProductos buscador = new PnlBuscadorProductos(pantallaInicio);
        buscador.setProductosSeleccionados(productos);
        buscador.cargarProductosSeleccionados();
        buscador.setComandaExistente(comanda);
        pantallaInicio.pintarPanelPrincipal(buscador);
    }//GEN-LAST:event_btnAgregarProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProductos;
    private javax.swing.JButton btnGuardarCambios;
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
