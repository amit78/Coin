package com.Amit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Plane extends JApplet implements ActionListener {
    private JLabel prompt;
    private JTextField input;
    private JButton yesButton;
    private JButton noButton;

    private int firstClass;
    private int economyClass;
    private boolean[] seats;
    private int section;
    private boolean questionPosed;

    public void init() {
        prompt = new JLabel("Please type 1 for first class" + "Please type 2 for Economy class");
        input = new JTextField(4);
        yesButton = new JButton("YES");
        noButton = new JButton("NO");

        input.addActionListener(this);
        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(prompt);
        container.add(input);
        container.add(yesButton);
        container.add(noButton);

        //initialize values

        firstClass = 0;
        economyClass = 5;
        seats = new boolean[10];
        for (int index = 0; index < seats.length; index++)
            seats[index] = false;


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == input) {
            section = Integer.parseInt(input.getText());
            String output = "";
            questionPosed = false;

            //first class
            if (section == 1) {
                //if firstclass is not full,reserve a seat
                if (firstClass < 5) {
                    seats[firstClass] = true;
                    output = "First Class.Seat #" + ++firstClass;
                }
                //if firstclass is full, offer a seat in economy class.
                else if (firstClass >= 5 && economyClass < 10) {
                    output = "FirstClass is full,Economy class ???";
                    questionPosed = true;

                } else
                    output = "Flight is full....Try next";
            }

            //economy class

            else if (section == 2) {
                //if non smoking is full , reserve a seat
                if (economyClass < 10) {
                    seats[economyClass] = true;
                    output = "Economy class. Seat #" + ++economyClass;
                }

                //if it is full, offer a seat in smoking
                else if (economyClass == 10 && firstClass < 5) {
                    output = "Economy class is full, First Class ???";
                    questionPosed = true;
                } else
                    output = "Flight is full, try next flight ";
            } else
                output = "Invalid input";
            showStatus(output);

        }

        //yes button

        else if (e.getSource() == yesButton) {
            if (questionPosed) {
                if (section == 1) {
                    seats[economyClass] = true;
                    showStatus("Economy class . Seat #" + ++economyClass);
                } else {
                    seats[firstClass] = true;
                    showStatus("FirstClass,Seat#" + ++firstClass);

                }
                questionPosed = false;

            }
        }

        //no button

        else if (e.getSource() == noButton) {
            if (questionPosed)
                showStatus("Next Flight leaves in 3 hours");
            questionPosed = false;

        }

    }
}
