package scias;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JFrame;


public class User implements ActionListener{
	
	JFrame frame;
	JLabel user_idlabel = new JLabel("User ID");
	JLabel usernamelabel = new JLabel("Username:");
	JLabel passwordlabel = new JLabel("Password:");
	JLabel confirmPasswordLabel=new JLabel("Confirm Password:");
	JLabel fullnamelabel = new JLabel("Full Name:");
	JLabel emaillabel = new JLabel ("Email:");
	JLabel phonenumberlabel = new JLabel("Phone Number:");
	JTextField user_idField = new JTextField();
	JTextField usernameField=new JTextField();
	JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField fullnameField=new JTextField();
    JTextField emailTextField=new JTextField();
    JTextField phonenumbertField=new JTextField();
    JButton registerButton=new JButton("REGISTER USER");
    JButton cancelButton=new JButton("CANCEL");
    
    User()
    {
    	createWindow();
    	setLocationandSize();
    	addComponents();
    	actionEvent();
    }
    
    public void createWindow() {
    	frame=new JFrame();
        frame.setTitle("Register Users");
        frame.setBounds(60,60,400,700);
        //frame.getContentPane().setBackground(Color.blue);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
	
    public void setLocationandSize() {
    	user_idlabel.setBounds(20,20,80,70);
    	usernamelabel.setBounds(20,70,80,70);
    	passwordlabel.setBounds(20,120,120,70);
    	confirmPasswordLabel.setBounds(20, 170, 160, 70);
    	fullnamelabel.setBounds(20, 220, 200, 70);
    	emaillabel.setBounds(20, 270, 240, 70);
    	phonenumberlabel.setBounds(20, 320, 280, 70);
    	user_idField.setBounds(180, 43, 183, 23);
    	usernameField.setBounds(180, 93, 183, 23);
    	passwordField.setBounds(180, 143, 183, 23);
    	confirmPasswordField.setBounds(180, 193, 183, 23);
    	fullnameField.setBounds(180, 243, 183, 23);
    	emailTextField.setBounds(180, 293, 183, 23);
    	phonenumbertField.setBounds(180, 343, 183, 23);
    	registerButton.setBounds(60,460,150,40);
    	cancelButton.setBounds(240,460,100,40);
    	
    }
    
    public void addComponents() {
    	frame.add(user_idlabel);
    	frame.add(user_idField);
    	frame.add(usernamelabel);
    	frame.add(usernameField);
    	frame.add(passwordlabel);
    	frame.add(passwordField);
    	frame.add(confirmPasswordLabel);
    	frame.add(confirmPasswordField);
    	frame.add(fullnamelabel);
    	frame.add(fullnameField);
    	frame.add(emaillabel);
    	frame.add(emailTextField);
    	frame.add(phonenumberlabel);
    	frame.add(phonenumbertField);
    	frame.add(registerButton);
    	frame.add(cancelButton);
    	
    }
    
    public void actionEvent() {
    	registerButton.addActionListener(this);
    	cancelButton.addActionListener(this);
    }
  
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==registerButton) {
				try {
					Connection con = dbconnect.getConnection();
					PreparedStatement Pstatement = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
					Pstatement.setString(1, user_idField.getText());
					Pstatement.setString(2, usernameField.getText());
					Pstatement.setString(3, passwordField.getText());
					Pstatement.setString(4, confirmPasswordField.getText());
					Pstatement.setString(5, fullnameField.getText());
					Pstatement.setString(6, emailTextField.getText());
					Pstatement.setString(7, phonenumbertField.getText());
					
					 if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
		                {
		                    //Executing query
		                    Pstatement.executeUpdate();
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"password did not match");
		                }
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}

	
}
