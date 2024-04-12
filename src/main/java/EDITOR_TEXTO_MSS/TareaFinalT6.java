package EDITOR_TEXTO_MSS;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TareaFinalT6 extends JFrame implements ActionListener {
    private JComboBox<String> comboBox1, comboBox2;
    private JButton button1, button2, button3, button4, button5;
    private JPanel Panel;
    private JTextPane textPane1;

    public TareaFinalT6() {
        setLayout(null);
        //Creamos el panel y le asignamos un color y un rango (Es un rango elevando para que al ampliar la ventana no queden zonas en blanco)
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new java.awt.Color(108, 63, 172));
        Panel.setBounds(0, 0, 10000000, 1000000);
        add(Panel);

        //Creamos los diferentes botones  con las acciones que van a realizar cada uno su tamaño y ubicacion, lo añadimos al panel
        // y mediante addActionlistener le mostramos el evento y que lo va a realizar ese mismo boton
        button1 = new JButton("Negrita");
        button1.addActionListener(new BoldButtonListener());
        button1.setBounds(20, 30, 90, 30);
        Panel.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Cursiva");
        button2.addActionListener(new ItalicButtonListener());
        button2.setBounds(120, 30, 90, 30);
        Panel.add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Subrayado");
        button3.addActionListener(new UnderlineButtonListener());
        button3.setBounds(220, 30, 100, 30);
        Panel.add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Color");
        button4.addActionListener(new ColorButtonListener());
        button4.setBounds(330, 30, 90, 30);
        Panel.add(button4);
        button4.addActionListener(this);

        button5 = new JButton("Enviar");
        button5.setBounds(650, 380, 90, 30);
        Panel.add(button5);
        button5.addActionListener(this);

        //Con combo box podremos introducir varias opciones a seleccionar en un mismo boton como es el caso de las fuentes y sus tamaños
        comboBox1 = new JComboBox<>(new String[]{"Arial", "Times new Roman", "Calibrí", "Verdana"});
        comboBox1.addActionListener(new FontComboBoxListener());
        comboBox1.setBounds(440, 30, 150, 30);
        Panel.add(comboBox1);

        comboBox2 = new JComboBox(new Integer[]{12,14,16,18,20,22,24});
        comboBox2.addActionListener(new SizeComboBoxListener());
        comboBox2.setBounds(600, 30, 150, 30);
        Panel.add(comboBox2);

        textPane1 = new JTextPane();
        textPane1.setBounds(20, 70, 730, 300);
        Panel.add(textPane1);

        //JScrollPane nos permite crear una barra en la posicion que indiquemos para poder scrollear el texto en el caso de que sea extenso
        JScrollPane scrollPane = new JScrollPane(textPane1);
        scrollPane.setBounds(20, 70, 730, 300);
        Panel.add(scrollPane);

        //Mediante setTitle podremos asignarle un titulo a la ventana emerjente en este caso se llamara editor de texto
        setTitle("Editor de Texto");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //Empezaremos a crear diferentes metodos especificos para cada boton realizando la accion deseada para cada uno
    private class BoldButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane para poder manipularlo
            StyledDocument doc = textPane1.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Negrita", null);

            // Verificar si el texto seleccionado está en negrita
            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esNegrita = StyleConstants.isBold(atributos);

            // Alternar el estilo de negrita
            if (esNegrita) {
                // Si el texto seleccionado está en negrita al pulsar de nuevo se quita el estilo de negrita
                StyleConstants.setBold(style, false);
            } else {
                // Si el texto seleccionado no está en negrita se aplica el estilo de negrita
                StyleConstants.setBold(style, true);
            }
            // Aplicar el estilo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class ItalicButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();
            StyledDocument doc = textPane1.getStyledDocument();
            Style style = doc.addStyle("Cursiva", null);
            AttributeSet attributes = doc.getCharacterElement(start).getAttributes();
            boolean esCursiva = StyleConstants.isItalic(attributes);

            if (esCursiva) {
                StyleConstants.setItalic(style, false);
            } else {
                StyleConstants.setItalic(style, true);
            }
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class UnderlineButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();
            StyledDocument doc = textPane1.getStyledDocument();
            Style style = doc.addStyle("Subrayado", null);
            AttributeSet attributes = doc.getCharacterElement(start).getAttributes();
            boolean esSubrayada = StyleConstants.isUnderline(attributes);

            if (esSubrayada) {
                StyleConstants.setUnderline(style, false);
            } else {
                StyleConstants.setUnderline(style, true);
            }
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class ColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Al ser una nueva pestaña le pondremos un titulo, y asignaremos el color predefinido como negro
            Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);

            if (selectedColor != null) {
                int start = textPane1.getSelectionStart();
                int end = textPane1.getSelectionEnd();
                StyledDocument doc = textPane1.getStyledDocument();
                Style style = doc.addStyle("Color", null);
                StyleConstants.setForeground(style, selectedColor);
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }
    private class FontComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedFontName = (String) comboBox1.getSelectedItem();

            if (selectedFontName != null) {
                int start = textPane1.getSelectionStart();
                int end = textPane1.getSelectionEnd();
                StyledDocument doc = textPane1.getStyledDocument();
                Style style = doc.addStyle("Fuente", null);
                StyleConstants.setFontFamily(style, selectedFontName);
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }
    private class SizeComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedFontName = (String) comboBox1.getSelectedItem();
            int selectedFontSize = (Integer) comboBox2.getSelectedItem(); // Obtener el tamaño de fuente seleccionado

            if (selectedFontName != null) {
                int start = textPane1.getSelectionStart();
                int end = textPane1.getSelectionEnd();
                StyledDocument doc = textPane1.getStyledDocument();
                Style style = doc.addStyle("Fuente", null);
                StyleConstants.setFontFamily(style, selectedFontName);
                StyleConstants.setFontSize(style, selectedFontSize);
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }

    public static void main(String[] args) {
        TareaFinalT6 tareaFinalT6 = new TareaFinalT6();
        tareaFinalT6.setTitle("Editor de Texto");
        tareaFinalT6.setSize(770, 460);
        tareaFinalT6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tareaFinalT6.setVisible(true);
    }
    //@Override indica que este metodo está sobrescribiendo un metodo de la clase padre, en este caso seria ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        //Mediante if asignaremos las acciones de los botones
        if (e.getSource() == button1) {
            // Código para acción de Negrita
        } else if (e.getSource() == button2) {
            // Código para acción de Cursiva
        } else if (e.getSource() == button3) {
            // Código para acción de Subrayado
        } else if (e.getSource() == button4) {
            // Código para acción de Color
        } else if (e.getSource() == button5) {
            //En el boton enviar mediante un JOptionPane crearemos una nueva pantalla emergente en la cual se indica que se
            //ha enviado el mensaje
            JOptionPane.showMessageDialog(this, "Mensaje enviado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
