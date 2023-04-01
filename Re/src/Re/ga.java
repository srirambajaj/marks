package Re;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ga {

	private JFrame frame;
	private JTextField t1;
	private JTextField n1;
	private JTextField em;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ga window = new ga();
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
	public ga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblNewLabel.setBounds(151, 11, 91, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSno = new JLabel("s.no");
		lblSno.setForeground(Color.RED);
		lblSno.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblSno.setBounds(32, 53, 45, 21);
		frame.getContentPane().add(lblSno);
		
		t1 = new JTextField();
		t1.setBounds(151, 52, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblName.setBounds(32, 96, 45, 21);
		frame.getContentPane().add(lblName);
		
		n1 = new JTextField();
		n1.setBounds(151, 95, 86, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		JLabel lblMarks = new JLabel("marks");
		lblMarks.setForeground(Color.RED);
		lblMarks.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblMarks.setBounds(32, 183, 61, 21);
		frame.getContentPane().add(lblMarks);
		
		em = new JTextField();
		em.setBounds(151, 139, 86, 20);
		frame.getContentPane().add(em);
		em.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblEmail.setBounds(32, 140, 45, 21);
		frame.getContentPane().add(lblEmail);
		
		m1 = new JTextField();
		m1.setBounds(151, 182, 86, 20);
		frame.getContentPane().add(m1);
		m1.setColumns(10);
		
		JButton btnDone = new JButton("done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn=t1.getText();
				int sno=Integer.parseInt(sn);
				String name=n1.getText();
				String email=em.getText();
				String m=m1.getText();
				int marks=Integer.parseInt(m);
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/re_da","root","mrec");
					String q="Insert into reg values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnDone, "Done");
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDone.setBounds(301, 208, 89, 23);
		frame.getContentPane().add(btnDone);
	}
}
