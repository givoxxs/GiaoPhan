package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai4_handlestring extends JFrame implements ActionListener {

    JTextField txtInput, txtUpper, txtLower, txtLowUp, txtNum;
    JLabel lbInput, lbUpper, lbLower, lbLowUp, lbNum;
    JButton ok, reset, exit;
    GridBagLayout gbl;
    GridBagConstraints gbc;

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int fill) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbl.setConstraints(component, gbc);
        gbc.weightx = 1.0;
        add(component);
      }
    
    public void GUI() {  
    	setTitle("Bài 4: Xử lý chuỗi kí tự");
        setBounds(200, 200, 468, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	lbInput = new JLabel("Enter a String");
    	lbUpper = new JLabel("To UpperCase");
    	lbLower = new JLabel("To LowerCase");
    	lbLowUp = new JLabel("To LowerUpper");
    	lbNum = new JLabel("Number of word");
    	
    	txtInput = new JTextField(20);
    	txtUpper = new JTextField(20);
    	txtLower = new JTextField(20);
    	txtLowUp = new JTextField(20);
    	txtNum = new JTextField(20);
    	
    	txtUpper.setEditable(false);
    	txtLower.setEditable(false);
    	txtLowUp.setEditable(false);
    	txtNum.setEditable(false);  	
    	
    	ok = new JButton("ok");
    	reset = new JButton("reset");
    	exit = new JButton("exit");
    	
    	ok.addActionListener(this);
    	reset.addActionListener(this);
    	exit.addActionListener(this);
    	
    	gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.insets = new Insets(8, 8, 8, 8);  
    	
    	addComponent(lbInput, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL);
        addComponent(txtInput, 1, 0, 2, 1, GridBagConstraints.HORIZONTAL);
        addComponent(lbUpper, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL);
        addComponent(txtUpper, 1, 1, 2, 1, GridBagConstraints.HORIZONTAL);
        addComponent(lbLower, 0, 2, 1, 1, GridBagConstraints.HORIZONTAL);
        addComponent(txtLower, 1, 2, 2, 1, GridBagConstraints.HORIZONTAL);
        addComponent(lbLowUp, 0, 3, 1, 1, GridBagConstraints.HORIZONTAL);
        addComponent(txtLowUp, 1, 3, 2, 1, GridBagConstraints.HORIZONTAL);
        addComponent(lbNum, 0, 4, 1, 1, GridBagConstraints.HORIZONTAL);
        addComponent(txtNum, 1, 4, 2, 1, GridBagConstraints.HORIZONTAL);
        addComponent(ok, 0, 5, 1, 1, GridBagConstraints.CENTER);
        addComponent(reset, 1, 5, 1, 1, GridBagConstraints.WEST);
        addComponent(exit, 2, 5, 1, 1, GridBagConstraints.EAST);

		setLocationRelativeTo(null);
		setVisible(true);
    }
    
    private String ToUpperCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
        	if (c >= 'a' && c <= 'z') {
        		c -= 32;
        	}
        	result.append(c);
        }
        return result.toString();
     }
    
    private String ToLowerCase(String input) {
    	StringBuilder result = new StringBuilder();
    	for (char c : input.toCharArray()) {
    		if (c >= 'A' && c <= 'Z') {
    			c += 32;
    		}
    		result.append(c);
        }
        return result.toString();
     }
    
    private String ToLowUp(String input) {
    	StringBuilder result = new StringBuilder();
    	for (char c : input.toCharArray()) {
    		if (c >= 'A' && c <= 'Z') {
    			c += 32;
    		} else if (c >= 'a' && c <= 'z') {
    			c -= 32;
    		}
    		
    		result.append(c);
        }
        return result.toString();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
          System.exit(0);
        }
        if (e.getSource() == reset) {
          txtInput.setText("");
          txtUpper.setText("");
          txtLower.setText("");
          txtLowUp.setText("");
          txtNum.setText("");
        }
        if (e.getSource() == ok) {
          String input = txtInput.getText();
          txtUpper.setText(ToUpperCase(input));
          txtLower.setText(ToLowerCase(input));

          String[] words = input.split("\\s+");
          StringBuilder result = new StringBuilder();
          for (String word : words) {
            if (word.length() > 0) {
              String temp = ToLowUp(word);
              result.append(temp);
              result.append(" ");
            }
          }
          txtLowUp.setText(result.toString().trim());

          txtNum.setText(String.valueOf(words.length));
        }
      }    
      

    public static void main(String[] args) {
    	Bai4_handlestring frame = new Bai4_handlestring();
    	frame.GUI();
    	frame.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    	        System.exit(0);
    	    }
    	});
    }
}
