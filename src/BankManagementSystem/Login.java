package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

	JLabel l1, l2, l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
   //constructor
	Login(){   

         //To center the title text
		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("AUTOMATED BANKING SYSTEM");
		int y = fm.stringWidth(" ");
		int z = getWidth() - x;
		int w = z/y;
		String pad = "";
		pad = String.format("%"+w+"s", pad);
		setTitle(pad+"AUTOMATED BANKING SYSTEM");

        
		l1 = new JLabel("WELCOME TO ATM");
		Font font1 = new Font("Courier", Font.BOLD, 40);
		l1.setFont(font1);
		
		l2 = new JLabel("Card No:");
		l2.setFont(new Font("Raleway", Font.BOLD, 30));
		
		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 30));
		
		
		tf1 = new JTextField(17);
		pf2 = new JPasswordField(17);
		
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.BLUE);
				
		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.BLUE);
		
		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.BLUE);
		
        setLayout(null);
        
        l1.setBounds(175, 50, 450, 200);
        add(l1);
                
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        //Adding Style
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300, 235, 230, 30);
        add(tf1);
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 310, 230, 30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        b1.addActionListener(this);    
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.cyan);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);    
    }
  
    public void actionPerformed(ActionEvent ae){
       
    	try {
    		conn c1 = new conn();
    		String a = tf1.getText();
    		String b = pf2.getText();
    		String q = "select * from login where cardno = '"+a+"'and pin = '"+b+"'";
    		
    		ResultSet rs = c1.s.executeQuery(q);
    		
    		if (ae.getSource()==b1) {
    			if(rs.next()) {
    				new Transcations
    			}
    			
    		}
    			
    			
            if(ae.getSource()==b1){
                if(rs.next()){
                    new Transcations().setVisible(true);
                    setVisible(false);
                
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                    
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                new Signup().setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    } 
    public static void main(String[] args){
        new Login().setVisible(true);
    }
   
}
