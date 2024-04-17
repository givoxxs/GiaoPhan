package source_code;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bai3 extends JFrame implements ActionListener{
	private JTextField jt1;
	private JTextField jt2;
	
	private JLabel jl1;
	private JLabel jl2;
	
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;
	private JLabel jl6;
	
	private JScrollPane jsp;
	private JTextArea jta1;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jb1)
		{
			String input = jt1.getText();
			String sql = jt2.getText();
			
			getData(input, sql);
		}
		
		else 
		if(e.getSource() == jb2)
		{
			jta1.setText("");
		}
		
		else
		if(e.getSource() == jb3)
		{
			jt1.setText("");
			jt2.setText("");
			jta1.setText("");
		}
		
	}
	
	public void getData(String input, String sql)
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(input, "root", "");
			
			Statement stm = con.createStatement();
			
			
			
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next())
			{
				int ID = rs.getInt("ID");
				String Name = rs.getString("Name");
				String Address = rs.getString("Address");
				int Total = rs.getInt("Total");
				
				jta1.append("\t      "+ ID + "\t\t" + Name + "\t\t       " + Address + "\t\t         " + Total + "\n");
			}
			
			
				
		}
		catch(Exception e)
		{
			jta1.append("Loi ket noi den csdl:" + e);
		}
	}
	
	public void GUI()
	{
		this.setTitle("Database Programming");
		this.setSize(800, 400);
			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		GridLayout glo = new GridLayout(2, 2, 20,10);
		
		JPanel jp1 = new JPanel(glo);
		jl1 = new JLabel("Input Information");
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		jl1.setVerticalAlignment(SwingConstants.CENTER);
		jt1 = new JTextField(20);
		jl2 = new JLabel("SQL");
		jl2.setHorizontalAlignment(SwingConstants.CENTER);
		jl2.setVerticalAlignment(SwingConstants.CENTER);
		jt2 = new JTextField(20);
		
		jp1.add(jl1); jp1.add(jt1);
		jp1.add(jl2); jp1.add(jt2);
		jp1.setBorder(BorderFactory.createEmptyBorder(20, 20, 0 , 20));
			
		
		
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 150,  0));
		jl3 = new JLabel("ID");
		jl4 = new JLabel("Name");
		jl5 = new JLabel("Address");
		jl6 = new JLabel("Total");
		
		jp2.add(jl3);
		jp2.add(jl4);
		jp2.add(jl5);
		jp2.add(jl6);
		
		JPanel jp3 = new JPanel(new BorderLayout());
		jta1 = new JTextArea(50, 100);
		jta1.setEditable(false);
		jsp = new JScrollPane(jta1);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jp3.add(jsp);
		
		
		JPanel jp23 = new JPanel(new BorderLayout());
		jp23.add(jp2, BorderLayout.NORTH);
		jp23.add(jp3, BorderLayout.CENTER);
				
		
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 10));
		jb1 = new JButton("Submit");
		jb2 = new JButton("Reset");
		jb3 = new JButton("Cancel");
		jp4.add(jb1);
		jb1.addActionListener(this);
		jp4.add(jb2);
		jb2.addActionListener(this);
		jp4.add(jb3);
		jb3.addActionListener(this);
		
		this.setLayout(new BorderLayout(30, 30));
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp23, BorderLayout.CENTER);
		this.add(jp4, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new Bai3().GUI();
	}
}

