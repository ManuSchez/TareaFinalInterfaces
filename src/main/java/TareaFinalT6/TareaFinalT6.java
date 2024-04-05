package TareaFinalT6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TareaFinalT6 extends JFrame implements ActionListener {
    private JComboBox<String> comboBox1, comboBox2;
    private JButton button1, button2, button3, button4, button5;
    private JPanel Panel;
    private JTextArea textArea1;
    private JPanel panelTexto;

    public TareaFinalT6() {
        setLayout(null);
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new java.awt.Color(108, 63, 172));
        Panel.setBounds(0, 0, 10000000, 1000000);
        add(Panel);

        button1 = new JButton("Negrita");
        button1.setBounds(20, 30, 90, 30);
        Panel.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Cursiva");
        button2.setBounds(120, 30, 90, 30);
        Panel.add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Subrayado");
        button3.setBounds(220, 30, 100, 30);
        Panel.add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Color");
        button4.setBounds(330, 30, 90, 30);
        Panel.add(button4);
        button4.addActionListener(this);

        button5 = new JButton("Enviar");
        button5.setBounds(650, 380, 90, 30);
        Panel.add(button5);
        button5.addActionListener(this);

        comboBox1 = new JComboBox<>(new String[]{"Arial", "Times new Roman", "Calibrí", "Verdana"});
        comboBox1.setBounds(440, 30, 150, 30);
        Panel.add(comboBox1);

        comboBox2 = new JComboBox(new Integer[]{8,10,12,14,16,18,20});
        comboBox2.setBounds(600, 30, 150, 30);
        Panel.add(comboBox2);

        textArea1 = new JTextArea();
        textArea1.setBounds(20, 70, 730, 300);
        Panel.add(textArea1);
    }

    public static void main(String[] args) {
        TareaFinalT6 tareaFinalT6 = new TareaFinalT6();
        tareaFinalT6.setTitle("Ejemplo de Botón Desplegable");
        tareaFinalT6.setSize(770, 460);
        tareaFinalT6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tareaFinalT6.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            // Código para acción de Negrita
        } else if (e.getSource() == button2) {
            // Código para acción de Cursiva
        } else if (e.getSource() == button3) {
            // Código para acción de Subrayado
        } else if (e.getSource() == button4) {
            // Código para acción de Color
        } else if (e.getSource() == button5) {
            JOptionPane.showMessageDialog(this, "Mensaje enviado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
