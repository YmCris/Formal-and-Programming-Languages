package ymcris.languages.practice.lexicalanalyzer.frontend.dialogs;

import javax.swing.JOptionPane;
import ymcris.languages.practice.lexicalanalyzer.backend.file.Archivo;

/**
 * JDGuardarArchivo es el dialog encargado de guardar el archivo de texto en una
 * carpeta definida por el usuario.
 *
 * @author YmCris
 */
public class JDGuardarArchivo extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Archivo archivo;
    private String contenido;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDGuardarArchivo(String contenido) {
        this.contenido = contenido;
        this.setModal(true);
        initComponents();
        this.archivo = new Archivo();
        this.setModal(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("CARGAR ARCHIVO");
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRutaArchivo = new javax.swing.JTextField();
        btnGuardarArchivo = new javax.swing.JButton();
        jfcArchivoDeTexto = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtNombreDelArchivo = new javax.swing.JTextField();

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

        btnGuardarArchivo.setBackground(new java.awt.Color(58, 58, 60));
        btnGuardarArchivo.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnGuardarArchivo.setForeground(new java.awt.Color(229, 229, 231));
        btnGuardarArchivo.setText("Guardar");
        btnGuardarArchivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        jfcArchivoDeTexto.setBackground(new java.awt.Color(142, 142, 147));
        jfcArchivoDeTexto.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jfcArchivoDeTexto.setForeground(new java.awt.Color(142, 142, 147));
        jfcArchivoDeTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfcArchivoDeTextoActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 231));
        jLabel2.setText("Nombre del Archivo:");

        txtNombreDelArchivo.setBackground(new java.awt.Color(142, 142, 147));
        txtNombreDelArchivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreDelArchivo.setForeground(new java.awt.Color(229, 229, 231));
        txtNombreDelArchivo.setBorder(null);
        txtNombreDelArchivo.setCaretColor(new java.awt.Color(142, 142, 147));
        txtNombreDelArchivo.setDisabledTextColor(new java.awt.Color(142, 142, 147));
        txtNombreDelArchivo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtNombreDelArchivo.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtNombreDelArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDelArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreDelArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                            .addComponent(txtRutaArchivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jfcArchivoDeTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jfcArchivoDeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreDelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardarArchivo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    }//GEN-LAST:event_txtRutaArchivoActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        if (txtRutaArchivo.getText().isEmpty() || txtRutaArchivo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes elegir alguna carpeta para guardar el archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNombreDelArchivo.getText().isEmpty() || txtNombreDelArchivo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes colocarle un nombre al archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (archivo.existeArchivo(txtRutaArchivo.getText(), txtNombreDelArchivo.getText())) {
            JOptionPane.showMessageDialog(null, "El archivo ya existe, cambialo de nombre o de ruta", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!archivo.existeCarpeta(txtRutaArchivo.getText())) {
            JOptionPane.showMessageDialog(null, "La carpeta no existe", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        archivo.crearArchivo(txtRutaArchivo.getText(), txtNombreDelArchivo.getText());
        archivo.escribirEnArchivo(txtRutaArchivo.getText(), txtNombreDelArchivo.getText(), contenido);
        JOptionPane.showMessageDialog(null, "El archivo se ha guardado correctamente", "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void jfcArchivoDeTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfcArchivoDeTextoActionPerformed
        String rutaCarpeta = jfcArchivoDeTexto.getSelectedFile().getAbsolutePath();
        txtRutaArchivo.setText(rutaCarpeta);
    }//GEN-LAST:event_jfcArchivoDeTextoActionPerformed

    private void txtNombreDelArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDelArchivoActionPerformed
    }//GEN-LAST:event_txtNombreDelArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFileChooser jfcArchivoDeTexto;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextField txtNombreDelArchivo;
    private javax.swing.JTextField txtRutaArchivo;
    // End of variables declaration//GEN-END:variables
}
