/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Constantes;
import control.Filtro;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon
 */
public class VistaCrearFiltro extends javax.swing.JFrame {

    private Filtro controlFiltro;
    private VistaMenu menu;
    
    /**
     * Creates new form VistaCrearFiltro
     */
    public VistaCrearFiltro() {
        initComponents();
        cargarTextosCombos();
        cargarNumeroCombos();
    }

    public void setMenu(VistaMenu menu) {
        this.menu = menu;
    }

    private void cargarTextosCombos () {
                
        String[] operadores = new String[]{"", "Igual","Mayor que", "Menor que", "Mayor o igual que", "Menor o igual que"};
        for (int i = 0; i < operadores.length; i++) {
            comboOpera1.addItem(operadores[i]);
            comboOpera2.addItem(operadores[i]);
            comboOpera3.addItem(operadores[i]);
            comboOpera4.addItem(operadores[i]);
            comboOpera5.addItem(operadores[i]);
            comboOpera6.addItem(operadores[i]);
        }

        comboRareza.addItem("");
        comboRareza.addItem("Normal");
        comboRareza.addItem("Magico");
        comboRareza.addItem("Raro");
        comboRareza.addItem("Unico");
        
        String[] colores = new String[]{"", "Rojo", "Verde", "Azul", "Blanco"};
        for (int i = 0; i < colores.length; i++) {
            comboColor1.addItem(colores[i]);
            comboColor2.addItem(colores[i]);
            comboColor3.addItem(colores[i]);
            comboColor4.addItem(colores[i]);
            comboColor5.addItem(colores[i]);
            comboColor6.addItem(colores[i]);
        }
    }
    
    private void cargarNumeroCombos () {
        comboNivel1.addItem("");
        comboNivel2.addItem("");
        comboHuecos.addItem("");
        comboUniones.addItem("");
        comboCalidad.addItem("");
        comboSonido.addItem("");
        
        for (int i = 1; i < 101; i++) {
            if (i < 7) {
               comboHuecos.addItem(i+""); 
               comboUniones.addItem(i+"");
            }
            
            if (i < 17) {
                comboSonido.addItem(i+"");
            }
            
            if (i < 21) {
                comboCalidad.addItem(i+"");
            }
            
            comboNivel1.addItem(i+"");
            comboNivel2.addItem(i+"");
        }
    }
    
