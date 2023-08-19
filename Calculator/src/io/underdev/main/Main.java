package io.underdev.main;

import javax.swing.JFrame;

public class Main {
	
	static JFrame frame = new JFrame("Calculator");
	
	private final static int WIDTH = 450;
	private final static int HEIGHT = WIDTH + 100;
	
	public static void main(String[] args) {
		new Calculator();
	}
	
}
