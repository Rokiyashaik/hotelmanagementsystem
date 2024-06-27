/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   Customerinfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        
        JLabel l1=new JLabel("id");
        l1.setBounds(40, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("phno");
        l2.setBounds(190, 10, 100, 20);
        add(l2);
        
          JLabel l3=new JLabel("name");
        l3.setBounds(300, 10, 100, 20);
        add(l3);
        
          JLabel l4=new JLabel("gender");
        l4.setBounds(430, 10, 100, 20);
        add(l4);
        
          JLabel l5=new JLabel("country");
        l5.setBounds(550, 10, 100, 20);
        add(l5);
        
         JLabel l6=new JLabel("RoomNo");
        l6.setBounds(650, 10, 100, 20);
        add(l6);
        
         JLabel l7=new JLabel("Checkin-Time");
        l7.setBounds(750, 10, 100, 20);
        add(l7);
        
         JLabel l8=new JLabel("deposit");
        l8.setBounds(890, 10, 100, 20);
        add(l8);
        
        
        
        table =new JTable();
  table.setBounds(0, 40, 1000, 400);        
  add(table);
        
        try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from customer");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         
          back=new JButton("BACK");
        back.setBounds(420,500,120,30);
      back.setForeground(Color.WHITE);
     back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
       setBounds(300,200,1000,600);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
             setVisible(false);
        new Reception();
            
        }
       
    }
    public static void main(String[]args){
        new Customerinfo();
    }
    
}
