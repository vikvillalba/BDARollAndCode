package itson.presentacion.frames;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.dominiorollandcode.dtos.ClienteReporteDTO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author victoria
 */
public class PnlReporteClientes extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IComandasBO comandasBO;

    public PnlReporteClientes(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        comandasBO = FabricaObjetosNegocio.crearComandasBO();

        JFormattedTextField txt = ((JSpinner.NumberEditor) numeroVisitas.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

    }

    private void llenarTabla(List<ClienteReporteDTO> clientes) {
        if (clientes == null) {
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblReporte.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        clientes.forEach(row -> {
            Object[] fila = new Object[5];
            fila[0] = row.getNombreCompleto();
            fila[1] = row.getNumeroVisitas();
            fila[2] = row.getTotalGastado();
            fila[3] = row.getPuntosFidelidad();
            fila[4] = convertirFecha(row.getUltimaComanda());

            modeloTabla.addRow(fila);
        });
    }

    private void cargarDatos() {
        String nombre = this.txtNombre.getText();
        int visitas = (int) numeroVisitas.getValue();
        List<ClienteReporteDTO> clientes = comandasBO.obtenerReporteClientesFrecuentes(nombre, visitas);

        if (clientes.isEmpty()) {
             JOptionPane.showMessageDialog(null, "No se encontraron registros relacionados", "Sin registros.", JOptionPane.INFORMATION_MESSAGE);
             this.txtNombre.setText(" ");
        }
        llenarTabla(clientes);
    }

    private String convertirFecha(Calendar fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(fecha.getTime());
    }

    public static BigDecimal convertToBigDecimal(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo.");
        }

        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;  // Ya es un BigDecimal
        } else if (obj instanceof String) {
            return new BigDecimal((String) obj);  // Convertir desde String
        } else if (obj instanceof Number) {
            return BigDecimal.valueOf(((Number) obj).doubleValue());  // Convertir desde Number
        } else {
            throw new IllegalArgumentException("El objeto no se puede convertir a BigDecimal.");
        }
    }

    private void addTableHeader(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new BaseColor(65, 70, 105));
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private void addTableCell(PdfPTable table, String text) {
        addTableCell(table, text, Element.ALIGN_LEFT);
    }

    private void addTableCell(PdfPTable table, String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(5);
        cell.setHorizontalAlignment(alignment);
        table.addCell(cell);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblNombreProducto1 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblNombreProducto2 = new javax.swing.JLabel();
        lblNombreProducto3 = new javax.swing.JLabel();
        numeroVisitas = new javax.swing.JSpinner();
        pnlFooter = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnGuardarReporte = new javax.swing.JButton();
        pnlIngredientesProducto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();

        setBackground(new java.awt.Color(247, 242, 239));
        setPreferredSize(new java.awt.Dimension(1272, 698));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(247, 242, 239));

        lblNombreProducto1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblNombreProducto1.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto1.setText("Reporte de clientes ");

        btnGenerarReporte.setBackground(new java.awt.Color(247, 242, 239));
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnGenerarReporte.png"))); // NOI18N
        btnGenerarReporte.setBorder(null);
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        txtNombre.setBorder(null);

        lblNombreProducto2.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblNombreProducto2.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto2.setText("Nombre cliente");

        lblNombreProducto3.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblNombreProducto3.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto3.setText("Número de visitas");

        numeroVisitas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        numeroVisitas.setBorder(null);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroVisitas))
                .addGap(67, 67, 67)
                .addComponent(btnGenerarReporte)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblNombreProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblNombreProducto1)
                .addGap(12, 12, 12)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProducto2)
                            .addComponent(lblNombreProducto3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(numeroVisitas))
                        .addContainerGap())
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.Alignment.TRAILING)))
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

        btnGuardarReporte.setBackground(new java.awt.Color(247, 242, 239));
        btnGuardarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnGuardarReporte.png"))); // NOI18N
        btnGuardarReporte.setBorder(null);
        btnGuardarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(61, 61, 61)
                .addComponent(btnGuardarReporte)
                .addGap(289, 289, 289))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(btnGuardarReporte))
                .addGap(21, 21, 21))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlIngredientesProducto.setBackground(new java.awt.Color(247, 242, 239));

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Número de visitas", "Total gastado", "Puntos de fidelidad", "Última comanda"
            }
        ));
        tblReporte.setPreferredSize(new java.awt.Dimension(450, 400));
        tblReporte.setSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout pnlIngredientesProductoLayout = new javax.swing.GroupLayout(pnlIngredientesProducto);
        pnlIngredientesProducto.setLayout(pnlIngredientesProductoLayout);
        pnlIngredientesProductoLayout.setHorizontalGroup(
            pnlIngredientesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientesProductoLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnlIngredientesProductoLayout.setVerticalGroup(
            pnlIngredientesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientesProductoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        add(pnlIngredientesProducto, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        if (txtNombre.getText().isEmpty() || txtNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Se debe de ingresar un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        cargarDatos();
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnGuardarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarReporteActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna carpeta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fullPath = String.format("%s/ReporteCliente.pdf", path);
        Document doc = new Document();
        File file = new File(fullPath);

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(fullPath));
            doc.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new BaseColor(65, 70, 105));
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, new BaseColor(227, 148, 147));
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);

            Paragraph title = new Paragraph("Reporte de Cliente frecuente", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);

            Paragraph valores = new Paragraph(
                    "Nombre: " + txtNombre.getText() + " Visitas mínimas: " + (int) numeroVisitas.getValue(),
                    subtitleFont
            );
            valores.setAlignment(Element.ALIGN_CENTER);
            doc.add(valores);

            doc.add(Chunk.NEWLINE);

            PdfPTable tbl = new PdfPTable(5);
            tbl.setWidthPercentage(100);
            tbl.setSpacingBefore(15f);
            tbl.setSpacingAfter(15f);

            float[] columnWidths = {1.2f, 2.5f, 1.5f, 2f, 1.5f};
            tbl.setWidths(columnWidths);

            addTableHeader(tbl, "Nombre", headerFont);
            addTableHeader(tbl, "Número de visitas", headerFont);
            addTableHeader(tbl, "Total gastado", headerFont);
            addTableHeader(tbl, "Puntos de fidelidad", headerFont);
            addTableHeader(tbl, "Última comanda", headerFont);

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

            for (int i = 0; i < tblReporte.getRowCount(); i++) {
                addTableCell(tbl, tblReporte.getValueAt(i, 0).toString());
                addTableCell(tbl, tblReporte.getValueAt(i, 1).toString());
                BigDecimal total = convertToBigDecimal(tblReporte.getValueAt(i, 2));
                String formattedTotal = currencyFormat.format(total);
                addTableCell(tbl, formattedTotal, Element.ALIGN_RIGHT);
                addTableCell(tbl, tblReporte.getValueAt(i, 3).toString());

                addTableCell(tbl, tblReporte.getValueAt(i, 4).toString());

            }

            doc.add(tbl);

            JOptionPane.showMessageDialog(this, "Documento generado con éxito!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (doc != null && doc.isOpen()) {
                doc.close();
            }
        }

        if (Desktop.isDesktopSupported() && file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "El PDF se generó pero no se pudo abrir: " + ex.getMessage(),
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGuardarReporte;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreProducto1;
    private javax.swing.JLabel lblNombreProducto2;
    private javax.swing.JLabel lblNombreProducto3;
    private javax.swing.JSpinner numeroVisitas;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlIngredientesProducto;
    private javax.swing.JTable tblReporte;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
