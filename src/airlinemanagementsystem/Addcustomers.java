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
public class Addcustomers extends JFrame implements ActionListener{
    
    JTextField nameField, nationField, numberField, adharField, addressField;
    JRadioButton male,female;
    
    Addcustomers(){
        
     
        setForeground(Color.WHITE);
        JLabel head= new JLabel("Add New Customers");
        head.setBounds(225,20,400,50);
        head.setFont(new Font("Ariel",Font.BOLD,32));
        add(head);
        
        JLabel name= new JLabel("Name");
        name.setBounds(30,100,150,20);
        name.setFont(new Font("Ariel",Font.PLAIN,18));
        add(name);
        
        nameField=new JTextField();
        nameField.setBounds(200,100,150,20);
        add(nameField);
        
        JLabel nationality= new JLabel("Nationality");
        nationality.setBounds(30,150,150,20);
        nationality.setFont(new Font("Ariel",Font.PLAIN,18));
        add(nationality);
        
        nationField=new JTextField();
        nationField.setBounds(200,150,150,20);
        add(nationField);
        
        JLabel adharNumber= new JLabel("Adhar Number");
        adharNumber.setBounds(30,200,150,20);
        adharNumber.setFont(new Font("Ariel",Font.PLAIN,18));
        add(adharNumber);
        
        adharField=new JTextField();
        adharField.setBounds(200,200,150,20);
        add(adharField);
        
        JLabel gender= new JLabel("Gender");
        gender.setBounds(30,250,150,20);
        gender.setFont(new Font("Ariel",Font.PLAIN,18));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 250, 100, 20);
        add(male);
        
        female = new JRadioButton("female");
        female.setBounds(300, 250, 100, 20);
        add(female);
        
        ButtonGroup gButton = new ButtonGroup();
        
        gButton.add(male);
        gButton.add(female);
        
        
        JLabel number= new JLabel("Phone Number");
        number.setBounds(30,300,150,20);
        number.setFont(new Font("Ariel",Font.PLAIN,18));
        add(number);
        
        numberField=new JTextField();
        numberField.setBounds(200,300,150,20);
        add(numberField);
        
        JLabel address= new JLabel("Address");
        address.setBounds(30,350,150,20);
        address.setFont(new Font("Ariel",Font.PLAIN,18));
        add(address);
        
        addressField=new JTextField();
        addressField.setBounds(200,350,150,20);
        add(addressField);
        
        JButton save = new JButton("SAVE");
        save.setBounds(350, 400, 100, 30);
        save.addActionListener(this);
        add(save);
        
        
        setLayout(null);
        setLocation(200,100);
        setSize(800,600);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent e){
        String name =nameField.getText();
        String nation =nationField.getText();
        String adhar =adharField.getText();
        String number =numberField.getText();
        String address=addressField.getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else{
             gender="Female";
        }
        
        try{
            Conn c= new Conn();
            String query ="insert into customers values('"+name+"', '"+nation+"', '"+adhar+"', '"+number+"', '"+gender+"', '"+address+"');";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
            setVisible(false);
                 }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
        
        
    }
    
    
    public static void main(String[] args){
        new Addcustomers();
    }
    
}
