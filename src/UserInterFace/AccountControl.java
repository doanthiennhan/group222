/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterFace;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public class AccountControl {
    public static  Connection getJDBConnection(){
        String url="jdbc:mysql://localhost:3306/managercenntergaming";
        String user = "root";//roof
        String password="Nhan2792003@";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args){
           Connection con=getJDBConnection();
           if(con !=null) 
              System.out.println("thành công!");
           else System.out.println("thất bại!");
    }
    public Boolean login(String username, String password){
        Connection con=getJDBConnection();
        String sql="SELECT * FROM customers WHERE username = ? and password = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, username);
            
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            
            if(rs.next() ){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return false;
    }
    public Boolean loginaADStaff(String username, String password,String table){
        Connection con=getJDBConnection();
        String sql="SELECT * FROM "+table+" WHERE username = ? and password = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, username);
            
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            
            if(rs.next() ){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return false;
    }
//    public Boolean login(String username, String password) {
//    Connection con = getJDBConnection();
//    String sql = "SELECT * FROM customer WHERE NameLogin = ? AND Password = ?";
//    
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, username);
//        ps.setString(2, password);
//        
//        ResultSet rs = ps.executeQuery();
//        
//        // Kiểm tra xem có ít nhất một bản ghi hay không
//        if (rs.next()) {
//            // Có ít nhất một bản ghi, truy vấn thành công
//            return true;
//        } else {
//            // Không có bản ghi nào, truy vấn không thành công
//            return false;
//        }
//    } catch (SQLException ex) {
//        Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
//    } finally {
//        try {
//            // Đóng ResultSet, PreparedStatement và Connection
//            if (con != null) con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    // Truy vấn không thành công
//    return false;
//}

}
