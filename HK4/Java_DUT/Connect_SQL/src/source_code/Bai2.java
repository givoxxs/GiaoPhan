package source_code;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;

public class Bai2 extends JFrame implements ActionListener {

  private JTextField txtSql;
  private JTextField txtInfo;
  private JTable table;
  private JButton btnSubmit, btnReset, btnCancel;
  private String defaultUrl = "jdbc:mysql://localhost:3306/data";
  private String defaultSql = "select * from Table1";

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Class.forName("com.mysql.jdbc.Driver");
          Bai2 window = new Bai2();
          window.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Bai2() {
    gui();
  }

  private void gui() {
    setTitle("Database programming");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 460, 584);
    getContentPane().setLayout(new BorderLayout(0, 0));

    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(20, 0, 20, 0));
    getContentPane().add(panel, BorderLayout.NORTH);
    GridBagLayout gbl_panel = new GridBagLayout();
    gbl_panel.columnWidths = new int[] { 30, 60, 90, 30 };
    gbl_panel.rowHeights = new int[] { 20, 0, 0 };
    gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
    gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
    panel.setLayout(gbl_panel);

    JLabel lblInfo = new JLabel("Input information: ");
    lblInfo.setFont(new Font("Open Sans", Font.BOLD, 11));
    GridBagConstraints gbc_lblInfo = new GridBagConstraints();
    gbc_lblInfo.anchor = GridBagConstraints.WEST;
    gbc_lblInfo.insets = new Insets(0, 0, 5, 10);
    gbc_lblInfo.gridx = 1;
    gbc_lblInfo.gridy = 0;
    panel.add(lblInfo, gbc_lblInfo);

    txtInfo = new JTextField();
    GridBagConstraints gbc_txtInfo = new GridBagConstraints();
    gbc_txtInfo.insets = new Insets(0, 0, 5, 0);
    gbc_txtInfo.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtInfo.gridx = 2;
    gbc_txtInfo.gridy = 0;
    panel.add(txtInfo, gbc_txtInfo);
    txtInfo.setColumns(10);
    txtInfo.setText(defaultUrl);

    JLabel lblSql = new JLabel("SQL: ");
    lblSql.setFont(new Font("Open Sans", Font.BOLD, 11));
    GridBagConstraints gbc_lblSql = new GridBagConstraints();
    gbc_lblSql.insets = new Insets(0, 0, 0, 10);
    gbc_lblSql.anchor = GridBagConstraints.WEST;
    gbc_lblSql.gridx = 1;
    gbc_lblSql.gridy = 1;
    panel.add(lblSql, gbc_lblSql);

    txtSql = new JTextField();
    GridBagConstraints gbc_txtSql = new GridBagConstraints();
    gbc_txtSql.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtSql.gridx = 2;
    gbc_txtSql.gridy = 1;
    panel.add(txtSql, gbc_txtSql);
    txtSql.setColumns(10);
    txtSql.setText(defaultSql);

    JPanel panelButtons = new JPanel();
    panelButtons.setBorder(new EmptyBorder(4, 0, 8, 0));
    FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
    flowLayout.setHgap(50);
    getContentPane().add(panelButtons, BorderLayout.SOUTH);

    btnSubmit = new JButton("Submit");
    panelButtons.add(btnSubmit);
    btnSubmit.addActionListener(this);

    btnReset = new JButton("Reset");
    panelButtons.add(btnReset);
    btnReset.addActionListener(this);

    btnCancel = new JButton("Cancel");
    panelButtons.add(btnCancel);
    btnCancel.addActionListener(this);

    JScrollPane scrollPane = new JScrollPane();

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
    scrollPane.setViewportView(table);

    scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 200));
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    JPanel panelWest = new JPanel();
    getContentPane().add(panelWest, BorderLayout.WEST);

    JPanel panelEast = new JPanel();
    getContentPane().add(panelEast, BorderLayout.EAST);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSubmit) {
      String url = txtInfo.getText();
      String sql = txtSql.getText();

      try {
        Connection conn = DriverManager.getConnection(url, "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (rs.next()) {
          Vector<Object> row = new Vector<>();
          for (int i = 1; i <= columnCount; i++) {
            row.add(rs.getObject(i));
          }
          model.addRow(row);
        }

      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == btnReset) {

      txtInfo.setText("");
      txtSql.setText("");
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      model.setRowCount(0);
    } else if (e.getSource() == btnCancel) {
      System.exit(0);
    }
  }
}
