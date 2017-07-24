package pointofsale;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Container;

import javax.swing.*;

public class WeclomePage{
                   
	JFrame frame=new JFrame("welcome to Point of sale system");
	Container c;
	 JButton b=new JButton("Next");
	 ImageIcon icon=new ImageIcon("welcome.jpg");
	 JLabel img=new JLabel(icon);
	 WeclomePage(){
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setBounds(300,200,770,425);
		 frame.setResizable(false);
		 img.setBounds(13,0,icon.getIconWidth(),icon.getIconHeight());
		 c=frame.getContentPane();
		 c.setLayout(null);
		 c.add(img);
		 b.setBounds(360, 360, 60, 30);
		 b.setBackground(Color.GREEN);
		 b.setForeground(Color.WHITE);
		  c.add(b);
		  b.addActionListener( new ActionListener()
		   {
		       @Override
		       public void actionPerformed(ActionEvent e)
		       {
		    	   frame.setVisible(false);
		  		 LoginForm lf=new LoginForm();
		       }
		   });
		   
	 }
	 
}
