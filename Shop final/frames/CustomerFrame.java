package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener
{
	private JLabel customerIdLabel, customerNameLabel, customerPhoneNumberLabel, customerAddressLabel;
	private JTextField customerIdTF, customerNameTF, customerPhoneNumberTF, customerAddressTF;
	private JButton loadBtn,refreshBtn, updateBtn, deleteBtn,backBtn,logoutBtn;
	private JPanel panel;
	
	private User user;
	private CustomerRepo er;
	private UserRepo ur;
	private Color color;
	
	
	public CustomerFrame(User user)
	{
		super("Change Information Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		customerIdLabel = new JLabel("ID :");
		customerIdLabel.setBounds(100,100,100,30);
		panel.add(customerIdLabel);
		
		customerIdTF = new JTextField();
		customerIdTF.setBounds(220,100,100,30);
		panel.add(customerIdTF);
		
		customerNameLabel = new JLabel("Name :");
		customerNameLabel.setBounds(100,150,100,30);
		panel.add(customerNameLabel);
		
		customerNameTF = new JTextField();
		customerNameTF.setBounds(220,150,100,30);
		panel.add(customerNameTF);
		
		customerPhoneNumberLabel = new JLabel("PhoneNumber: ");
		customerPhoneNumberLabel.setBounds(100,200,100,30);
		panel.add(customerPhoneNumberLabel);
		
		customerPhoneNumberTF = new JTextField();
		customerPhoneNumberTF.setBounds(220,200,100,30);
		panel.add(customerPhoneNumberTF);
		
		customerAddressLabel = new JLabel("Address: ");
		customerAddressLabel.setBounds(100,250,100,30);
		panel.add(customerAddressLabel);
		
		customerAddressTF = new JTextField();
		customerAddressTF.setBounds(220,250,100,30);
		panel.add(customerAddressTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.GREEN);
		panel.add(loadBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(195,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		refreshBtn.setBackground(Color.GREEN);
		panel.add(refreshBtn);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		updateBtn.setBackground(Color.GREEN);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(Color.GREEN);
		panel.add(deleteBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.GREEN);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn .setBounds(600, 300, 80, 30);
		logoutBtn .addActionListener(this);
		logoutBtn.setBackground(Color.CYAN);
		panel.add(logoutBtn );
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!customerIdTF.getText().equals("") || !customerIdTF.getText().equals(null))
			{
				Customer c = er.searchCustomer(customerIdTF.getText());
				if(c!= null)
				{
					customerNameTF.setText(c.getCustomerName());
					customerPhoneNumberTF.setText(c.getPhoneNumber());
					customerAddressTF.setText(c.getAddress()+"");
					
					customerIdTF.setEnabled(false);
					customerNameTF.setEnabled(true);
					customerPhoneNumberTF.setEnabled(true);
					customerAddressTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		
		
		else if(command.equals(updateBtn.getText()))
		{
			Customer c = new Customer();
			//User u = new User();
			
			c.setCustomerId(customerIdTF.getText());
			c.setCustomerName(customerNameTF.getText());
			c.setPhoneNumber(customerPhoneNumberTF.getText());
			c.setAddress(customerAddressTF.getText());
			
			er.updateInDatabase(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			customerIdTF.setText("");
			customerNameTF.setText("");
			customerPhoneNumberTF.setText("");
			customerAddressTF.setText("");
			
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			customerIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			customerPhoneNumberTF.setEnabled(true);
			customerAddressTF.setEnabled(true);
			
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDatabase(customerIdTF.getText());
			ur.deleteUser(customerIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			customerIdTF.setText("");
			customerNameTF.setText("");
			customerPhoneNumberTF.setText("");
			customerAddressTF.setText("");
			
			customerIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			customerPhoneNumberTF.setEnabled(true);
			customerAddressTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			customerIdTF.setText("");
			customerNameTF.setText("");
			customerPhoneNumberTF.setText("");
			customerAddressTF.setText("");
			
			customerIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		else if(command.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(user);
			ch.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			 LoginFrame lg = new LoginFrame();
			 lg.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}