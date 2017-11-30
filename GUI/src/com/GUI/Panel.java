package com.GUI;

import java.lang.String;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {

    private JButton[] numbers = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backSpace = new JButton(">");
    private JButton equals = new JButton("=");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton divide = new JButton("/");
    private JButton multiply = new JButton("*");

    public Panel(){
        setLayout(null); // чтобы можно было разместить хоть где элемент
        setFocusable(true);
        grabFocus();

        sign();

        fillIn();

        addLavel();

        addNumbersWithKeyboard();
    }

    private void sign(){
        backSpace.setBounds(10,250,50,50);
        add(backSpace);

        equals.setBounds(130,250,50,50);
        add(equals);

        plus.setBounds(190, 70, 50,50);
        add(plus);

        minus.setBounds(190, 130, 50,50);
        add(minus);

        divide.setBounds(190, 190, 50,50);
        add(divide);

        multiply.setBounds(190, 250, 50,50);
        add(multiply);
    }

    private void fillIn(){
        for(int i = 0; i < 3; i++){
            if(i == 0){
                numbers[0] = new JButton("0"); // кастуем к стрингу
                numbers[0].setBounds( 70,250, 50, 50);
                numbers[0].setFont(font);
                add(numbers[0]);
            }
            for(int j = 0; j < 3; j++){
                numbers[i*3 + j+1] = new JButton((i*3 + j +1) + ""); // кастуем к стрингу
                numbers[i*3 + j+1].setBounds(i * (50 + 10) + 10, j * (50+10) + 70, 50, 50);
                numbers[i*3 + j+1].setFont(font);
                add(numbers[i*3 + j+1]);
            }
        }
    }

    private void addLavel(){
        output.setBounds(10,10, 230, 50);
        output.setEditable(false); // нельзя изменять то, что напсиали
        output.setFont(font);
        add(output);

        ActionListener listenerButNumbers = (ActionEvent e) -> { // чтобы обработать щелчки
            JButton but  = (JButton)e.getSource();
            output.setText(output.getText() + but.getText());
        }; // лямбда выражение

        for(JButton but : numbers){
            but.addActionListener(listenerButNumbers);
        }

        // плюс
        ActionListener listenerButPlus = (ActionEvent e) -> {
            JButton but  = (JButton)e.getSource();
            output.setText(output.getText() + but.getText());
        }; // лямбда выражение

        plus.addActionListener(listenerButPlus);

        // минус
        ActionListener listenerButMinus = (ActionEvent e) -> {
            JButton but  = (JButton)e.getSource();
            output.setText(output.getText() + but.getText());
        }; // лямбда выражение

        minus.addActionListener(listenerButMinus);

        // деление
        ActionListener listenerButDivide = (ActionEvent e) -> {
            JButton but  = (JButton)e.getSource();
            output.setText(output.getText() + but.getText());
        }; // лямбда выражение

        divide.addActionListener(listenerButDivide);

        // умножение
        ActionListener listenerButMultiply = (ActionEvent e) -> {
            JButton but  = (JButton)e.getSource();
            output.setText(output.getText() + but.getText());
        }; // лямбда выражение

        multiply.addActionListener(listenerButMultiply);

        ActionListener listenerEquals = (ActionEvent e) -> {
            double sum = summ();
            output.setText("");
            output.setText(sum+"");
        };

        equals.addActionListener(listenerEquals);

        ActionListener listenerBackSpace = (ActionEvent e) -> {
            output.setText("");
        }; // лямбда выражение

        backSpace.addActionListener(listenerBackSpace);
    }

    private void addNumbersWithKeyboard(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                char symbol = e.getKeyChar();

                if(Character.isDigit(symbol)){
                    output.setText(output.getText() + symbol);
                }
            }
        });// позволяет обрабатывать нажатия на кнопки
    }

    private double summ(){
        String resault = output.getText();
        int value1 = 0;
        String mark = "";
        int value2 = 0;
        double sum = 0;

        for(int i = 0; i <= resault.length(); i++){
            try {
                if(Character.isDigit(resault.charAt(i)) && mark == ""){
                    value1 = value1 * 10;
                    String str = resault.charAt(i) + "";
                    int val = Integer.parseInt(str);
                    value1 = value1 + val;
                }
                else if(resault.charAt(i) == '+'){
                    mark = "+";
                }
                else if(resault.charAt(i) == '-'){
                    mark = "-";
                }
                else if(resault.charAt(i) == '*'){
                    mark = "+";
                }
                else if(resault.charAt(i) == '/'){
                    mark = "/";
                }
                else{
                    value2 = value2 * 10;
                    String str = resault.charAt(i) + "";
                    int val = Integer.parseInt(str);
                    value2 = value2 + val;
                }
            }
            catch (Exception e){
                continue;
            }
        }

        if(mark == "+"){
            sum = value1 + value2;
        }else if(mark == "-"){
            sum = value1 - value2;
        }
        else if(mark == "*"){
            sum = value1 * value2;
        }
        else if(mark == "/"){
            sum = value1 / value2;
        }
        JOptionPane.showMessageDialog(null, sum);
        return sum;

    }
}
