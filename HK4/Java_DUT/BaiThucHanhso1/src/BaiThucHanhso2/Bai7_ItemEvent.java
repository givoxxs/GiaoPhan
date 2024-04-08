package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai7_ItemEvent extends JFrame implements ItemListener {
	JCheckBox male, female;
	JComboBox cb;
	List list;
	JLabel lb;
	JPanel pn, pn1, pn2;	
	public void GUI() {
		setTitle("Bài 7: ItemEvent");
		setBounds(200, 200, 468, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel 1
		pn1 = new JPanel(new FlowLayout());
		
		male = new JCheckBox("Male");
		female = new JCheckBox("Female");
		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		male.addItemListener(this);
		female.addItemListener(this);
		
		cb = new JComboBox();
		cb.addItem("MS DOS");
		cb.addItem("Windows");
		cb.addItem("Unix");
		cb.addItem("Linux");
		cb.addItem("Android");
		cb.addItem("iOS");
		cb.addItem("Mac OS");
		cb.addItemListener(this);
		
		list = new List(3);
		list.add("Tiger");
		list.add("Lion");
		list.add("Elephant");
		list.addItemListener(this);	
		
		pn1.add(male);
		pn1.add(female);
		pn1.add(cb);
		pn1.add(list);
		// Panel 2
		pn2 = new JPanel(new FlowLayout());
		lb = new JLabel("The event is displayed here");
		lb.setFont(new Font("Arial", Font.BOLD, 14));
		pn2.add(lb);
		
		pn= new JPanel(new FlowLayout());
		pn.add(pn1);
		pn.add(pn2);
		add(pn);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source == male || source == female) {
            if (male.isSelected()) {
                lb.setText("Male is selected");
            } else if (female.isSelected()) {
                lb.setText("Female is selected;");
            }
        } else if (source == cb) {
            lb.setText("You selected: " + cb.getSelectedItem());
        } else if (source == list) {
            lb.setText("You selected: " + list.getSelectedItem());
        }
	}
	
	public Bai7_ItemEvent(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String args[]) {
		new Bai7_ItemEvent("ItemEvent");
	}
}
