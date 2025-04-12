package itson.presentacion.frames;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.mycompany.dominiorollandcode.dtos.ComandaReporteDTO;
import com.mycompany.dominiorollandcode.dtos.ProductoDTO;
import com.mycompany.negociorollandcode.IComandasBO;
import com.mycompany.negociorollandcode.fabrica.FabricaObjetosNegocio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoria
 */
public class PnlReporteComanda extends javax.swing.JPanel {

    private FrmPantallaInicio pantallaInicio;
    private IComandasBO comandasBO;

    public PnlReporteComanda(FrmPantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        comandasBO = FabricaObjetosNegocio.crearComandasBO();

    }

    private void llenarTabla(List<ComandaReporteDTO> comandas) {
        if (comandas == null) {
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblReporte.getModel();
        comandas.forEach(row -> {
            Object[] fila = new Object[6];
            fila[0] = row.getFolio();
            fila[1] = this.convertirFecha(row.getFechaHora());
            fila[2] = row.getNumeroMesa();
            fila[3] = row.getTotalVenta();
            fila[4] = row.getEstadoComanda();
            fila[5] = row.getNombreCompleto();

            modeloTabla.addRow(fila);
        });
    }

    private void cargarDatos() {
        Calendar fechaInicio = this.fechaInicio.getCalendar();
        Calendar fechaFin = this.fechaFin.getCalendar();
        List<ComandaReporteDTO> comandas = comandasBO.obtenerComandasReporte(fechaInicio, fechaFin);

        llenarTabla(comandas);
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
        cell.setBackgroundColor(new BaseColor(51, 102, 153));  // Color azul corporativo
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
        lblTipoProducto = new javax.swing.JLabel();
        lblTipoProducto1 = new javax.swing.JLabel();
        lblNombreProducto1 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        fechaFin = new com.toedter.calendar.JDateChooser();
        fechaInicio = new com.toedter.calendar.JDateChooser();
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

        lblTipoProducto.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTipoProducto.setForeground(new java.awt.Color(65, 70, 105));
        lblTipoProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoProducto.setText("de");

        lblTipoProducto1.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblTipoProducto1.setForeground(new java.awt.Color(65, 70, 105));
        lblTipoProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoProducto1.setText("a");

        lblNombreProducto1.setFont(new java.awt.Font("STHeiti", 1, 48)); // NOI18N
        lblNombreProducto1.setForeground(new java.awt.Color(65, 70, 105));
        lblNombreProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto1.setText("Reporte de comandas");

        btnGenerarReporte.setBackground(new java.awt.Color(247, 242, 239));
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilerias/botones/btnGenerarReporte.png"))); // NOI18N
        btnGenerarReporte.setBorder(null);
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(lblTipoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(btnGenerarReporte)))
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlHeaderLayout.createSequentialGroup()
                    .addGap(317, 317, 317)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(814, Short.MAX_VALUE)))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNombreProducto1)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGenerarReporte)
                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTipoProducto1)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoProducto)
                        .addContainerGap())))
            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                    .addContainerGap(93, Short.MAX_VALUE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
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
                "Folio", "Fecha y hora", "Num mesa", "Total de venta", "Estado", "Cliente"
            }
        ));
        tblReporte.setPreferredSize(new java.awt.Dimension(450, 400));
        tblReporte.setSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout pnlIngredientesProductoLayout = new javax.swing.GroupLayout(pnlIngredientesProducto);
        pnlIngredientesProducto.setLayout(pnlIngredientesProductoLayout);
        pnlIngredientesProductoLayout.setHorizontalGroup(
            pnlIngredientesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngredientesProductoLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        pnlIngredientesProductoLayout.setVerticalGroup(
            pnlIngredientesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientesProductoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlIngredientesProducto, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        pantallaInicio.pintarPanelPrincipal(new PnlPantallaPrincipal(pantallaInicio, pantallaInicio.getMesasBO()));
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
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

        String fullPath = String.format("%s/ReporteComandas.pdf", path);
        Document doc = new Document();
        File file = new File(fullPath);

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(fullPath));
            doc.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);


            Paragraph title = new Paragraph("Reporte de Ganancias por Comandas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);

            Paragraph dates = new Paragraph(
                    "Periodo: " + convertirFecha(fechaInicio.getCalendar()) + " - " + convertirFecha(fechaFin.getCalendar()),
                    subtitleFont
            );
            dates.setAlignment(Element.ALIGN_CENTER);
            doc.add(dates);

            doc.add(Chunk.NEWLINE);

            PdfPTable tbl = new PdfPTable(6);
            tbl.setWidthPercentage(100);
            tbl.setSpacingBefore(15f);
            tbl.setSpacingAfter(15f);


            float[] columnWidths = {1.2f, 2.5f, 1.5f, 2f, 1.5f, 2f};
            tbl.setWidths(columnWidths);

            addTableHeader(tbl, "Folio", headerFont);
            addTableHeader(tbl, "Fecha y Hora", headerFont);
            addTableHeader(tbl, "Mesa", headerFont);
            addTableHeader(tbl, "Total Venta", headerFont);
            addTableHeader(tbl, "Estado", headerFont);
            addTableHeader(tbl, "Cliente", headerFont);

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            BigDecimal suma = BigDecimal.ZERO;

            for (int i = 0; i < tblReporte.getRowCount(); i++) {
                addTableCell(tbl, tblReporte.getValueAt(i, 0).toString());
                addTableCell(tbl, tblReporte.getValueAt(i, 1).toString());
                addTableCell(tbl, tblReporte.getValueAt(i, 2).toString());

                BigDecimal total = convertToBigDecimal(tblReporte.getValueAt(i, 3));
                String formattedTotal = currencyFormat.format(total);
                addTableCell(tbl, formattedTotal, Element.ALIGN_RIGHT);

                addTableCell(tbl, tblReporte.getValueAt(i, 4).toString());
                addTableCell(tbl, tblReporte.getValueAt(i, 5).toString());

                suma = suma.add(total);
            }

            doc.add(tbl);

            Paragraph totalParagraph = new Paragraph(
                    "Ganancias Totales: " + currencyFormat.format(suma),
                    totalFont
            );
            totalParagraph.setAlignment(Element.ALIGN_RIGHT);
            doc.add(totalParagraph);

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
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreProducto1;
    private javax.swing.JLabel lblTipoProducto;
    private javax.swing.JLabel lblTipoProducto1;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlIngredientesProducto;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}
