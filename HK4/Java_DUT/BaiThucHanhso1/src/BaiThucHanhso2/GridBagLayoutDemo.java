package BaiThucHanhso2;

import java.awt.*;
import javax.swing.*;

public class GridBagLayoutDemo extends JFrame {
	JLabel lb1 = new JLabel("Name");
	JTextField tf1 = new JTextField(50);
	
	JLabel lb2 = new JLabel("Address");
	JTextArea ta1 = new JTextArea();
	
	JLabel lb3 = new JLabel("Sex");
	CheckboxGroup cb = new CheckboxGroup();	
	Checkbox cb1 = new Checkbox("Male", cb, true);
	Checkbox cb2 = new Checkbox("Female", cb, false);
	
	JLabel lb4 = new JLabel("Hobbies");
	Checkbox cb3 = new Checkbox("Reading", true);
	Checkbox cb4 = new Checkbox("Sport", false);
	Checkbox cb5 = new Checkbox("Travelling", false);
	
	JLabel lb5 = new JLabel("Age Group");
	Choice ch1 = new Choice();
	JButton bt1 = new JButton("OK");
	JButton bt2 = new JButton("Cancel");
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	public GridBagLayoutDemo(String title) {
		super(title);
		gb = new GridBagLayout();
		setLayout(gb);
		ch1.addItem("--");
		ch1.addItem("0-10");
		ch1.addItem("10-20");
		ch1.addItem("20-30");
		ch1.addItem("30-40");
		ch1.addItem("above 40");
		
		gbc = new GridBagConstraints();
		addComponent(lb1, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(tf1, 0, 1, 7, 1, GridBagConstraints.HORIZONTAL);
		addComponent(lb2, 1, 0, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(ta1, 1, 1, 7, 1, GridBagConstraints.HORIZONTAL);
		addComponent(lb3, 5, 0, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(cb1, 5, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(cb2, 6, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(lb4, 7, 0, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(cb3, 7, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(cb4, 8, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(cb5, 9, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(lb5, 10, 0, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(ch1, 10, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(bt1, 11, 3, 1, 1, GridBagConstraints.NONE);
		addComponent(bt2, 11, 4, 1, 1, GridBagConstraints.NONE);
		
//		setTitle("Grid Bag Layout Demo");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void addComponent(Component component, int row, int column, int width, int height, int fill) {
        gbc.gridx = column;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;

        gb.setConstraints(component, gbc);
        add(component);
    }
	
	public static void main(String args[]) {
		new GridBagLayoutDemo("GridBagLayout Demo");
	}
}
