/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagementsystem;
import java.sql.*;

/**
 *
 * @author adityabhatt
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagement", "root", "aditya7891");
        s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
