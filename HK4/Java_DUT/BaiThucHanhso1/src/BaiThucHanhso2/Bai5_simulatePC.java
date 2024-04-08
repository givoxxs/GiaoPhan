package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;
import java.util.*;

public class Bai5_simulatePC extends JFrame implements ActionListener {
	JTextField input;
	JButton[] num;
	JButton[] operator;
	JButton C, dot, result;
	GridBagConstraints gbc;
	GridBagLayout gbl;
	
    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int fill) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbl.setConstraints(component, gbc);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(component);
    }
    
    public void GUI() {
    	setTitle("Bài 5: Mô phỏng máy tính cá nhân");
        setBounds(200, 200, 468, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font buttonFont = new Font("Arial", Font.BOLD, 22);
    	
    	input = new JTextField(20);
    	
    	input.setHorizontalAlignment(JTextField.RIGHT);
        input.setFont(new Font("Arial", Font.BOLD, 20));
        input.setPreferredSize(new Dimension(50, 40));
        input.setBackground(Color.WHITE);
        
        num = new JButton[10];
        for (int i = 0; i < num.length; i++) {
          num[i] = new JButton(String.valueOf(i));
          num[i].setFont(buttonFont);
        }
        for (int i = 0; i < num.length; i++) {
            num[i].addActionListener(this);
       }
        
        
        operator = new JButton[4];
    	operator[0] = new JButton("+");
    	operator[1] = new JButton("-");
    	operator[2] = new JButton("*");
    	operator[3] = new JButton("/");
    	for (int i = 0; i < operator.length; i++) {
    	   operator[i].setFont(buttonFont);
    	}
    	for (int i = 0; i < operator.length; i++) {
     	   operator[i].addActionListener(this);
     	}
    	
    	C = new JButton("C");
    	dot = new JButton(".");
    	result = new JButton("=");
    	
    	C.setFont(buttonFont);
    	dot.setFont(buttonFont);
    	result.setFont(buttonFont);
    	
    	C.addActionListener(this);
    	dot.addActionListener(this);
    	result.addActionListener(this);
    	
    	gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.insets = new Insets(2, 2, 2, 2);  
        
        addComponent(input, 0, 0, 5, 1, GridBagConstraints.BOTH);
        addComponent(num[7], 0, 1, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[8], 1, 1, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[9], 2, 1, 1, 1, GridBagConstraints.BOTH);
        addComponent(operator[3], 3, 1, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[4], 0, 2, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[5], 1, 2, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[6], 2, 2, 1, 1, GridBagConstraints.BOTH);
        addComponent(operator[2], 3, 2, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[1], 0, 3, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[2], 1, 3, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[3], 2, 3, 1, 1, GridBagConstraints.BOTH);
        addComponent(operator[1], 3, 3, 1, 1, GridBagConstraints.BOTH);
        addComponent(num[0], 0, 4, 1, 1, GridBagConstraints.BOTH);
        addComponent(dot, 1, 4, 1, 1, GridBagConstraints.BOTH);
        addComponent(C, 2, 4, 1, 1, GridBagConstraints.BOTH);
        addComponent(operator[0], 3, 4, 1, 1, GridBagConstraints.BOTH);
        
        addComponent(result, 4, 1, 1, 4, GridBagConstraints.BOTH);
        
        setLocationRelativeTo(null);
		setVisible(true);
    }
    
    public static String calculate(String expression) {
        String postfix = infixToPostfix(expression);
        double result = evaluatePostfix(postfix);

        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String number = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                number += c;
            } else {
                if (!number.isEmpty()) {
                    result.append(number).append(" ");
                    number = "";
                }

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop()).append(" ");
                    }
                    if (!stack.isEmpty() && stack.peek() != '(') {
                        return "Invalid Expression";
                    } else {
                        stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }
        }

        if (!number.isEmpty()) {
            result.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString();
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            char c = token.charAt(0);

            if (Character.isDigit(c) || token.length() > 1) {
                stack.push(Double.parseDouble(token));
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
//    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == num[0]){
        	input.setText(input.getText()+"0");
        }
        if(e.getSource() == num[1]){
        	input.setText(input.getText()+"1");
        }
        if(e.getSource() == num[2]){
        	input.setText(input.getText()+"2");
        }
        if(e.getSource() == num[3]){
        	input.setText(input.getText()+"3");
        }
        if(e.getSource() == num[4]){
        	input.setText(input.getText()+"4");
        }
        if(e.getSource() == num[5]){
        	input.setText(input.getText()+"5");
        }
        if(e.getSource() == num[6]){
        	input.setText(input.getText()+"6");
        }
        if(e.getSource() == num[7]){
        	input.setText(input.getText()+"7");
        }
        if(e.getSource() == num[8]){
        	input.setText(input.getText()+"8");
        }
        if(e.getSource() == num[9]){
        	input.setText(input.getText()+"9");
        }
        if(e.getSource() == dot){
        	input.setText(input.getText()+".");
        }
        if(e.getSource() == operator[0]){
        	input.setText(input.getText()+"+");
        }
        if(e.getSource() == operator[1]){
        	input.setText(input.getText()+"-");
        }
        if(e.getSource() == operator[2]){
        	input.setText(input.getText()+"*");
        }
        if(e.getSource() == operator[3]){
        	input.setText(input.getText()+"/");
        }
        if(e.getSource() == result){
            String a = input.getText();
            input.setText(calculate(a));
        }
        if(e.getSource() == C){
            input.setText("");
        }
    }
    
    
    public static void main(String []args) {
    	Bai5_simulatePC frame = new Bai5_simulatePC();
    	frame.GUI();
    	frame.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    	        System.exit(0);
    	    }
    	});
    }
}
