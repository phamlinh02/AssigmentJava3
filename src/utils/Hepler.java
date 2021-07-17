/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Thuy Linh
 */
public class Hepler {
     public static boolean checkRong(JTextField tf, String mss ){
        if (tf.getText().equals("")){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkSo(JTextField tf , String mss){
            float so ;
        try {
           so = Float.parseFloat(tf.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkMien(JTextField tf , String mss){
        float so = Float.parseFloat(tf.getText());
        if(so>10 || so<0){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    
}
