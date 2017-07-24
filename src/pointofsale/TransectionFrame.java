package pointofsale;

import java.awt.*;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.*;
public class TransectionFrame {
	JFrame jf=new JFrame();
	Container c;
	JTextField t1=new JTextField("item code");
	JTextField t2=new JTextField("item name");
	JTextField t3=new JTextField("brand name");
	JTextField t4=new JTextField("item price");
	JTextField t5=new JTextField("item tax");
	JTextField t6=new JTextField("00.00");
	JTextField t7=new JTextField("00.00");
	JTextField t8=new JTextField("00.00");
	JTextField t9=new JTextField("");
	JButton btn=new JButton("Add item");
	JButton btn1=new JButton("About");
	JButton btn2=new JButton("Detail");
	JButton btn3=new JButton("Logout");
	JButton btn4=new JButton();
	JButton btn5=new JButton();
	JButton btn6=new JButton("Cash Recived");
	JButton btn7=new JButton("calculate");
	ImageIcon icon2=new ImageIcon("logo.png");
	JLabel jl=new JLabel(icon2);
	JLabel jl1=new JLabel("Itm code:");
	JLabel jl2=new JLabel("Itm name:");
	JLabel jl3=new JLabel("Brnd name:");
	JLabel jl4=new JLabel("itm price");
	JLabel jl5=new JLabel("Itm tax"); 
	JLabel jl6=new JLabel("PLese Enter The Item Detail"); 
	JLabel jl7=new JLabel("Amount:");
	JLabel jl8=new JLabel("Cash Paid:");
	JLabel jl9=new JLabel("Customer Blance:");
	JLabel jl10=new JLabel("Customer Name:");
	JLabel jl11=new JLabel("Item code:");
	JLabel jl12=new JLabel("Quantity:");
	   JTextArea area=new JTextArea("Ready for Transection");  
	
