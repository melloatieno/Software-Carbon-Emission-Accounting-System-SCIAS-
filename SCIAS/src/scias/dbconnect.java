package scias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbconnect {
	public static void main(String[] args) throws Exception {
        getConnection();
        creatTable();
        SCIAS frame = new SCIAS();
		frame.setVisible(true);
    }

    public static void creatTable() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS user(user_id int NOT NULL AUTO_INCREMENT,username varchar(255), password varchar(255),confirmPassword varchar(255), fullname varchar(255), email varchar(255), phone_number int(100), PRIMARY KEY(user_id))");
            create.executeUpdate();
            PreparedStatement create2 = con.prepareStatement("CREATE TABLE IF NOT EXISTS softwareComponents(component_id int NOT NULL AUTO_INCREMENT,component varchar(255), energy_consumed int(100), swcarbon_emission int(100), hardware_carbon int(100), functional_unit int(255), sci int(100), PRIMARY KEY(component_id))");
            create2.executeUpdate();

        } catch(Exception e) {System.out.println(e);}
        finally{
            System.out.println("Function complete");
        }
    }

    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/scias";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e) {System.out.println(e);}

        return null;
    }

}
