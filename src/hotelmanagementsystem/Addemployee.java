/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Addemployee extends JFrame implements ActionListener{
      JTextField  tfname,tfage,tfemail,tfphone,tfsalary;
      JRadioButton rbmale,rbfemale;
      JButton submit;
      JComboBox cbjob;
    
    
    
    
    
    
    
    
    
    Addemployee(){
        setLayout(null);
         JLabel lname=new JLabel("NAME");
         lname.setBounds(60,30,120,30);
         lname.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lname);
          tfname=new  JTextField();
         tfname.setBounds(200,30,150,30);
         add(tfname);
        
         
           JLabel lage=new JLabel("AGE");
         lage.setBounds(60,80,120,30);
         lage.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lage);
          tfage=new  JTextField();
         tfage.setBounds(200,80,150,30);
         add(tfage);
         
           JLabel lgender=new JLabel("GENDER");
         lgender.setBounds(60,130,120,30);
         lgender.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lgender);
         
       rbmale=new JRadioButton("Male");
         rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
         rbmale.setBackground(Color.WHITE);
         rbmale.setBounds(200,130,70, 30);
         add(rbmale);
         
        rbfemale=new JRadioButton("Female");
         rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
         rbfemale.setBackground(Color.WHITE);
         rbfemale.setBounds(280,130,70, 30);
         add(rbfemale);
          ButtonGroup bg=new ButtonGroup();
          bg.add(rbmale);
          bg.add(rbfemale);
         
             JLabel ljob=new JLabel("JOB");
         ljob.setBounds(60,180,120,30);
         ljob.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(ljob);
          String str[]={"receptionist","porters","bell boys","house keeping","kitchen staff","chefs","Manager","Waiter"};
          cbjob=new JComboBox(str);
         cbjob.setBounds(200,180,150,30);
         cbjob.setBackground(Color.WHITE);
         add(cbjob);
         
         
             JLabel lsalary=new JLabel("SALARY");
         lsalary.setBounds(60,230,120,30);
          lsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
         add( lsalary);
         
           tfsalary=new  JTextField();
        tfsalary.setBounds(200,230,150,30);
         add(tfsalary);
         
             JLabel lphone=new JLabel("PHONE.NO");
       lphone.setBounds(60,280,120,30);
         lphone.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lphone);
         
          tfphone=new  JTextField();
        tfphone.setBounds(200,280,150,30);
         add(tfphone);
         
         
         
           JLabel lemail=new JLabel("EMAIL");
     lemail.setBounds(60,330,120,30);
         lemail.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lemail);
         
          tfemail=new  JTextField();
       tfemail.setBounds(200,330,150,30);
         add(tfemail);
         
        submit=new JButton("SUBMIT");
         submit.setBackground(Color.BLACK);
          submit.setForeground(Color.WHITE); 
          submit.setBounds(200,430,150,30);
          submit.addActionListener(this);
          add(submit);
          
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
          Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
          JLabel image=new JLabel(i3);
          image.setBounds(380,60,450,370);
          add(image);
            
         
         
       setBounds(350,200,850,540);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
            String name=tfname.getText(); 
            String age=tfage.getText(); 
            String salary=tfsalary.getText(); 
            String phone=tfphone.getText(); 
           String email=tfemail.getText(); 
           String gender=null;
           if(rbmale.isSelected()){
               gender="Male";
           }
           else if(rbfemale.isSelected()){
               gender="Female";
           }
           String job=(String)cbjob.getSelectedItem();
           
         try{
             Conn c=new Conn();
             String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
             c.s.executeUpdate(query);
              JOptionPane.showMessageDialog (null,"Employee added successfully");
              setVisible(false);
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }

     
    public static void main(String[]args){
        new Addemployee();
    }
}
