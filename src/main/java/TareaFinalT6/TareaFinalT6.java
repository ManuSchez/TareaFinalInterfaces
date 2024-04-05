package TareaFinalT6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TareaFinalT6 extends JFrame implements ActionListener {
    private JComboBox comboBox1, comboBox2;
    private JButton button1, button2, button3, button4;
    private JPanel Panel;

    public TareaFinalT6(){
        setLayout(null);
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new java.awt.Color(108, 63, 172));
        Panel.setBounds(0, 0, 3500000, 2000000);
        add(Panel);
        
        button1 = new JButton("Negrita");
        button1.setBounds(110, 100, 90, 30);
        button1.setBackground(Color.darkGray);
        Panel.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Cursiva");
        button2.setBounds(110, 100, 90, 30);
        button2.setBackground(Color.darkGray);
        Panel.add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Subrayado");
        button3.setBounds(110, 100, 90, 30);
        button3.setBackground(Color.darkGray);
        Panel.add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Color");
        button4.setBounds(110, 100, 90, 30);
        button4.setBackground(Color.darkGray);
        Panel.add(button4);
        button4.addActionListener(this);

        JFrame frame = new JFrame("Ejemplo de Botón Desplegable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(50, 50, 150, 30);
        frame.add(comboBox);
        frame.setLayout(null);
        frame.setVisible(true);

}
}
