package ymcris.languages.practice.lexicalanalyzer.frontend;

import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.json.JFConfigJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.uploadfile.JFAnalizador;

/**
 * JavaFrame encargado de dar inicio al menú
 *
 * @author YmCris
 */
public class JFMenuPrincipal extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private ArchivoJSON json;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFMenuPrincipal(ArchivoJSON json) {
        initComponents();
        this.json = json;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("MENÚ PRINCIPAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnUtilizarAnalizador = new javax.swing.JButton();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        btnVisualizarReportes = new javax.swing.JButton();
        btnConfigurarAnalizador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(28, 28, 30));
        pnlMenu.setForeground(new java.awt.Color(255, 255, 255));

        btnUtilizarAnalizador.setBackground(new java.awt.Color(58, 58, 60));
        btnUtilizarAnalizador.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 36)); // NOI18N
        btnUtilizarAnalizador.setForeground(new java.awt.Color(229, 229, 231));
        btnUtilizarAnalizador.setText("Utilizar el Analizador");
        btnUtilizarAnalizador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUtilizarAnalizador.setBorderPainted(false);
        btnUtilizarAnalizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilizarAnalizadorActionPerformed(evt);
            }
        });

        lblTitulo3.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo3.setFont(new java.awt.Font("Swis721 Cn BT", 1, 100)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("LÉXICO");
        lblTitulo3.setToolTipText("");
        lblTitulo3.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo3.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo3.setName(""); // NOI18N
        lblTitulo3.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo4.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo4.setFont(new java.awt.Font("Swis721 Cn BT", 1, 100)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo4.setText("ANALIZADOR");
        lblTitulo4.setToolTipText("");
        lblTitulo4.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo4.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo4.setName(""); // NOI18N
        lblTitulo4.setPreferredSize(new java.awt.Dimension(300, 300));

        btnVisualizarReportes.setBackground(new java.awt.Color(58, 58, 60));
        btnVisualizarReportes.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 36)); // NOI18N
        btnVisualizarReportes.setForeground(new java.awt.Color(229, 229, 231));
        btnVisualizarReportes.setText("Visualizar Reportes");
        btnVisualizarReportes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUtilizarAnalizador.setBorderPainted(false);
        btnVisualizarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarReportesActionPerformed(evt);
            }
        });

        btnConfigurarAnalizador.setBackground(new java.awt.Color(58, 58, 60));
        btnConfigurarAnalizador.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 36)); // NOI18N
        btnConfigurarAnalizador.setForeground(new java.awt.Color(229, 229, 231));
        btnConfigurarAnalizador.setText("Configurar el Analizador");
        btnConfigurarAnalizador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUtilizarAnalizador.setBorderPainted(false);
        btnConfigurarAnalizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarAnalizadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnUtilizarAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(btnVisualizarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnConfigurarAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352))))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUtilizarAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnConfigurarAnalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // CÓDIGO AUTOGENERADO -----------------------------------------------------

    private void btnUtilizarAnalizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilizarAnalizadorActionPerformed
        this.dispose();
        new JFAnalizador(json).setVisible(true);
    }//GEN-LAST:event_btnUtilizarAnalizadorActionPerformed

    private void btnVisualizarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarReportesActionPerformed
        //new JDReportes(this).setVisible(true);
    }//GEN-LAST:event_btnVisualizarReportesActionPerformed

    private void btnConfigurarAnalizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarAnalizadorActionPerformed
        new JFConfigJSON(json).setVisible(true);
    }//GEN-LAST:event_btnConfigurarAnalizadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfigurarAnalizador;
    private javax.swing.JButton btnUtilizarAnalizador;
    private javax.swing.JButton btnVisualizarReportes;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
