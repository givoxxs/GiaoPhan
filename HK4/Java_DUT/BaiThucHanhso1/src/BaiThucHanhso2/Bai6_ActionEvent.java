package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai6_ActionEvent extends JFrame implements ActionListener {
	JButton ok;
	JTextField tf, tf1;
	List list;
	
	JPanel panel;
	public void GUI() {
		ok = new JButton("OK");
		tf = new JTextField(20);
		list = new List(3);
		
		list.add("Tiger");
		list.add("Lion");
		list.add("Elephant");
		
		ok.addActionListener(this);
		list.addActionListener(this);
		tf.addActionListener(this);
		
		panel = new JPanel(new FlowLayout());
		panel.add(ok);
		panel.add(tf);
		panel.add(list);
		
		tf1 = new JTextField("The event is displayed here");
		tf1.setEditable(false);
		tf1.setBorder(null);
		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(tf1);
		add(panel);
		
		setTitle("Bài 6: ActionEvent");
		setBounds(200, 200, 468, 300);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			tf1.setText("OK button is clicked");
		}
		if (e.getSource() == tf) {
			tf1.setText("You entered: " + tf.getText());
		}
		if (e.getSource() == list) {
			tf1.setText("You selected: " + list.getSelectedItem());
		}
	}
	
	public Bai6_ActionEvent(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String args[]) {
		new Bai6_ActionEvent("ActionEvent");
	}
}
