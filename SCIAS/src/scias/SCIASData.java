package scias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class SCIASData extends JFrame {

	private JPanel contentPane;
	private JTable SCItable;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;

	public SCIASData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 11, 353, 350);
		contentPane.add(scrollPane);
		
		SCItable = new JTable();
		scrollPane.setViewportView(SCItable);
		
		JButton GeneratePdfbtn = new JButton("Generate SCIAS Report");		
		GeneratePdfbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		GeneratePdfbtn.setBounds(10, 175, 227, 32);
		contentPane.add(GeneratePdfbtn);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admindashboard();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(45, 256, 139, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Show SCIAS Data");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = dbconnect.getConnection();
					Statement st=con.createStatement();
					String query="select * from softwarecomponents";
					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model = new DefaultTableModel();
					SCItable.setModel(model);
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String component_id, component, energy_consumed, swcarbon_emission, hardware_carbon, funtional_unit, sci;
					while(rs.next()) {
						component_id=rs.getString(1);
						component=rs.getString(2);
						energy_consumed=rs.getString(3);
						swcarbon_emission=rs.getString(4);
						hardware_carbon=rs.getString(5);
						funtional_unit=rs.getString(6);
						sci=rs.getString(7);
						String[] row= {component_id, component, energy_consumed, swcarbon_emission, hardware_carbon, funtional_unit, sci};
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
		btnNewButton_2.setBounds(34, 101, 174, 23);
		contentPane.add(btnNewButton_2);
	}
}
