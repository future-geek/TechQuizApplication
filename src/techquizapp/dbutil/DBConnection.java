/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sachin Saxena
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//Saxena-PC:1521/xe","project","java");
        JOptionPane.showMessageDialog(null,"Connected Succesfully to the Database","Success!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error Connectiong to the Database"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception is :"+ex);
        }
        
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection()
        {
                if(conn!=null)
		{
			try{
				conn.close();
				JOptionPane.showMessageDialog(null,"Successfully disconnected from the DB","Success!",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(SQLException sq)
			{
                                JOptionPane.showMessageDialog(null,"Error closing the connection "+sq,"Error!",JOptionPane.ERROR_MESSAGE);
                                
			}
                }
        }
}
