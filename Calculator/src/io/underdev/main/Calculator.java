package io.underdev.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calculator implements ActionListener {
	
	JFrame frame = new JFrame(TITLE);
	
	JTextField text = new JTextField();
	
	JPanel panel = new JPanel();
	
	JButton[] numbers = new JButton[10];
	JButton[] function = new JButton[10];
	JButton add, sub, mul, div;
	JButton dec, neg, equ, del, clr;
	JButton exit = new JButton("Exit");
	
	Font font = new Font(null, Font.PLAIN, 25);
	
	double num1 = 0, num2 = 0, result = 0;
	char operation;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = WIDTH + 100;
	public static final String TITLE = "Calculator";
	
	Border butBorder = BorderFactory.createEtchedBorder(Color.BLACK, Color.black);
	
	public void textField() {
		text.setBounds(50, 80, 400, 50);
		text.setBackground(Color.WHITE);
		text.setFont(new Font(null, Font.PLAIN, 25));
		text.setEnabled(false);
	}
	
	public void num() {
		
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		dec = new JButton(".");
		neg = new JButton("(-)");
		equ = new JButton("=");
		del = new JButton("Delete");
		clr = new JButton("Clear");
		
		function[0] = add;
		function[1] = sub;
		function[2] = mul;
		function[3] = div;
		function[4] = dec;
		function[5] = neg;
		function[6] = equ;
		function[7] = del;
		function[8] = clr;
		function[9] = exit;
		
		for(int i = 0; i < 10; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].setBackground(Color.GRAY);
			numbers[i].addActionListener(this);
			numbers[i].setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
			numbers[i].setFont(font);
			numbers[i].setFocusable(false);
		}
		
		for(int i = 0; i < 10; i++) {
			function[i].setBackground(Color.GRAY);
			function[i].addActionListener(this);
			function[i].setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.black));
			function[i].setFont(font);
			function[i].setFocusable(false);
		}
		
		panel.setBounds(50, 200, 400, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.DARK_GRAY);
		
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(add);
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(sub);
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(numbers[0]);
		panel.add(equ);
		panel.add(div);
		
		neg.setBounds(330, 510, 150, 50);
		del.setBounds(170, 510, 150, 50);
		clr.setBounds(10, 510, 150, 50);
		exit.setBounds(270, 10, 200, 50);
		
	}
	
	public Calculator() {
		
		textField();
		
		num();
		
		frame.add(neg);
		frame.add(del);
		frame.add(clr);
		frame.add(panel);
		frame.add(text);
		frame.add(exit);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numbers[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == dec) {
			text.setText(text.getText().concat("."));
		}
		
		if(e.getSource() == neg) {
			double num = Double.parseDouble(text.getText());
			num *= -1;
			text.setText(String.valueOf(num));
		}
		
		if(e.getSource() == add) {
			num1 = Double.parseDouble(text.getText());
			operation = '+';
			text.setText("");
		}
		
		if(e.getSource() == sub) {
			num1 = Double.parseDouble(text.getText());
			operation = '-';
			text.setText("");
		}
		
		if(e.getSource() == mul) {
			num1 = Double.parseDouble(text.getText());
			operation = '*';
			text.setText("");
		}
		
		if(e.getSource() == div) {
			num1 = Double.parseDouble(text.getText());
			operation = '/';
			text.setText("");
		}
		
		if(e.getSource() == equ) {
			num2 = Double.parseDouble(text.getText());
			switch(operation) {
			case '+':
				result = num1 + num2;
				break;
				
			case '-':
				result = num1 - num2;
				break;
				
			case '*':
				result = num1 * num2;
				break;
				
			case '/':
				result = num1 / num2;
				break;
			}
			
			text.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clr) {
			text.setText("");
		}
		
		if(e.getSource() == del) {
			String string = text.getText();
			text.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				text.setText(text.getText() + string.charAt(i));
			}
		}
		
		if(e.getSource() == exit) {
			System.exit(0);
		}
		
	}
	
}

