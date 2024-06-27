/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver"); 
             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","12345678");
             s=c.createStatement();
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    public static void main(String[]args){
        
        
    }
    }
  