	 String[] languages={"110a","111a","112b","113c","115c","116f","130d","a10"};        
     @SuppressWarnings({ "rawtypes", "unchecked" })
	 JComboBox cb=new JComboBox(languages);   
     
	
	Font f=new Font("Varela Round",Font.BOLD,20);
	String pass1;
	String dbusr;
	String amnt1;
	float amnt=0;
	 int auto=0;
	void getName(String pass,String dbadmin)
	{
		pass1=pass;
	    dbusr=dbadmin;
	}

	
   TransectionFrame(){
	   jf.setTitle("Transection");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(0,0,1370,770);
		jf.setResizable(true);
		c=jf.getContentPane();
		BorderLayout bl=new BorderLayout(10,10);
		c.setLayout(bl);
		  JPanel p1=new JPanel(); 
		c.add(p1,BorderLayout.NORTH);
		    p1.add(jl);  
		    JPanel p2=new JPanel();  
		    c.add(p2,BorderLayout.CENTER);
		    p2.setLayout(null);
		   // p2.setBackground(Color.YELLOW);
		    JPanel p4=new JPanel();
		    JPanel p5=new JPanel();
		    JPanel p6=new JPanel();
		  
		    JTabbedPane tp=new JTabbedPane();  
		    tp.setBounds(85,0,800,540);  
		    tp.setFont(f);
		    tp.add("Transection",p4);  
		    tp.add("Invoice",p5);  
		    tp.add("Record",p6);  
		    p2.add(tp); 
            
		    
		    p4.setLayout(null);
		    p4.setBackground(Color.GREEN);
		    jl11.setBounds(60,10,600,30);
	   		p4.add(jl11);
		     cb.setBounds(60, 40,600,30); 
		     cb.setEditable(true);
		    p4.add(cb);
		    jl12.setBounds(60,70,600,30);
	   		//jl12.setFont(f);
	   		p4.add(jl12);
		    String[] quantity=new String[50]; 
			 for(int i=1;i<=50;i++)
				quantity[i-1]=Integer.toString(i); 
			 @SuppressWarnings({ "rawtypes", "unchecked" })
			 JComboBox cb1=new JComboBox(quantity); 
		     cb1.setBounds(60, 100,600,30); 
		     cb1.setEditable(true);
		      p4.add(cb1);
		      jl10.setBounds(60,140,600,30);
		   		//jl10.setFont(f);
		   		p4.add(jl10);
		        t9.setBounds(60,170,600,30);
		        p4.add(t9);
		        btn7.setBounds(560,210,100,25);
		        p4.add(btn7);
		     
               
           area.setBounds(60,250,600,230);  
           area.setFont(f);
             p4.add(area);
  
  btn7.addActionListener( new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
    	  ConectDb con1=new ConectDb();
			Connection c1=con1.getConnection();
			java.sql.PreparedStatement stmt1;
			java.sql.PreparedStatement stmt2;
			ResultSet rs1;
			ResultSet rs2;
			String itm_brand;
			String itm_name;
			int itm_price;
			int itm_tax;
	String itm_code=(String)cb.getSelectedItem();
	String quanty=(String)cb1.getSelectedItem();
	String usr_name=t9.getText();
	float qnty = 0;
	 try{
			 qnty=Float.parseFloat(quanty);
			
		 }
		 catch(Exception ex){
		  
		 }
		
	try {
		stmt1 = c1.prepareStatement("select item_code,item_name,brand_name,item_price,item_tax from item_details where item_code='"+itm_code+"'");
		rs1=stmt1.executeQuery();  
		while(rs1.next()){    
		itm_code=rs1.getString(1);
			itm_name=rs1.getString(2);
			 itm_brand=rs1.getString(3);
			 itm_price=rs1.getInt(4);
			 itm_tax=rs1.getInt(5);
			 amnt=(itm_price*qnty)+itm_tax;
			 area.setText(" item_code:\t"+itm_code+"\nitem_name:\t"+itm_name+"\nbrand_name:\t"+itm_brand+"\nitem_price:\t"+itm_price+"\nitem_tax:\t"+itm_tax+"\namount:\t"+amnt );
			  amnt1=Float.toString(amnt);
			  t6.setText(amnt1);
		}
		stmt2 = c1.prepareStatement("select * from cash_details");
		rs2=stmt2.executeQuery();  
		while(rs2.next()){ 
			auto=rs2.getInt(1);
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
	
      }
  });
  
  
		    JPanel p3=new JPanel(); 
		    p3.setBounds(900,30, 375,510);
		    p3.setLayout(null);
		    p3.setBackground(Color.YELLOW);
		    p2.add(p3);
		    jl7.setBounds(40,100,300,30);
		    p3.add(jl7);
		    t6.setBounds(40,130,300,30);
		    p3.add(t6);
		    
		    jl8.setBounds(40,160,300,30);
		    p3.add(jl8);
		    t7.setBounds(40,190,300,30);
		    p3.add(t7);
		    jl9.setBounds(40,220,300,30);
		    p3.add(jl9);
		    t8.setBounds(40,250,300,30);
		    p3.add(t8);
		    
		    btn6.setBounds(120,350,150,35);
		    p3.add(btn6);
		    
			  btn6.addActionListener( new ActionListener()
			   {
			       @Override
			       public void actionPerformed(ActionEvent e)
			       {
			  	     String cash_paid1 = t7.getText();
		   			 float cash_paid2=0;
		   			 float cash_rcd1=0;
		   			 
		   			 try{
		   				 cash_paid2=Float.parseFloat(cash_paid1);
		   			 }
		   			 catch(Exception ex){
		   			  
		   			 }
		   			cash_rcd1=cash_paid2-amnt;
		   			String cstmr_blnc=Float.toString(cash_rcd1);
		   			t8.setText(cstmr_blnc);
		   		     ConectDb b=new ConectDb();
		   		     Connection c3=b.getConnection();
		   		   
		   		     
		   		     try {
		   				Statement st3=c3.createStatement();
		   				if(cash_paid2==0)
		   				JOptionPane.showMessageDialog(t1, "please enter the digit value into cash_paid field"); 
		   				else if(cash_paid2<amnt)
		   				JOptionPane.showMessageDialog(t1, "please paid the totall amount"); 
		   				else	{
		   				    Calendar calendar = Calendar.getInstance();
		   				    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
                              auto++;
		   					st3.executeUpdate("insert into cash_details(cash_id,operator_pass,cash_date,amount,cash_paid,customar_blance) values ('"+auto+"','"+pass1+"','"+ourJavaDateObject+"','"+amnt+"','"+cash_paid2+"','"+cash_rcd1+"')");
		   					JOptionPane.showMessageDialog(t1, "transection compelted");
		   					
		   			 }
		   			} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   				e1.printStackTrace();
		   			
			       }
			       }
			   });
			   
		    btn.setBounds(85,545,90,30);
		    p2.add(btn);
		    btn1.setBounds(185,545,90,30);
		    p2.add(btn1);
		    
		    btn2.setBounds(285,545,90,30);
		   p2.add(btn2);
		   btn3.setBounds(385,545,90,30);
		   p2.add(btn3);
		   
