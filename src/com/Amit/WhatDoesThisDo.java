package com.Amit;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: qlogy
 * Date: 11/17/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class WhatDoesThisDo extends JApplet {

     int result;


    public void init() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
        System.out.println(array[1] + "is array second element");
       result= WhatIsThis(array, array.length);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        JTextArea output = new JTextArea();
        output.setText("Result is:" + result);
        container.add(output);
    }

    private int WhatIsThis(int[] array2, int length) {
        if (length == 1)
            return array2[0];
        else
            return array2[length - 1] + WhatIsThis(array2, length - 1);
    }
}
