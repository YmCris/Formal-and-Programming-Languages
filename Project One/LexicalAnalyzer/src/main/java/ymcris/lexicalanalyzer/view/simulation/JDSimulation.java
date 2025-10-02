package ymcris.lexicalanalyzer.view.simulation;

import ymcris.lexicalanalyzer.backend.automata.Automata;
import ymcris.lexicalanalyzer.backend.simulator.Simulation;
import ymcris.lexicalanalyzer.backend.simulator.Step;

/**
 *
 * @author YmCris
 */
public class JDSimulation extends javax.swing.JDialog {

    private Automata automata;
    private Simulation simulation;

    public JDSimulation(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.setTitle("SIMULATOR");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.automata = new Automata(null);
        this.simulation = new Simulation(automata);
    }

    private void updateUIState() {
        lblState.setText("" + simulation.getCurrentState());
        lblLexeme.setText("" + simulation.getLexeme());
        jtpText.setText("");

        for (Step step : simulation.getHistory()) {
            jtpText.setText(jtpText.getText() + step.getMessage() + "\n");
        }

        if (!simulation.getFinalizedTokens().isEmpty()) {
            Step last = simulation.getFinalizedTokens()
                    .get(simulation.getFinalizedTokens().size() - 1);
            lblAcepted.setText("Last Token: " + last.getLexemeBefore() + " (" + last.getTokenType() + ")");
        } else {
            lblAcepted.setText("Last Token: none");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpBackground = new javax.swing.JDesktopPane();
        lbl = new javax.swing.JLabel();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        txtText = new javax.swing.JTextField();
        lblState1 = new javax.swing.JLabel();
        lblState2 = new javax.swing.JLabel();
        lblState3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtpText = new javax.swing.JTextPane();
        lblState4 = new javax.swing.JLabel();
        lblState5 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblLexeme = new javax.swing.JLabel();
        lblAcepted = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnEjecutar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jdpBackground.setBackground(new java.awt.Color(28, 28, 30));

        lbl.setBackground(java.awt.SystemColor.activeCaptionText);
        lbl.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl.setText("Texto a analizar:");
        lbl.setToolTipText("");
        lbl.setMaximumSize(new java.awt.Dimension(300, 300));
        lbl.setMinimumSize(new java.awt.Dimension(300, 300));
        lbl.setName(""); // NOI18N
        lbl.setPreferredSize(new java.awt.Dimension(300, 300));

        btnAvanzar.setBackground(new java.awt.Color(58, 58, 60));
        btnAvanzar.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(229, 229, 231));
        btnAvanzar.setText("Avanzar");
        btnAvanzar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnRetroceder.setBackground(new java.awt.Color(58, 58, 60));
        btnRetroceder.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(229, 229, 231));
        btnRetroceder.setText("Retroceder");
        btnRetroceder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        btnEjecutar.setBackground(new java.awt.Color(58, 58, 60));
        btnEjecutar.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnEjecutar.setForeground(new java.awt.Color(229, 229, 231));
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnReiniciar.setBackground(new java.awt.Color(58, 58, 60));
        btnReiniciar.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnReiniciar.setForeground(new java.awt.Color(229, 229, 231));
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        txtText.setBackground(new java.awt.Color(142, 142, 147));
        txtText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtText.setForeground(new java.awt.Color(255, 255, 255));
        txtText.setBorder(null);
        txtText.setCaretColor(new java.awt.Color(255, 255, 255));
        txtText.setDisabledTextColor(new java.awt.Color(142, 142, 147));
        txtText.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtText.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTextActionPerformed(evt);
            }
        });

        lblState1.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState1.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState1.setForeground(new java.awt.Color(255, 255, 255));
        lblState1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState1.setText("Lectura de caracteres");
        lblState1.setToolTipText("");
        lblState1.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState1.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState1.setName(""); // NOI18N
        lblState1.setPreferredSize(new java.awt.Dimension(300, 300));

        lblState2.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState2.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState2.setForeground(new java.awt.Color(255, 255, 255));
        lblState2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState2.setText("Construccion del lexema:");
        lblState2.setToolTipText("");
        lblState2.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState2.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState2.setName(""); // NOI18N
        lblState2.setPreferredSize(new java.awt.Dimension(300, 300));

        lblState3.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState3.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState3.setForeground(new java.awt.Color(255, 255, 255));
        lblState3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState3.setText("Estado actual:");
        lblState3.setToolTipText("");
        lblState3.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState3.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState3.setName(""); // NOI18N
        lblState3.setPreferredSize(new java.awt.Dimension(300, 300));

        jtpText.setBackground(new java.awt.Color(58, 58, 60));
        jtpText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60), new java.awt.Color(58, 58, 60)));
        jtpText.setForeground(new java.awt.Color(255, 255, 255));
        jtpText.setCaretColor(new java.awt.Color(229, 229, 231));
        jtpText.setDisabledTextColor(new java.awt.Color(229, 229, 231));
        jtpText.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtpText.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jtpText);

        lblState4.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState4.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState4.setForeground(new java.awt.Color(255, 255, 255));
        lblState4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState4.setText("Aceptacion del token:");
        lblState4.setToolTipText("");
        lblState4.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState4.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState4.setName(""); // NOI18N
        lblState4.setPreferredSize(new java.awt.Dimension(300, 300));

        lblState5.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState5.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState5.setForeground(new java.awt.Color(255, 255, 255));
        lblState5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState5.setText("Error en el token:");
        lblState5.setToolTipText("");
        lblState5.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState5.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState5.setName(""); // NOI18N
        lblState5.setPreferredSize(new java.awt.Dimension(300, 300));

        lblState.setBackground(java.awt.SystemColor.activeCaptionText);
        lblState.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState.setToolTipText("");
        lblState.setMaximumSize(new java.awt.Dimension(300, 300));
        lblState.setMinimumSize(new java.awt.Dimension(300, 300));
        lblState.setName(""); // NOI18N
        lblState.setPreferredSize(new java.awt.Dimension(300, 300));

        lblLexeme.setBackground(java.awt.SystemColor.activeCaptionText);
        lblLexeme.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblLexeme.setForeground(new java.awt.Color(255, 255, 255));
        lblLexeme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLexeme.setToolTipText("");
        lblLexeme.setMaximumSize(new java.awt.Dimension(300, 300));
        lblLexeme.setMinimumSize(new java.awt.Dimension(300, 300));
        lblLexeme.setName(""); // NOI18N
        lblLexeme.setPreferredSize(new java.awt.Dimension(300, 300));

        lblAcepted.setBackground(java.awt.SystemColor.activeCaptionText);
        lblAcepted.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblAcepted.setForeground(new java.awt.Color(255, 255, 255));
        lblAcepted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcepted.setText("false");
        lblAcepted.setToolTipText("");
        lblAcepted.setMaximumSize(new java.awt.Dimension(300, 300));
        lblAcepted.setMinimumSize(new java.awt.Dimension(300, 300));
        lblAcepted.setName(""); // NOI18N
        lblAcepted.setPreferredSize(new java.awt.Dimension(300, 300));

        lblError.setBackground(java.awt.SystemColor.activeCaptionText);
        lblError.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 255, 255));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("false");
        lblError.setToolTipText("");
        lblError.setMaximumSize(new java.awt.Dimension(300, 300));
        lblError.setMinimumSize(new java.awt.Dimension(300, 300));
        lblError.setName(""); // NOI18N
        lblError.setPreferredSize(new java.awt.Dimension(300, 300));

        btnEjecutar1.setBackground(new java.awt.Color(58, 58, 60));
        btnEjecutar1.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnEjecutar1.setForeground(new java.awt.Color(229, 229, 231));
        btnEjecutar1.setText("Analizar");
        btnEjecutar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEjecutar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutar1ActionPerformed(evt);
            }
        });

        jdpBackground.setLayer(lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnAvanzar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnRetroceder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnEjecutar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnReiniciar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(txtText, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblState, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblLexeme, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblAcepted, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(lblError, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnEjecutar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpBackgroundLayout = new javax.swing.GroupLayout(jdpBackground);
        jdpBackground.setLayout(jdpBackgroundLayout);
        jdpBackgroundLayout.setHorizontalGroup(
            jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpBackgroundLayout.createSequentialGroup()
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRetroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(btnEjecutar1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblState3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblState1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblState4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAcepted, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblState5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblState2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lblLexeme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jdpBackgroundLayout.setVerticalGroup(
            jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpBackgroundLayout.createSequentialGroup()
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEjecutar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRetroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLexeme, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAcepted, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblState1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        Step step = simulation.stepForward();
        if (step != null) {
            jtpText.setText(jtpText.getText()
                    + String.format("Idx %d: '%c' | %d -> %d | lex='%s' -> '%s'\n",
                            step.getIndex(), step.getReadedCharacter(), step.getPreviousState(), step.getNextState(),
                            step.getLexemeBefore(), step.getLexemeAfter()));
            if (step.isError()) {
                lblError.setText("true");
            }
        }
        updateUIState();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        Step undone = simulation.stepBack();
        if (undone == null) {
            jtpText.setText(jtpText.getText() + "Nada que deshacer\n");
        } else {
            jtpText.setText(jtpText.getText() + "Se deshizo el paso en el indice " + undone.getIndex() + "\n");
        }
        updateUIState();    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        java.util.List<Step> steps = simulation.runUntilTokenEnd();
        for (Step s : steps) {
            jtpText.setText(jtpText.getText() + s.getMessage() + "\n");
        }
        updateUIState();    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        String text = txtText.getText();
        simulation.setInput(text);
        updateUIState();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void txtTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTextActionPerformed

    }//GEN-LAST:event_txtTextActionPerformed

    private void btnEjecutar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutar1ActionPerformed
        while (simulation.getIndex() < txtText.getText().length()) {
            Step s = simulation.stepForward();
            jtpText.setText(jtpText.getText() + s.getMessage() + "\n");
        }
        updateUIState();
    }//GEN-LAST:event_btnEjecutar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnEjecutar1;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JDesktopPane jdpBackground;
    private javax.swing.JTextPane jtpText;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblAcepted;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLexeme;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblState1;
    private javax.swing.JLabel lblState2;
    private javax.swing.JLabel lblState3;
    private javax.swing.JLabel lblState4;
    private javax.swing.JLabel lblState5;
    private javax.swing.JTextField txtText;
    // End of variables declaration//GEN-END:variables
}
