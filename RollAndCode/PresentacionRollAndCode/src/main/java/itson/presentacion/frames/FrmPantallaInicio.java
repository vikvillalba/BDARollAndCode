package itson.presentacion.frames;

import com.mycompany.dominiorollandcode.entidades.Usuario;
import com.mycompany.dominiorollandcode.enums.TipoUsuario;
import com.mycompany.negociorollandcode.IClientesBO;
import com.mycompany.negociorollandcode.IIngredientesBO;
import com.mycompany.negociorollandcode.IMesasBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import itson.presentacion.frames.panelesIndividuales.ModoVista;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Clase que contiene el menú de navegación, y actúa como control de navegación entre las pantallas.
 *
 * @author victoria
 */
public class FrmPantallaInicio extends javax.swing.JFrame {

    private boolean mesasAgregadas = false;
    private final IMesasBO mesasBO = FabricaObjetosNegocio.crearMesasBO();
    private final IIngredientesBO ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();
    private final IClientesBO clientesBO = FabricaObjetosNegocio.crearClientesBO();
    private Usuario usuario;

    public FrmPantallaInicio(Usuario usuario) {
        initComponents();
        this.setTitle("Roll & Code");
        this.btnInicioActionPerformed(null);
        this.setSize(1272, 789);
        this.setLocationRelativeTo(null);
        this.usuario = usuario;

        if (!this.usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)) {
            btnClientesFrecuentes.setEnabled(false);
            btnIngredientes.setEnabled(false);
            btnProductos.setEnabled(false);
            btnReportes.setEnabled(false);
        }

    }

    public void pintarPanelPrincipal(JPanel panel) {
        scrollPane.setViewportView(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.revalidate();
        scrollPane.repaint();
        panel.revalidate();
        panel.repaint();
    }

    public boolean isMesasAgregadas() {
        return mesasAgregadas;
    }

    public void setMesasAgregadas(boolean mesasAgregadas) {
        this.mesasAgregadas = mesasAgregadas;
    }

    public IMesasBO getMesasBO() {
        return mesasBO;
    }

    public IIngredientesBO getIngredientesBO() {
        return ingredientesBO;
    }

    public IClientesBO getClientesBO() {
        return clientesBO;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        pnlFondo = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        JMenuPrincipal = new javax.swing.JMenuBar();
        separador = new javax.swing.JMenu();
        btnInicio = new javax.swing.JMenu();
        btnComandas = new javax.swing.JMenu();
        btnNuevaComanda = new javax.swing.JMenuItem();
        btnVerComandas = new javax.swing.JMenuItem();
        btnProductos = new javax.swing.JMenu();
        btnVerProductos = new javax.swing.JMenuItem();
        btnNuevoProducto = new javax.swing.JMenuItem();
        btnIngredientes = new javax.swing.JMenu();
        btnVerIngredientes = new javax.swing.JMenuItem();
        btnNuevoIngrediente = new javax.swing.JMenuItem();
        btnClientesFrecuentes = new javax.swing.JMenu();
        btnBuscarCliente = new javax.swing.JMenuItem();
        btnNuevoCliente = new javax.swing.JMenuItem();
        btnReportes = new javax.swing.JMenu();
        btnReporteClientes = new javax.swing.JMenuItem();
        btnReporteComandas = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFondo.setBackground(new java.awt.Color(247, 242, 239));
        pnlFondo.setLayout(new javax.swing.BoxLayout(pnlFondo, javax.swing.BoxLayout.LINE_AXIS));

        scrollPane.setPreferredSize(null);
        pnlFondo.add(scrollPane);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        JMenuPrincipal.setBackground(new java.awt.Color(249, 205, 204));
        JMenuPrincipal.setPreferredSize(new java.awt.Dimension(75, 80));

        separador.setEnabled(false);
        separador.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        separador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        separador.setMinimumSize(new java.awt.Dimension(130, 50));
        separador.setPreferredSize(new java.awt.Dimension(30, 50));
        JMenuPrincipal.add(separador);

        btnInicio.setText("Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInicio.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.setPreferredSize(new java.awt.Dimension(80, 50));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        JMenuPrincipal.add(btnInicio);

        btnComandas.setText("Comandas");
        btnComandas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnComandas.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnComandas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComandas.setMinimumSize(new java.awt.Dimension(130, 50));
        btnComandas.setPreferredSize(new java.awt.Dimension(130, 50));

        btnNuevaComanda.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnNuevaComanda.setText("Crear comanda");
        btnNuevaComanda.setPreferredSize(new java.awt.Dimension(190, 45));
        btnNuevaComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaComandaActionPerformed(evt);
            }
        });
        btnComandas.add(btnNuevaComanda);

        btnVerComandas.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnVerComandas.setText("Ver comandas ");
        btnVerComandas.setPreferredSize(new java.awt.Dimension(190, 45));
        btnVerComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComandasActionPerformed(evt);
            }
        });
        btnComandas.add(btnVerComandas);

        JMenuPrincipal.add(btnComandas);

        btnProductos.setText("Productos");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProductos.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setPreferredSize(new java.awt.Dimension(120, 50));

        btnVerProductos.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnVerProductos.setText("Ver productos");
        btnVerProductos.setPreferredSize(new java.awt.Dimension(190, 45));
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });
        btnProductos.add(btnVerProductos);

        btnNuevoProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnNuevoProducto.setText("Agregar producto");
        btnNuevoProducto.setPreferredSize(new java.awt.Dimension(200, 45));
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });
        btnProductos.add(btnNuevoProducto);

        JMenuPrincipal.add(btnProductos);

        btnIngredientes.setText("Ingredientes");
        btnIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngredientes.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnIngredientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngredientes.setPreferredSize(new java.awt.Dimension(130, 50));

        btnVerIngredientes.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnVerIngredientes.setText("Ver Ingredientes");
        btnVerIngredientes.setPreferredSize(new java.awt.Dimension(190, 45));
        btnVerIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerIngredientesActionPerformed(evt);
            }
        });
        btnIngredientes.add(btnVerIngredientes);

        btnNuevoIngrediente.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnNuevoIngrediente.setText("Agregar Ingrediente");
        btnNuevoIngrediente.setPreferredSize(new java.awt.Dimension(220, 45));
        btnNuevoIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoIngredienteActionPerformed(evt);
            }
        });
        btnIngredientes.add(btnNuevoIngrediente);

        JMenuPrincipal.add(btnIngredientes);

        btnClientesFrecuentes.setText("Clientes Frecuentes");
        btnClientesFrecuentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientesFrecuentes.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnClientesFrecuentes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientesFrecuentes.setPreferredSize(new java.awt.Dimension(200, 50));
        btnClientesFrecuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesFrecuentesActionPerformed(evt);
            }
        });

        btnBuscarCliente.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(210, 45));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        btnClientesFrecuentes.add(btnBuscarCliente);

        btnNuevoCliente.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnNuevoCliente.setText("Agregar cliente");
        btnNuevoCliente.setPreferredSize(new java.awt.Dimension(190, 45));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        btnClientesFrecuentes.add(btnNuevoCliente);

        JMenuPrincipal.add(btnClientesFrecuentes);

        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReportes.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes.setMinimumSize(new java.awt.Dimension(130, 50));
        btnReportes.setPreferredSize(new java.awt.Dimension(130, 50));

        btnReporteClientes.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnReporteClientes.setText("Reporte de clientes");
        btnReporteClientes.setPreferredSize(new java.awt.Dimension(210, 45));
        btnReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteClientesActionPerformed(evt);
            }
        });
        btnReportes.add(btnReporteClientes);

        btnReporteComandas.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnReporteComandas.setText("Reporte de comandas");
        btnReporteComandas.setPreferredSize(new java.awt.Dimension(240, 45));
        btnReporteComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteComandasActionPerformed(evt);
            }
        });
        btnReportes.add(btnReporteComandas);

        JMenuPrincipal.add(btnReportes);

        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setPreferredSize(new java.awt.Dimension(80, 50));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        JMenuPrincipal.add(btnSalir);

        setJMenuBar(JMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        this.pintarPanelPrincipal(new PnlNuevoProducto(this));
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        this.pintarPanelPrincipal(new PnlProductosExistentes(this));
    }//GEN-LAST:event_btnVerProductosActionPerformed

    private void btnNuevaComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaComandaActionPerformed
        this.pintarPanelPrincipal(new PnlNuevaComanda(this));
    }//GEN-LAST:event_btnNuevaComandaActionPerformed

    private void btnNuevoIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoIngredienteActionPerformed
        this.pintarPanelPrincipal(new PnlNuevoIngrediente(this));
    }//GEN-LAST:event_btnNuevoIngredienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        try {
            this.pintarPanelPrincipal(new PnlRegistrarCliente(this));
        } catch (Exception ex) {
            Logger.getLogger(FrmPantallaInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnVerIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerIngredientesActionPerformed
        this.pintarPanelPrincipal(new PnlIngredientesExistentes(this));
    }//GEN-LAST:event_btnVerIngredientesActionPerformed

    private void btnClientesFrecuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesFrecuentesActionPerformed

    }//GEN-LAST:event_btnClientesFrecuentesActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        this.pintarPanelPrincipal(new PnlBuscarClientes(this, false));
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnVerComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComandasActionPerformed
        this.pintarPanelPrincipal(new PnlComandasActivas(this));
    }//GEN-LAST:event_btnVerComandasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        this.pintarPanelPrincipal(new PnlPantallaPrincipal(this, mesasBO));
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        this.pintarPanelPrincipal(new PnlPantallaPrincipal(this, mesasBO));
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        this.dispose();
        ModoVista vista = new ModoVista();
        vista.setVisible(true);
    }//GEN-LAST:event_btnSalirMousePressed

    private void btnReporteComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteComandasActionPerformed
        this.pintarPanelPrincipal(new PnlReporteComanda(this));
    }//GEN-LAST:event_btnReporteComandasActionPerformed

    private void btnReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteClientesActionPerformed
        this.pintarPanelPrincipal(new PnlReporteClientes(this));
    }//GEN-LAST:event_btnReporteClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuPrincipal;
    private javax.swing.JMenuItem btnBuscarCliente;
    private javax.swing.JMenu btnClientesFrecuentes;
    private javax.swing.JMenu btnComandas;
    private javax.swing.JMenu btnIngredientes;
    private javax.swing.JMenu btnInicio;
    private javax.swing.JMenuItem btnNuevaComanda;
    private javax.swing.JMenuItem btnNuevoCliente;
    private javax.swing.JMenuItem btnNuevoIngrediente;
    private javax.swing.JMenuItem btnNuevoProducto;
    private javax.swing.JMenu btnProductos;
    private javax.swing.JMenuItem btnReporteClientes;
    private javax.swing.JMenuItem btnReporteComandas;
    private javax.swing.JMenu btnReportes;
    private javax.swing.JMenu btnSalir;
    private javax.swing.JMenuItem btnVerComandas;
    private javax.swing.JMenuItem btnVerIngredientes;
    private javax.swing.JMenuItem btnVerProductos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JMenu separador;
    // End of variables declaration//GEN-END:variables
}
