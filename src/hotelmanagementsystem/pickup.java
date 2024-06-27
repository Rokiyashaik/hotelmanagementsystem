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
public class pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice cartype;
    JCheckBox available;
    pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       JLabel l=new JLabel("PICK UP SERVICE");
       l.setFont(new Font("Tahoma",Font.BOLD,20));
       l.setBounds(400,30,200,30);
       add(l);
       
        JLabel lbl=new JLabel("Type of car");
       lbl.setFont(new Font("Tahoma",Font.BOLD,20));
lbl.setBounds(50,100,100,20);
       add(lbl);
        
       cartype=new Choice();
       cartype.setBounds(150,100,200,25);
       add(cartype);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartype.add(rs.getString("company"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }


       
        available=new JCheckBox("Only display Available ");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        
          JLabel l3=new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        
          JLabel l4=new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
          JLabel l5=new JLabel("model");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        
         JLabel l6=new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        
         JLabel l7=new JLabel("Loacation");
        l7.setBounds(890, 160, 100, 20);
        add(l7);
        
        
        
        table =new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from driver");
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
              
          String query= "select * from driver where company = '"+cartype.getSelectedItem()+"'";
	 
          Conn c =new Conn();
            ResultSet rs;
            
               rs=c.s.executeQuery(query);
            
            
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
        new pickup();
    }
    
}