    private void cargarFiltro () {
        controlFiltro = new Filtro();
        //Nombre del filtro
        controlFiltro.setNombre(cajaNombre.getText());
        
        //Visibilidad del filtro
        if (radioVisibleSi.isSelected()) {
            controlFiltro.setVisibilidad("Si");
        } else if (radioVisibleNo.isSelected()) {
            controlFiltro.setVisibilidad("No");
        }
        
        //Nivel del objeto
        if (comboOpera1.getSelectedIndex() > 0 && comboNivel1.getSelectedIndex() > 0 || comboOpera2.getSelectedIndex() > 0 && comboNivel2.getSelectedIndex() > 0) {
            controlFiltro.setNivelObjeto(comboOpera1.getSelectedItem().toString(), comboNivel1.getSelectedItem().toString(), comboOpera2.getSelectedItem().toString(), comboNivel2.getSelectedItem().toString());
        }

        //Calidad objeto
        if (comboOpera3.getSelectedIndex() > 0 && comboCalidad.getSelectedIndex() > 0) {
            controlFiltro.setCalidad(comboOpera3.getSelectedItem().toString(), comboCalidad.getSelectedItem().toString());
        }

        //Rareza objeto
        if (comboOpera4.getSelectedIndex() > 0 && comboRareza.getSelectedIndex() > 0) {
            controlFiltro.setRareza(comboOpera4.getSelectedItem().toString(), comboRareza.getSelectedItem().toString());
        }

        //Clase objeto
        if (!cajaClase.getText().isEmpty()) {
            String textoPlano = cajaClase.getText();
            textoPlano.replaceAll(" ", "");
            String texto[] = textoPlano.split(",");
            String textoCompleto = "";
            for (int i = 0; i < texto.length; i++) {
                textoCompleto += "\"" +texto[i] + "\" ";
            }
            controlFiltro.setClaseObjeto(textoCompleto);
        }
        //Base objeto
        if (!cajaBase.getText().isEmpty()) {
            String textoPlano = cajaBase.getText();
            textoPlano.replaceAll(" ", "");
            String texto[] = textoPlano.split(",");
            String textoCompleto = "";
            for (int i = 0; i < texto.length; i++) {
                textoCompleto += "\"" +texto[i] + "\" ";
            }
            controlFiltro.setTipoBase(textoCompleto);
        }

        //Huecos objeto
        if (comboOpera5.getSelectedIndex() > 0 && comboHuecos.getSelectedIndex() > 0) {
            controlFiltro.setNumeroHuecos(comboOpera5.getSelectedItem().toString(), comboHuecos.getSelectedItem().toString());
        }

        //Uniones objeto
        if (comboOpera6.getSelectedIndex() > 0 && comboUniones.getSelectedIndex() > 0) {
            controlFiltro.setNumeroUniones(comboOpera6.getSelectedItem().toString(), comboUniones.getSelectedItem().toString());
        }

        //Colores objeto
        if (comboColor1.getSelectedIndex() > 0 || comboColor2.getSelectedIndex() > 0 || comboColor3.getSelectedIndex() > 0 || comboColor4.getSelectedIndex() > 0 || comboColor5.getSelectedIndex() > 0 || comboColor6.getSelectedIndex() > 0) {
            controlFiltro.setColoresHuecos(comboColor1.getSelectedItem().toString(), comboColor2.getSelectedItem().toString(), comboColor3.getSelectedItem().toString(), comboColor4.getSelectedItem().toString(), comboColor5.getSelectedItem().toString(), comboColor6.getSelectedItem().toString());
        }
        
        //Identificado
        if (radioIdentificadoSi.isSelected()) {
            controlFiltro.setIdentificado(String.valueOf(radioIdentificadoSi.isSelected()));
        } else if (radioIdentificadoNo.isSelected()) {
            controlFiltro.setIdentificado(String.valueOf(radioIdentificadoNo.isSelected()));
        }
        
        //Corrupto
        if (radioCorruptoSi.isSelected()) {
            controlFiltro.setCorrupto(String.valueOf(radioCorruptoSi.isSelected()));
        } else if (radioCorruptoNo.isSelected()) {
            controlFiltro.setCorrupto(String.valueOf(radioCorruptoNo.isSelected()));
        }

        //Acciones
        //Color borde
        if (!cajaColorBorde.getText().isEmpty()) {
            controlFiltro.setColorBorde(cajaColorBorde.getText());
        }

        //Color texto
        if (!cajaColorTexto.getText().isEmpty()) {
            controlFiltro.setColorTexto(cajaColorTexto.getText());
        }

        //Color fondo
        if (!cajaColorFondo.getText().isEmpty()) {
            controlFiltro.setColorFondo(cajaColorFondo.getText());
        }

        //Sonido alerta
        if (comboSonido.getSelectedIndex() > 0 && barraVolumen.getValue() != 0) {
            controlFiltro.setSonidoAlerta(comboSonido.getSelectedItem().toString(), barraVolumen.getValue() + "");
        }

        //Tamaño texto
        if (barraTamano.getValue() != 32) {
            controlFiltro.setTamañoLetra(barraTamano.getValue() + "");
        }
    }
    
    private String textoRGB () {
        JColorChooser colorBorde = new JColorChooser();
        Color color = colorBorde.showDialog(null, "Seleciona un color", Color.WHITE);
        String rgba = color.getRed() + " " + color.getGreen() + " " + color.getBlue();
        if (color.getAlpha() != 255) {
            rgba = rgba + " " + color.getAlpha();
        }
        return rgba;
    }
    
