
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.IngredienteProductoDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteProductoExistente;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victoria
 */
public class PnlEditarProductoExistente extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private ProductoDTO producto;
    private List<IngredienteProductoDTO> ingredientes;
    private IProductosBO productosBO;
    
    public PnlEditarProductoExistente(FrmPantallaInicio pantallaInicio, ProductoDTO producto) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.producto = producto;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Detalles del producto");
        
        this.lblNombreProducto.setText(producto.getNombre());
        this.lblTipoProducto.setText(producto.getTipo().toString());
        this.txtPrecioProducto.setText(producto.getPrecio().toString());
        this.productosBO = FabricaObjetosNegocio.crearProductosBO();
        
        this.ingredientes = new ArrayList<>(this.producto.getIngredientes());
        
        int filas = (int) Math.ceil(ingredientes.size() / 3.0);
        this.pnlIngredientesProducto.setPreferredSize(new Dimension(pnlIngredientesProducto.getWidth(), filas * 210));
        
        cargarIngredientes(this.ingredientes);
        
    }

    public void cargarIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.pnlIngredientesProducto.removeAll();
        for (IngredienteProductoDTO ingrediente : ingredientes) {
            PnlIngredienteProductoExistente pnlIngrediente = new PnlIngredienteProductoExistente(ingrediente);
            pnlIngrediente.setPnlEditarProducto(this);
            pnlIngrediente.activarEdicionCantidad();
            this.pnlIngredientesProducto.add(pnlIngrediente);
        }

        this.pnlIngredientesProducto.revalidate();
        this.pnlIngredientesProducto.repaint();
    }

    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public JPanel getPnlIngredientesProducto() {
        return pnlIngredientesProducto;
    }

    
 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblTipoProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblTipoProducto1 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pnlFooter = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAgregarIngredientes = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
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

        txtPrecioProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtPrecioProducto.setBorder(null);

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
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoProducto)
                        .addComponent(lblTipoProducto1))
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        btnAgregarIngredientes.setBackground(new java.awt.Color(247, 242, 239));
        btnAgregarIngredientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarIngredientes.png"))); // NOI18N
        btnAgregarIngredientes.setBorder(null);
        btnAgregarIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIngredientesActionPerformed(evt);
            }
        });

        btnGuardarCambios.setBackground(new java.awt.Color(247, 242, 239));
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/guardarCambios.png"))); // NOI18N
        btnGuardarCambios.setBorder(null);
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnRegresar)
                .addGap(36, 36, 36)
                .addComponent(btnAgregarIngredientes)
                .addGap(34, 34, 34)
                .addComponent(btnGuardarCambios)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarCambios)
                    .addComponent(btnAgregarIngredientes)
                    .addComponent(btnRegresar))
                .addGap(21, 21, 21))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlIngredientesProducto.setBackground(new java.awt.Color(247, 242, 239));
        pnlIngredientesProducto.setPreferredSize(null);
        add(pnlIngredientesProducto, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // vuelve a la pantalla de inicio
        pantallaInicio.pintarPanelPrincipal(new PnlDetallesProductoExistente(pantallaInicio, producto));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        try {
            producto.setIngredientes(ingredientes);
            productosBO.actualizar(producto);
            JOptionPane.showMessageDialog(null, "Los cambios se guardaron correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            pantallaInicio.pintarPanelPrincipal(new PnlProductosExistentes(pantallaInicio));
        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnAgregarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredientesActionPerformed
        // pasar productodto a nuevoproductodto para agregar ingredientes 
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();

        for (IngredienteProductoDTO ingrediente : ingredientes) {

            IngredienteDTO ingredienteBuscador = new IngredienteDTO(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getUnidadMedida(), ingrediente.getCantidadStock());
            ingredientesDTO.add(ingredienteBuscador);

        }

        PnlBuscadorIngredientes buscador = new PnlBuscadorIngredientes(pantallaInicio);
        buscador.setIngredientesSeleccionados(ingredientesDTO);
        buscador.cargarIngredientesSeleccionados();
        buscador.setProductoExistente(producto);
        pantallaInicio.pintarPanelPrincipal(buscador);
    }//GEN-LAST:event_btnAgregarIngredientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarIngredientes;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblTipoProducto;
    private javax.swing.JLabel lblTipoProducto1;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlIngredientesProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
