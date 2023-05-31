package scias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Users extends JFrame {

	private JPanel contentPane;
	private JTable userstbl;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;


	public Users() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 11, 397, 379);
		contentPane.add(scrollPane);
		
		userstbl = new JTable();
		scrollPane.setViewportView(userstbl);
		
		JButton btnNewButton = new JButton("Add New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(30, 158, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admindashboard();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(30, 241, 141, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("View Users");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = dbconnect.getConnection();
					Statement st=con.createStatement();
					String query="select * from user";
					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model = new DefaultTableModel();
					userstbl.setModel(model);
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String user_id, username, password, confirmPassword, email, phone_number;
					while(rs.next()) {
						user_id=rs.getString(1);
						username=rs.getString(2);
						password=rs.getString(3);
						confirmPassword=rs.getString(4);
						email=rs.getString(5);
						phone_number=rs.getString(6);
						String[] row= {user_id, username, password, confirmPassword, email, phone_number};
						model.addRow(row);
					}
					st.close();
					con.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(30, 66, 141, 23);
		contentPane.add(btnNewButton_2);
	}

}
