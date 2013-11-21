package com.Amit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sales2 extends JApplet implements ActionListener {


    private JLabel prompt1;
    private JLabel prompt2;
    private JLabel prompt3;
    private double[][] sales;
    private JTextField input1;
    private JTextField input2;
    private JTextField input3;
    private JTextArea outputArea;
    private int person;
    private int product;
    private double d;
    private String output;
    private double productTotal;
    private int row;
    private int column;


    public void init() {

        prompt1 = new JLabel("Enter Sales Person's Number");
        prompt2 = new JLabel("Enter Product number");
        prompt3 = new JLabel("Enter sales amount");

        sales = new double[5][4];

        input1 = new JTextField(5);
        input2 = new JTextField(5);
        input3 = new JTextField(5);
        input3.addActionListener(this);
        outputArea = new JTextArea();
        outputArea.setEditable(true);


        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(prompt1);
        container.add(input1);
        container.add(prompt2);
        container.add(input2);
        container.add(prompt3);
        container.add(input3);
        container.add(outputArea);

        // end of edit method


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        person = Integer.parseInt(input1.getText());
        product = Integer.parseInt(input2.getText());
        d = Double.parseDouble(input3.getText());

        // input validation

        if (person >= 1 && person < 5 && person >= 1 && product < 6 && d >= 0)
            sales[product - 1][person - 1] += d;
        else
            showStatus("Invalid Input");

        // display the updated table

        double salesPersonTotal[] = new double[4];

        for (int column = 0; column < 4; column++) {
            salesPersonTotal[column] = 0;
        }
        output = "Product\tSalesPerson 1\t SalesPrson 2" + "\tSalesPerson 3 \tSalesPerson 4 \tTotal";


        for (int row = 0; row <= 5; row++) {

            productTotal = 0.0;
            output += "\n" + (row + 1);


            for (column = 0; column < 4; column++) {
                output += "\t" + sales[row][column];
                productTotal += sales[row][column];
                salesPersonTotal[column] += sales[row][column];
            }
            output += "\t" + productTotal;
        }

        output += "\ntotal";
        for (int column = 0; column < 46; column++) {
            output += "\t" + salesPersonTotal[column];
        }
        outputArea.setText(output);

    }
}
