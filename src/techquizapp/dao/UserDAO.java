/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

/**
 *
 * @author Sachin
 */
public class UserDAO {
    public static boolean validateUser(User u) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where userid = ? and password = ? and usertype = ?");
        ps.setString(1,u.getUserName());
        ps.setString(2,u.getPassword());
        ps.setString(3,u.getUserType());
        ResultSet rs = ps.executeQuery();
        if(rs.next()==false)
            return false;
        else
            return true;        
    }
}
