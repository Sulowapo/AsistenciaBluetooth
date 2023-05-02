package formularios;

import interfaces.IConexionBD;

public class Menu extends javax.swing.JFrame {

    private IConexionBD conexion;
    
    public Menu(IConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrarAsistencia_jButton = new javax.swing.JButton();
        cargarBD_jButton = new javax.swing.JButton();
        registrarAlum_jButton = new javax.swing.JButton();
        registrarGrupo_jButton = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setName("Menú Principal"); // NOI18N

        registrarAsistencia_jButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        registrarAsistencia_jButton.setText("Registrar Asistencia");
        registrarAsistencia_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarAsistencia_jButtonActionPerformed(evt);
            }
        });

        cargarBD_jButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        cargarBD_jButton.setText("Cargar Base de Datos");

        registrarAlum_jButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        registrarAlum_jButton.setText("Registrar Alumno");

        registrarGrupo_jButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        registrarGrupo_jButton.setText("Registrar Grupo");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Asistencia Bluetooth");

        btnInforme.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnInforme.setText("Informe de Asistencias");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< Updated upstream
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
>>>>>>> Stashed changes
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargarBD_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(registrarAlum_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrarGrupo_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrarAsistencia_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cargarBD_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(registrarAlum_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(registrarGrupo_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(registrarAsistencia_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registrarAsistencia_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarAsistencia_jButtonActionPerformed
        new AsistenciaForm(Long.valueOf("1"), conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registrarAsistencia_jButtonActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        new InformeAsistencia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInformeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton cargarBD_jButton;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JButton registrarAlum_jButton;
    private javax.swing.JButton registrarAsistencia_jButton;
    private javax.swing.JButton registrarGrupo_jButton;
    // End of variables declaration//GEN-END:variables
}
