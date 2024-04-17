package source_code;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.sql.*;

public class JDBCDemoWithJTable extends JFrame {
    private JTable table;

    public JDBCDemoWithJTable() {
        setTitle("JDBC Demo with JTable");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton loadDataButton = new JButton("Load Data");

        loadDataButton.addActionListener(e -> loadDataFromDatabase());

        buttonPanel.add(loadDataButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadDataFromDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/data";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();

            String sql = "select * from Table1";
            ResultSet rs = stmt.executeQuery(sql);

            // Create a TableModel with data from ResultSet
            ResultSetTableModel model = new ResultSetTableModel(rs);

            table.setModel(model);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JDBCDemoWithJTable().setVisible(true));
    }
}

class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private int rowCount;

    public ResultSetTableModel(ResultSet rs) throws SQLException {
        this.rs = rs;
        this.rsmd = rs.getMetaData();
        rs.last();
        this.rowCount = rs.getRow();
        rs.beforeFirst();
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

