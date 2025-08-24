package ymcris.languages.practice.lexicalanalyzer.frontend.dialogs;

import javax.swing.JOptionPane;

/**
 *
 * @author YmCris
 */
public class JDCargarArchivo extends javax.swing.JDialog {

    public JDCargarArchivo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("CARGAR ARCHIVO");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRutaArchivo = new javax.swing.JTextField();
        btnSeleccionarArchivo = new javax.swing.JButton();
        jfcArchivoDeTexto = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl.setBackground(new java.awt.Color(28, 28, 30));

        jLabel1.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 231));
        jLabel1.setText("Ruta del Archivo:");

        txtRutaArchivo.setBackground(new java.awt.Color(142, 142, 147));
        txtRutaArchivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtRutaArchivo.setForeground(new java.awt.Color(229, 229, 231));
        txtRutaArchivo.setBorder(null);
        txtRutaArchivo.setCaretColor(new java.awt.Color(142, 142, 147));
        txtRutaArchivo.setDisabledTextColor(new java.awt.Color(142, 142, 147));
        txtRutaArchivo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtRutaArchivo.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtRutaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaArchivoActionPerformed(evt);
            }
        });

        btnSeleccionarArchivo.setBackground(new java.awt.Color(58, 58, 60));
        btnSeleccionarArchivo.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnSeleccionarArchivo.setForeground(new java.awt.Color(229, 229, 231));
        btnSeleccionarArchivo.setText("Seleccionar");
        btnSeleccionarArchivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoActionPerformed(evt);
            }
        });

        jfcArchivoDeTexto.setBackground(new java.awt.Color(142, 142, 147));
        jfcArchivoDeTexto.setForeground(new java.awt.Color(142, 142, 147));
        jfcArchivoDeTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfcArchivoDeTextoActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarArchivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jfcArchivoDeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jfcArchivoDeTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarArchivo))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaArchivoActionPerformed

    private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void jfcArchivoDeTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfcArchivoDeTextoActionPerformed
        String nombreArchivo = jfcArchivoDeTexto.getSelectedFile().getName();
        String rutaCarpeta = jfcArchivoDeTexto.getSelectedFile().getAbsolutePath();
        if (nombreArchivo.length() > 4) {
            if (!nombreArchivo.substring(nombreArchivo.length() - 4, nombreArchivo.length()).equals(".txt")) {
                JOptionPane.showMessageDialog(null, "El archivo debe ser un archivo de texto", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            txtRutaArchivo.setText(rutaCarpeta);
        }
    }//GEN-LAST:event_jfcArchivoDeTextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFileChooser jfcArchivoDeTexto;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextField txtRutaArchivo;
    // End of variables declaration//GEN-END:variables
}
