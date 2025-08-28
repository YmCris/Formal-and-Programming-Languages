package ymcris.languages.practice.lexicalanalyzer.frontend.dialogs;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.backend.tokens.Token;
import ymcris.languages.practice.lexicalanalyzer.controller.validation.LexemaController;

/**
 * JavaDialog encargado de mostrar los reportes y las opciones de generarlos y
 * exportarlos
 *
 * @author YmCris
 */
public class JDReportes extends javax.swing.JDialog {

    private int cantidadErrores;
    private int tokensValidos;
    private LexemaController controller;
    private ArrayList<Token> errores;
    private ArrayList<Token> tokensReportes;//tambien sirve para el general
    private ArrayList<Token> tokensNoUsados;//tambien sirve para el general
    private DefaultTableModel tablaReporteErrores;
    private DefaultTableModel tablaReporteTokens;
    private DefaultTableModel tablaReporteLexemas;
    private DefaultTableModel tablaReporteGeneral;

    // MÉTODO COSNTRUCTOR ------------------------------------------------------
    public JDReportes(Frame parent, LexemaController controller) {
        super(parent, true);
        this.controller = controller;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.tokensNoUsados = new ArrayList<>();
        this.setTitle("MENÚ PRINCIPAL");
    }

    private void verificarTokensNoUtilizados() {
        tokensNoUsados.clear();
        for (String palabraReservada : controller.getPalabrasReservadas()) {
            if (!contieneToken(tokensReportes, palabraReservada)) {
                tokensNoUsados.add(new Token(palabraReservada));
            }
        }
        for (char operadorAritmetico : controller.getOperadoresAritmeticos()) {
            String operador = String.valueOf(operadorAritmetico);
            if (!contieneToken(tokensReportes, operador)) {
                tokensNoUsados.add(new Token(operador));
            }
        }
        for (char signoPuntuacion : controller.getSignosDePuntuacion()) {
            String simbolo = String.valueOf(signoPuntuacion);
            if (!contieneToken(tokensReportes, simbolo)) {
                tokensNoUsados.add(new Token(simbolo));
            }
        }
        for (char signoAgrupacion : controller.getSignosDeAgrupacion()) {
            String simbolo = String.valueOf(signoAgrupacion);
            if (!contieneToken(tokensReportes, simbolo)) {
                tokensNoUsados.add(new Token(simbolo));
            }
        }
    }

    private boolean contieneToken(ArrayList<Token> lista, String lexema) {
        for (Token t : lista) {
            if (t.getLexema().equals(lexema)) {
                return true;
            }
        }
        return false;
    }

    private void agregarErrores() {
        tablaReporteErrores = (DefaultTableModel) jtblReporteErrores.getModel();
        for (Token error : errores) {
            tablaReporteErrores.addRow(new Object[]{error.getLexema()});
        }
    }

    private void agregarTokens() {
        tablaReporteTokens = (DefaultTableModel) jtblReporteTokens.getModel();
        for (Token tokenReporte : tokensReportes) {
            tablaReporteTokens.addRow(new Object[]{tokenReporte.getTipo(), tokenReporte.getLexema()});
        }
    }

