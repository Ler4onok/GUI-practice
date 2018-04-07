package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Press"); //create a button
    private JTextField input = new JTextField("", 5); //create a text field with 5 columns
    private JLabel label = new JLabel("Input:"); //the name of the text field
    private JRadioButton radio1 = new JRadioButton("Select this"); //a field of choice (1st)
    private JRadioButton radio2 = new JRadioButton("Select that"); //(2nd)
    private JCheckBox check = new JCheckBox("Check", false); //postavit' galochku

    public SimpleGUI() {
        super("Sumple GUI"); //the name of the opened window
        this.setBounds(100, 100, 250, 100); //size of the opened window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // condition of closure

        Container container = this.getContentPane(); //create our window where we will place all buttons, text etc.
        container.setLayout( new GridLayout(3, 3, 2, 2 )); //parameters of uor window
        container.add(label); //place label in our window
        container.add(input);

        ButtonGroup group = new ButtonGroup(); //group radio1 and radio2
        group.add(radio1);
        group.add(radio2);

        container.add(radio1);
        radio1.setSelected(true); //default value of radio1
        container.add(radio2);

        container.add(check);

        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio 1" : "Radio 2") + " is selected" + "\n"; // if radio1 is selected print radio 1, else radio 2
            message += "Checkbox is " + (check.isSelected() ? "checked" : "not checked");

            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE); //print a new message in our window



        }

    }
}
