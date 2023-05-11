package formularios;

import entidades.Alumno;
import entidades.Grupo;
import interfaces.IConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
//import vista.Asistencia;
import com.itextpdf.text.Document;
import java.io.File;
import javax.swing.JFileChooser;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import control.ControlGrupos;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class InformeAsistencia extends javax.swing.JFrame {

    private IConexionBD conexion;
    private Statement statement;
    //private List<Alumno> listaAlumnos;
    //private List<Asistencia> listaAsistencias;
    private List<Grupo> listaGrupos;

    public InformeAsistencia(IConexionBD conexion) throws SQLException {
        initComponents();
        this.conexion = conexion;
        this.statement = this.conexion.obtenerConexion().createStatement();
        llenarComboboxGrupos();
    }

    private void llenarComboboxGrupos(){
        this.listaGrupos = new ControlGrupos(conexion).consultarGrupos();
        for(Grupo grupo: listaGrupos){
            cbGrupos.addItem(grupo.getNombreClase());
        }
    }

    private void llenarTablaInformes(String grupoSeleccionado) {
        DefaultTableModel modelo = (DefaultTableModel) tablaInforme.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de llenarla nuevamente
        try {
            String query = "SELECT alumnos.nombre AS nombre_alumno, alumnos.apellido AS apellido_alumno, alumnos.matricula AS matricula_alumno, asistencias.fechaHoraRegistro AS fecha_asistencia, asistencias.estado AS estado_asistencia "
                    + "FROM alumnos "
                    + "JOIN asistencias ON alumnos.id = asistencias.id_alumno "
                    + "JOIN grupos ON asistencias.id_grupo = grupos.id "
                    + "WHERE grupos.nombreClase = ?"; //Implementado con nombre del grupo pero es con id_grupo
            try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(query)) {
                statement.setString(1, grupoSeleccionado);
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        String nombre = rs.getString("nombre_alumno");
                        String apellido = rs.getString("apellido_alumno");
                        String matricula = rs.getString("matricula_alumno");
                        String fechaHoraRegistro = rs.getString("fecha_asistencia");
                        String estado = rs.getString("estado_asistencia");
                        modelo.addRow(new Object[]{nombre + " " + apellido, matricula, fechaHoraRegistro, estado});
                    }
                    //System.out.println("AQUI");
                    tablaInforme.setModel(modelo);
                }
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            // Manejo de excepciones
        }
    }

    private void llenarTablaEstadisticas(String grupoSeleccionado) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tablaEstadisticas.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de llenarla nuevamente
        String query = "SELECT alumnos.nombre, alumnos.apellido, alumnos.matricula, asistencias.fechaHoraRegistro, asistencias.estado, grupos.nombreClase\n"
                + "FROM alumnos\n"
                + "JOIN asistencias ON alumnos.id = asistencias.id_alumno\n"
                + "JOIN grupos ON asistencias.id_grupo = grupos.id"
                + "WHERE nombreClase = ?";
        try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(query)) {
            statement.setString(1, grupoSeleccionado);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int idAlumno = rs.getInt("id_alumno");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int presentes = rs.getInt("presentes");
                    int faltas = rs.getInt("faltas");
                    int retardos = rs.getInt("retardos");
                    int justificados = rs.getInt("justificados");
                    modelo.addRow(new Object[]{idAlumno, nombre, apellido, presentes, faltas, retardos, justificados});
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEstadisticas = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cal_FechaFin = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cal_FechaInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInforme = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbGrupos = new javax.swing.JComboBox<>();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informe Asistencia");

        tablaEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Alumno", "Presentes", "Faltas", "Justificados", "Retardos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaEstadisticas);

        btnAceptar.setBackground(new java.awt.Color(255, 153, 102));
        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Fin");

        tablaInforme.setFont(new java.awt.Font("Mongolian Baiti", 0, 15)); // NOI18N
        tablaInforme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Matricula", "Fecha", "Asistencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInforme.setToolTipText("");
        tablaInforme.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tablaInforme);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Inicio");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Grupo");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Informe Asistencia");

        cbGrupos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGruposActionPerformed(evt);
            }
        });

        btnPdf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPdf.setText("Descargar PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cal_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cal_FechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnSalir))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cal_FechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cal_FechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbGrupos))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String grupoSeleccionado = cbGrupos.getSelectedItem().toString();
        //llenarTablaInforme();
        llenarTablaInformes(grupoSeleccionado);
        //llenarTablaEstadisticas(grupoSeleccionado);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new MenuForm(conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGruposActionPerformed
    }//GEN-LAST:event_cbGruposActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Crear el objeto Document
            Document document = new Document(PageSize.A4);

            try {
                // Abrir el documento para escritura
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                // Crear el título "Informe de Asistencia"
                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
                Paragraph title = new Paragraph("Informe de Asistencia", titleFont);
                Paragraph blank = new Paragraph(" ");
                title.setAlignment(Element.ALIGN_CENTER);

                // Agregar el título al documento
                document.add(title);

                // Agregar salto de línea
                document.add(Chunk.NEWLINE);

                // Crear la tabla para tablaInforme
                PdfPTable tablaInformePdf = new PdfPTable(4);
                addTableContent(tablaInformePdf, tablaInforme);

                // Crear el título "Estadísticas"
                Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
                Paragraph subtitle = new Paragraph("Asistencias", subtitleFont);

                // Agregar salto de línea
                document.add(Chunk.NEWLINE);

                // Agregar el título "Estadísticas" al documento
                document.add(subtitle);
                document.add(blank);

                // Crear la tabla para tablaEstadisticas
                PdfPTable tablaEstadisticasPdf = new PdfPTable(6);
                addTableContent(tablaEstadisticasPdf, tablaEstadisticas);

                // Agregar tablaInforme al documento
                document.add(tablaInformePdf);

                Paragraph subtit = new Paragraph("Estadísticas", subtitleFont);

                // Agregar salto de línea
                document.add(Chunk.NEWLINE);

                document.add(subtit);
                document.add(blank);

                // Agregar tablaEstadisticas al documento
                document.add(tablaEstadisticasPdf);

                // Cerrar el documento
                document.close();

                // Mostrar mensaje de descarga exitosa
                JOptionPane.showMessageDialog(null, "Descarga exitosa");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    // Método para agregar el contenido de una JTable a una PdfPTable
    private void addTableContent(PdfPTable pdfTable, JTable jTable) {
        // Agregar encabezados de columna
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(jTable.getColumnName(i)));
            pdfTable.addCell(cell);
        }
        // Agregar contenido de celdas
        for (int row = 0; row < jTable.getRowCount(); row++) {
            for (int col = 0; col < jTable.getColumnCount(); col++) {
                Object value = jTable.getValueAt(row, col);
                String cellValue = (value != null) ? value.toString() : "";
                pdfTable.addCell(cellValue);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser cal_FechaFin;
    private com.toedter.calendar.JDateChooser cal_FechaInicio;
    private javax.swing.JComboBox<String> cbGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaEstadisticas;
    private javax.swing.JTable tablaInforme;
    // End of variables declaration//GEN-END:variables
}
