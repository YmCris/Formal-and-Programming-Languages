package ymcris.languages.practice.lexicalanalyzer.frontend.uploadfile;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.JOptionPane;
import javax.swing.text.Highlighter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.BadLocationException;
import ymcris.languages.practice.lexicalanalyzer.backend.tokens.Token;
import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.JFMenuPrincipal;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDReportes;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDCargarArchivo;
import ymcris.languages.practice.lexicalanalyzer.frontend.dialogs.JDGuardarArchivo;
import ymcris.languages.practice.lexicalanalyzer.controller.validation.LexemaController;

/**
 * JavaFrame encargado de mostrar el analizador y dar a conocer la mayor parte
 * de sus funcionalidades.
 *
 * @author YmCris
 */
public class JFAnalizador extends javax.swing.JFrame {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private ArchivoJSON json;
    private ArrayList<Token[]> tokens;
    private ArrayList<String> lineasDeTexto;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    int cantidadErrores = 0;
    int tokensValidos = 0;
    boolean analisisRealizado = false;

    // INSTANCIAS --------------------------------------------------------------
    LexemaController controller = new LexemaController(this);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public JFAnalizador(ArchivoJSON json) {
        initComponents();
        this.json = json;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("MENÚ PRINCIPAL");
        this.lineasDeTexto = new ArrayList<>();
        agregarReconocimientoDeTeclasAlPane();
    }

