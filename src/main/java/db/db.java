/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import  java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author c0666985
 */
public class db {
    private static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host=System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port= System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username=System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password=System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        
        String name="db";
        String url="jdbc:mysql://" + host + ":" + port + ":" + name;
        return DriverManager.getConnection(url,username,password);
    }
    
    public static String getTable(){
        String output= "";
        try{
            Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select *from PEOPLE");
            while(rs.next()){
                output+="<h2>" + rs.getString("name") + "</h2>";
                output+="<p>" + rs.getString("bio") + "</p>";                
            }
            conn.close();;
        }
        catch(SQLException ex){
            output=" SQL Exception: " +ex.getMessage();
        }
        return output;
    }
}
