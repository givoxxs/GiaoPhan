package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai2_ptsohoc extends JFrame implements ActionListener {
	JLabel lb, lb1, lb2, lbkq;
	JTextField txt1, txt2, txtkq;
	JButton add, sub, mul, div, reset, exit;
	JPanel pn, pn1, pn2, pn3, pn4;
	public void GUI() {
		lb = new JLabel("Basic Arithmetic Operations");
		lb1 = new JLabel("Number 1:");
		lb2 = new JLabel("Number 2:");
		lbkq = new JLabel("Result:");
		
		txt1 = new JTextField(7);
		txt2 = new JTextField(7);
		txtkq = new JTextField(7);
		
		add = new JButton("Addition");
		sub = new JButton("Subtraction");
		mul = new JButton("Multiplication");
		div = new JButton("Division");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		
		pn = new JPanel(new GridLayout(4,1));
		pn1 = new JPanel(new FlowLayout());
		pn2 = new JPanel(new GridLayout(3,2));
		pn3 = new JPanel(new FlowLayout());
		pn4 = new JPanel(new FlowLayout());
		
		pn1.add(lb);
		
		pn2.add(lb1);	pn2.add(txt1);
		pn2.add(lb2);	pn2.add(txt2);
		pn2.add(lbkq);	pn2.add(txtkq);
		
		pn3.add(add);
		pn3.add(sub);
		pn3.add(mul);
		pn3.add(div);
		
		pn4.add(reset);
		pn4.add(exit);
			
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);

		add(pn);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// add
		if (e.getSource() == add) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txtkq.setText(Float.toString((float)(a + b)));
		}
		//sub
		if (e.getSource() == sub) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txtkq.setText(Float.toString((float)(a - b)));
		}
		//mul
		if (e.getSource() == mul) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txtkq.setText(Float.toString((float)(a * b)));
		}
		//div
		if (e.getSource() == div) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			if (b!=0) {
				txtkq.setText(Float.toString((float)(a/b)));
			} else {
				txtkq.setText("Phuong trinh vo nghiem");
			}
		}
		// Reset
		if (e.getSource() == reset) {
			txt1.setText("");
			txt2.setText("");
			txtkq.setText("");
		}
		// Thoat
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
	
	public Bai2_ptsohoc(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String args[]) {
		new Bai2_ptsohoc("Arithmetic Operations");
	}
	
}
