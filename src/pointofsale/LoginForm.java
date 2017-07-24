package pointofsale;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm  {
	JFrame j=new JFrame();
	Container c;
	JTextField t1=new JTextField("naveed"); 
	JPasswordField jp=new JPasswordField("ali123");
	ImageIcon icon=new ImageIcon("login.png");
	JButton btn=new JButton(icon);
	JLabel jl1=new JLabel("USER NAME:");
	
	JLabel jl2=new JLabel("PASSWORD:");
	Font f=new Font("Varela Round",Font.BOLD,20);
	ImageIcon icon1=new ImageIcon("login1.png");
	JLabel jl3=new JLabel(icon1);
	String user;
	LoginForm()
	{
		j.setTitle("Login Page");
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(300,200,770,500);
		j.setResizable(false);
	
		c=j.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.YELLOW);
		jl3.setBounds(290,10,icon1.getIconWidth(),icon1.getIconHeight());
		c.add(jl3);
		t1.setBounds(290,250,250,40);
		c.add(t1);
		jl1.setBounds(150,250,180,40);
		jl1.setFont(f);
		c.add(jl1);
		jp.setBounds(290,300,250,40);
		c.add(jp);
		jl2.setBounds(150,300,180,30);
		jl2.setFont(f);
		c.add(jl2);
		btn.setBounds(290,380,icon.getIconWidth(),icon.getIconHeight());
		c.add(btn);
		 
		  btn.addActionListener( new ActionListener()
		   {
		       @Override
		       public void actionPerformed(ActionEvent e)
		       {
		   		ConectDb con=new ConectDb();
				Connection c=con.getConnection();
				user=t1.getText();
				String pass=jp.getText();
				
				String dbusr = null;
				String pas = null;
				Statement stmt;
				try {
					stmt = c.createStatement();
					ResultSet rs=stmt.executeQuery("select * from operator_detail");  
					while(rs.next())  {
						dbusr=rs.getString(2);
						pas=rs.getString(1);
					if(user.equals(dbusr) && pass.equals(pas)){
						j.setVisible(false);
						TransectionFrame fr=new TransectionFrame();
						fr.getName(pass,dbusr);
						break;
					}	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				  if(!user.equals(dbusr) || !pass.equals(pas))
				    JOptionPane.showMessageDialog(t1, "please enter correct user name and password"); 
				    
		       }
		   });
		   
	
	

			
	 }

}