    private void agregarTokensNoUtilizados() {
        tablaReporteGeneral = (DefaultTableModel) jtblReporteGeneral.getModel();
        for (Token token : tokensNoUsados) {
            tablaReporteGeneral.addRow(new Object[]{token.getLexema()});
        }
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTPFormularios = new javax.swing.JTabbedPane();
        pnlFormulario1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnVerReportes = new javax.swing.JButton();
        lblTitulo4 = new javax.swing.JLabel();
        btnExportarReportesVistos = new javax.swing.JButton();
        pnlFormulario2 = new javax.swing.JPanel();
        btnGenerarReporteErrores = new javax.swing.JButton();
        lblTitulo5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExportarReporteErrores = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblReporteErrores = new javax.swing.JTable();
        pnlFormulario5 = new javax.swing.JPanel();
        lblTitulo8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblReporteTokens = new javax.swing.JTable();
        btnGenerarReporteTokens = new javax.swing.JButton();
        btnExportarReporteTokens = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlFormulario10 = new javax.swing.JPanel();
        lblTitulo10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblRecuentoLexemas = new javax.swing.JTable();
        btnGenerarRecuentoLexemas = new javax.swing.JButton();
        btnExportarRecuentoLexemas = new javax.swing.JButton();
        pnlFormulario9 = new javax.swing.JPanel();
        lblTitulo9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo11 = new javax.swing.JLabel();
        lblTitulo12 = new javax.swing.JLabel();
        lblTitulo13 = new javax.swing.JLabel();
        lblCantidadErrores = new javax.swing.JLabel();
        lblPorcentajeTokensValidos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblReporteGeneral = new javax.swing.JTable();
        btnGenerarReporteGeneral = new javax.swing.JButton();
        btnExportarReporteGeneral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTPFormularios.setBackground(new java.awt.Color(58, 58, 60));
        JTPFormularios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JTPFormularios.setForeground(new java.awt.Color(255, 255, 255));
        JTPFormularios.setMaximumSize(new java.awt.Dimension(900, 700));
        JTPFormularios.setMinimumSize(new java.awt.Dimension(900, 700));

        pnlFormulario1.setBackground(new java.awt.Color(28, 28, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Solamente se puede generar si existen errores en el texto de entrada");

        btnVerReportes.setBackground(new java.awt.Color(102, 102, 102));
        btnVerReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnVerReportes.setText("Ver Reportes");
        btnVerReportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerReportes.setOpaque(false);
        btnVerReportes.setBorderPainted(false);
        btnVerReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReportesActionPerformed(evt);
            }
        });

        lblTitulo4.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo4.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo4.setText("VER TODOS LOS REPORTES REALIZADOS");
        lblTitulo4.setToolTipText("");
        lblTitulo4.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo4.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo4.setName(""); // NOI18N
        lblTitulo4.setPreferredSize(new java.awt.Dimension(300, 300));

