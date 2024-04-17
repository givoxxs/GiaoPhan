package CreateTableInClass;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

public class Bai1 extends JFrame implements ActionListener {
	
	// model
	static String Info= "";
	static String SQL= "";
	static String password="";
	static String username="root";
	static Connection connection=null;
	
	
	
	// VIEW 
	
	JLabel lbHeader,input, sql,option;
	JTable table;
	JScrollPane Scr;
	JButton btnOk, btnReset, btnExit;
	Panel panel1, panel2;
	TextField txtInfo, txtSQL;
	GridBagConstraints gbc;
	GridBagLayout gb;
	Choice choice_option;
	
	private void addComponent(Component c, int row, int col, int width, int height, int fill) {
	    
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.insets= new Insets(10,10,10,30);
        gb.setConstraints(c, gbc);
        panel1.add(c, gbc);
	}
	
	void GUI() {
		
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Tuy xuat co so du lieu");
		
		String option_SQLs[]= {"Select","Insert","Update","Delete"};
		choice_option=new Choice();
		for (String option : option_SQLs) {
			choice_option.addItem(option);
		}
		
		lbHeader = new JLabel("TRUY XUAT CO SO DU LIEU");
		option = new  JLabel("Option");
		input = new JLabel("Input Informatior");
		sql = new JLabel("SQL");
		btnOk= new JButton("OK");
		btnReset= new JButton("Reset");
		btnExit = new JButton("Exit");
		txtInfo = new TextField(25);
		txtSQL = new TextField(25);
		table = new JTable();
	    table.setModel(new DefaultTableModel(
	        new Object[][] {
	        },
	        new String[] {
	            "Id", "Name", "Address", "Total"
	        }));
	    table.getColumnModel().getColumn(0).setPreferredWidth(70);
	    table.getColumnModel().getColumn(1).setPreferredWidth(150);
	    table.getColumnModel().getColumn(2).setPreferredWidth(175);
	    table.setRowHeight(24);
	    Scr =new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		btnReset.addActionListener(this);
		
		
		gb= new GridBagLayout();
		gbc= new GridBagConstraints();
		panel1= new Panel(gb);
		addComponent(lbHeader, 0, 1, 4, 1, GridBagConstraints.HORIZONTAL);
		Font font = new Font("Arial", Font.BOLD, 20);
		lbHeader.setFont(font);
		addComponent(input, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(txtInfo, 1, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(sql,2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent( txtSQL, 2, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(option,3, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(choice_option, 3, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		
		panel2= new Panel(new FlowLayout(FlowLayout.CENTER,70,10));
		panel2.add(btnOk);
		panel2.add(btnReset);
		panel2.add(btnExit);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(panel1,BorderLayout.NORTH);
		this.add(Scr,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.SOUTH);
	
		this.setVisible(true);
	}
	
		
	public static Connection beginConnection() {
		Connection c = null;
		try {
			com.mysql.jdbc.Driver drive = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(drive);
			
			c = DriverManager.getConnection(Info, username, password);
		}
		catch (SQLException e) {
				System.out.println("Error Connection: "+e);
		}
		return c;
	}
	public static void endConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("Error end Connection: "+e);
		}
	}
		
	public void ChangeData() {
		try {
		connection = beginConnection();
		Statement stmt = connection.createStatement();
		int cout= stmt.executeUpdate(SQL);
		System.out.println("Doing: " +SQL);
		System.out.println("Have "+cout+" rows were changed!");
		endConnection(connection);
		printInfor();
		}
		catch (Exception e) {
			System.out.println("Statemen: "+e);
		}
	}
	public void Select() {
		try {
			connection = beginConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			while (rs.next()) {
			    Vector<Object> row = new Vector<>();
			    for (int i = 1; i <= socot; i++) {
			            row.add(rs.getObject(i));
			     }
			          model.addRow(row);
				}
			endConnection(connection);
			}
			catch (Exception e) {
				System.out.println(" loi hien thi cau lenh Select: "+e);
			}
	}
		
	public  void printInfor() {
		try {
			connection = beginConnection();
			String sql = "SELECT * FROM Table1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			while (rs.next()) {
			    Vector<Object> row = new Vector<>();
			    for (int i = 1; i <= socot; i++) {
			    	row.add(rs.getObject(i));
			    }
			    model.addRow(row);
			}
			
			endConnection(connection);
			
		}
		catch (Exception e) {
			System.out.println(" loi hien thi table: "+e);
		} 	
	 }
	@Override	 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnOk) {
			SQL= txtSQL.getText();
			Info= txtInfo.getText();
			String choice = choice_option.getSelectedItem();
			if ((Info+SQL)!="")
			{
				switch (choice) {
					case "Insert":
						if (SQL.toLowerCase().replace(" ","").contains(("Insert").toLowerCase()) || (SQL.replace(" ","").toLowerCase().contains((",id=")))) {
							ChangeData();
						} else {
							System.out.println("You can't insert into this table!");
						}
						break;
					case "Update":
						if (SQL.toLowerCase().replace(" ", "").contains(("Update").toLowerCase()) || (SQL.replace(" ","").toLowerCase().contains((",id=")))) {
							ChangeData();
						} else {
							System.out.println("You can't update this table!");
						}
						break;
					case "Delete":
						if (SQL.toLowerCase().replace(" ", "").contains(("Delete").toLowerCase()) || (SQL.replace(" ","").toLowerCase().contains((",id=")))) {
							ChangeData();
						} else {
							System.out.println("You can't delete this table!");
						}
						break;
					case "Select":
						Select();
						break;	
				}
			}
			
		}
		if (e.getSource()==btnReset) {
			txtSQL.setText("");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
		}
		if (e.getSource()==btnExit) {
			System.exit(0);
		}
		
	}
	
	public Bai1(){
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai1();
	}
}
