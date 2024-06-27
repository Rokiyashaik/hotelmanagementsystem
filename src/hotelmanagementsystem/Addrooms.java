/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Addrooms extends JFrame implements ActionListener{
   JButton add,cancel;
   JTextField  tfroomno,tfroomprice;
   JComboBox cclean, cavail,ctype;
   
    
    Addrooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
         JLabel lroomno=new JLabel("ROOM NUMBER");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(60, 80, 120, 30);
        add(lroomno);
        
         tfroomno=new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);
        
        
           JLabel lrooomavai=new JLabel("AVALABILTY");
      lrooomavai.setFont(new Font("Tahoma",Font.PLAIN,16));
       lrooomavai.setBounds(60, 130, 120, 30);
        add(lrooomavai);
        
        String availableoptions[]={"Available","Not Available"};
         cavail=new  JComboBox(availableoptions);
        cavail.setBounds(200, 130, 150, 30);
        cavail.setBackground(Color.WHITE);
        add(cavail);
        
           JLabel lroomclean=new JLabel("CLEANING STATUS");
       lroomclean.setFont(new Font("Tahoma",Font.PLAIN,16));
       lroomclean.setBounds(60, 180, 120, 30);
        add( lroomclean);
        
        String cleanoptions[]={"Done","Not Done"};
        cclean=new  JComboBox(cleanoptions);
        cclean.setBounds(200, 180, 150, 30);
        cclean.setBackground(Color.WHITE);
        add(cclean);
        
        
        JLabel lroomprice=new JLabel("ROOM PRICE");
      lroomprice.setFont(new Font("Tahoma",Font.PLAIN,16));
       lroomprice.setBounds(60, 230, 120, 30);
        add(lroomprice);
        
         tfroomprice=new JTextField();
         tfroomprice.setBounds(200,230,150,30);
        add(tfroomprice);
        
        
            JLabel lroomtype=new JLabel("ROOM TYPE");
     lroomtype.setFont(new Font("Tahoma",Font.PLAIN,16));
       lroomtype.setBounds(60, 280, 120, 30);
        add(lroomtype);
        
        String roomoptions[]={"Single-bedded","Double-bedded","Triple-bedded"};
        ctype=new  JComboBox(roomoptions);
      ctype.setBounds(200, 280, 150, 30);
        ctype.setBackground(Color.WHITE);
        add(ctype);
        
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
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
          setBounds(330,200,940,470);
          setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber=tfroomno.getText();
            String availabilty=(String)cavail.getSelectedItem();
            String clean=(String) cclean.getSelectedItem();
            String price=tfroomprice.getText();
            String type=(String)ctype.getSelectedItem();
            
            try{
               Conn c=new Conn();
             String query="insert into room values('"+roomnumber+"','"+availabilty+"','"+clean+"','"+price+"','"+type+"')";
               c.s.executeUpdate(query);
              JOptionPane.showMessageDialog (null,"Room added successfully");
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
        new Addrooms();
    }
}
