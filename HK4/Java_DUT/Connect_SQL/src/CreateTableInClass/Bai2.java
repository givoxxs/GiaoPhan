package CreateTableInClass;

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class Bai2 extends JFrame implements ActionListener{
	// model
	static String defaultUrl = "jdbc:mysql://localhost:3306/data";
	static String defaultSql;
	static Connection connection = null;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	JPanel panel;
	JLabel lbInfo, lbSearchAs, lbId, lbName, lbDate, lbAddress, lbGender, lbHeader;
	JTextField txtInfo;
	JButton btnSearch, btnReset, btnExit;
	JRadioButton rdId, rdName, rdDate, rdAddress, rdGender;
	JTable table;
	
	public void GUI() {
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Bài 2: Tìm kiếm thông tin trong CSDL");
		
		lbHeader = new JLabel("TÌM KIẾM THÔNG TIN");
		
		lbInfo = new JLabel("  Input: ");
		txtInfo = new JTextField(25);
		
		btnSearch = new JButton("Search");
		btnReset = new JButton("Reset");
		btnExit = new JButton("Exit");
		
		btnSearch.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		lbSearchAs = new JLabel("  Search as: ");
		
		rdId = new JRadioButton("Id");
		rdName = new JRadioButton("Name");
		rdDate = new JRadioButton("Date");
		rdAddress = new JRadioButton("Address");
		rdGender = new JRadioButton("Gender");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdId);
		group.add(rdName);
		group.add(rdDate);
		group.add(rdAddress);
		group.add(rdGender);
		
		// table
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Id", "Name", "Date", "Address", "Gender"}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.setRowHeight(24);
		JScrollPane Scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.insets = new Insets(20, 20, 20, 20); 
		
		panel = new JPanel(new BorderLayout());
		panel.setLayout(gb);
		
		addComponent(lbHeader, 0, 2, 4, 1, GridBagConstraints.HORIZONTAL);
		Font font = new Font("Google Scans", Font.BOLD, 20);
		lbHeader.setFont(font);
		addComponent(lbInfo, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(txtInfo, 1, 2, 2, 1, GridBagConstraints.HORIZONTAL);
		addComponent(btnSearch, 1, 4, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(btnReset, 1, 5, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(btnExit, 1, 6, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(lbSearchAs, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(rdId, 2, 2, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(rdName, 2, 3, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(rdDate, 2, 4, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(rdAddress, 2, 5, 1, 1, GridBagConstraints.HORIZONTAL);
		addComponent(rdGender, 2, 6, 1, 1, GridBagConstraints.HORIZONTAL);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(Scr, BorderLayout.CENTER);
		setVisible(true);
	}
	// add component
	private void addComponent(Component c, int row, int col, int width, int height, int fill) {    
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.insets= new Insets(10,10,10,30);
        gb.setConstraints(c, gbc);
        panel.add(c, gbc);
	}
	// get connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
           com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
           DriverManager.registerDriver(driver);
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error connection: " + e);
		}
		return conn;
	}
	// close connection
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error close connection: " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnSearch) {
            String info = txtInfo.getText().toLowerCase();
            String sql = "";
            if (rdId.isSelected()) {
                sql = "select * from table2 where id like '%" + info + "%'";
            }
            else if (rdName.isSelected()) {
            	sql = "select * from table2 where lower(name) like '%" + info + "%'";
            }
            else if (rdDate.isSelected()) {
            	sql = "select * from table2 where date like '%" + info + "%'";
            }
            else if (rdAddress.isSelected()) {
            	sql = "select * from table2 where address like '%" + info + "%'";
            }
            else if (rdGender.isSelected()) {
            	sql = "select * from table2 where gender like '%" + info + "%'";
            }
            else {
                sql = "select * from table2";
            }
            try {
                Connection conn = getConnection();
                Statement stmt = (Statement) conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); 
                
                ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row); 
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error: " + ex);
            }
		}
		else if (e.getSource() == btnReset) {
		    txtInfo.setText("");
		    rdId.setSelected(false);
		    rdName.setSelected(false);
		    rdDate.setSelected(false);
		    rdAddress.setSelected(false);
		    rdGender.setSelected(false);
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0);
		}
		else if (e.getSource() == btnExit) {
			System.exit(0);
		}
	}
	
	public Bai2() {
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai2();
	}

}
