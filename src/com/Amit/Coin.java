package com.Amit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Coin extends JApplet implements ActionListener {

    private JButton button;
    private int heads = 0;
    private int tails = 0;

    public Coin() {

    }

    public void init() {

        button = new JButton("TOSS");
        button.addActionListener(this);
        Container container = getContentPane();
        container.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (flip() == true)
            heads++;
        else
            tails++;

        showStatus("Heads :" + heads + "   Tails: " + tails);
    }

    private boolean flip() {
        if ((int) (Math.random() * 2) == 1)
            return true;
        else
            return false;  //To change body of created methods use File | Settings | File Templates.
    }
}

