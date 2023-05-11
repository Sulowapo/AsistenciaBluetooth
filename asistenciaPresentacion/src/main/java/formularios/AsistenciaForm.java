package formularios;

import control.ControlAlumnos;
import control.ControlAsistencia;
import control.ControlGrupos;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultCellEditor;
import interfaces.IConexionBD;
import javax.swing.JComboBox;
import java.util.ArrayList;
import funciones.Tiempo;
import entidades.Alumno;
import entidades.Asistencia;
import entidades.Grupo;
import funciones.RemoteDeviceDiscovery;
import interfacescontrol.IControlAlumnos;
import java.awt.Color;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.RemoteDevice;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class AsistenciaForm extends javax.swing.JFrame {

    private IConexionBD conexion;
    private Long id_grupo;
    private List<Alumno> listaAlumnos = new ArrayList<>();
    private boolean asistenciaBluetooth = false;
    private boolean hiloIniciado = false;
    private Thread hilo;
    private Vector<RemoteDevice> dispositivosDescubiertos;
    private List<Grupo> listaGrupos;

    public AsistenciaForm(Long id_grupo, IConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        this.id_grupo = id_grupo;
        this.hilo = new Thread(verificadorBluetooth);
        asignarFecha();
        generarTabla(id_grupo);
        llenarComboboxGrupos();
    }

    private void asignarFecha() {
        Tiempo time = new Tiempo();
        this.labelFecha.setText(time.getFecha());
    }

    private void llenarComboboxGrupos(){
        this.listaGrupos = new ControlGrupos(conexion).consultarGrupos();
        for(Grupo grupo: listaGrupos){
            cbGrupos.addItem(grupo.getNombreClase());
        }
    }
    
    private void generarTabla(Long id_grupo) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaAsistencia.getModel();
        modeloTabla.setRowCount(0);
        IControlAlumnos controlAlumnos = new ControlAlumnos(conexion);
        listaAlumnos = controlAlumnos.consultarAlumnosPorGrupo(id_grupo);
        List<Asistencia> listaAsistencia = new ControlAsistencia(conexion).consultarAsistenciasGrupoPorFecha(id_grupo, labelFecha.getText());
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("Presente");
        comboBox1.addItem("Retardo");
        comboBox1.addItem("Falta");
        comboBox1.addItem("Justificado");

        //Altura de las filas de la tabla
        tablaAsistencia.setRowHeight(22);

        //Centrar datos de columnas
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tablaAsistencia.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tablaAsistencia.getColumnModel().getColumn(4).setCellRenderer(tcr);

        int i = 1;
        for (Alumno alumno : listaAlumnos) {
            modeloTabla.addRow(new Object[]{i,
                alumno.getMatricula_alumno(),
                alumno.getApellido() + " " + alumno.getNombre(),
                alumno.getCorreo_alumno()
            });
            i++;
        }

        tablaAsistencia.setModel(modeloTabla);
        tablaAsistencia.getColumnModel().getColumn(0).setMaxWidth(70);
        tablaAsistencia.getColumnModel().getColumn(0).setResizable(false);
        tablaAsistencia.getColumnModel().getColumn(1).setMaxWidth(100);
        tablaAsistencia.getColumnModel().getColumn(1).setMinWidth(100);
        tablaAsistencia.getColumnModel().getColumn(1).setResizable(false);
        tablaAsistencia.getColumnModel().getColumn(2).setMaxWidth(300);
        tablaAsistencia.getColumnModel().getColumn(2).setMinWidth(300);
        tablaAsistencia.getColumnModel().getColumn(2).setResizable(false);
        tablaAsistencia.getColumnModel().getColumn(3).setMaxWidth(300);
        tablaAsistencia.getColumnModel().getColumn(3).setMinWidth(300);
        tablaAsistencia.getColumnModel().getColumn(3).setResizable(false);
        tablaAsistencia.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox1));

        if (!listaAsistencia.isEmpty()) {
            for (Asistencia asistencia : listaAsistencia) {
                i = 0;
                for (Alumno alumno : listaAlumnos) {
                    if (Objects.equals(alumno.getId_Alumno(), asistencia.getId_alumno())) {
                        tablaAsistencia.setValueAt(asistencia.getEstado(), i, 4);
                    }
                    i++;
                }
            }
        }
    }

    public List<Asistencia> obtenerAsistencias() {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaAsistencia.getModel();
        List<Asistencia> listaAsistencias = new ArrayList<>();
        String estado;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Long id_Alumno = listaAlumnos.get(i).getId_Alumno();
            if (modelo.getValueAt(i, 4) == null) {
                estado = "Falta";
            } else {
                estado = modelo.getValueAt(i, 4).toString();
            }
            listaAsistencias.add(new Asistencia(id_Alumno, id_grupo, labelFecha.getText(), estado));
        }
        return listaAsistencias;
    }

    public boolean verificarRegistroAsistencia() {
        return new ControlAsistencia(conexion).verificarExistenciaAsistencia(id_grupo, labelFecha.getText());
    }

    Runnable verificadorBluetooth = new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (asistenciaBluetooth) {
                    try {
                        dispositivosDescubiertos = new RemoteDeviceDiscovery().getDevices();
                        int i = 0;
                        for (Alumno alumno : listaAlumnos) {
                            for (RemoteDevice dispositivosDescubierto : dispositivosDescubiertos) {
                                if (alumno.getDispositivoBluetoothDireccion() == null ? dispositivosDescubierto.getBluetoothAddress() == null : alumno.getDispositivoBluetoothDireccion().equals(dispositivosDescubierto.getBluetoothAddress())) {
                                    tablaAsistencia.setValueAt("Presente", i, 4);
                                }
                            }
                            i++;
                        }
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("Hilo");
                    }
                } else {
                    synchronized (this) {
                        while (!asistenciaBluetooth) {
                            try {
                                wait();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AsistenciaForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                }
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAsistencia = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnVincular = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        cbGrupos = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAsistenciaBluetooth = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Asistencia");
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de asistencia");

        jLabel4.setBackground(new java.awt.Color(102, 255, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Curso/Nivel");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Fecha");

        tablaAsistencia.setFont(new java.awt.Font("Mongolian Baiti", 0, 15)); // NOI18N
        tablaAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", "", ""},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "ID", "Nombre completo", "Correo", "Asistencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAsistencia.setToolTipText("");
        tablaAsistencia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaAsistencia);

        btnGuardar.setBackground(new java.awt.Color(102, 255, 102));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVincular.setBackground(new java.awt.Color(153, 153, 255));
        btnVincular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVincular.setForeground(new java.awt.Color(0, 0, 0));
        btnVincular.setText("Vincular dispositivos");
        btnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularActionPerformed(evt);
            }
        });

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha.setText("---");

        cbGrupos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbGrupos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGruposItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnSalir.setBackground(new java.awt.Color(255, 204, 153));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("<<< Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAsistenciaBluetooth.setBackground(new java.awt.Color(51, 153, 255));
        btnAsistenciaBluetooth.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAsistenciaBluetooth.setForeground(new java.awt.Color(0, 0, 0));
        btnAsistenciaBluetooth.setText("Activar asistencia por Bluetooth");
        btnAsistenciaBluetooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaBluetoothActionPerformed(evt);
            }
        });

        jMenu1.setText("Asistencia");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Grupo");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Archivos");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVincular, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAsistenciaBluetooth, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(693, 693, 693))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFecha)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVincular, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btnAsistenciaBluetooth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        List<Asistencia> listaAsistencia = obtenerAsistencias();
        boolean registro = verificarRegistroAsistencia();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de guardar la asistencia?\n aquellos registros vacíos serán tomados como falta", "Registrar asistencia", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            if (registro == true) {
                for (Asistencia asistencia : listaAsistencia) {
                    if (!new ControlAsistencia(conexion).registrarAsistencia(asistencia)) {
                        Alumno alumno = new ControlAlumnos(conexion).consultarAlumnoPorId(asistencia.getId_alumno());
                        JOptionPane.showMessageDialog(this, "Error al registrar la asistencia del alumno " + alumno.getApellido() + " " + alumno.getNombre(), "Fallo en la asistencia", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(this, "Se registró la asistencia correctamente", "Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (Asistencia asistencia : listaAsistencia) {
                    if (!new ControlAsistencia(conexion).actualizarAsistencia(asistencia)) {
                        Alumno alumno = new ControlAlumnos(conexion).consultarAlumnoPorId(asistencia.getId_alumno());
                        JOptionPane.showMessageDialog(this, "Error al registrar la asistencia del alumno " + alumno.getApellido() + " " + alumno.getNombre(), "Fallo en la asistencia", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(this, "Se actualizó la asistencia correctamente", "Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularActionPerformed
        // TODO add your handling code here:
        new VincularForm(id_grupo, conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVincularActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new MenuForm(conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAsistenciaBluetoothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaBluetoothActionPerformed
        // TODO add your handling code here:
        if (asistenciaBluetooth == false) {
            if (!hiloIniciado) {
                hilo.start();
                hiloIniciado = true;
            }
            asistenciaBluetooth = true;
            btnAsistenciaBluetooth.setText("Desactivar Bluetooth");
            btnAsistenciaBluetooth.setBackground(Color.RED);
        } else {
//            try {
//                System.out.println("Antes de hilo");
//                hilo.join();
//                System.out.println("Depsues de hilo");
            asistenciaBluetooth = false;
            btnAsistenciaBluetooth.setText("Activar asistencia por Bluetooth");
            btnAsistenciaBluetooth.setBackground(Color.BLUE);
//            } catch (InterruptedException ex) {
//                System.out.println("Test");
//            }
        }
    }//GEN-LAST:event_btnAsistenciaBluetoothActionPerformed

    private void cbGruposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGruposItemStateChanged
        // TODO add your handling code here:
         for(Grupo grupo: listaGrupos){
             if(grupo.getNombreClase() == cbGrupos.getSelectedItem()){
                 generarTabla(grupo.getId_grupo());
             }
         }
    }//GEN-LAST:event_cbGruposItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistenciaBluetooth;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVincular;
    private javax.swing.JComboBox<String> cbGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JTable tablaAsistencia;
    // End of variables declaration//GEN-END:variables

}
