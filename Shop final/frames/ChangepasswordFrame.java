package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ChangepasswordFrame extends JFrame implements ActionListener
{
	private JLabel cpLabel,npLabel,rpLabel;
	private JPasswordField cpPF,npPF,rpPF;
	private JButton changeBtn,backBtn;
	private JPanel panel;
	private Color color;

	private User user;
	private UserRepo ur;
	
	
	public ChangepasswordFrame(User user) 
	{
		super("Change Password");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		ur = new UserRepo();
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		 
		cpLabel = new JLabel("Current Password :");
		cpLabel.setBounds(200, 80,150 ,50);
		cpLabel.setBackground(Color.WHITE);
		panel.add(cpLabel);
		cpLabel.setOpaque(true);
		
		cpPF = new JPasswordField();
		cpPF.setBounds(350,90,120,30);
		cpPF.setEchoChar('*');
		panel.add(cpPF);
		
		npLabel = new JLabel("Enter New Password :");
		npLabel.setBounds(200, 120,150 ,50);
		npLabel.setBackground(Color.WHITE);
		panel.add(npLabel);
		npLabel.setOpaque(true);
		
		npPF = new JPasswordField();
		npPF.setBounds(350,130,120,30);
		cpPF.setEchoChar('*');
		panel.add(npPF);
		
		rpLabel = new JLabel("confirm Enter New Password :");
		rpLabel.setBounds(150, 160,180 ,50);
		rpLabel.setBackground(Color.WHITE);
		panel.add(rpLabel);
		rpLabel.setOpaque(true);
		
		rpPF = new JPasswordField();
		rpPF.setBounds(350,170,120,30);
		cpPF.setEchoChar('*');
		panel.add(rpPF);
		
		changeBtn = new JButton("Change");
		changeBtn.setBounds(260,220,80,30);
		changeBtn.setBackground(Color.GREEN);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400,220,80,30);
		backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(changeBtn.getText()))
		{
			User u = ur.getUser(user.getUserId(),user.getPassword());

			if((cpPF.getText()).equals(user.getPassword())&&
				(npPF.getText()).equals(rpPF.getText()))
			{
				u.setUserId(user.getUserId());
				u.setPassword(npPF.getText());
				u.setStatus(user.getStatus());
				
				ur.updateUser(u);
				JOptionPane.showMessageDialog(this, "Password Changed");
			
				cpPF.setText("");
				npPF.setText("");
				rpPF.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Changing Denied");
			}
		}
		else if(command.equals(backBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				EmployeeHome eh = new EmployeeHome(user);
				eh.setVisible(true);
				this.setVisible(false);
			}
			else
			{
			
			}
		}
		
	}
}