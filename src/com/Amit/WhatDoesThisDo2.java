package com.Amit;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: qlogy
 * Date: 11/17/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class WhatDoesThisDo2 extends JApplet {
    public void init() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20};
        JTextArea outputArea = new JTextArea();
        JTextArea myArea = new JTextArea();
        someFunction(array, 0, outputArea);

        Container container = getContentPane();
        container.add(outputArea);
    }

    private void someFunction(int[] array2, int x, JTextArea out) {
        if (x < array2.length) {
            someFunction(array2, x+1, out);
            out.append(array2[x] + " ");
        }
    }
}
