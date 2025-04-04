package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.dominiorollandcode.dtos.NuevoProductoDTO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.excepciones.IngredienteException;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteExistente;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteSeleccionado;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victoria
 */
public class PnlBuscadorIngredientes extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IIngredientesBO ingredientesBO;
    private NuevoProductoDTO nuevoProductoDTO;
    // para los ingredientes que se ponen en el panel de ingredientesseleccionados;
    private List<IngredienteDTO> ingredientesSeleccionados = new ArrayList<>();
    private List<PnlIngredienteExistente> pnlIngredientesExistentes = new ArrayList<>();
    private ButtonGroup opcionesBusqueda;

    public PnlBuscadorIngredientes(FrmPantallaInicio pantallaInicio,  NuevoProductoDTO nuevoProductoDTO) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.ingredientesBO = pantallaInicio.getIngredientesBO();
        this.nuevoProductoDTO = nuevoProductoDTO;

        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Buscar Ingredientes");
        cargarIngredientes(ingredientesBO.obtenerIngredientesExistentes());
        opcionesBusqueda = new ButtonGroup();
        opcionesBusqueda.add(rbNombreIngrediente);
        opcionesBusqueda.add(rbUnidadMedida);
    }

    private void cargarIngredientes(List<IngredienteDTO> ingredientes) {
        this.pnlIngredientes.removeAll(); 
        this.pnlIngredientesExistentes.clear(); 


        for (IngredienteDTO ingrediente : ingredientes) {
            PnlIngredienteExistente pnlIngrediente = new PnlIngredienteExistente(ingrediente, this);
            this.pnlIngredientes.add(pnlIngrediente);
            this.pnlIngredientesExistentes.add(pnlIngrediente); 
        }

        this.pnlIngredientes.revalidate();
        this.pnlIngredientes.repaint(); 
    }

    public List<IngredienteDTO> getIngredientesSeleccionados() {
        return ingredientesSeleccionados;
    }

    public void setIngredientesSeleccionados(List<IngredienteDTO> ingredientesSeleccionados) {
        this.ingredientesSeleccionados = ingredientesSeleccionados;
    }

    public void cargarIngredientesSeleccionados() {
        this.pnlIngredientesSeleccionados.removeAll(); 
        for (IngredienteDTO ingrediente : ingredientesSeleccionados) {
            boolean yaExiste = false;

            for (Component component : this.pnlIngredientesSeleccionados.getComponents()) {
                if (component instanceof PnlIngredienteSeleccionado) {
                    PnlIngredienteSeleccionado pnl = (PnlIngredienteSeleccionado) component;
                    if (pnl.getIngredienteDTO().equals(ingrediente)) {
                        yaExiste = true;
                        break;
                    }
                }
            }
            if (!yaExiste) {
                PnlIngredienteSeleccionado pnlIngrediente = new PnlIngredienteSeleccionado(ingrediente, this);
                this.pnlIngredientesSeleccionados.add(pnlIngrediente);
            }
        }

        this.pnlIngredientesSeleccionados.revalidate(); 
        this.pnlIngredientesSeleccionados.repaint();
    }

    public List<PnlIngredienteExistente> getPnlIngredientesExistentes() {
        return pnlIngredientesExistentes;
    }

    public JPanel getPnlIngredientes() {
        return pnlIngredientes;
    }

    public JPanel getPnlIngredientesSeleccionados() {
        return pnlIngredientesSeleccionados;
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
        pnlIngredientesSeleccionados = new javax.swing.JPanel();
        pnlBuscador = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        txtBuscadorIngrediente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        rbNombreIngrediente = new javax.swing.JRadioButton();
        rbUnidadMedida = new javax.swing.JRadioButton();
        btnBorrarSeleccion = new javax.swing.JButton();
        pnlIngredientes = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));
        setLayout(new java.awt.BorderLayout());

        pnlRight.setBackground(new java.awt.Color(249, 205, 204));
        pnlRight.setPreferredSize(new java.awt.Dimension(300, 518));
        pnlRight.setLayout(new java.awt.BorderLayout());

        pnlHeader2.setBackground(new java.awt.Color(249, 205, 204));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ingredientes");

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
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        pnlIngredientesSeleccionados.setBackground(new java.awt.Color(249, 205, 204));
        pnlRight.add(pnlIngredientesSeleccionados, java.awt.BorderLayout.CENTER);

        add(pnlRight, java.awt.BorderLayout.LINE_END);

        pnlBuscador.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));
        pnlHeader.setPreferredSize(new java.awt.Dimension(572, 140));

        lblTitulo1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo1.setText("Selección de Ingredientes");

        txtBuscadorIngrediente.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtBuscadorIngrediente.setBorder(null);

        btnBuscar.setBackground(new java.awt.Color(247, 242, 239));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        rbNombreIngrediente.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbNombreIngrediente.setForeground(new java.awt.Color(65, 70, 105));
        rbNombreIngrediente.setText("Nombre");

        rbUnidadMedida.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbUnidadMedida.setForeground(new java.awt.Color(65, 70, 105));
        rbUnidadMedida.setText("Unidad de medida");

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
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtBuscadorIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(0, 343, Short.MAX_VALUE)
                        .addComponent(rbNombreIngrediente)
                        .addGap(61, 61, 61)
                        .addComponent(rbUnidadMedida)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarSeleccion)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 221, Short.MAX_VALUE)
                .addComponent(lblTitulo1)
                .addGap(149, 149, 149))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarSeleccion)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbNombreIngrediente)
                                    .addComponent(rbUnidadMedida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscadorIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlBuscador.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlIngredientes.setBackground(new java.awt.Color(247, 242, 239));
        pnlIngredientes.setPreferredSize(new java.awt.Dimension(0, 543));
        pnlBuscador.add(pnlIngredientes, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = txtBuscadorIngrediente.getText().trim();
        this.txtBuscadorIngrediente.setText(""); 

        List<IngredienteDTO> ingredientes = new ArrayList<>();

        if (filtro.isEmpty()) {
            ingredientes = this.ingredientesBO.obtenerIngredientesExistentes();
        } else if (rbNombreIngrediente.isSelected()) {
            try {
                ingredientes = this.ingredientesBO.obtenerIngredientesFiltradosNombre(filtro);
            } catch (IngredienteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbUnidadMedida.isSelected()) {
            try {
                ingredientes = this.ingredientesBO.obtenerIngredientesFiltradosUnidadMedida(filtro);
            } catch (IngredienteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        cargarIngredientes(ingredientes);
        this.opcionesBusqueda.clearSelection();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionActionPerformed
        List<IngredienteDTO> ingredientes = this.ingredientesBO.obtenerIngredientesExistentes();
        cargarIngredientes(ingredientes);
    }//GEN-LAST:event_btnBorrarSeleccionActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // ingredientesseleccionados
        this.nuevoProductoDTO.setIngredientes(ingredientesSeleccionados);
        pantallaInicio.pintarPanelPrincipal(new PnlConfirmarNuevoProducto(pantallaInicio, nuevoProductoDTO, this));
    }//GEN-LAST:event_btnContinuarActionPerformed


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
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeader2;
    private javax.swing.JPanel pnlIngredientes;
    private javax.swing.JPanel pnlIngredientesSeleccionados;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JRadioButton rbNombreIngrediente;
    private javax.swing.JRadioButton rbUnidadMedida;
    private javax.swing.JTextField txtBuscadorIngrediente;
    // End of variables declaration//GEN-END:variables
}
