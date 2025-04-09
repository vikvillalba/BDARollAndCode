
package itson.presentacion.frames;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author victoria
 */
public class PnlSeleccionarProductos extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
     
    public PnlSeleccionarProductos(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        pantallaInicio.pintarPanelPrincipal(this);
        pantallaInicio.setTitle("Buscar Productos");
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
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
        pnlHeader = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        txtBuscadorProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        rbNombreProducto = new javax.swing.JRadioButton();
        rbTipoProducto = new javax.swing.JRadioButton();
        pnlProductos = new javax.swing.JPanel();

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

        pnlProductosSeleccionados.setBackground(new java.awt.Color(249, 205, 204));

        javax.swing.GroupLayout pnlProductosSeleccionadosLayout = new javax.swing.GroupLayout(pnlProductosSeleccionados);
        pnlProductosSeleccionados.setLayout(pnlProductosSeleccionadosLayout);
        pnlProductosSeleccionadosLayout.setHorizontalGroup(
            pnlProductosSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pnlProductosSeleccionadosLayout.setVerticalGroup(
            pnlProductosSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        pnlRight.add(pnlProductosSeleccionados, java.awt.BorderLayout.CENTER);

        add(pnlRight, java.awt.BorderLayout.LINE_END);

        pnlBuscador.setBackground(new java.awt.Color(247, 242, 239));
        pnlBuscador.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));
        pnlHeader.setPreferredSize(new java.awt.Dimension(572, 140));

        lblTitulo1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(65, 70, 105));
        lblTitulo1.setText("Productos");

        txtBuscadorProducto.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtBuscadorProducto.setBorder(null);

        btnBuscar.setBackground(new java.awt.Color(247, 242, 239));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rbNombreProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbNombreProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbNombreProducto.setText("Nombre");

        rbTipoProducto.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        rbTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        rbTipoProducto.setText("Tipo");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 319, Short.MAX_VALUE)
                .addComponent(rbNombreProducto)
                .addGap(147, 147, 147)
                .addComponent(rbTipoProducto)
                .addGap(353, 353, 353))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo1)
                .addGap(386, 386, 386))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTipoProducto)
                    .addComponent(rbNombreProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtBuscadorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscar))
        );

        pnlBuscador.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlProductos.setBackground(new java.awt.Color(247, 242, 239));
        pnlProductos.setPreferredSize(null);
        pnlBuscador.add(pnlProductos, java.awt.BorderLayout.CENTER);

        add(pnlBuscador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlProductosSeleccionados;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JRadioButton rbNombreProducto;
    private javax.swing.JRadioButton rbTipoProducto;
    private javax.swing.JTextField txtBuscadorProducto;
    // End of variables declaration//GEN-END:variables

}