    private void limitarColores (java.awt.event.KeyEvent e, javax.swing.JTextField caja) {
        char letra = e.getKeyChar();
        if (!Character.isDigit(letra) && !Character.isWhitespace(letra) || caja.getText().length() >= 15) {
            getToolkit().beep();
            e.consume();
        }
    }
    
    private void limitarTextos (java.awt.event.KeyEvent e) {
        char letra = e.getKeyChar();
        if (!Character.isLetter(letra) && !Character.isWhitespace(letra) && letra != ',') {
            getToolkit().beep();
            e.consume();
        }
    }
    
    private void limpiarCampos () {
        final int RESET = -1;
        cajaNombre.setText("");
        grupoRadioVisibilidad.clearSelection();
        comboOpera1.setSelectedIndex(RESET);
        comboNivel1.setSelectedIndex(RESET);
        comboOpera2.setSelectedIndex(RESET);
        comboNivel2.setSelectedIndex(RESET);
        comboOpera3.setSelectedIndex(RESET);
        comboCalidad.setSelectedIndex(RESET);
        comboOpera4.setSelectedIndex(RESET);
        comboRareza.setSelectedIndex(RESET);
        cajaClase.setText("");
        cajaBase.setText("");
        comboOpera5.setSelectedIndex(RESET);
        comboHuecos.setSelectedIndex(RESET);
        comboOpera6.setSelectedIndex(RESET);
        comboUniones.setSelectedIndex(RESET);
        comboColor1.setSelectedIndex(RESET);    
        comboColor2.setSelectedIndex(RESET);        
        comboColor3.setSelectedIndex(RESET);        
        comboColor5.setSelectedIndex(RESET);        
        comboColor6.setSelectedIndex(RESET);
        grupoRadioIdentificado.clearSelection();
        grupoRadioCorrupto.clearSelection();
        cajaColorBorde.setText("");
        cajaColorTexto.setText("");
        cajaColorFondo.setText("");
        comboSonido.setSelectedIndex(RESET);
        barraVolumen.setValue(0);
        barraTamano.setValue(32);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadioVisibilidad = new javax.swing.ButtonGroup();
        grupoRadioIdentificado = new javax.swing.ButtonGroup();
        grupoRadioCorrupto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboOpera1 = new javax.swing.JComboBox<>();
        comboNivel1 = new javax.swing.JComboBox<>();
        comboOpera2 = new javax.swing.JComboBox<>();
        comboNivel2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboCalidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboRareza = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cajaClase = new javax.swing.JTextField();
        cajaBase = new javax.swing.JTextField();
        comboHuecos = new javax.swing.JComboBox<>();
        comboUniones = new javax.swing.JComboBox<>();
        comboColor1 = new javax.swing.JComboBox<>();
        comboColor2 = new javax.swing.JComboBox<>();
        comboColor3 = new javax.swing.JComboBox<>();
        comboColor4 = new javax.swing.JComboBox<>();
        comboColor5 = new javax.swing.JComboBox<>();
        comboColor6 = new javax.swing.JComboBox<>();
        comboOpera4 = new javax.swing.JComboBox<>();
        comboOpera3 = new javax.swing.JComboBox<>();
        comboOpera5 = new javax.swing.JComboBox<>();
        comboOpera6 = new javax.swing.JComboBox<>();
        radioVisibleSi = new javax.swing.JRadioButton();
        radioVisibleNo = new javax.swing.JRadioButton();
        radioIdentificadoSi = new javax.swing.JRadioButton();
        radioCorruptoSi = new javax.swing.JRadioButton();
        radioIdentificadoNo = new javax.swing.JRadioButton();
        radioCorruptoNo = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cajaColorBorde = new javax.swing.JTextField();
        cajaColorTexto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cajaColorFondo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        comboSonido = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        buttonColorBorde = new javax.swing.JButton();
        buttonColorTexto = new javax.swing.JButton();
        buttonColorFondo = new javax.swing.JButton();
        barraVolumen = new javax.swing.JSlider();
        barraTamano = new javax.swing.JSlider();
        botonLimpiar = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creador de secciones");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Filter_64px.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1270, 720));
        setMinimumSize(new java.awt.Dimension(1270, 720));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(Constantes.COLOR_FONDO);

        jPanel2.setBackground(Constantes.COLOR_PANELES);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Identificadores");
        jLabel1.setToolTipText("Solo llena la información que necesites");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jLabel2.setToolTipText("El nombre relacionado con la sección en el filtro");

        cajaNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Visibilidad");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nivel del objeto");
        jLabel4.setToolTipText("Seleccione un operador y el nivel del objeto, si es entre dos valores seleccione el segundo bloque y cambia sus valores.");

