package Re;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class lp {

	private JFrame frame;
	private JTextField t;
	private JLabel lblName;
	private JLabel lblMarks;
	private JTextField lb1;
	private JTextField lb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lp window = new lp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel t1 = new JLabel("sno");
		t1.setBounds(40, 55, 46, 14);
		frame.getContentPane().add(t1);
		
		t = new JTextField();
		t.setBounds(177, 52, 86, 20);
		frame.getContentPane().add(t);
		t.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn=t.getText();
				int sno=Integer.parseInt(sn);
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/re_da","root","mrec");
					String q="Select name,marks from reg where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("name:"+rs.getString(1));
					lb2.setText("marks:"+rs.getInt(2));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(285, 196, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("name");
		lblName.setBounds(40, 104, 46, 14);
		frame.getContentPane().add(lblName);
		
		lblMarks = new JLabel("marks");
		lblMarks.setBounds(40, 144, 46, 14);
		frame.getContentPane().add(lblMarks);
		
		lb1 = new JTextField();
		lb1.setColumns(10);
		lb1.setBounds(177, 101, 86, 20);
		frame.getContentPane().add(lb1);
		
		lb2 = new JTextField();
		lb2.setColumns(10);
		lb2.setBounds(177, 141, 86, 20);
		frame.getContentPane().add(lb2);
	}

}
