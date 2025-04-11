package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.dtos.ClienteDTO;
import com.mycompany.dominiorollandcode.dtos.MesaDTO;
import com.mycompany.dominiorollandcode.dtos.NuevaComandaDTO;
import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import java.util.List;

/**
 *
 * @author victoria
 */
public class PnlNuevaComanda extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private NuevaComandaDTO comanda;
    private IMesasBO mesasBO;

    public PnlNuevaComanda(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.mesasBO = FabricaObjetosNegocio.crearMesasBO();
        this.comanda = new NuevaComandaDTO();
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Nueva Comanda");
        cargarMesas();
    }

    public void pnlNuevaComanda(PnlNuevaComanda panel, NuevaComandaDTO comanda) {
        pantallaInicio.pintarPanelPrincipal(panel.recuperarContexto(panel, comanda));
    }

    private PnlNuevaComanda recuperarContexto(PnlNuevaComanda panel, NuevaComandaDTO comanda) {
        PnlNuevaComanda pnlNuevaComanda = new PnlNuevaComanda(panel.pantallaInicio);
        pnlNuevaComanda.comanda.setCliente(comanda.getCliente());

        pnlNuevaComanda.cbxNumeroMesa.setSelectedItem(comanda.getMesa());
        pnlNuevaComanda.comanda.setMesa(comanda.getMesa());

        return pnlNuevaComanda;
    }

    private void cargarMesas() {
        List<MesaDTO> mesas = mesasBO.obtenerMesas();

        for (MesaDTO mesa : mesas) {
            this.cbxNumeroMesa.addItem(mesa.getNumero().toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        cbxNumeroMesa = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnAsignarCliente = new javax.swing.JButton();
        btnContinuarSinAsignarCliente = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));

        lblTitulo.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo.setText("Nueva Comanda");

        lblMesa.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblMesa.setForeground(new java.awt.Color(65, 70, 105));
        lblMesa.setText("Seleccione una mesa:");

        cbxNumeroMesa.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        cbxNumeroMesa.setBorder(null);
        cbxNumeroMesa.setPreferredSize(new java.awt.Dimension(89, 40));

        btnRegresar.setBackground(new java.awt.Color(247, 242, 239));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAsignarCliente.setBackground(new java.awt.Color(247, 242, 239));
        btnAsignarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/agregarClienteComanda.png"))); // NOI18N
        btnAsignarCliente.setBorder(null);
        btnAsignarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAsignarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarClienteActionPerformed(evt);
            }
        });

        btnContinuarSinAsignarCliente.setBackground(new java.awt.Color(247, 242, 239));
        btnContinuarSinAsignarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/continuarSinAgregarCliente.png"))); // NOI18N
        btnContinuarSinAsignarCliente.setBorder(null);
        btnContinuarSinAsignarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContinuarSinAsignarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarSinAsignarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(lblMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnRegresar)
                        .addGap(57, 57, 57)
                        .addComponent(btnAsignarCliente)
                        .addGap(57, 57, 57)
                        .addComponent(btnContinuarSinAsignarCliente)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblTitulo)
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMesa)
                    .addComponent(cbxNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addComponent(btnAsignarCliente)
                    .addComponent(btnContinuarSinAsignarCliente))
                .addGap(94, 94, 94))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // vuelve a la pantalla de inicio
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnContinuarSinAsignarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarSinAsignarClienteActionPerformed
        Integer numeroMesa = Integer.valueOf((String) cbxNumeroMesa.getSelectedItem());
        MesaDTO mesa = this.mesasBO.obtenerMesa(numeroMesa);
        comanda.setMesa(mesa);
        PnlBuscadorProductos buscador = new PnlBuscadorProductos(pantallaInicio);
        buscador.setComanda(comanda);
        pantallaInicio.pintarPanelPrincipal(buscador);
    }//GEN-LAST:event_btnContinuarSinAsignarClienteActionPerformed

    private void btnAsignarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarClienteActionPerformed
        Integer numeroMesa = Integer.valueOf((String) cbxNumeroMesa.getSelectedItem());
        MesaDTO mesa = this.mesasBO.obtenerMesa(numeroMesa);
        comanda.setMesa(mesa);
        pantallaInicio.pintarPanelPrincipal(new PnlBuscarClientes(pantallaInicio, comanda, this, true));
    }//GEN-LAST:event_btnAsignarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarCliente;
    private javax.swing.JButton btnContinuarSinAsignarCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxNumeroMesa;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
