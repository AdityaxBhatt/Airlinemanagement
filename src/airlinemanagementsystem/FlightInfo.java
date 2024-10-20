/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
/**
 *
 * @author adityabhatt
 */
   
public class FlightInfo extends JFrame{
    
    
    FlightInfo(){
        setLayout(null);
        setLocation(800,600);
        setSize(800,600);
        setVisible(true);
        
        JTable table = new JTable();
        try{
            Conn c=new Conn();
            String query="select * from flight;";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane t=new JScrollPane(table);
        t.setViewportBorder(BorderFactory.createLineBorder(Color.black));
        t.setBounds(0,0,800,600);
        add(t);
    }
    
    
    public static void main(String [] args){
        new FlightInfo();
    }
    
}