        comboOpera1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboNivel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboOpera2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboNivel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Calidad");
        jLabel5.setToolTipText("Seleccione un operado y la calidad del objeto a resaltar.");

        comboCalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Rareza");
        jLabel6.setToolTipText("Seleccione un operado y la rareza del objeto a resaltar.");

        comboRareza.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Clase de objeto");
        jLabel7.setToolTipText("En el cuadro del frente se debe escribir en ingles la clase del conjunto de los objetos que se desean resaltar, se deben separados por comas, por ejemplo: Currency, Divination Card, Maps, etc.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tipo base");
        jLabel8.setToolTipText("En el cuadro del frente se debe escribir en ingles los nombres de los objetos que se desea resaltar, se deben separa por comas, por ejemplo:  Skin of the Lords, Wildslash Awl, Immortal Call, etc.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad de huecos");
        jLabel9.setToolTipText("Seleccione un operador y luego la cantidad de huecos que debe tener el objeto.");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Uniones");
        jLabel10.setToolTipText("Seleccione un operador y luego la cantidad de uniones que debe tener el objeto.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Colores de los huecos");
        jLabel11.setToolTipText("Seleccione cada uno de los colores del equipamiento que se necesite ser resaltado.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Identificado");
        jLabel12.setToolTipText("Seleccione si o no, si desea que se resalte el objeto identificado.");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Corrupto");
        jLabel13.setToolTipText("Seleccione si o no, si desea que se resalte el objeto corrupto.");

