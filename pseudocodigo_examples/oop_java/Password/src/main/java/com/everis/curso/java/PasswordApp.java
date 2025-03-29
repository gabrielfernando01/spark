package com.everis.curso.java;

import javax.swing.JOptionPane;
public class PasswordApp {

    public static void main(String[] args) {

        // We input the size of the array and the password length
        String text = JOptionPane.showInputDialog("Enter a size for the array");
        int size = Integer.parseInt(text);

        text = JOptionPane.showInputDialog("Enter the password length");
        int length = Integer.parseInt(text);

        // We create the arraus
        Password passwordList[] = new Password[size];
        boolean passwordStrength[] = new boolean[size];

        // We create object, indicate if it is strong, and display the password and its stregth.
        for (int i = 0; i < passwordList.length; i++) {
            passwordList[i] = new Password(length);
            passwordStrength[i] = passwordList[i].isStrong();
            System.out.println(passwordList[i].getPassword() + " " + passwordStrength[1]);
        }
    }
}
