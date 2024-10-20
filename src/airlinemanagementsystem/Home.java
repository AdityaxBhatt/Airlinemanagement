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
public class Home extends JFrame implements ActionListener{
    JMenuItem customers,flight, journey,bookFlight, cancelTicket,boardingPass;
    
    
    Home(){
        setLayout(null);
        
        ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/background.jpg"));
        Image image =ig.getImage();
        image =image.getScaledInstance(1440, 900, 1000);
        
        
        JLabel il=new JLabel(new ImageIcon(image));
        il.setBounds(0,0,1440,900);
        add(il);
        pack();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JMenuBar menu= new JMenuBar();
        setJMenuBar(menu);
        JMenu details =new JMenu("Details");
        menu.add(details);
        
        flight= new JMenuItem("Flight Details");
        flight.addActionListener(this);
        details.add(flight);
        
        customers= new JMenuItem("Add Customers Details");
        customers.addActionListener(this);
        details.add(customers);
        
        journey= new JMenuItem("Journey Details");
        journey.addActionListener(this);
        details.add(journey);
        
        bookFlight= new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        cancelTicket= new JMenuItem("Cancel Ticket");
        cancelTicket.addActionListener(this);
        details.add(cancelTicket);
        
        JMenu ticket =new JMenu("Ticket");
        menu.add(ticket);
        
        boardingPass=new JMenuItem("Borading Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        
        
        
        
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==customers){
            new Addcustomers();
        }
        else if(e.getSource()==flight){
            new FlightInfo();
        }
        else if(e.getSource()==journey){
            new JourneyDetails();
        }
        else if(e.getSource()==bookFlight){
            new BookFlight();
        }
        else if(e.getSource()==cancelTicket){
            new Cancel();
        }
        else if(e.getSource()==boardingPass){
            new BoardingPass();
        }
       
         
    }
    
    
    public static void main(String args[]){
        new Home();
    }
}
