package ymcris.lexicalanalyzer.view.diagram;

/**
 *
 * @author YmCris
 */
public class JPState extends javax.swing.JPanel {

    public JPState(int state, char character) {
        initComponents();
        this.lblState.setText("Q" + state);
        this.lblCharacter.setText("" + character);
    }

    public void changeArrow() {
        lblArrow.setText("<---");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblState = new javax.swing.JLabel();
        lblCharacter = new javax.swing.JLabel();
        lblArrow = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 255, 255));

        lblState.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState.setText("Qn");
        lblState.setToolTipText("");
        lblState.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState.setName(""); // NOI18N
        lblState.setPreferredSize(new java.awt.Dimension(300, 300));

        lblCharacter.setBackground(java.awt.SystemColor.activeCaptionText);
        lblCharacter.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblCharacter.setForeground(new java.awt.Color(255, 255, 255));
        lblCharacter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCharacter.setText("a");
        lblCharacter.setToolTipText("");
        lblCharacter.setMaximumSize(new java.awt.Dimension(300, 300));
        lblCharacter.setMinimumSize(new java.awt.Dimension(300, 300));
        lblCharacter.setName(""); // NOI18N
        lblCharacter.setPreferredSize(new java.awt.Dimension(300, 300));

        lblArrow.setBackground(java.awt.SystemColor.activeCaptionText);
        lblArrow.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblArrow.setForeground(new java.awt.Color(255, 255, 255));
        lblArrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArrow.setText("--->");
        lblArrow.setToolTipText("");
        lblArrow.setMaximumSize(new java.awt.Dimension(300, 300));
        lblArrow.setMinimumSize(new java.awt.Dimension(300, 300));
        lblArrow.setName(""); // NOI18N
        lblArrow.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblCharacter;
    private javax.swing.JLabel lblState;
    // End of variables declaration//GEN-END:variables
}
