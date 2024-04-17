package source_code;

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

public class Bai1_TruyXuatCoSoDuLieu extends JFrame implements ActionListener {
	
	// model
	static String url= "";
	static String _sql= "";
	static String Password="";
	static String UserName="root";
	static Connection connection=null;
	
	
	
	// VIEW 
	
	JLabel title,input, sql,option;
	TextArea output;
	JTable table;
	JScrollPane Scr;
	JButton ButtonOk, Buttonreset, ButtonExit;
	Panel pn1,pn2;
	TextField txtIput,txtSql;
	GridBagConstraints gbc;
	GridBagLayout gb;
	Choice choice_option;
	
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
		title = new JLabel("TRUY XUAT CO SO DU LIEU");
		option = new  JLabel("Option");
		input = new JLabel("Input Informatior");
		sql = new JLabel("SQL");
		output = new TextArea();
		ButtonOk= new JButton("OK");
		Buttonreset= new JButton("Reset");
		ButtonExit = new JButton("Exit");
		txtIput = new TextField(25);
		txtSql = new TextField(25);
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
		
		ButtonOk.addActionListener(this);
		ButtonExit.addActionListener(this);
		Buttonreset.addActionListener(this);
		
		
		gb= new GridBagLayout();
		gbc= new GridBagConstraints();
		pn1= new Panel(gb);
		addComponent(title, 0, 1, 4, 1, GridBagConstraints.HORIZONTAL);
		Font font = new Font("Arial", Font.BOLD, 20);
		title.setFont(font);
		addComponent(input, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(txtIput, 1, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(sql,2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(txtSql, 2, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(option,3, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(choice_option, 3, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		
		pn2= new Panel(new FlowLayout(FlowLayout.CENTER,70,10));
		pn2.add(ButtonOk);
		pn2.add(Buttonreset);
		pn2.add(ButtonExit);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(pn1,BorderLayout.NORTH);
		this.add(Scr,BorderLayout.CENTER);
		this.add(pn2,BorderLayout.SOUTH);
	
		this.setVisible(true);
	}
	private void addComponent(Component c, int row, int col, int width, int height, int fill) {
	    
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.insets= new Insets(10,10,10,30);
        gb.setConstraints(c, gbc);
        pn1.add(c, gbc);
}
		
	public static Connection getConnection() {
		Connection c=null;
		try {
			// resister driver
			com.mysql.jdbc.Driver drive = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(drive);
			
			c = DriverManager.getConnection(url, UserName, Password);
		}
		catch (SQLException e) {
				System.out.println("Loi ket noi CSDL: "+e);
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("loi ngat ket noi: "+e);
		}
	}
		
	public void Insert_Update_Delete() {
		try {
		connection = getConnection();
		Statement stmt = connection.createStatement();
		int cout= stmt.executeUpdate(_sql);
		System.out.println("Ban da thuc hien cau lenh: " +_sql);
		System.out.println("Co "+cout+" dong bi thay doi!");
		closeConnection(connection);
		printInfor();
		}
		catch (Exception e) {
			System.out.println(" loi thuc hien cau lenh : "+e);
		}
	}
	public void Select() {
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(_sql);
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
			closeConnection(connection);
			 }
			catch (Exception e) {
				System.out.println(" loi hien thi cau lenh Select: "+e);
			}
	}
		
	public  void printInfor() {
		try {
			connection = getConnection();
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
			
			closeConnection(connection);
			
		}
		catch (Exception e) {
			System.out.println(" loi hien thi table: "+e);
		} 	
	 }
	@Override	 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==ButtonOk) {
			_sql=txtSql.getText();
			url= txtIput.getText();
			String choice = choice_option.getSelectedItem();
			if ((url+_sql)!="")
			{
				output.setText("");
				switch (choice) {
					case "Insert":
					case "Update":
					case "Delete":
						Insert_Update_Delete();
						break;
					case "Select":
						Select();
						break;	
				}
			}
			
		}
		if (e.getSource()==Buttonreset) {
			txtSql.setText("");
			output.setText("");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
		}
		if (e.getSource()==ButtonExit) {
			System.exit(0);
		}
		
	}
	
	Bai1_TruyXuatCoSoDuLieu(){
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai1_TruyXuatCoSoDuLieu();
	}
}
