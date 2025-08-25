package ymcris.languages.practice.lexicalanalyzer.frontend.uploadfile;

import ymcris.languages.practice.lexicalanalyzer.backend.JSON.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.JFMenuPrincipal;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDCargarArchivo;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDReports;

/**
 *
 * @author YmCris
 */
public class JFAnalyzer extends javax.swing.JFrame {

    private ArchivoJSON json;

    public JFAnalyzer(ArchivoJSON json) {
        initComponents();
        this.json = json;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("MENÚ PRINCIPAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpBackground = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpTexto = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtpInformacion = new javax.swing.JTextPane();
        btnSeleccionarArchivo = new javax.swing.JButton();
        btnBuscarPalabra = new javax.swing.JButton();
        txtEscribirPalabra = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnGuardarTextoActual = new javax.swing.JButton();
        btnGenerarReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGenerarReportes1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpBackground.setBackground(new java.awt.Color(28, 28, 30));

        jtpTexto.setBackground(new java.awt.Color(100, 100, 105));
        jtpTexto.setBorder(null);
        jtpTexto.setForeground(new java.awt.Color(229, 229, 231));
        jtpTexto.setCaretColor(new java.awt.Color(100, 100, 105));
        jtpTexto.setDisabledTextColor(new java.awt.Color(100, 100, 105));
        jtpTexto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtpTexto.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jtpTexto);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jtpInformacion.setEditable(false);
        jtpInformacion.setBackground(new java.awt.Color(58, 58, 60));
        jtpInformacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60)));
        jtpInformacion.setForeground(new java.awt.Color(229, 229, 231));
        jtpInformacion.setCaretColor(new java.awt.Color(58, 58, 60));
        jtpInformacion.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        jtpInformacion.setSelectedTextColor(new java.awt.Color(58, 58, 60));
        jtpInformacion.setSelectionColor(new java.awt.Color(58, 58, 60));
        jScrollPane3.setViewportView(jtpInformacion);

        btnSeleccionarArchivo.setBackground(new java.awt.Color(58, 58, 60));
        btnSeleccionarArchivo.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnSeleccionarArchivo.setForeground(new java.awt.Color(229, 229, 231));
        btnSeleccionarArchivo.setText("Seleccionar Archivo");
        btnSeleccionarArchivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoActionPerformed(evt);
            }
        });

        btnBuscarPalabra.setBackground(new java.awt.Color(58, 58, 60));
        btnBuscarPalabra.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnBuscarPalabra.setForeground(new java.awt.Color(229, 229, 231));
        btnBuscarPalabra.setText("Buscar Palabra");
        btnBuscarPalabra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBuscarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPalabraActionPerformed(evt);
            }
        });

        txtEscribirPalabra.setBackground(new java.awt.Color(142, 142, 147));
        txtEscribirPalabra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEscribirPalabra.setForeground(new java.awt.Color(229, 229, 231));
        txtEscribirPalabra.setBorder(null);
        txtEscribirPalabra.setCaretColor(new java.awt.Color(142, 142, 147));
        txtEscribirPalabra.setDisabledTextColor(new java.awt.Color(142, 142, 147));
        txtEscribirPalabra.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtEscribirPalabra.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtEscribirPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscribirPalabraActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        btnGuardarTextoActual.setBackground(new java.awt.Color(58, 58, 60));
        btnGuardarTextoActual.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnGuardarTextoActual.setForeground(new java.awt.Color(229, 229, 231));
        btnGuardarTextoActual.setText("Guardar Texto Actual");
        btnGuardarTextoActual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuardarTextoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTextoActualActionPerformed(evt);
            }
        });

        btnGenerarReportes.setBackground(new java.awt.Color(58, 58, 60));
        btnGenerarReportes.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnGenerarReportes.setForeground(new java.awt.Color(229, 229, 231));
        btnGenerarReportes.setText("Generar Reportes");
        btnGenerarReportes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 231));
        jLabel1.setText("Texto de entrada:");

        jLabel2.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 231));
        jLabel2.setText("Resultados:");

        btnGenerarReportes1.setBackground(new java.awt.Color(58, 58, 60));
        btnGenerarReportes1.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnGenerarReportes1.setForeground(new java.awt.Color(229, 229, 231));
        btnGenerarReportes1.setText("Regresar al Menú Principal");
        btnGenerarReportes1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerarReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportes1ActionPerformed(evt);
            }
        });

        jdpBackground.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnSeleccionarArchivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnBuscarPalabra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(txtEscribirPalabra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnGuardarTextoActual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnGenerarReportes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnGenerarReportes1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpBackgroundLayout = new javax.swing.GroupLayout(jdpBackground);
        jdpBackground.setLayout(jdpBackgroundLayout);
        jdpBackgroundLayout.setHorizontalGroup(
            jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarTextoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBuscarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEscribirPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jdpBackgroundLayout.setVerticalGroup(
            jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarTextoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEscribirPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnBuscarPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpBackground)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpBackground)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
        new JDCargarArchivo().setVisible(true);
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void btnBuscarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPalabraActionPerformed

    private void btnGuardarTextoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTextoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarTextoActualActionPerformed

    private void btnGenerarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportesActionPerformed
        new JDReports(this).setVisible(true);
    }//GEN-LAST:event_btnGenerarReportesActionPerformed

    private void txtEscribirPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscribirPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscribirPalabraActionPerformed

    private void btnGenerarReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportes1ActionPerformed
        this.dispose();
        new JFMenuPrincipal(json).setVisible(true);
    }//GEN-LAST:event_btnGenerarReportes1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPalabra;
    private javax.swing.JButton btnGenerarReportes;
    private javax.swing.JButton btnGenerarReportes1;
    private javax.swing.JButton btnGuardarTextoActual;
    private javax.swing.JButton btnSeleccionarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JDesktopPane jdpBackground;
    private javax.swing.JTextPane jtpInformacion;
    private javax.swing.JTextPane jtpTexto;
    private javax.swing.JTextField txtEscribirPalabra;
    // End of variables declaration//GEN-END:variables
}
