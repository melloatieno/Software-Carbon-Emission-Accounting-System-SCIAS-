package scias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SCIAS extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SCIAS() {
		setTitle("SCI Accounting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(25, 242, 129, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminlogin();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(293, 242, 159, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to SCIAccounting System. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(103, 11, 246, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblTheSystemIs = new JLabel("The system calculates carbon emission of software components");
		lblTheSystemIs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheSystemIs.setBounds(10, 42, 436, 51);
		contentPane.add(lblTheSystemIs);
		
		JLabel lblNewLabel_1 = new JLabel("Login to continue");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(139, 90, 138, 23);
		contentPane.add(lblNewLabel_1);
	}
}