        btnExportarReportesVistos.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarReportesVistos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarReportesVistos.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarReportesVistos.setText("Exportar Reporte");
        btnExportarReportesVistos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarReportesVistos.setOpaque(false);
        btnExportarReportesVistos.setBorderPainted(false);
        btnExportarReportesVistos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarReportesVistosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormulario1Layout = new javax.swing.GroupLayout(pnlFormulario1);
        pnlFormulario1.setLayout(pnlFormulario1Layout);
        pnlFormulario1Layout.setHorizontalGroup(
            pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario1Layout.createSequentialGroup()
                        .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(212, 212, 212))))
            .addGroup(pnlFormulario1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(btnVerReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnExportarReportesVistos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFormulario1Layout.setVerticalGroup(
            pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                .addGroup(pnlFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarReportesVistos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        JTPFormularios.addTab("Ver Reportes", pnlFormulario1);

        pnlFormulario2.setBackground(new java.awt.Color(28, 28, 30));

        btnGenerarReporteErrores.setBackground(new java.awt.Color(102, 102, 102));
        btnGenerarReporteErrores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarReporteErrores.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteErrores.setText("Generar Reporte");
        btnGenerarReporteErrores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarReporteErrores.setOpaque(false);
        btnGenerarReporteErrores.setBorderPainted(false);
        btnGenerarReporteErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteErroresActionPerformed(evt);
            }
        });

        lblTitulo5.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo5.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo5.setText("REPORTE DE ERRORES");
        lblTitulo5.setToolTipText("");
        lblTitulo5.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo5.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo5.setName(""); // NOI18N
        lblTitulo5.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solamente se puede generar si existen errores en el texto de entrada");

        btnExportarReporteErrores.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarReporteErrores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarReporteErrores.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarReporteErrores.setText("Exportar Reporte");
        btnExportarReporteErrores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarReporteErrores.setOpaque(false);
        btnExportarReporteErrores.setBorderPainted(false);
        btnExportarReporteErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarReporteErroresActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(58, 58, 60));

        jtblReporteErrores.setBackground(new java.awt.Color(58, 58, 60));
        jtblReporteErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Cadena de error", "Símbolo de error", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jtblReporteErrores.setGridColor(new java.awt.Color(221, 221, 221));
        jScrollPane1.setViewportView(jtblReporteErrores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlFormulario2Layout = new javax.swing.GroupLayout(pnlFormulario2);
        pnlFormulario2.setLayout(pnlFormulario2Layout);
        pnlFormulario2Layout.setHorizontalGroup(
            pnlFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario2Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnGenerarReporteErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarReporteErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(pnlFormulario2Layout.createSequentialGroup()
                .addGroup(pnlFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormulario2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(214, 214, 214))
        );
        pnlFormulario2Layout.setVerticalGroup(
            pnlFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporteErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarReporteErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JTPFormularios.addTab("Generar Reporte de Errores", pnlFormulario2);

        pnlFormulario5.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo8.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo8.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo8.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo8.setText("REPORTE DE TOKENS");
        lblTitulo8.setToolTipText("");
        lblTitulo8.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo8.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo8.setName(""); // NOI18N
        lblTitulo8.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Solamente se puede generar si existen no errores en el texto de entrada");

        jPanel3.setBackground(new java.awt.Color(58, 58, 60));

        jtblReporteTokens.setBackground(new java.awt.Color(58, 58, 60));
        jtblReporteTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Nombre del token", "Lexema", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jtblReporteTokens.setGridColor(new java.awt.Color(221, 221, 221));
        jtblReporteTokens.setSelectionBackground(new java.awt.Color(221, 221, 221));
        jtblReporteTokens.setShowGrid(true);
        jScrollPane3.setViewportView(jtblReporteTokens);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGenerarReporteTokens.setBackground(new java.awt.Color(102, 102, 102));
        btnGenerarReporteTokens.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarReporteTokens.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteTokens.setText("Generar Reporte");
        btnGenerarReporteTokens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarReporteTokens.setOpaque(false);
        btnGenerarReporteTokens.setBorderPainted(false);
        btnGenerarReporteTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteTokensActionPerformed(evt);
            }
        });

        btnExportarReporteTokens.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarReporteTokens.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarReporteTokens.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarReporteTokens.setText("Exportar Reporte");
        btnExportarReporteTokens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarReporteTokens.setOpaque(false);
        btnExportarReporteTokens.setBorderPainted(false);
        btnExportarReporteTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarReporteTokensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormulario5Layout = new javax.swing.GroupLayout(pnlFormulario5);
        pnlFormulario5.setLayout(pnlFormulario5Layout);
        pnlFormulario5Layout.setHorizontalGroup(
            pnlFormulario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario5Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnGenerarReporteTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarReporteTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(pnlFormulario5Layout.createSequentialGroup()
                .addGroup(pnlFormulario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormulario5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario5Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario5Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel5)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlFormulario5Layout.setVerticalGroup(
            pnlFormulario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlFormulario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporteTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarReporteTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        JTPFormularios.addTab("Generar Reporte de Tokens", pnlFormulario5);

        jPanel2.setBackground(new java.awt.Color(28, 28, 30));

        pnlFormulario10.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo10.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo10.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo10.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo10.setText("RECUENTO DE LEXEMAS");
        lblTitulo10.setToolTipText("");
        lblTitulo10.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo10.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo10.setName(""); // NOI18N
        lblTitulo10.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Únicamente esta disponible cuando no existan errores en el texto de entrada");

        jPanel5.setBackground(new java.awt.Color(58, 58, 60));

        jtblRecuentoLexemas.setBackground(new java.awt.Color(58, 58, 60));
        jtblRecuentoLexemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lexema", "Tipo de Token", "Usos en el archivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRecuentoLexemas.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane4.setViewportView(jtblRecuentoLexemas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGenerarRecuentoLexemas.setBackground(new java.awt.Color(102, 102, 102));
        btnGenerarRecuentoLexemas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarRecuentoLexemas.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarRecuentoLexemas.setText("Generar Reporte");
        btnGenerarRecuentoLexemas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarRecuentoLexemas.setOpaque(false);
        btnGenerarRecuentoLexemas.setBorderPainted(false);
        btnGenerarRecuentoLexemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRecuentoLexemasActionPerformed(evt);
            }
        });

        btnExportarRecuentoLexemas.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarRecuentoLexemas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarRecuentoLexemas.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarRecuentoLexemas.setText("Exportar Reporte");
        btnExportarRecuentoLexemas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarRecuentoLexemas.setOpaque(false);
        btnExportarRecuentoLexemas.setBorderPainted(false);
        btnExportarRecuentoLexemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarRecuentoLexemasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormulario10Layout = new javax.swing.GroupLayout(pnlFormulario10);
        pnlFormulario10.setLayout(pnlFormulario10Layout);
        pnlFormulario10Layout.setHorizontalGroup(
            pnlFormulario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario10Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnGenerarRecuentoLexemas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarRecuentoLexemas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(pnlFormulario10Layout.createSequentialGroup()
                .addGroup(pnlFormulario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormulario10Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario10Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblTitulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(183, 183, 183))
        );
        pnlFormulario10Layout.setVerticalGroup(
            pnlFormulario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlFormulario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarRecuentoLexemas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarRecuentoLexemas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlFormulario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlFormulario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        JTPFormularios.addTab("Recuento de Lexemas", jPanel2);

        pnlFormulario9.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo9.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo9.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo9.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo9.setText("REPORTE GENERAL");
        lblTitulo9.setToolTipText("");
        lblTitulo9.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo9.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo9.setName(""); // NOI18N
        lblTitulo9.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Determina la calidad del texto de entrada");

        jPanel4.setBackground(new java.awt.Color(58, 58, 60));

        lblTitulo11.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo11.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        lblTitulo11.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo11.setText("Cantidad de Errores:");
        lblTitulo11.setToolTipText("");
        lblTitulo11.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo11.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo11.setName(""); // NOI18N
        lblTitulo11.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo12.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo12.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        lblTitulo12.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo12.setText("Tokens Validos:");
        lblTitulo12.setToolTipText("");
        lblTitulo12.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo12.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo12.setName(""); // NOI18N
        lblTitulo12.setPreferredSize(new java.awt.Dimension(300, 300));

        lblTitulo13.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo13.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        lblTitulo13.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo13.setText(" Tokens No Utilizados:");
        lblTitulo13.setToolTipText("");
        lblTitulo13.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo13.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo13.setName(""); // NOI18N
        lblTitulo13.setPreferredSize(new java.awt.Dimension(300, 300));

        lblCantidadErrores.setBackground(java.awt.SystemColor.activeCaptionText);
        lblCantidadErrores.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        lblCantidadErrores.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadErrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadErrores.setText("5000");
        lblCantidadErrores.setToolTipText("");
        lblCantidadErrores.setMaximumSize(new java.awt.Dimension(300, 300));
        lblCantidadErrores.setMinimumSize(new java.awt.Dimension(300, 300));
        lblCantidadErrores.setName(""); // NOI18N
        lblCantidadErrores.setPreferredSize(new java.awt.Dimension(300, 300));

        lblPorcentajeTokensValidos.setBackground(java.awt.SystemColor.activeCaptionText);
        lblPorcentajeTokensValidos.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        lblPorcentajeTokensValidos.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentajeTokensValidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentajeTokensValidos.setText("15%");
        lblPorcentajeTokensValidos.setToolTipText("");
        lblPorcentajeTokensValidos.setMaximumSize(new java.awt.Dimension(300, 300));
        lblPorcentajeTokensValidos.setMinimumSize(new java.awt.Dimension(300, 300));
        lblPorcentajeTokensValidos.setName(""); // NOI18N
        lblPorcentajeTokensValidos.setPreferredSize(new java.awt.Dimension(300, 300));

        jtblReporteGeneral.setBackground(new java.awt.Color(58, 58, 60));
        jtblReporteGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token Utilizado", "Ha sido utilizado", "Veces que ha sido utilizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblReporteGeneral.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(jtblReporteGeneral);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTitulo13, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblTitulo12, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPorcentajeTokensValidos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblTitulo11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCantidadErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorcentajeTokensValidos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnGenerarReporteGeneral.setBackground(new java.awt.Color(102, 102, 102));
        btnGenerarReporteGeneral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarReporteGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteGeneral.setText("Generar Reporte");
        btnGenerarReporteGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarReporteGeneral.setOpaque(false);
        btnGenerarReporteGeneral.setBorderPainted(false);
        btnGenerarReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteGeneralActionPerformed(evt);
            }
        });

        btnExportarReporteGeneral.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarReporteGeneral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarReporteGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarReporteGeneral.setText("Exportar Reporte");
        btnExportarReporteGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarReporteGeneral.setOpaque(false);
        btnExportarReporteGeneral.setBorderPainted(false);
        btnExportarReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarReporteGeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormulario9Layout = new javax.swing.GroupLayout(pnlFormulario9);
        pnlFormulario9.setLayout(pnlFormulario9Layout);
        pnlFormulario9Layout.setHorizontalGroup(
            pnlFormulario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormulario9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(310, 310, 310))
            .addGroup(pnlFormulario9Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnGenerarReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(pnlFormulario9Layout.createSequentialGroup()
                .addGroup(pnlFormulario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormulario9Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormulario9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pnlFormulario9Layout.setVerticalGroup(
            pnlFormulario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormulario9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlFormulario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        JTPFormularios.addTab("Generar Reporte General", pnlFormulario9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JTPFormularios, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JTPFormularios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarRecuentoLexemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarRecuentoLexemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarRecuentoLexemasActionPerformed

    private void btnGenerarRecuentoLexemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRecuentoLexemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarRecuentoLexemasActionPerformed

    private void btnExportarReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarReporteGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarReporteGeneralActionPerformed

    private void btnGenerarReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteGeneralActionPerformed
        verificarTokensNoUtilizados();
        lblCantidadErrores.setText(String.valueOf(cantidadErrores));
        lblPorcentajeTokensValidos.setText(String.valueOf(tokensValidos));
        agregarTokensNoUtilizados();
    }//GEN-LAST:event_btnGenerarReporteGeneralActionPerformed

    private void btnExportarReporteTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarReporteTokensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarReporteTokensActionPerformed

    private void btnGenerarReporteTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteTokensActionPerformed
        agregarTokens();
    }//GEN-LAST:event_btnGenerarReporteTokensActionPerformed

    private void btnExportarReporteErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarReporteErroresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarReporteErroresActionPerformed

    private void btnGenerarReporteErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteErroresActionPerformed
        agregarErrores();
    }//GEN-LAST:event_btnGenerarReporteErroresActionPerformed

    private void btnExportarReportesVistosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarReportesVistosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarReportesVistosActionPerformed

    private void btnVerReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReportesActionPerformed

    }//GEN-LAST:event_btnVerReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTPFormularios;
    private javax.swing.JButton btnExportarRecuentoLexemas;
    private javax.swing.JButton btnExportarReporteErrores;
    private javax.swing.JButton btnExportarReporteGeneral;
    private javax.swing.JButton btnExportarReporteTokens;
    private javax.swing.JButton btnExportarReportesVistos;
    private javax.swing.JButton btnGenerarRecuentoLexemas;
    private javax.swing.JButton btnGenerarReporteErrores;
    private javax.swing.JButton btnGenerarReporteGeneral;
    private javax.swing.JButton btnGenerarReporteTokens;
    private javax.swing.JButton btnVerReportes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtblRecuentoLexemas;
    private javax.swing.JTable jtblReporteErrores;
    private javax.swing.JTable jtblReporteGeneral;
    private javax.swing.JTable jtblReporteTokens;
    private javax.swing.JLabel lblCantidadErrores;
    private javax.swing.JLabel lblPorcentajeTokensValidos;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JPanel pnlFormulario1;
    private javax.swing.JPanel pnlFormulario10;
    private javax.swing.JPanel pnlFormulario2;
    private javax.swing.JPanel pnlFormulario5;
    private javax.swing.JPanel pnlFormulario9;
    // End of variables declaration//GEN-END:variables

    public int getCantidadErrores() {
        return cantidadErrores;
    }

    public int getTokensValidos() {
        return tokensValidos;
    }

    public void setCantidadErrores(int cantidadErrores) {
        this.cantidadErrores = cantidadErrores;
    }

    public void setTokensValidos(int tokensValidos) {
        this.tokensValidos = tokensValidos;
    }

    public ArrayList<Token> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<Token> errores) {
        this.errores = errores;
    }

    public void setTokensReportes(ArrayList<Token> tokensReportes) {
        this.tokensReportes = tokensReportes;
    }
}
