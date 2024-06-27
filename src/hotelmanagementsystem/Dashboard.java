/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
  
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        JLabel text=new JLabel("ROKIYA GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("serif",Font.PLAIN,50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
       
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        
        JMenuItem reception =new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        setVisible(true);
        
         JMenuItem addemployee =new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms =new JMenuItem("ADD ROOMS");
          addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem addworker =new JMenuItem("ADD DRIVER");
         addworker.addActionListener(this);
        admin.add(addworker);
     

    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getActionCommand().equals("ADD EMPLOYEE")){
             new Addemployee();
         }
         else if(ae.getActionCommand().equals("ADD ROOMS")){
             new Addrooms();
         }
        else if(ae.getActionCommand().equals("ADD DRIVER")){
            new Adddrivers();
        }
         
         else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
     }
    public static void main(String[]args){
        new Dashboard();
    }
    
}
