/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
  JButton newcust,rooms,dept,allemp,allcus,managerinfo,checkout,update,
    roomstat, pickup,searchroom,logout;
    Reception(){
       
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        newcust =new JButton("New Customer Found");
        newcust.setBounds(10,30,200,30);
        newcust.setBackground(Color.BLACK);
        newcust.setForeground(Color.WHITE);
        newcust.addActionListener(this);
        add(newcust);
        
        rooms =new JButton("ROOMS");
      rooms.setBounds(10,70,200,30);
      rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        
       dept=new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
       dept.setForeground(Color.WHITE);
       dept.addActionListener(this);
        add(dept);
        
        allemp=new JButton("All Employee");
         allemp.setBounds(10,150,200,30);
        allemp.setBackground(Color.BLACK);
       allemp.setForeground(Color.WHITE);
       allemp.addActionListener(this);
        add( allemp);
        
         allcus=new JButton("Customer Details");
         allcus.setBounds(10,190,200,30);
        allcus.setBackground(Color.BLACK);
       allcus.setForeground(Color.WHITE);
         allcus.addActionListener(this);
        add( allcus);
        
        
             managerinfo=new JButton("Manager Info");
         managerinfo.setBounds(10,230,200,30);
       managerinfo.setBackground(Color.BLACK);
      managerinfo.setForeground(Color.WHITE);
      managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout=new JButton("Checkout Info");
       checkout.setBounds(10,270,200,30);
      checkout.setBackground(Color.BLACK);
      checkout.setForeground(Color.WHITE);
      checkout.addActionListener(this);
        add(checkout);
        
       update=new JButton("Update Status");
     update.setBounds(10,310,200,30);
      update.setBackground(Color.BLACK);
     update.setForeground(Color.WHITE);
     update.addActionListener(this);
        add(update);
        
      roomstat=new JButton("Update room Status");
    roomstat.setBounds(10,350,200,30);
      roomstat.setBackground(Color.BLACK);
      roomstat.setForeground(Color.WHITE);
    roomstat.addActionListener(this);
        add(roomstat);
        
      pickup=new JButton("Pickup Service");
    pickup.setBounds(10,390,200,30);
       pickup.setBackground(Color.BLACK);
      pickup.setForeground(Color.WHITE);
       pickup.addActionListener(this);
        add( pickup);
        
        searchroom=new JButton("Search Room");
   searchroom.setBounds(10,430,200,30);
     searchroom.setBackground(Color.BLACK);
     searchroom.setForeground(Color.WHITE);
  searchroom.addActionListener(this);
        add(searchroom);
        
       logout=new JButton("Logout");
  logout.setBounds(10,470,200,30);
  logout.setBackground(Color.BLACK);
    logout.setForeground(Color.WHITE);
    logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        
        add(image);
        
        
        
        
        
        
        
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newcust){
            setVisible(false);
            new Addcustomer();
        }
        
         else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        
        
        else if(ae.getSource()==dept){
            setVisible(false);
            new Department();
        }
        
         else if(ae.getSource()== allemp){
            setVisible(false);
            new Employeeinfo() ;
        }
        
         else if(ae.getSource()==  managerinfo){
            setVisible(false);
            new Managerinfo() ;
        }
          else if(ae.getSource()==  allcus){
            setVisible(false);
            new Customerinfo() ;
        }
        
        else if(ae.getSource()==  searchroom){
            setVisible(false);
            new Searchroom() ;
        }
         else if(ae.getSource()==  update){
            setVisible(false);
          new updatecheck();
        }
        
        else if(ae.getSource()== roomstat ){
            setVisible(false);
          new Updateroom();
        }
        
        else if(ae.getSource()==pickup){
            setVisible(false);
          new pickup();
        }
         
        else if(ae.getSource()==checkout){
            setVisible(false);
          new checkout();
        }
        
         else if(ae.getSource()==logout){
            setVisible(false);
             System.exit(0);
        }
        
        
        
        
    }
    public static void main(String[]args){
        new Reception();
        
    }
}
