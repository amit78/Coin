package com.Amit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Sales extends JApplet implements ActionListener {


    private int[] total;
    private JTextField inputField;
    private JTextArea outputArea;
    private JLabel prompt;
    private double dollars;
    private double salary;
    private String output;
    private int range2;

    public void init() {


        total = new int[9];

        for (int counter = 0; counter < total.length; counter++) {
            total[counter] = 0;

        }

        prompt = new JLabel("Enter Sales Amount");
        inputField = new JTextField(5);
        inputField.addActionListener(this);
        outputArea = new JTextArea();
        inputField.addActionListener(this);


        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(prompt);
        container.add(inputField);
        container.add(outputArea);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        dollars = Double.parseDouble(inputField.getText());
        salary = dollars * 0.09 + 200;

        int range = (int) (salary / 100);

        if (range > 9)
            range = 10;

        ++total[range - 2];
        inputField.setText("");

        output = "Range\t\tNumber";

        for (int range2 = 0; range2 < total.length - 1; range2++)
        output = output + "\n$" + (200 + 100 * range2) + "-$" + (299 + 100 * range2) + "\t\t" + total[range2];

        output = output + "\n$1000 and over\t\t" + total[total.length - 1];
        outputArea.setText(output);

    }
}






























