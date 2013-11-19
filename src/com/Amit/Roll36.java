package com.Amit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: qlogy
 * Date: 11/17/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Roll36 extends JApplet implements ActionListener {
    private JTextArea outputArea;
    private JButton button;
    private int totalRolls;
    private int[] total;
    private int face1;
    private int face2;
    private String output;

    public void init() {

        outputArea = new JTextArea();
        button = new JButton("Roll 3600 times and shut the fuck u  p");
        button.addActionListener(this);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(outputArea);
        container.add(button);

        totalRolls = 0;
        total = new int[13];
        for (int index = 0; index < total.length; index++)
            total[index] = 0;

        rollDice();

    }

    private void rollDice() {

        for (int roll = 1; roll <= 36000; roll++) {
            face1 = (int) (1 + Math.random() * 6);
            face2 = (int) (1 + Math.random() * 6);
            total[face1 + face2]++;
        }
        totalRolls = totalRolls + 36000;

        output = "Sum\tFrequency\tPercentage";

        for (int k = 2; k < total.length; k++) {
            int percent = total[k] / (totalRolls / 100);
            output = output + "\n" + k + "\t" + total[k] + "\t" + percent + "%";
        }
        outputArea.setText(output);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        for (i = 0; i < total.length; i++)
            total[i] = 0;

        totalRolls = 0;
        rollDice();


    }
}
