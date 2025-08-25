package ymcris.languages.practice.lexicalanalyzer.frontend.json;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ymcris.languages.practice.lexicalanalyzer.backend.JSON.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.JFMenuPrincipal;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDEditarPalabra;

/**
 *
 * @author YmCris
 */
public class JFConfigJSON extends javax.swing.JFrame {

    private ArchivoJSON json;

    public JFConfigJSON(ArchivoJSON json) {
        initComponents();
        this.json = json;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("CONFIGURACIÓN DEL ANALIZADOR LÉXICO");
    }

    public static void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    private void opcionCrear(String nombreLista, JTextField txt) {
        if (txt.getText().isBlank() || txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El recuadro no puede estar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        json.agregarPalabraAJSON(nombreLista, txt.getText());
    }

    private void opcionEliminar(String nombreLista, JTextField txt) {
        if (txt.getText().isBlank() || txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debes seleccionar una palabra antes de eliminarla", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        json.eliminarPalabraEnJSON(nombreLista, txt.getText());
    }

    private void opcionModificar(String lista, String palabra) {
        if (palabra.isBlank() || palabra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debes seleccionar una palabra antes de modificarla", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        new JDEditarPalabra(this, lista, palabra, json).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpConfig = new javax.swing.JTabbedPane();
        pnlPalabrasReservadas = new javax.swing.JPanel();
        lblTitulo6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPalabrasReservadas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCrearPalabraReservada = new javax.swing.JTextField();
        btnCrearPalabraReservada = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminarPalabraReservada = new javax.swing.JButton();
        btnEditarPalabraReservada = new javax.swing.JButton();
        txtPalabraReservadaSeleccionada = new javax.swing.JTextField();
        btnRMPR = new javax.swing.JButton();
        pnlPalabrasReservadas1 = new javax.swing.JPanel();
        lblTitulo7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOperadorAritmetico = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCrearOperadorAritmetico = new javax.swing.JTextField();
        btnCrearOperadorAritmetico = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarOperadorAritmetico = new javax.swing.JButton();
        btnEditarOperadorAritmetico = new javax.swing.JButton();
        txtOperadorSeleccionado = new javax.swing.JTextField();
        btnRMPR1 = new javax.swing.JButton();
        pnlPalabrasReservadas2 = new javax.swing.JPanel();
        lblTitulo8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSignosDePuntuacion = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCrearSignoDePuntuacion = new javax.swing.JTextField();
        btnCrearSignoDePuntuacion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnSignosDePuntuacion = new javax.swing.JButton();
        btnEditarSignoDePuntuacion = new javax.swing.JButton();
        txtSignoDePuntuacionSeleccionado = new javax.swing.JTextField();
        btnRMPR2 = new javax.swing.JButton();
        pnlPalabrasReservadas3 = new javax.swing.JPanel();
        lblTitulo9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSignosDeAgrupacion = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCrearSignoDeAgrupacion = new javax.swing.JTextField();
        btnCrearSignoDeAgrupacion = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnEliminarSignoDeAgrupacion = new javax.swing.JButton();
        btnEditarSignoDeAgrupacion = new javax.swing.JButton();
        txtSignoDeAgrupacionSeleccionado = new javax.swing.JTextField();
        btnRMPR3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(58, 58, 60));
        setForeground(new java.awt.Color(58, 58, 60));

        jtpConfig.setBackground(new java.awt.Color(58, 58, 60));
        jtpConfig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtpConfig.setForeground(new java.awt.Color(255, 255, 255));
        jtpConfig.setMaximumSize(new java.awt.Dimension(900, 700));
        jtpConfig.setMinimumSize(new java.awt.Dimension(900, 700));

        pnlPalabrasReservadas.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo6.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo6.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo6.setText("PALABRAS RESERVADAS");
        lblTitulo6.setToolTipText("");
        lblTitulo6.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo6.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo6.setName(""); // NOI18N
        lblTitulo6.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        tblPalabrasReservadas.setBackground(new java.awt.Color(58, 58, 60));
        tblPalabrasReservadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Palabras Reservadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPalabrasReservadas.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(tblPalabrasReservadas);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("La palabra reservada que deseas modificar es:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Crear palabra reservada");

        txtCrearPalabraReservada.setBackground(new java.awt.Color(58, 58, 60));
        txtCrearPalabraReservada.setForeground(new java.awt.Color(229, 229, 231));
        txtCrearPalabraReservada.setBorder(null);
        txtCrearPalabraReservada.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtCrearPalabraReservada.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtCrearPalabraReservada.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtCrearPalabraReservada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearPalabraReservadaActionPerformed(evt);
            }
        });

