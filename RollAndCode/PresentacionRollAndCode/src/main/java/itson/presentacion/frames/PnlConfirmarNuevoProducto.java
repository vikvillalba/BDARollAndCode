
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoIngredienteDTO;
import com.mycompany.negociorollandcode.IProductosBO;
import com.mycompany.negociorollandcode.excepciones.ProductoException;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.excepciones.PresentacionException;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlConfirmarNuevoProducto extends javax.swing.JPanel {


    private FrmPantallaInicio pantallaInicio;
    private PnlBuscadorIngredientes buscadorIngredientes;
    private List<IngredienteDTO> ingredientesProducto;
    private NuevoProductoDTO nuevoProductoDTO;
    private IProductosBO productosBO;
    private List<PnlIngredienteProducto> panelesIngredientes;
    
    public PnlConfirmarNuevoProducto(FrmPantallaInicio pantallaInicio, NuevoProductoDTO nuevoProductoDTO, PnlBuscadorIngredientes buscadorIngredientes) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.productosBO = FabricaObjetosNegocio.crearProductosBO();
        this.nuevoProductoDTO = nuevoProductoDTO;
        this.buscadorIngredientes = buscadorIngredientes;
        this.panelesIngredientes = new ArrayList<>();
        
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Confirmar nuevo producto");
        
        
        this.lblNombreProducto.setText(nuevoProductoDTO.getNombre());
        this.lblTipoProducto.setText(nuevoProductoDTO.getTipo().toString());
        
        cargarIngredientes();
    }


    private void cargarIngredientes(){
        ingredientesProducto = this.nuevoProductoDTO.getIngredientes();
        for (IngredienteDTO ingredienteDTO : ingredientesProducto) {
            PnlIngredienteProducto ingrediente = new PnlIngredienteProducto(ingredienteDTO);
            this.pnlIngredientesProducto.add(ingrediente);
            this.panelesIngredientes.add(ingrediente);
        }
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
        btnGuardarNuevoProducto = new javax.swing.JButton();
        pnlIngredientesProducto = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));
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
                .addContainerGap()
                .addComponent(lblNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        btnGuardarNuevoProducto.setBackground(new java.awt.Color(247, 242, 239));
        btnGuardarNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/guardarNuevoProducto.png"))); // NOI18N
        btnGuardarNuevoProducto.setBorder(null);
        btnGuardarNuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNuevoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(btnRegresar)
                .addGap(136, 136, 136)
                .addComponent(btnGuardarNuevoProducto)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarNuevoProducto)
                    .addComponent(btnRegresar))
                .addGap(21, 21, 21))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlIngredientesProducto.setBackground(new java.awt.Color(247, 242, 239));
        pnlIngredientesProducto.setPreferredSize(null);
        pnlIngredientesProducto.setRequestFocusEnabled(false);
        add(pnlIngredientesProducto, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        pantallaInicio.pintarPanelPrincipal(buscadorIngredientes);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNuevoProductoActionPerformed
        // Obtener cantidad por cada producto
        List<NuevoProductoIngredienteDTO> ingredientes = new ArrayList<>();
        for (PnlIngredienteProducto panelIngrediente : panelesIngredientes) {

            String cantidadtxt = panelIngrediente.getCantidadTxt();

            if (cantidadtxt == null || cantidadtxt.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacía.", "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer cantidad = null;
            try {
                cantidad = Integer.valueOf(cantidadtxt);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número válido.", "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }

            IngredienteDTO ingrediente = panelIngrediente.getIngrediente();
            NuevoProductoIngredienteDTO ingredienteRelacion = new NuevoProductoIngredienteDTO();
            ingredienteRelacion.setIdIngrediente(ingrediente.getId());
            ingredienteRelacion.setCantidad(cantidad);
            ingredientes.add(ingredienteRelacion);
        }

        String preciotxt = this.txtPrecioProducto.getText();
        if (preciotxt == null || preciotxt.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El precio no puede estar vacío.", "Precio inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal precio = null;
        try {
            precio = new BigDecimal(preciotxt);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.", "Precio inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nuevoProductoDTO.setIngredientesRelacion(ingredientes);
        nuevoProductoDTO.setPrecio(precio);

        try {
            this.productosBO.registrar(nuevoProductoDTO);
            JOptionPane.showMessageDialog(null, "Producto registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            pantallaInicio.pintarPanelPrincipal(new PnlProductosExistentes(pantallaInicio));
        } catch (ProductoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            pantallaInicio.pintarPanelPrincipal(new PnlNuevoProducto(pantallaInicio));
        }
    }//GEN-LAST:event_btnGuardarNuevoProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarNuevoProducto;
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
