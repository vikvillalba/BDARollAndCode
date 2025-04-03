
package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.IngredienteDTO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.excepciones.IngredienteException;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteExistente;
import itson.presentacion.frames.panelesIndividuales.PnlIngredienteSeleccionado;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class PnlBuscadorIngredientes extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IIngredientesBO ingredientesBO;
    private List<IngredienteDTO> ingredientesSeleccionados = new ArrayList<>();
    private List<PnlIngredienteExistente> pnlIngredientesExistentes = new ArrayList<>();
   
    public PnlBuscadorIngredientes(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.ingredientesBO = pantallaInicio.getIngredientesBO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Buscar Ingredientes");
        cargarIngredientes(ingredientesBO.obtenerIngredientesExistentes());
        ButtonGroup opcionesBusqueda =  new ButtonGroup();
        opcionesBusqueda.add(rbNombreIngrediente);
        opcionesBusqueda.add(rbUnidadMedida);
    }

    private void cargarIngredientes(List<IngredienteDTO> ingredientes) {
        for (int i = 0; i < ingredientes.size(); i++) {
            // por cada ingrediente existente en la bd crea un panel
            IngredienteDTO ingrediente = ingredientes.get(i);

            PnlIngredienteExistente pnlIngrediente = new PnlIngredienteExistente(ingrediente, this);
            this.pnlIngredientes.add(pnlIngrediente);
            this.pnlIngredientesExistentes.add(pnlIngrediente); 
        }
    }
    

    public List<IngredienteDTO> getIngredientesSeleccionados(){
        return ingredientesSeleccionados;
    }

    public void setIngredientesSeleccionados(List<IngredienteDTO> ingredientesSeleccionados) {
       this.ingredientesSeleccionados = ingredientesSeleccionados;
    }

    public void cargarIngredientesSeleccionados() {
        this.pnlIngredientesSeleccionados.removeAll();
        
        for (int i = 0; i < ingredientesSeleccionados.size(); i++) {
            IngredienteDTO ingrediente = ingredientesSeleccionados.get(i);
            PnlIngredienteSeleccionado pnlIngrediente = new PnlIngredienteSeleccionado(ingrediente, this);
            this.pnlIngredientesSeleccionados.add(pnlIngrediente);
        }

        this.pnlIngredientesSeleccionados.revalidate();
        this.pnlIngredientesSeleccionados.repaint();
    }

    public PnlIngredienteExistente getPanelIngredienteExistente(IngredienteDTO ingrediente) {
        for (PnlIngredienteExistente pnl : pnlIngredientesExistentes) {
            if (pnl.getIngredienteDTO().equals(ingrediente)) {
                return pnl;
            }
        }
        return null;
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

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/seleccionContinuar.png"))); // NOI18N
        btnContinuar.setBorder(null);
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                        .addGap(0, 354, Short.MAX_VALUE)
                        .addComponent(rbNombreIngrediente)
                        .addGap(61, 61, 61)
                        .addComponent(rbUnidadMedida)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo1)
                .addGap(149, 149, 149))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlBuscador.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlIngredientes.setBackground(new java.awt.Color(247, 242, 239));
        pnlIngredientes.setPreferredSize(new java.awt.Dimension(0, 543));
        pnlBuscador.add(pnlIngredientes, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       if(rbNombreIngrediente.isSelected()){
           String filtro = txtBuscadorIngrediente.getText();
           try {
               List<IngredienteDTO> ingredientesNombre = this.ingredientesBO.obtenerIngredientesFiltradosNombre(filtro);
               cargarIngredientes(ingredientesNombre);
               
           } catch (IngredienteException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage(), "Error" ,JOptionPane.ERROR_MESSAGE);
           }
       }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
