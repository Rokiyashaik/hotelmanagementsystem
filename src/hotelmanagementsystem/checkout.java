/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import hotelmanagementsystem.Reception;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;
public class checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lbroomno,lbcheckintime,lbcheckouttime;
    JButton checkout,back ;
    checkout(){
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text=new JLabel("Checkout");
         text.setBounds(100,20,100,30);
         text.setForeground(Color.MAGENTA);
         text.setFont(new Font("Tahoma",Font.BOLD,20));
         add(text);
         
         
          JLabel lbid=new JLabel("Customer id");
         lbid.setBounds(30,80,100,30);
        add(lbid);
         
        ccustomer =new Choice();
        ccustomer.setBounds(150,80,150,25);
         add(ccustomer);
         
         
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(310,80,20,20);
         add(image);
         
         
           JLabel lbroom=new JLabel("Room No");
        lbroom.setBounds(30,130,100,30);
        add(lbroom);
         
        lbroomno=new JLabel();
        lbroomno.setBounds(150,130,100,30);
        add(lbroomno);
         
            JLabel lbcheckin=new JLabel("Check in time");
      lbcheckin.setBounds(30,180,100,30);
        add(lbcheckin);
        
      lbcheckintime=new JLabel();
      lbcheckintime.setBounds(150,180,100,30);
        add(lbcheckintime);
        
        
          JLabel lbcheckout=new JLabel("Check out time");
     lbcheckout.setBounds(30,230,100,30);
        add(lbcheckout);
        Date date=new Date();
      lbcheckouttime=new JLabel(""+date);
     lbcheckouttime.setBounds(150,230,100,30);
        add(lbcheckouttime);
        
         try{
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery("select * from customer");
              while(rs.next()){
                  ccustomer.add(rs.getString("phno"));
                  lbroomno.setText(rs.getString("roomno"));
                  lbcheckintime.setText(rs.getString("checkintime"));
              }
          }
          catch(Exception e){
             e.printStackTrace();
          }
         
         checkout =new JButton("checkout");
          checkout.setBounds(30,280,120,30);
          checkout.setBackground(Color.BLACK);
           checkout.setForeground(Color.WHITE);
           checkout.addActionListener(this);
         add(checkout);
         
         back =new JButton("Back ");
          back .setBounds(200,280,120,30);
         back .setBackground(Color.BLACK);
          back .setForeground(Color.WHITE);
          
          back.addActionListener(this);
         add(back );
         
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
          Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
         ImageIcon i6=new ImageIcon(i5);
         JLabel image1=new JLabel(i6);
         image1.setBounds(350,50,400,250);
         add(image1);
         
         
        setBounds(300,200,800,400);
        setVisible(true);
    }
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==checkout){
              String query1="delete from customer where phno='"+ccustomer.getSelectedItem()+"'";
              String query2="update room set Availability='Available' where RoomNo='"+lbroomno.getText()+"'";
              try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                 JOptionPane.showMessageDialog(null, "check out done");
                   setVisible(false);
                   new Reception();
          }
              
              catch(Exception e){
                  e.printStackTrace();
              }
          }
          else{
              setVisible(false);
              new Reception();
          }
          
      }
    public static void main(String[]args){
        new checkout();
        
    }
}
