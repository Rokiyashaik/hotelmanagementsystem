/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Adddrivers extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfname,tfage,tcompany,tmodel,tlocation;
    JComboBox cgender,cavail;
    
    Adddrivers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
         heading.setBounds(150, 10, 200, 20);
         add(heading);
         
         JLabel lname=new JLabel("Name");
       lname.setFont(new Font("Tahoma",Font.PLAIN,18));
         lname.setBounds(60, 70, 120, 30);
         add(lname);
         
         tfname =new JTextField();
       tfname.setBounds(200, 70, 150, 30);
         add(tfname);
         
          JLabel lage=new JLabel("Age");
      lage.setFont(new Font("Tahoma",Font.PLAIN,18));
         lage.setBounds(60, 110, 120, 30);
         add(lage);
         
       tfage =new JTextField();
     tfage.setBounds(200, 110, 150, 30);
         add(tfage);
         
          JLabel lgender=new JLabel("Gender");
   lgender.setFont(new Font("Tahoma",Font.PLAIN,18));
         lgender.setBounds(60, 150, 120, 30);
         add(lgender); 
         
         String gender[]={"Male","Female"};
         cgender=new JComboBox(gender);
         cgender.setBounds(200,150,150,30);
         cgender.setBackground(Color.WHITE);
         add(cgender);
        
            JLabel carcompany=new JLabel("Car Company");
   carcompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        carcompany.setBounds(60, 190, 120, 30);
         add(carcompany); 
         
         tcompany =new JTextField();
    tcompany .setBounds(200, 190, 150, 30);
         add(tcompany);
         
          JLabel carmodel=new JLabel("Car Model");
 carmodel.setFont(new Font("Tahoma",Font.PLAIN,18));
        carmodel.setBounds(60, 230, 120, 30);
         add(carmodel); 
         
         tmodel =new JTextField();
   tmodel .setBounds(200, 230, 150, 30);
         add(tmodel);
         
         
          JLabel Availabilty=new JLabel("Available");
Availabilty.setFont(new Font("Tahoma",Font.PLAIN,18));
       Availabilty.setBounds(60, 270, 120, 30);
         add(Availabilty);
         
       
          String Avail[]={"Available","Not Available"};
        cavail=new JComboBox(Avail);
        cavail.setBounds(200,270,150,30);
          cavail.setBackground(Color.WHITE);
         add(cavail);
         
         
          JLabel location=new JLabel("Location");
  location.setFont(new Font("Tahoma",Font.PLAIN,18));
       location.setBounds(60, 310, 120, 30);
         add(location); 
         
         tlocation =new JTextField();
   tlocation.setBounds(200, 310, 150, 30);
         add(tlocation);
         
        add=new JButton("ADD");
        add.setBounds(60,350,130,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
                add(add);
        
         cancel=new JButton("CANCEL");
       cancel.setBounds(220,350,130,30);
      cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.addActionListener(this);
        
        add(cancel);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
        image.setBounds(400,80,500,300);
        add(image);
         
         
        
        setBounds(300,200,980,470);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
          String name= tfname.getText();
          String age=tfage.getText();
         String company=tcompany.getText();
          String model= tmodel.getText();
            String location=  tlocation.getText();
            String gender=(String)cgender.getSelectedItem();
             String avail=(String)cavail.getSelectedItem();
            
           
        try{
            Conn c=new Conn();
            String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+avail+"','"+location+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog (null,"Driver added successfully");
              setVisible(false);
            
        }
        catch(Exception e){
           e.printStackTrace();
            
        }
          
    }
    else{
        setVisible(false);
    }
    }
    public static void main(String[]args){
        new Adddrivers();
    }
}