    // **************** MÉTODOS PARA LECTURA DEL ÁREA DE TEXTO *****************
    private void agregarReconocimientoDeTeclasAlPane() {
        jtpTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarLineas();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarLineas();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarLineas();
            }
        });
    }

    private void actualizarLineas() {
        lineasDeTexto.clear();
        String texto = jtpTexto.getText();
        String[] lineas = texto.split("\\n");
        for (String linea : lineas) {
            lineasDeTexto.add(linea);
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // ******************* MÉTODOS DE LECTURA DEL ARCHIVO **********************
    /**
     * Método encargado de actualizar el texto de entrada
     */
    public void actualizarTextoDeEntradaPorArchivo() {
        StringBuilder builder = new StringBuilder();
        for (String linea : lineasDeTexto) {
            builder.append(linea);
            builder.append("\n");
        }
        jtpTexto.setText(builder.toString());
    }

    // ****************** MÉTODOS PARA COLOREAR EL ANALIZADOR ******************
    /**
     * Método encargado de insertar un token en el jtpTexto
     *
     * @param jtpText - texto de entrada
     * @param token - token a evaluar para colorearlo
     * @throws BadLocationException
     */
    private void insertarToken(JTextPane jtpText, Token token) throws BadLocationException {
        StyledDocument doc = jtpText.getStyledDocument();
        String color = token.getColor();
        Style style = jtpText.addStyle("tokenStyle", null);
        switch (color) {
            case "azul" -> {// palabras reservadas
                StyleConstants.setForeground(style, Color.BLUE);
                tokensValidos++;
            }
            case "cafe" -> {// identificadores
                StyleConstants.setForeground(style, Color.DARK_GRAY);
                tokensValidos++;
            }
            case "verde" -> {// números
                StyleConstants.setForeground(style, Color.GREEN);
                tokensValidos++;
            }
            case "naranja" -> {// cadena
                StyleConstants.setForeground(style, Color.ORANGE);
                tokensValidos++;
            }
            case "negro" -> {// decimales
                StyleConstants.setForeground(style, Color.BLACK);
                tokensValidos++;
            }
            case "verdeOscuro" -> {// comentarios de línea o bloque
                StyleConstants.setForeground(style, Color.CYAN);
                tokensValidos++;
            }
            case "amarillo" -> { // operadores
                StyleConstants.setForeground(style, Color.YELLOW);
                tokensValidos++;
            }
            case "morado" -> { // agrupación
                StyleConstants.setForeground(style, new Color(128, 0, 128));
                tokensValidos++;
            }
            case "rojo" -> { // errores
                StyleConstants.setForeground(style, Color.RED);
                cantidadErrores++;
            }
            default ->
                StyleConstants.setForeground(style, Color.BLACK);
        }
        doc.insertString(doc.getLength(), token.getLexema() + " ", style);
    }

    /**
     * Método encargado de mostrar los tokens en el jtpText para que el
     * analizador funcione
     *
     * @param jtpText - txtPane al cual se le agregarán los tokens
     * @param tokens - tokens existentes.
     */
    public void mostrarTokensEnTextPane(JTextPane jtpText, ArrayList<Token[]> tokens) {
        StyledDocument doc = jtpText.getStyledDocument();
        try {
            doc.remove(0, doc.getLength());
            for (Token[] linea : tokens) {
                for (Token token : linea) {
                    insertarToken(jtpText, token);
                }
                doc.insertString(doc.getLength(), "\n", null);
            }
        } catch (BadLocationException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al mostrar los tokens en el pane porque " + e.getMessage());
            e.printStackTrace();
        }
        analisisRealizado = true;
    }

    // ********************* MÉTODOS PARA BUSCAR UNA PALABRA *******************
    /**
     * Método encargado de buscar una palabra dentro del texto de entrada y
     * resaltarlo
     *
     * @param jtpText - texto de entrada
     * @param palabraABuscar - palabra que se desea buscar
     */
    public void buscarPalabra(JTextPane jtpText, String palabraABuscar) {
        try {
            Highlighter resaltador = jtpText.getHighlighter();
            resaltador.removeAllHighlights();
            String textoDeEntrada = jtpText.getText();
            int indice = textoDeEntrada.indexOf(palabraABuscar);
            boolean encontrado = false;
            while (indice >= 0) {
                int fin = indice + palabraABuscar.length();
                resaltador.addHighlight(Math.max(indice - 1, 0), fin, new DefaultHighlighter.DefaultHighlightPainter(Color.BLACK));
                encontrado = true;
                indice = textoDeEntrada.indexOf(palabraABuscar, fin);
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(jtpText, "La palabra '" + palabraABuscar + "' no existe en el texto de entrada");
            }
        } catch (BadLocationException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al buscar la palabra porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    // CÓDIGO AUTOGENERADO -----------------------------------------------------
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
        btnAnalizar = new javax.swing.JButton();
        btnAnalizar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpBackground.setBackground(new java.awt.Color(28, 28, 30));

        jtpTexto.setBackground(new java.awt.Color(100, 100, 105));
        jtpTexto.setBorder(null);
        jtpTexto.setForeground(new java.awt.Color(229, 229, 231));
        jtpTexto.setCaretColor(new java.awt.Color(229, 229, 231));
        jtpTexto.setDisabledTextColor(new java.awt.Color(229, 229, 231));
        jtpTexto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtpTexto.setSelectionColor(new java.awt.Color(255, 255, 255));
        jtpTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtpTextoKeyTyped(evt);
            }
        });
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

        btnAnalizar.setBackground(new java.awt.Color(58, 58, 60));
        btnAnalizar.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnAnalizar.setForeground(new java.awt.Color(229, 229, 231));
        btnAnalizar.setText("Analizar");
        btnAnalizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnAnalizar1.setBackground(new java.awt.Color(58, 58, 60));
        btnAnalizar1.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        btnAnalizar1.setForeground(new java.awt.Color(229, 229, 231));
        btnAnalizar1.setText("Limpiar");
        btnAnalizar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
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
        jdpBackground.setLayer(btnAnalizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpBackground.setLayer(btnAnalizar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                .addGroup(jdpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jdpBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        new JDCargarArchivo(this).setVisible(true);
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void btnBuscarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPalabraActionPerformed
        if (txtEscribirPalabra.getText().isEmpty() || txtEscribirPalabra.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "El recuadro para buscar palabra no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (lineasDeTexto.size() <= 0) {
            JOptionPane.showMessageDialog(null, "El texto de entrada debe de tener contenido", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        buscarPalabra(jtpTexto, txtEscribirPalabra.getText());
    }//GEN-LAST:event_btnBuscarPalabraActionPerformed

    private void btnGuardarTextoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTextoActualActionPerformed
        if (jtpTexto.getText().isEmpty() || jtpTexto.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes almacenar algo en el archivo antes de crearlo", "PELIGRO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        System.out.println(jtpTexto.getText());
        System.out.println("-------------------------");
        System.out.println("Tamaño: " + lineasDeTexto.size());
        System.out.println(lineasDeTexto);
        System.out.println("***************************************");
        new JDGuardarArchivo(jtpTexto.getText()).setVisible(true);
    }//GEN-LAST:event_btnGuardarTextoActualActionPerformed

    private void btnGenerarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportesActionPerformed
        if (!analisisRealizado) {
            JOptionPane.showMessageDialog(null, "El texto de entrada debe ser analizado primero", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JDReportes reportes = new JDReportes(this);
        reportes.setCantidadErrores(cantidadErrores);
        reportes.setTokensValidos(tokensValidos);
        reportes.setVisible(true);
    }//GEN-LAST:event_btnGenerarReportesActionPerformed

    private void txtEscribirPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscribirPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscribirPalabraActionPerformed

    private void btnGenerarReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportes1ActionPerformed
        this.dispose();
        new JFMenuPrincipal(json).setVisible(true);
    }//GEN-LAST:event_btnGenerarReportes1ActionPerformed
    private void jtpTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpTextoKeyPressed
    }//GEN-LAST:event_jtpTextoKeyPressed

    private void jtpTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpTextoKeyTyped
    }//GEN-LAST:event_jtpTextoKeyTyped

    private void jtpTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpTextoKeyReleased
    }//GEN-LAST:event_jtpTextoKeyReleased

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        System.out.println("\n".repeat(50));
        controller.setLineas(lineasDeTexto);
        controller.setPalabrasDeLasLineas(new ArrayList<>());
        controller.analizar();
        mostrarTokensEnTextPane(jtpTexto, tokens);
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizar1ActionPerformed
        lineasDeTexto.clear();
        tokens.clear();
        jtpTexto.setText("");
    }//GEN-LAST:event_btnAnalizar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizar1;
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

    public ArrayList<String> getLineasDeTexto() {
        return lineasDeTexto;
    }

    public void setLineasDeTexto(ArrayList<String> lineasDeTexto) {
        this.lineasDeTexto = lineasDeTexto;
    }

    public void setTokens(ArrayList<Token[]> tokens) {
        this.tokens = tokens;
    }

}
