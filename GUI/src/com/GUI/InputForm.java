package com.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class InputForm {
    private JFrame window;

    public InputForm(){
        window = new JFrame("Calculate");
        window.setSize(250,350);
        window.add(new Panel());
        window.setLocationRelativeTo(null); // Чтобы окно было в самом центре
        window.setResizable(false); // Чтобы нельзя было окно изменять
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // по нажатию на крестик закрывается программа
        window.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new InputForm();
            }
        });

    }
}
