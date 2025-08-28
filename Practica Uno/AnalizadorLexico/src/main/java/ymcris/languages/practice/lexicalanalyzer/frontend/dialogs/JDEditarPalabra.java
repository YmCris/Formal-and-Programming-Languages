package ymcris.languages.practice.lexicalanalyzer.frontend.dialogs;

import java.awt.Frame;
import javax.swing.JOptionPane;
import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;

/**
 * JavaDialog encargado de editar una palabra del archivo JSON
 *
 * @author crist
 */
public class JDEditarPalabra extends javax.swing.JDialog {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String lista;
    private String palabra;
    private ArchivoJSON json;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JDEditarPalabra(Frame parent, String lista, String palabra, ArchivoJSON json) {
        super(parent, true);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("EDITAR");
        this.json = json;
        this.lista = lista;
        this.lblTexto.setText(palabra);
        this.palabra = palabra;
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFormulario1 = new javax.swing.JPanel();
        lblTexto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnEditarPalabra = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNuevaPalabra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlFormulario1.setBackground(new java.awt.Color(28, 28, 30));

        lblTexto.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTexto.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText("private");
        lblTexto.setToolTipText("");
        lblTexto.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTexto.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTexto.setName(""); // NOI18N
        lblTexto.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        btnEditarPalabra.setBackground(new java.awt.Color(102, 102, 102));
        btnEditarPalabra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarPalabra.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPalabra.setText("Editar");
        btnEditarPalabra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarPalabra.setOpaque(false);
        btnEditarPalabra.setBorderPainted(false);
        btnEditarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPalabraActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Se convertirá en la palabra:");

        txtNuevaPalabra.setBackground(new java.awt.Color(58, 58, 60));
        txtNuevaPalabra.setForeground(new java.awt.Color(229, 229, 231));
        txtNuevaPalabra.setBorder(null);
        txtNuevaPalabra.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtNuevaPalabra.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtNuevaPalabra.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtNuevaPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevaPalabraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormulario1Layout = new javax.swing.GroupLayout(pnlFormulario1);
        pnlFormulario1.setLayout(pnlFormulario1Layout);
        pnlFormulario1Layout.setHorizontalGroup(
            pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario1Layout.createSequentialGroup()
                .addGroup(pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormulario1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8))
                    .addGroup(pnlFormulario1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario1Layout.createSequentialGroup()
                        .addGap(646, 646, 646)
                        .addComponent(jLabel9)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtNuevaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFormulario1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(btnEditarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFormulario1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFormulario1Layout.setVerticalGroup(
            pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(16, 16, 16)
                .addComponent(txtNuevaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlFormulario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFormulario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPalabraActionPerformed
        if (palabra != null || !palabra.isBlank() || !palabra.isEmpty()) {
            if (txtNuevaPalabra.getText().isEmpty() || txtNuevaPalabra.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "El recuadro no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            json.modificarPalabraJSON(lista, palabra, txtNuevaPalabra.getText());
        }
    }//GEN-LAST:event_btnEditarPalabraActionPerformed

    private void txtNuevaPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevaPalabraActionPerformed
    }//GEN-LAST:event_txtNuevaPalabraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPalabra;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JPanel pnlFormulario1;
    private javax.swing.JTextField txtNuevaPalabra;
    // End of variables declaration//GEN-END:variables
}
