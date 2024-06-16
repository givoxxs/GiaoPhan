package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class mainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtResult;
	private JButton btnS, btnP;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// GUI 
	void GUI() {
		btnS.addActionListener(this);
		btnP.addActionListener(this);
	}
	
	/**
	 * Create the frame.
	 */
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tính chu vi và diện tích tam giác");
		setLocationRelativeTo(null);
		setBounds(100, 100, 420, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Độ dài cạnh a:");
		lblNewLabel.setBounds(60, 36, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDiCnh = new JLabel("Độ dài cạnh b:");
		lblDiCnh.setBounds(60, 63, 108, 14);
		contentPane.add(lblDiCnh);
		
		JLabel lblDiCnh_2 = new JLabel("Độ dài cạnh c:");
		lblDiCnh_2.setBounds(60, 88, 108, 14);
		contentPane.add(lblDiCnh_2);
		
		txtA = new JTextField();
		txtA.setBounds(194, 33, 168, 17);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(194, 60, 168, 17);
		contentPane.add(txtB);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(194, 85, 168, 17);
		contentPane.add(txtC);
		
		btnS = new JButton("Tính diện tích");
		btnS.setBounds(194, 113, 168, 23);
		contentPane.add(btnS);
		
		btnP = new JButton("Tính chu vi");
		btnP.setBounds(194, 147, 168, 23);
		contentPane.add(btnP);
		
		JLabel lblDiCnh_2_1 = new JLabel("Kết quả");
		lblDiCnh_2_1.setBounds(60, 183, 108, 14);
		contentPane.add(lblDiCnh_2_1);
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setColumns(10);
		txtResult.setBounds(194, 181, 168, 17);
		contentPane.add(txtResult);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(txtA.getText());
		double b = Double.parseDouble(txtB.getText());
		double c = Double.parseDouble(txtC.getText());
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		if (txtA.getText().isEmpty() || txtB.getText().isEmpty() || txtC.getText().isEmpty()) {
			txtResult.setText("Vui lòng nhập đủ thông tin");
		} else if ((a < 0 || b < 0 || c < 0)) {
			txtResult.setText("");
		} else if (checkTriangle(a, b, c) == 0) {
			txtResult.setText("Đây không phải tam giác");
		} else if (e.getSource() == btnS) {
			txtResult.setText(String.valueOf(s));
		} else if (e.getSource() == btnP) {
			txtResult.setText(String.valueOf(p * 2));
		}
	}
	
	public int checkTriangle(double a, double b, double c) {
		if (a + b > c && a + c > b && b + c > a) {
			return 1;
		} else {
			return 0;
		}
	}
}
