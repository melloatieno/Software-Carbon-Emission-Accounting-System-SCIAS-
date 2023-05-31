package scias;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SoftwareComponent implements ActionListener {
	
	
	JFrame frame;
	JLabel component_IDlabel = new JLabel("Component ID");
	JLabel componentnamelabel = new JLabel("Component Name:");
	JLabel energyConsumedlabel = new JLabel("Energy Consumed:");
	JLabel swCarbonlabel = new JLabel("Carbon Emitted per kWh of Energy");
	JLabel hardwareCarbonLabel=new JLabel("Hardware Carbon:");
	JLabel funtionalUnitlabel = new JLabel("Functional Unit:");
	JLabel SCIlabel = new JLabel ("Software Carbon Intensity Score:");
	JTextField component_IDField = new JTextField();
	JTextField componentnameField=new JTextField();
    JTextField energyConsumedField=new JTextField();
    JTextField swCarbonField = new JTextField();
    JTextField hardwareCarbontField=new JTextField();
    JTextField funtionalUnitField=new JTextField();
    JTextField SCIField=new JTextField();
    JButton getSCIScore = new JButton("GET SCI SCORE");
    JButton submitButton=new JButton("SUBMIT");
    JButton cancelButton=new JButton("CANCEL");
    
    SoftwareComponent()
    {
    	createWindow();
    	setLocationandSize();
    	addComponents();
    	actionEvent();
    }
    
    public void createWindow() {
    	frame=new JFrame();
        frame.setTitle("Software Components Details");
        frame.setBounds(60,60,400,600);
        //frame.getContentPane().setBackground(Color.blue);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
	
    public void setLocationandSize() {
    	component_IDlabel.setBounds(20,50,150,70);
    	componentnamelabel.setBounds(20,100,150,70);
    	energyConsumedlabel.setBounds(20,150,150,70);
    	swCarbonlabel.setBounds(20,200,150,70);
    	hardwareCarbonLabel.setBounds(20,250,150,70);
    	funtionalUnitlabel.setBounds(20,300,150,70);
    	SCIlabel.setBounds(20,350,150,70);
    	component_IDField.setBounds(180,73,150,20);
    	componentnameField.setBounds(180,123,150,20);
    	energyConsumedField.setBounds(180,173,150,20);
    	swCarbonField.setBounds(180, 223, 150, 20);
    	hardwareCarbontField.setBounds(180,273,150,20);
    	funtionalUnitField.setBounds(180,323,150,20);
    	SCIField.setBounds(180,373,150,20);
    	getSCIScore.setBounds(150,400,100,35);
        submitButton.setBounds(100,450,100,35);
        cancelButton.setBounds(280,450,100,35);
    	
    }
    
    public void addComponents() {
    	frame.add(component_IDlabel);
    	frame.add(componentnamelabel);
    	frame.add(energyConsumedlabel);
    	frame.add(swCarbonlabel);
    	frame.add(hardwareCarbonLabel);
    	frame.add(funtionalUnitlabel);
    	frame.add(SCIlabel);
    	frame.add(component_IDField);
    	frame.add(componentnameField);
    	frame.add(energyConsumedField);
    	frame.add(swCarbonField);
    	frame.add(hardwareCarbontField);
    	frame.add(funtionalUnitField);
    	frame.add(SCIField);
    	frame.add(getSCIScore);
    	frame.add(submitButton);
    	frame.add(cancelButton);
    	
    }
    
    public void actionEvent() {
    	getSCIScore.addActionListener(this);
    	submitButton.addActionListener(this);
    	cancelButton.addActionListener(this);
    }
  
		public void actionPerformed(ActionEvent e) {
			int energyConsumed, carbonEmission, hardwareCarbon, functionalUnit, score;
			if(e.getSource()== getSCIScore) {
				try {
					energyConsumed=Integer.parseInt(energyConsumedField.getText());
					carbonEmission=Integer.parseInt(swCarbonField.getText());
					hardwareCarbon=Integer.parseInt(hardwareCarbontField.getText());
					functionalUnit=Integer.parseInt(funtionalUnitField.getText());
					
					score=((energyConsumed * carbonEmission) + hardwareCarbon) / functionalUnit;
					SCIField.setText(Integer.toString(score));
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Values");
				}
			}
			
			if(e.getSource()==submitButton) {
				try {
					Connection con = dbconnect.getConnection();
					PreparedStatement Pstatement = con.prepareStatement("insert into softwareComponents values(?,?,?,?,?,?,?)");
					Pstatement.setString(1, component_IDField.getText());
					Pstatement.setString(2, componentnameField.getText());
					Pstatement.setString(3, energyConsumedField.getText());
					Pstatement.setString(4, swCarbonField.getText());
					Pstatement.setString(5, hardwareCarbontField.getText());
					Pstatement.setString(6, funtionalUnitField.getText());
					Pstatement.setString(7, SCIField.getText());
					
					{
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                }
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
}