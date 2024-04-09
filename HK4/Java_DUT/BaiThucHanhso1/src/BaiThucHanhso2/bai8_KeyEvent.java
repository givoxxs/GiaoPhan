package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai8_KeyEvent extends JFrame {
	JLabel lb;
	JPanel pn;

	public void GUI() {
		lb = new JLabel("h");
		lb.setFont(new Font("Arial", Font.BOLD, 20));
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		pn = new JPanel(new BorderLayout());
		pn.add(lb, BorderLayout.CENTER);
		add(pn);
		
		addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                String keyString = String.valueOf(keyChar);
                lb.setText(keyString);
            }
        });
        setFocusable(true);
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public bai8_KeyEvent(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String []args) {
		new bai8_KeyEvent("Key Event");
	}
}
