/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Ronald
 */
public class MyBorder {

    public static void setBorder(JTextField tf) {
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border2 = new CompoundBorder(null, empty);
        tf.setBorder(border2);
    }
     public static void setBorder2(JTextField tf) {
           Border line = BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4));
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border2 = new CompoundBorder(line, empty);
        tf.setBorder(border2);
    }
}
