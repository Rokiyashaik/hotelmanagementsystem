/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Updateroom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom ,tfavail ,tfstatus;
    JButton checking,update,back;
   Updateroom(){
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
         JLabel lbid=new JLabel("Customer Id");
          lbid.setBounds(20,80,100,30);
          add(lbid);
         ccustomer=new Choice();
          ccustomer.setBounds(200,80,150,25);
          add(ccustomer);
        
         try{
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery("select * from customer");
              while(rs.next()){
                  ccustomer.add(rs.getString("phno"));
              }
          }
          catch(Exception e){
             e.printStackTrace();
          }
        
          JLabel lbroom=new JLabel("Room Number");
          lbroom.setBounds(30,130,100,20);
          add( lbroom); 
          
          tfroom=new JTextField();
          tfroom.setBounds(200,130,150,25);
          add(tfroom);
          
           JLabel lbname=new JLabel("Availability");
          lbname.setBounds(30,180,100,20);
          add(lbname); 
          
          tfavail=new JTextField();
            tfavail.setBounds(200,180,150,25);
          add(tfavail);
          
            JLabel lbcheckin=new JLabel("Cleaning Status");
        lbcheckin.setBounds(30,230,100,20);
          add(lbcheckin); 
          
          tfstatus=new JTextField();
         tfstatus.setBounds(200,230,150,25);
          add( tfstatus);
        
             checking=new JButton("CHECK");
          checking.setBackground(Color.BLACK);
          checking.setForeground(Color.WHITE);
          checking.setBounds(30,300,100,30);
          checking.addActionListener(this);
          add(checking);
          
          
          update=new JButton("UPDATE");
           update.setBackground(Color.BLACK);
         update.setForeground(Color.WHITE);
         update.setBounds(150,300,100,30);
       update.addActionListener(this);
          add(update);
          
          back=new JButton("BACK");
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(270,300,100,30);
          back.addActionListener(this);
          add(back); 
          
             
         
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
         Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         
         JLabel image=new JLabel(i3);
          image.setBounds(400,50,500,300);
          add(image);
        
        
         setBounds(300,200,900,450);
      setVisible(true);
       
       
   } 
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checking){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where phno= '"+id+"' ";
             try{
                 Conn c=new Conn();
                 ResultSet rs=c.s.executeQuery(query);
                 while(rs.next()){
                     tfroom.setText(rs.getString("roomno"));
                     
                     
                    
                 }
                 ResultSet rs2=c.s.executeQuery("select * from room where RoomNo='"+tfroom.getText()+"'");
                 while(rs2.next()){
                   tfavail.setText(rs2.getString("Availability"));
                    tfstatus.setText(rs2.getString("Cleaningstatus"));
                   
                 }
                 
             }
             
             catch(Exception e){
                 
                 e.printStackTrace();
             }
            
            
        }
        
        else if(ae.getSource()==update){
            String id=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String  avail=tfavail.getText();
            String status=tfstatus.getText();
            
            
    
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set Availability= '"+avail+"',Cleaningstatus='"+status+"' where RoomNo = '"+room+"'");
                JOptionPane.showMessageDialog(null, "successfully updated");
                setVisible(false);
                new Reception();
                
            }
            catch(Exception e){
                
                e.printStackTrace();
                
            }
            
        }
        
        else  if(ae.getSource()==back){
            
           setVisible(false);
                new Reception();
            
        }
        
        
    }
   public static void main(String[]args){
       new Updateroom();
   }
}