        btnCrearPalabraReservada.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearPalabraReservada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearPalabraReservada.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearPalabraReservada.setText("Crear");
        btnCrearPalabraReservada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearPalabraReservada.setOpaque(false);
        btnCrearPalabraReservada.setBorderPainted(false);
        btnCrearPalabraReservada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPalabraReservadaActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        btnEliminarPalabraReservada.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminarPalabraReservada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarPalabraReservada.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPalabraReservada.setText("Eliminar palabra reservada");
        btnEliminarPalabraReservada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarPalabraReservada.setOpaque(false);
        btnEliminarPalabraReservada.setBorderPainted(false);
        btnEliminarPalabraReservada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPalabraReservadaActionPerformed(evt);
            }
        });

        btnEditarPalabraReservada.setBackground(new java.awt.Color(102, 102, 102));
        btnEditarPalabraReservada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarPalabraReservada.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPalabraReservada.setText("Editar palabra reservada");
        btnEditarPalabraReservada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarPalabraReservada.setOpaque(false);
        btnEditarPalabraReservada.setBorderPainted(false);
        btnEditarPalabraReservada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPalabraReservadaActionPerformed(evt);
            }
        });

        txtPalabraReservadaSeleccionada.setBackground(new java.awt.Color(58, 58, 60));
        txtPalabraReservadaSeleccionada.setForeground(new java.awt.Color(229, 229, 231));
        txtPalabraReservadaSeleccionada.setBorder(null);
        txtPalabraReservadaSeleccionada.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtPalabraReservadaSeleccionada.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtPalabraReservadaSeleccionada.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtPalabraReservadaSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPalabraReservadaSeleccionadaActionPerformed(evt);
            }
        });

        btnRMPR.setBackground(new java.awt.Color(102, 102, 102));
        btnRMPR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRMPR.setForeground(new java.awt.Color(255, 255, 255));
        btnRMPR.setText("Regresar al menú");
        btnRMPR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRMPR.setOpaque(false);
        btnRMPR.setBorderPainted(false);
        btnRMPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRMPRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPalabrasReservadasLayout = new javax.swing.GroupLayout(pnlPalabrasReservadas);
        pnlPalabrasReservadas.setLayout(pnlPalabrasReservadasLayout);
        pnlPalabrasReservadasLayout.setHorizontalGroup(
            pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCrearPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8))
                    .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarPalabraReservada)
                            .addComponent(btnEditarPalabraReservada)
                            .addComponent(txtPalabraReservadaSeleccionada)
                            .addComponent(btnRMPR))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );
        pnlPalabrasReservadasLayout.setVerticalGroup(
            pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPalabrasReservadasLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPalabraReservadaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminarPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarPalabraReservada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRMPR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(pnlPalabrasReservadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadasLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(578, Short.MAX_VALUE)))
        );

        jtpConfig.addTab("Editar las palabras reservadas", pnlPalabrasReservadas);

        pnlPalabrasReservadas1.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo7.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo7.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo7.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo7.setText("OPERADORES ARITMÉTICOS");
        lblTitulo7.setToolTipText("");
        lblTitulo7.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo7.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo7.setName(""); // NOI18N
        lblTitulo7.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        tblOperadorAritmetico.setBackground(new java.awt.Color(58, 58, 60));
        tblOperadorAritmetico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Operadores Aritméticos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperadorAritmetico.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(tblOperadorAritmetico);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("El operador aritmético que deseas modificar es:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Crear operador aritmético");

        txtCrearOperadorAritmetico.setBackground(new java.awt.Color(58, 58, 60));
        txtCrearOperadorAritmetico.setForeground(new java.awt.Color(229, 229, 231));
        txtCrearOperadorAritmetico.setBorder(null);
        txtCrearOperadorAritmetico.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtCrearOperadorAritmetico.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtCrearOperadorAritmetico.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtCrearOperadorAritmetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearOperadorAritmeticoActionPerformed(evt);
            }
        });

        btnCrearOperadorAritmetico.setBackground(new java.awt.Color(58, 58, 60));
        btnCrearOperadorAritmetico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearOperadorAritmetico.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearOperadorAritmetico.setText("Crear");
        btnCrearOperadorAritmetico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearOperadorAritmetico.setOpaque(false);
        btnCrearOperadorAritmetico.setBorderPainted(false);
        btnCrearOperadorAritmetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearOperadorAritmeticoActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        btnEliminarOperadorAritmetico.setBackground(new java.awt.Color(58, 58, 60));
        btnEliminarOperadorAritmetico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarOperadorAritmetico.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarOperadorAritmetico.setText("Eliminar operador aritmético");
        btnEliminarOperadorAritmetico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarOperadorAritmetico.setOpaque(false);
        btnEliminarOperadorAritmetico.setBorderPainted(false);
        btnEliminarOperadorAritmetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarOperadorAritmeticoActionPerformed(evt);
            }
        });

        btnEditarOperadorAritmetico.setBackground(new java.awt.Color(58, 58, 60));
        btnEditarOperadorAritmetico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarOperadorAritmetico.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarOperadorAritmetico.setText("Editar operador aritmético");
        btnEditarOperadorAritmetico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarOperadorAritmetico.setOpaque(false);
        btnEditarOperadorAritmetico.setBorderPainted(false);
        btnEditarOperadorAritmetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOperadorAritmeticoActionPerformed(evt);
            }
        });

        txtOperadorSeleccionado.setBackground(new java.awt.Color(58, 58, 60));
        txtOperadorSeleccionado.setForeground(new java.awt.Color(229, 229, 231));
        txtOperadorSeleccionado.setBorder(null);
        txtOperadorSeleccionado.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtOperadorSeleccionado.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtOperadorSeleccionado.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtOperadorSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOperadorSeleccionadoActionPerformed(evt);
            }
        });

        btnRMPR1.setBackground(new java.awt.Color(58, 58, 60));
        btnRMPR1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRMPR1.setForeground(new java.awt.Color(255, 255, 255));
        btnRMPR1.setText("Regresar al menú");
        btnRMPR1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRMPR1.setOpaque(false);
        btnRMPR1.setBorderPainted(false);
        btnRMPR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRMPR1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPalabrasReservadas1Layout = new javax.swing.GroupLayout(pnlPalabrasReservadas1);
        pnlPalabrasReservadas1.setLayout(pnlPalabrasReservadas1Layout);
        pnlPalabrasReservadas1Layout.setHorizontalGroup(
            pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtCrearOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11))
                    .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarOperadorAritmetico)
                            .addComponent(btnEditarOperadorAritmetico)
                            .addComponent(txtOperadorSeleccionado)
                            .addComponent(btnRMPR1))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );
        pnlPalabrasReservadas1Layout.setVerticalGroup(
            pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPalabrasReservadas1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOperadorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminarOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarOperadorAritmetico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRMPR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(pnlPalabrasReservadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas1Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(578, Short.MAX_VALUE)))
        );

        jtpConfig.addTab("Editar los operadores aritméticos", pnlPalabrasReservadas1);

        pnlPalabrasReservadas2.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo8.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo8.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo8.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo8.setText("SIGNOS DE PUNTUACIÓN");
        lblTitulo8.setToolTipText("");
        lblTitulo8.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo8.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo8.setName(""); // NOI18N
        lblTitulo8.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        tblSignosDePuntuacion.setBackground(new java.awt.Color(58, 58, 60));
        tblSignosDePuntuacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Signos de Puntuación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSignosDePuntuacion.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(tblSignosDePuntuacion);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("El signo de puntuación que deseas modificar es:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Crear signo de puntuación");

        txtCrearSignoDePuntuacion.setBackground(new java.awt.Color(58, 58, 60));
        txtCrearSignoDePuntuacion.setForeground(new java.awt.Color(229, 229, 231));
        txtCrearSignoDePuntuacion.setBorder(null);
        txtCrearSignoDePuntuacion.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtCrearSignoDePuntuacion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtCrearSignoDePuntuacion.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtCrearSignoDePuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearSignoDePuntuacionActionPerformed(evt);
            }
        });

        btnCrearSignoDePuntuacion.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearSignoDePuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearSignoDePuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearSignoDePuntuacion.setText("Crear");
        btnCrearSignoDePuntuacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearSignoDePuntuacion.setOpaque(false);
        btnCrearSignoDePuntuacion.setBorderPainted(false);
        btnCrearSignoDePuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSignoDePuntuacionActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        btnSignosDePuntuacion.setBackground(new java.awt.Color(102, 102, 102));
        btnSignosDePuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignosDePuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        btnSignosDePuntuacion.setText("Eliminar signo de puntuación");
        btnSignosDePuntuacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSignosDePuntuacion.setOpaque(false);
        btnSignosDePuntuacion.setBorderPainted(false);
        btnSignosDePuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignosDePuntuacionActionPerformed(evt);
            }
        });

        btnEditarSignoDePuntuacion.setBackground(new java.awt.Color(102, 102, 102));
        btnEditarSignoDePuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarSignoDePuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarSignoDePuntuacion.setText("Editar signo de puntuación");
        btnEditarSignoDePuntuacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarSignoDePuntuacion.setOpaque(false);
        btnEditarSignoDePuntuacion.setBorderPainted(false);
        btnEditarSignoDePuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSignoDePuntuacionActionPerformed(evt);
            }
        });

        txtSignoDePuntuacionSeleccionado.setBackground(new java.awt.Color(58, 58, 60));
        txtSignoDePuntuacionSeleccionado.setForeground(new java.awt.Color(229, 229, 231));
        txtSignoDePuntuacionSeleccionado.setBorder(null);
        txtSignoDePuntuacionSeleccionado.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtSignoDePuntuacionSeleccionado.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtSignoDePuntuacionSeleccionado.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtSignoDePuntuacionSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSignoDePuntuacionSeleccionadoActionPerformed(evt);
            }
        });

        btnRMPR2.setBackground(new java.awt.Color(102, 102, 102));
        btnRMPR2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRMPR2.setForeground(new java.awt.Color(255, 255, 255));
        btnRMPR2.setText("Regresar al menú");
        btnRMPR2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRMPR2.setOpaque(false);
        btnRMPR2.setBorderPainted(false);
        btnRMPR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRMPR2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPalabrasReservadas2Layout = new javax.swing.GroupLayout(pnlPalabrasReservadas2);
        pnlPalabrasReservadas2.setLayout(pnlPalabrasReservadas2Layout);
        pnlPalabrasReservadas2Layout.setHorizontalGroup(
            pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCrearSignoDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearSignoDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel14))
                    .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSignosDePuntuacion)
                            .addComponent(btnEditarSignoDePuntuacion)
                            .addComponent(txtSignoDePuntuacionSeleccionado)
                            .addComponent(btnRMPR2))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );
        pnlPalabrasReservadas2Layout.setVerticalGroup(
            pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPalabrasReservadas2Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearSignoDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearSignoDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSignoDePuntuacionSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnSignosDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarSignoDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRMPR2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(pnlPalabrasReservadas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas2Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(578, Short.MAX_VALUE)))
        );

        jtpConfig.addTab("Editar los signos de puntuación", pnlPalabrasReservadas2);

        pnlPalabrasReservadas3.setBackground(new java.awt.Color(28, 28, 30));

        lblTitulo9.setBackground(java.awt.SystemColor.activeCaptionText);
        lblTitulo9.setFont(new java.awt.Font("Swis721 Cn BT", 1, 36)); // NOI18N
        lblTitulo9.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo9.setText("SIGNOS DE AGRUPACIÓN");
        lblTitulo9.setToolTipText("");
        lblTitulo9.setMaximumSize(new java.awt.Dimension(300, 300));
        lblTitulo9.setMinimumSize(new java.awt.Dimension(300, 300));
        lblTitulo9.setName(""); // NOI18N
        lblTitulo9.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        tblSignosDeAgrupacion.setBackground(new java.awt.Color(58, 58, 60));
        tblSignosDeAgrupacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Signos de Agrupación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSignosDeAgrupacion.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(tblSignosDeAgrupacion);

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("El signo de agrupación que deseas modificar es:");

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Crear signo de agrupación");

        txtCrearSignoDeAgrupacion.setBackground(new java.awt.Color(58, 58, 60));
        txtCrearSignoDeAgrupacion.setForeground(new java.awt.Color(229, 229, 231));
        txtCrearSignoDeAgrupacion.setBorder(null);
        txtCrearSignoDeAgrupacion.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtCrearSignoDeAgrupacion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtCrearSignoDeAgrupacion.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtCrearSignoDeAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearSignoDeAgrupacionActionPerformed(evt);
            }
        });

        btnCrearSignoDeAgrupacion.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearSignoDeAgrupacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearSignoDeAgrupacion.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearSignoDeAgrupacion.setText("Crear");
        btnCrearSignoDeAgrupacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearSignoDeAgrupacion.setOpaque(false);
        btnCrearSignoDeAgrupacion.setBorderPainted(false);
        btnCrearSignoDeAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSignoDeAgrupacionActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        btnEliminarSignoDeAgrupacion.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminarSignoDeAgrupacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarSignoDeAgrupacion.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarSignoDeAgrupacion.setText("Eliminar signo de agrupación");
        btnEliminarSignoDeAgrupacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarSignoDeAgrupacion.setOpaque(false);
        btnEliminarSignoDeAgrupacion.setBorderPainted(false);
        btnEliminarSignoDeAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSignoDeAgrupacionActionPerformed(evt);
            }
        });

        btnEditarSignoDeAgrupacion.setBackground(new java.awt.Color(102, 102, 102));
        btnEditarSignoDeAgrupacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarSignoDeAgrupacion.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarSignoDeAgrupacion.setText("Editar signo de agrupación");
        btnEditarSignoDeAgrupacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarSignoDeAgrupacion.setOpaque(false);
        btnEditarSignoDeAgrupacion.setBorderPainted(false);
        btnEditarSignoDeAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSignoDeAgrupacionActionPerformed(evt);
            }
        });

        txtSignoDeAgrupacionSeleccionado.setBackground(new java.awt.Color(58, 58, 60));
        txtSignoDeAgrupacionSeleccionado.setForeground(new java.awt.Color(229, 229, 231));
        txtSignoDeAgrupacionSeleccionado.setBorder(null);
        txtSignoDeAgrupacionSeleccionado.setDisabledTextColor(new java.awt.Color(58, 58, 60));
        txtSignoDeAgrupacionSeleccionado.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txtSignoDeAgrupacionSeleccionado.setSelectionColor(new java.awt.Color(229, 229, 231));
        txtSignoDeAgrupacionSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSignoDeAgrupacionSeleccionadoActionPerformed(evt);
            }
        });

        btnRMPR3.setBackground(new java.awt.Color(102, 102, 102));
        btnRMPR3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRMPR3.setForeground(new java.awt.Color(255, 255, 255));
        btnRMPR3.setText("Regresar al menú");
        btnRMPR3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRMPR3.setOpaque(false);
        btnRMPR3.setBorderPainted(false);
        btnRMPR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRMPR3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPalabrasReservadas3Layout = new javax.swing.GroupLayout(pnlPalabrasReservadas3);
        pnlPalabrasReservadas3.setLayout(pnlPalabrasReservadas3Layout);
        pnlPalabrasReservadas3Layout.setHorizontalGroup(
            pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCrearSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17))
                    .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarSignoDeAgrupacion)
                            .addComponent(btnEditarSignoDeAgrupacion)
                            .addComponent(txtSignoDeAgrupacionSeleccionado)
                            .addComponent(btnRMPR3))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jSeparator4)
            .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );
        pnlPalabrasReservadas3Layout.setVerticalGroup(
            pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPalabrasReservadas3Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSignoDeAgrupacionSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminarSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarSignoDeAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRMPR3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(pnlPalabrasReservadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPalabrasReservadas3Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(578, Short.MAX_VALUE)))
        );

        jtpConfig.addTab("Editar los signos de agrupación", pnlPalabrasReservadas3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtpConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtpConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRMPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRMPRActionPerformed
        this.dispose();
        new JFMenuPrincipal(json).setVisible(true);
    }//GEN-LAST:event_btnRMPRActionPerformed

    private void txtPalabraReservadaSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPalabraReservadaSeleccionadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPalabraReservadaSeleccionadaActionPerformed

    private void btnEditarPalabraReservadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPalabraReservadaActionPerformed
        opcionModificar("palabrasReservadas", txtPalabraReservadaSeleccionada.getText());    }//GEN-LAST:event_btnEditarPalabraReservadaActionPerformed

    private void btnEliminarPalabraReservadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPalabraReservadaActionPerformed
        opcionEliminar("palabrasReservadas", txtPalabraReservadaSeleccionada);
    }//GEN-LAST:event_btnEliminarPalabraReservadaActionPerformed

    private void btnCrearPalabraReservadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPalabraReservadaActionPerformed
        opcionCrear("palabrasReservadas", txtCrearPalabraReservada);
    }//GEN-LAST:event_btnCrearPalabraReservadaActionPerformed

    private void txtCrearPalabraReservadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearPalabraReservadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearPalabraReservadaActionPerformed

    private void txtCrearOperadorAritmeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearOperadorAritmeticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearOperadorAritmeticoActionPerformed

    private void btnCrearOperadorAritmeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearOperadorAritmeticoActionPerformed
        opcionCrear("operadoresAritmeticos", txtCrearOperadorAritmetico);
    }//GEN-LAST:event_btnCrearOperadorAritmeticoActionPerformed

    private void btnEliminarOperadorAritmeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarOperadorAritmeticoActionPerformed
        opcionEliminar("operadoresAritmeticos", txtOperadorSeleccionado);
    }//GEN-LAST:event_btnEliminarOperadorAritmeticoActionPerformed

    private void btnEditarOperadorAritmeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOperadorAritmeticoActionPerformed
        opcionModificar("operadoresAritmeticos", txtOperadorSeleccionado.getText());
    }//GEN-LAST:event_btnEditarOperadorAritmeticoActionPerformed

    private void txtOperadorSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOperadorSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOperadorSeleccionadoActionPerformed

    private void btnRMPR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRMPR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRMPR1ActionPerformed

    private void txtCrearSignoDePuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearSignoDePuntuacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearSignoDePuntuacionActionPerformed

    private void btnCrearSignoDePuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSignoDePuntuacionActionPerformed
        opcionCrear("signosDePuntuacion", txtCrearSignoDePuntuacion);
    }//GEN-LAST:event_btnCrearSignoDePuntuacionActionPerformed

    private void btnSignosDePuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignosDePuntuacionActionPerformed
        opcionEliminar("signosDePuntuacion", txtSignoDeAgrupacionSeleccionado);
    }//GEN-LAST:event_btnSignosDePuntuacionActionPerformed

    private void btnEditarSignoDePuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSignoDePuntuacionActionPerformed
        opcionModificar("signosDePuntuacion", txtSignoDePuntuacionSeleccionado.getText());
    }//GEN-LAST:event_btnEditarSignoDePuntuacionActionPerformed

    private void txtSignoDePuntuacionSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSignoDePuntuacionSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSignoDePuntuacionSeleccionadoActionPerformed

    private void btnRMPR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRMPR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRMPR2ActionPerformed

    private void txtCrearSignoDeAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearSignoDeAgrupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearSignoDeAgrupacionActionPerformed

    private void btnCrearSignoDeAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSignoDeAgrupacionActionPerformed
        opcionCrear("signosDeAgrupacion", txtCrearSignoDeAgrupacion);
    }//GEN-LAST:event_btnCrearSignoDeAgrupacionActionPerformed

    private void btnEliminarSignoDeAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSignoDeAgrupacionActionPerformed
        opcionEliminar("signosDeAgrupacion", txtSignoDeAgrupacionSeleccionado);
    }//GEN-LAST:event_btnEliminarSignoDeAgrupacionActionPerformed

    private void btnEditarSignoDeAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSignoDeAgrupacionActionPerformed
        opcionModificar("signosDeAgrupacion", txtSignoDeAgrupacionSeleccionado.getText());
    }//GEN-LAST:event_btnEditarSignoDeAgrupacionActionPerformed

    private void txtSignoDeAgrupacionSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSignoDeAgrupacionSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSignoDeAgrupacionSeleccionadoActionPerformed

    private void btnRMPR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRMPR3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRMPR3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearOperadorAritmetico;
    private javax.swing.JButton btnCrearPalabraReservada;
    private javax.swing.JButton btnCrearSignoDeAgrupacion;
    private javax.swing.JButton btnCrearSignoDePuntuacion;
    private javax.swing.JButton btnEditarOperadorAritmetico;
    private javax.swing.JButton btnEditarPalabraReservada;
    private javax.swing.JButton btnEditarSignoDeAgrupacion;
    private javax.swing.JButton btnEditarSignoDePuntuacion;
    private javax.swing.JButton btnEliminarOperadorAritmetico;
    private javax.swing.JButton btnEliminarPalabraReservada;
    private javax.swing.JButton btnEliminarSignoDeAgrupacion;
    private javax.swing.JButton btnRMPR;
    private javax.swing.JButton btnRMPR1;
    private javax.swing.JButton btnRMPR2;
    private javax.swing.JButton btnRMPR3;
    private javax.swing.JButton btnSignosDePuntuacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jtpConfig;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JPanel pnlPalabrasReservadas;
    private javax.swing.JPanel pnlPalabrasReservadas1;
    private javax.swing.JPanel pnlPalabrasReservadas2;
    private javax.swing.JPanel pnlPalabrasReservadas3;
    private javax.swing.JTable tblOperadorAritmetico;
    private javax.swing.JTable tblPalabrasReservadas;
    private javax.swing.JTable tblSignosDeAgrupacion;
    private javax.swing.JTable tblSignosDePuntuacion;
    private javax.swing.JTextField txtCrearOperadorAritmetico;
    private javax.swing.JTextField txtCrearPalabraReservada;
    private javax.swing.JTextField txtCrearSignoDeAgrupacion;
    private javax.swing.JTextField txtCrearSignoDePuntuacion;
    private javax.swing.JTextField txtOperadorSeleccionado;
    private javax.swing.JTextField txtPalabraReservadaSeleccionada;
    private javax.swing.JTextField txtSignoDeAgrupacionSeleccionado;
    private javax.swing.JTextField txtSignoDePuntuacionSeleccionado;
    // End of variables declaration//GEN-END:variables
}
