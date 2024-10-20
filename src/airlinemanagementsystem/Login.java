/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author adityabhatt
 */
public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close;
    JTextField userField;
    JPasswordField passField;
    
    Login(){
        setVisible(true);
        setSize(400,250);
        setLocation(550,250);
        
        setLayout(null);
        
        JLabel username= new JLabel("Unsername");
        username.setBounds(40,30, 100,20);
        add(username);
        
        userField= new JTextField();
        userField.setBounds(140,30, 150,20);
        add(userField);
        
        JLabel pass= new JLabel("Password");
        pass.setBounds(40,60, 100,20);
        add(pass);
        
        passField= new JPasswordField();
        passField.setBounds(140,60,150,20);
        add(passField);
        
        reset= new JButton("Reset");
        reset.setBounds(100,120,80,20);
        reset.addActionListener(this);
        add(reset);
        
        submit= new JButton("Submit");
        submit.setBounds(200,120,80,20);
        submit.addActionListener(this);
        add(submit);

        close= new JButton("Close");
        close.setBounds(150,160,80,20);
        close.addActionListener(this);
        add(close);
        
        
        
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String user=userField.getText();
            String pass=passField.getText();
            
            try{
                Conn c= new Conn();
                
                String query ="select * from login where username='"+user+"' and password='"+pass+"'";
                
                ResultSet r=c.s.executeQuery(query);
                
                if(r.next()){
                    new Home();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    userField.setText("");
                    passField.setText("");
                }
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        else if(e.getSource()==close){
            setVisible(false);
        }
        else if(e.getSource()==reset){
            userField.setText("");
            passField.setText("");
        }
        
    }
    
    
    public static void main(String args[]){
        new Login();
    }
}
