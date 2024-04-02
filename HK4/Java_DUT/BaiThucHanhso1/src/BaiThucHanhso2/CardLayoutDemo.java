package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo extends Frame implements ActionListener {
	JButton order = new JButton("Order");
	JButton products = new JButton("Products");
	
	CardLayoutDemo(String title) {
		super(title);
		setBounds(200, 200, 200, 200);
		setLayout(new CardLayout());
		JPanel p = new JPanel();
		p.add(new JLabel("Product 1"));
		p.add(new JLabel("Product 2"));
		p.add(order);
		order.addActionListener(this);
		products.addActionListener(this);
		add("products", p);
		JPanel p1 = new JPanel();
		p1.add(new JTextField("Name: ", 20));
		p1.add(new JTextField("Address: ", 20));
		p1.add(new JTextField("Phone: ", 20));
		p1.add(new JButton("Order"));
		p1.add(products);
		add("order", p1);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		show();
	}
	
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) getLayout();
		if (e.getSource() == order)
			cl.show(this, "order");
		if (e.getSource() == products) {
			cl.show(this, "products");
		}
	}
	
	public static void main(String args[]) {
		new CardLayoutDemo("Card Layout");
//		CardLayoutDemo f = new CardLayoutDemo("Card Layout");
//		f.setVisible(true);
	}
	
}