        cajaClase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaClase.setToolTipText("");
        cajaClase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaClaseKeyTyped(evt);
            }
        });

        cajaBase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaBase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBaseKeyTyped(evt);
            }
        });

        comboHuecos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboUniones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboColor6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboOpera4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboOpera3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboOpera5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        comboOpera6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        grupoRadioVisibilidad.add(radioVisibleSi);
        radioVisibleSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioVisibleSi.setText("Si");
        radioVisibleSi.setOpaque(false);

        grupoRadioVisibilidad.add(radioVisibleNo);
        radioVisibleNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioVisibleNo.setText("No");
        radioVisibleNo.setOpaque(false);

        grupoRadioIdentificado.add(radioIdentificadoSi);
        radioIdentificadoSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioIdentificadoSi.setText("Si");
        radioIdentificadoSi.setOpaque(false);

        grupoRadioCorrupto.add(radioCorruptoSi);
        radioCorruptoSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioCorruptoSi.setText("Si");
        radioCorruptoSi.setOpaque(false);

        grupoRadioIdentificado.add(radioIdentificadoNo);
        radioIdentificadoNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioIdentificadoNo.setText("No");
        radioIdentificadoNo.setOpaque(false);

        grupoRadioCorrupto.add(radioCorruptoNo);
        radioCorruptoNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioCorruptoNo.setText("No");
        radioCorruptoNo.setOpaque(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboOpera6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboOpera3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOpera4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboCalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboRareza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboOpera5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboHuecos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cajaBase)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(comboOpera1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jSeparator1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioVisibleSi)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(comboOpera2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioVisibleNo)))
                            .addComponent(cajaClase)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioIdentificadoSi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioIdentificadoNo)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel13)
                                .addGap(20, 20, 20)
                                .addComponent(radioCorruptoSi)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboColor3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboColor4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboColor5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioCorruptoNo)
                            .addComponent(comboColor6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboUniones, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(radioVisibleSi)
                        .addComponent(radioVisibleNo))
                    .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(comboOpera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboOpera2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboOpera3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboRareza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboOpera4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cajaClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cajaBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboHuecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboOpera5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboUniones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboOpera6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboColor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboColor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboColor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboColor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(radioCorruptoSi)
                    .addComponent(radioCorruptoNo)
                    .addComponent(radioIdentificadoNo)
                    .addComponent(radioIdentificadoSi)
                    .addComponent(jLabel12))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(Constantes.COLOR_PANELES);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Acciones");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Color del borde");
        jLabel15.setToolTipText("Puede escribir o seleccionar con el botón el conjunto de número que cambien el color del borde del objeto, por ejemplo, el número debe quedar 255 100 255 150 (el cuarto color es para la opacidad).");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Color del texto");
        jLabel16.setToolTipText("Puede escribir o seleccionar con el botón el conjunto de número que cambien el color del texto del objeto, por ejemplo, el número debe quedar 255 100 255 150 (el cuarto color es para la opacidad).");

        cajaColorBorde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaColorBorde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColorBordeKeyTyped(evt);
            }
        });

        cajaColorTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaColorTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColorTextoKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Color del fondo");
        jLabel17.setToolTipText("Puede escribir o seleccionar con el botón el conjunto de número que cambien el color del fondo del objeto, por ejemplo, el número debe quedar 255 100 255 150 (el cuarto color es para la opacidad).");

        cajaColorFondo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaColorFondo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColorFondoKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Sonido de alerta");
        jLabel18.setToolTipText("Seleccione uno de los sonidos de alerta que existen en el juego y el volumen para el objeto.");

        comboSonido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Volumen");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Tamaño letra");
        jLabel20.setToolTipText("Seleccione el tamaño de las letras para el objeto, el tamaño predeterminado es 32.");

        buttonColorBorde.setText("Selecione un color");
        buttonColorBorde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorBordeActionPerformed(evt);
            }
        });

        buttonColorTexto.setText("Selecione un color");
        buttonColorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorTextoActionPerformed(evt);
            }
        });

        buttonColorFondo.setText("Selecione un color");
        buttonColorFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorFondoActionPerformed(evt);
            }
        });

        barraVolumen.setFont(new java.awt.Font("Tahoma", 0, 6)); // NOI18N
        barraVolumen.setMajorTickSpacing(20);
        barraVolumen.setMaximum(300);
        barraVolumen.setMinorTickSpacing(20);
        barraVolumen.setPaintLabels(true);
        barraVolumen.setPaintTicks(true);
        barraVolumen.setSnapToTicks(true);
        barraVolumen.setValue(0);
        barraVolumen.setOpaque(false);

        barraTamano.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        barraTamano.setMajorTickSpacing(1);
        barraTamano.setMaximum(45);
        barraTamano.setMinimum(16);
        barraTamano.setMinorTickSpacing(1);
        barraTamano.setPaintLabels(true);
        barraTamano.setPaintTicks(true);
        barraTamano.setValue(32);
        barraTamano.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajaColorBorde)
                            .addComponent(cajaColorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaColorFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonColorBorde)
                            .addComponent(buttonColorTexto)
                            .addComponent(buttonColorFondo)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(comboSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barraVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barraTamano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cajaColorBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColorBorde))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cajaColorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColorTexto))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cajaColorFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColorFondo))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(comboSonido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19))
                    .addComponent(barraVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(barraTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Clear_Filters_32px.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonCrear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Save_as_32px.png"))); // NOI18N
        botonCrear.setText("Guardar");
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ebrima", 1, 48)); // NOI18N
        jLabel21.setForeground(Constantes.COLOR_TITULO);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Sección filtro");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Close_Window_32px.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Menu_32px.png"))); // NOI18N
        jButton2.setText("Menú");
        jButton2.setToolTipText("");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        if (!cajaNombre.getText().isEmpty() && radioVisibleSi.isSelected() || radioVisibleNo.isSelected()) {
            cargarFiltro();
            String ruta = menu.getAlmacen().rutasGuardar();
            boolean guardo = menu.getAlmacen().guardaBloqueFiltro(ruta, controlFiltro.packFiltro());
            if (guardo) {
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El filtro debe tener como minimo nombre y visibilidad", "Es presento un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonCrearActionPerformed

    private void buttonColorBordeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorBordeActionPerformed
        cajaColorBorde.setText(textoRGB());//Utilizo el metodo textoRGB para traer el string con codigo RGB elegido
    }//GEN-LAST:event_buttonColorBordeActionPerformed

    private void buttonColorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorTextoActionPerformed
        cajaColorTexto.setText(textoRGB());//Utilizo el metodo textoRGB para traer el string con codigo RGB elegido
    }//GEN-LAST:event_buttonColorTextoActionPerformed

    private void buttonColorFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorFondoActionPerformed
        cajaColorFondo.setText(textoRGB());//Utilizo el metodo textoRGB para traer el string con codigo RGB elegido
    }//GEN-LAST:event_buttonColorFondoActionPerformed

    private void cajaColorBordeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColorBordeKeyTyped
        limitarColores(evt, cajaColorBorde);
    }//GEN-LAST:event_cajaColorBordeKeyTyped

    private void cajaColorTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColorTextoKeyTyped
        limitarColores(evt, cajaColorTexto);
    }//GEN-LAST:event_cajaColorTextoKeyTyped

    private void cajaColorFondoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColorFondoKeyTyped
        limitarColores(evt, cajaColorFondo);
    }//GEN-LAST:event_cajaColorFondoKeyTyped

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cajaClaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaClaseKeyTyped
        limitarTextos(evt);
    }//GEN-LAST:event_cajaClaseKeyTyped

    private void cajaBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBaseKeyTyped
        limitarTextos(evt);
    }//GEN-LAST:event_cajaBaseKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCrearFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCrearFiltro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider barraTamano;
    private javax.swing.JSlider barraVolumen;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton buttonColorBorde;
    private javax.swing.JButton buttonColorFondo;
    private javax.swing.JButton buttonColorTexto;
    private javax.swing.JTextField cajaBase;
    private javax.swing.JTextField cajaClase;
    private javax.swing.JTextField cajaColorBorde;
    private javax.swing.JTextField cajaColorFondo;
    private javax.swing.JTextField cajaColorTexto;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JComboBox<String> comboCalidad;
    private javax.swing.JComboBox<String> comboColor1;
    private javax.swing.JComboBox<String> comboColor2;
    private javax.swing.JComboBox<String> comboColor3;
    private javax.swing.JComboBox<String> comboColor4;
    private javax.swing.JComboBox<String> comboColor5;
    private javax.swing.JComboBox<String> comboColor6;
    private javax.swing.JComboBox<String> comboHuecos;
    private javax.swing.JComboBox<String> comboNivel1;
    private javax.swing.JComboBox<String> comboNivel2;
    private javax.swing.JComboBox<String> comboOpera1;
    private javax.swing.JComboBox<String> comboOpera2;
    private javax.swing.JComboBox<String> comboOpera3;
    private javax.swing.JComboBox<String> comboOpera4;
    private javax.swing.JComboBox<String> comboOpera5;
    private javax.swing.JComboBox<String> comboOpera6;
    private javax.swing.JComboBox<String> comboRareza;
    private javax.swing.JComboBox<String> comboSonido;
    private javax.swing.JComboBox<String> comboUniones;
    private javax.swing.ButtonGroup grupoRadioCorrupto;
    private javax.swing.ButtonGroup grupoRadioIdentificado;
    private javax.swing.ButtonGroup grupoRadioVisibilidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioCorruptoNo;
    private javax.swing.JRadioButton radioCorruptoSi;
    private javax.swing.JRadioButton radioIdentificadoNo;
    private javax.swing.JRadioButton radioIdentificadoSi;
    private javax.swing.JRadioButton radioVisibleNo;
    private javax.swing.JRadioButton radioVisibleSi;
    // End of variables declaration//GEN-END:variables
}