		   btn3.addActionListener( new ActionListener()
		   {
		       @Override
		       public void actionPerformed(ActionEvent e)
		       {
		           jf.dispose();
		           LoginForm lg=new LoginForm();
		       }
		   });
		   
		   
		   btn1.addActionListener( new ActionListener()
		   {
		       @Override
		       public void actionPerformed(ActionEvent e)
		       {
		    	  JOptionPane.showMessageDialog(tp, "I'm very happy ,juxt completed my first project in java\n Naveed Rajput(Software Enginer) \n  Email:Rana.naveed812@gmail.com"); 
		    	   
		       }
		   });
		   
		   btn.addActionListener( new ActionListener()
		   {
		       @Override
		       public void actionPerformed(ActionEvent e)
		       {
		    	   JFrame jf1=new JFrame();
		    	   Container c1;
		    	   jf1.setTitle("New Item");
		   		jf1.setVisible(true);
		   		
		   	    jf1.setLayout(null);
		   		jf1.setBounds(400,100,600,600);
		   		
		   		jf1.setResizable(false);
		   		c1=jf1.getContentPane();
		   		c1.setBackground(Color.YELLOW);
		   		jl6.setBounds(200,50,300,35);
		   		jl6.setFont(f);
		   		c1.add(jl6);
		   		jl1.setBounds(60,100,100,35);
		   		jl1.setFont(f);
		   		c1.add(jl1);
		   		t1.setBounds(200,100,300,35);
		   		c1.add(t1);
		   		jl2.setBounds(60,150,100,35);
		   		jl2.setFont(f);
		   		c1.add(jl2);
		   		t2.setBounds(200,150,300,35);
		   		c1.add(t2);
		   		jl3.setBounds(60,200,100,35);
		   		jl3.setFont(f);
		   		c1.add(jl3);
		   		t3.setBounds(200,200,300,35);
		   		c1.add(t3);
		   		jl4.setBounds(60,250,100,35);
		   		jl4.setFont(f);
		   		c1.add(jl4);
		   		t4.setBounds(200,250,300,35);
		   		c1.add(t4);
		   		jl5.setBounds(60,300,100,35);
		   		jl5.setFont(f);
		   		c1.add(jl5);
		   		t5.setBounds(200,300,300,35);
		   		c1.add(t5);
		   		btn4.setText("submit");
		   		btn4.setBounds(250,400,100,35);
		   		c1.add(btn4);
		   		btn5.setText("Reset");
		   		btn5.setBounds(360,400,100,35);
		   		c1.add(btn5);

		   		btn5.addActionListener( new ActionListener()
		   		{
		   		    @Override
		   		    public void actionPerformed(ActionEvent e)
		   		    {
		   		    	t1.setText(null);
		   		    	t2.setText(null);
		   		    	t3.setText(null);
		   		    	t4.setText(null);
		   		    	t5.setText(null);
		   		  
		   		    }
		   		});
		   		
		   		
		   		
		  		btn4.addActionListener( new ActionListener()
		   		{
		   		    @SuppressWarnings("unchecked")
					@Override
		   		    public void actionPerformed(ActionEvent e)
		   		    {
		   		     String item_code1 = t1.getText();
		   			 String item_name1 = t2.getText();
		   			 String brand_name1 = t3.getText();
		   			 String item_price1 = t4.getText();
		   			 String brand_tax1 = t5.getText();
		   			 float price=0;
		   			 float tax=0;
		   			 
		   			 try{
		   				 price=Float.parseFloat(item_price1);
		   				 tax=Float.parseFloat(brand_tax1);
		   			 }
		   			 catch(Exception ex){
		   			  
		   			 }
		   			
		   		     ConectDb b=new ConectDb();
		   		     Connection c=b.getConnection();
		   		   
		   		     
		   		     try {
		   				Statement st=c.createStatement();
		   				if(price==0 || tax==0)
		   				JOptionPane.showMessageDialog(t1, "please enter the digit value into item_price ,and taxfield"); 
		   				else	{
		   				st.executeUpdate("insert into item_details(item_code,item_name,brand_name,item_price,item_tax) values ('"+item_code1+"','"+item_name1+"','"+brand_name1+"','"+price+"','"+tax+"')");
		   				cb.addItem(item_code1);
		   			 JOptionPane.showMessageDialog(t1, "your data is succsfully submitted"); }
		   			} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   				e1.printStackTrace();
		   			}
		   		     
		   		    
		   		    }
		   		});
		   		
		   		
		   		
		       }
		   });
			   
   }
   }
