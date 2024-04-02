package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai3_changebg extends JFrame implements ActionListener {
	JButton red, green, blue, thoat;
	JPanel pn1, pn;
	public void GUI() {
		red = new JButton("RED");
		green = new JButton("GREEN");
		blue = new JButton("Blue");
		thoat = new JButton("Thoat");
		
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new JPanel(new BorderLayout());
		pn1 = new JPanel(new FlowLayout());
		
		pn1.add(red);
		pn1.add(green);
		pn1.add(blue);
		pn1.add(thoat);
		
		pn.add(pn1, BorderLayout.SOUTH);
		
		add(pn);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == red) {
			pn.setBackground(Color.red);
			pn1.setBackground(Color.red);
		}
		if(e.getSource() == green) {
			pn.setBackground(Color.green);
			pn1.setBackground(Color.green);
		}
		if(e.getSource() == blue) {
			pn.setBackground(Color.blue);
			pn1.setBackground(Color.blue);
		}
		if(e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public Bai3_changebg(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String args[]) {
		new Bai3_changebg("");
	}
}
