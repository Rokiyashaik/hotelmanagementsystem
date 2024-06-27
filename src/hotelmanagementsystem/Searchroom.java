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
public class Searchroom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
     Searchroom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       JLabel l=new JLabel("Search for Room");
       l.setFont(new Font("Tahoma",Font.BOLD,20));
       l.setBounds(400,30,200,30);
       add(l);
       
        JLabel lbl=new JLabel("Bed Type");
       lbl.setFont(new Font("Tahoma",Font.BOLD,20));
lbl.setBounds(50,100,100,20);
       add(lbl);
        
        bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        available=new JCheckBox("Only display Available ");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1=new JLabel("RoomNo");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);
        
          JLabel l3=new JLabel("clean status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);
        
          JLabel l4=new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);
        
          JLabel l5=new JLabel("Bed type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);
        
        
        
        table =new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from room");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
           submit=new JButton("SUBMIT");
      submit.setBounds(300,520,120,30);
     submit.setForeground(Color.WHITE);
    submit.setBackground(Color.BLACK);
       submit.addActionListener(this);
        add(submit);
         
          back=new JButton("BACK");
       back.setBounds(500,520,120,30);
      back.setForeground(Color.WHITE);
     back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==submit){
          try{ 
              
          String query1= "select * from room where Roomtype = '"+bedtype.getSelectedItem()+"'";
	  String query2 = "select * from room where Availability = 'Available' AND Roomtype ='"+bedtype.getSelectedItem()+"'";
          Conn c =new Conn();
            ResultSet rs;
            if(available.isSelected()){
               rs=c.s.executeQuery(query2);
            }
            else{
              rs=c.s.executeQuery(query1); 
            }
                table.setModel(DbUtils.resultSetToTableModel(rs));
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
        new Searchroom();
    }
    
}
