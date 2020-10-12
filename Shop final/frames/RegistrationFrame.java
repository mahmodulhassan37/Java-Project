package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import repository.*;
import entity.*;

public class RegistrationFrame extends JFrame implements MouseListener,ActionListener
{
	 private JLabel customerIdLabel,customerPasswordLabel, customerNameLabel, phoneNumberLabel, customerAddressLabel;
	 private JTextField customerIdTF, customerNameTF, customerphoneNumberTF, customerAddressTF;
	 private JPasswordField passPF;
     private  JButton submitBtn, backBtn,showPassBtn;
	 //private Font  myFont;
	 
	 private JPanel panel;
	 private UserRepo ur;
	
	public RegistrationFrame()
	{
		super("Register Now ");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		customerIdLabel = new JLabel("ID :");
		customerIdLabel.setBounds(100,50,100,30);
		panel.add(customerIdLabel);
		
		customerIdTF = new JTextField();
		customerIdTF.setBounds(250,50,200,30);
		panel.add(customerIdTF);
		
		customerPasswordLabel = new JLabel("Password :");
		customerPasswordLabel.setBounds(100,100,100,30);
		panel.add(customerPasswordLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(250,100,200,30);
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,100,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		customerNameLabel = new JLabel("Name :");
		customerNameLabel.setBounds(100,150,100,30);
		panel.add(customerNameLabel);
		
		customerNameTF = new JTextField();
		customerNameTF.setBounds(250,150,200,30);
		panel.add(customerNameTF);
		
		phoneNumberLabel = new JLabel("Phone Number: ");
		phoneNumberLabel.setBounds(100,200,140,30);
		panel.add(phoneNumberLabel);
		
		customerphoneNumberTF = new JTextField();
		customerphoneNumberTF.setBounds(250,200,200,30);
		panel.add(customerphoneNumberTF);
		
		customerAddressLabel = new JLabel("Address: ");
		customerAddressLabel.setBounds(100,250,100,30);
		panel.add(customerAddressLabel);
		
		customerAddressTF = new JTextField();
		customerAddressTF.setBounds(250,250,200,30);
		panel.add(customerAddressTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(220, 310, 80, 40);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(350, 310, 80, 40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			Customer c = new Customer();
			User u = new User();
			c.setCustomerId(customerIdTF.getText());
			c.setCustomerName(customerNameTF.getText());
			c.setPhoneNumber(customerphoneNumberTF.getText());
			c.setAddress(customerAddressTF.getText());
			
			u.setUserId(customerIdTF.getText());
			u.setPassword(passPF.getText());
			
			CustomerRepo cr = new CustomerRepo();
		    UserRepo ur = new UserRepo();
			
			cr.insertInDatabase(c);
			ur.insertUser(u);
		
		}
		
		else if(command.equals(backBtn.getText()))
		{   LoginFrame lf = new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		else
		    {
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+customerIdTF.getText()+"and Password: "+passPF.getText());
		    }
	}	
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}