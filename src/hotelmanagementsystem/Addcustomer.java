/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Addcustomer extends JFrame implements ActionListener{
    JComboBox cid;
    JTextField tfnum,tfname,tfcountry, tfdeposit;
    JRadioButton rmale,rfemale;
    JLabel  checkltime;
    Choice croom;
    JButton add,back;
    Addcustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("New Customer Form");
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        heading.setBounds(100,20,300,30);
        add(heading);
        
        
         JLabel lid=new JLabel("ID");
       lid.setFont(new Font("Raleway",Font.PLAIN,20));
       lid.setBounds(35,80,100,20);
        add( lid);
        
        String options[]={"Adhaar Card","Passport","Driving License","Voter-id"};
        cid=new JComboBox(options);
        cid.setBounds(200,80,150,25);
        cid.setBackground(Color.WHITE);
        add(cid);
        
          JLabel lnum=new JLabel("Number");
      lnum.setFont(new Font("Raleway",Font.PLAIN,20));
      lnum.setBounds(35,120,100,20);
        add(lnum);
        
        tfnum=new JTextField();
        tfnum.setBounds(200,120,150,25);
        add(tfnum);
        
             JLabel lname=new JLabel("Name");
    lname.setFont(new Font("Raleway",Font.PLAIN,20));
    lname.setBounds(35,160,100,20);
        add(lname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        
             JLabel lgender=new JLabel("Gender");
   lgender.setFont(new Font("Raleway",Font.PLAIN,20));
    lgender.setBounds(35,200,100,20);
        add(lgender);
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
          rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
        
           JLabel lcountry=new JLabel("Country");
   lcountry.setFont(new Font("Raleway",Font.PLAIN,20));
    lcountry.setBounds(35,240,100,20);
        add(lcountry);
        
        tfcountry=new JTextField();
      tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        
            JLabel lroom=new JLabel("Room Number");
   lroom.setFont(new Font("Raleway",Font.PLAIN,20));
    lroom.setBounds(35,280,100,20);
        add(lroom);
        
        
        croom=new Choice();
        try{
            Conn c=new Conn();
            String query="select * from room";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              croom.add(rs.getString("RoomNo"));
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
       croom.setBounds(200,280,150,25);
        croom.setBackground(Color.WHITE);
        add(croom);
        
        
         JLabel lbltime=new JLabel("Checkin Time");
   lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
   lbltime.setBounds(35,320,100,20);
        add(lbltime);
        
        Date date=new Date();
       checkltime=new JLabel(""+date);
   checkltime.setFont(new Font("Raleway",Font.PLAIN,10));
   checkltime.setBounds(200,320,120,20);
        add(checkltime);  
        
        
         
         JLabel lbldeposit=new JLabel("deposit");
  lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
  lbldeposit.setBounds(35,360,100,20);
        add(lbldeposit);
        
          tfdeposit=new JTextField();
      tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
         add=new JButton("ADD");
        add.setBounds(50,410,120,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
          back=new JButton("BACK");
       back.setBounds(200,410,130,30);
      back.setForeground(Color.WHITE);
     back.setBackground(Color.BLACK);
        back.addActionListener(this);
      
        add(back);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
          Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
          JLabel image=new JLabel(i3);
          image.setBounds(400,50,300,400);
          add(image);
            
        
        
        
        setBounds(350,200,800,550);
        setVisible(true);
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id=(String)cid.getSelectedItem();
            String num= tfnum.getText();
             String name=tfname.getText();
             String country=tfcountry.getText();
              String deposit=tfdeposit.getText();
              String gender=null;
              if(rmale.isSelected()){
                  gender="Male";
              }
              else if(rfemale.isSelected()){
                  gender="Female";
              }
              
              String room=croom.getSelectedItem();
              String checkintime=checkltime.getText();
                try{
               Conn c=new Conn();
             String query1="insert into customer values('"+id+"','"+num+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkintime+"','"+deposit+"')";
             String query2="update room set Availability='Not Available' where RoomNo='"+room+"'";
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
              JOptionPane.showMessageDialog (null," Registered successfully");
              setVisible(false);
              new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
                    
            
        }
        else if(ae.getSource()==back){
             setVisible(false);
              new Reception();
        }
    }
    public static void main(String[]args){
         new Addcustomer();
    }
}
