package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;


import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	private JLabel title, userLabel, passLabel,imgLabel,backImgLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, regBtn, showPassBtn;
	private JPanel panel;
	private Color color;
	private ImageIcon img , backImg;
	private Font myFont;
	
	
	public LoginFrame()
	{
		super("Shop Management System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		color = new Color(240, 250, 160);
		myFont = new Font("Consolas", Font.ITALIC | Font.BOLD, 35);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(255,255,255);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);
		
		title = new JLabel("Shop Management System");
		title.setBounds(280, 40, 440, 45);
		title.setBackground(Color.GRAY);
		title.setOpaque(true);
		title.setFont(myFont);
		panel.add(title);
		
		userLabel = new JLabel("User ID   : ");
		userLabel.setBounds(300, 100, 80, 30);
		panel.add(userLabel);
		
		
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,150,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.setBackground(Color.GREEN);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		exitBtn.setBackground(Color.RED);
		panel.add(exitBtn);
		
		regBtn = new JButton("Registration");
		regBtn.setBounds(300, 250, 170, 30);
		regBtn.setBackground(Color.CYAN);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		
		/*img = new ImageIcon("b.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 450);
		panel.add(imgLabel);*/
		
		
		backImg = new ImageIcon("b.png");
		Image rawImage = backImg.getImage();
		Image resizedImage = rawImage.getScaledInstance(800, 450, Image.SCALE_SMOOTH);
		
		backImg = new ImageIcon(resizedImage);
		backImgLabel = new JLabel(backImg);
		backImgLabel.setBounds(0,0, 800, 450);
		panel.add(backImgLabel);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1)
				{
					EmployeeHome eh = new EmployeeHome(user);
					eh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					//CustomerHome ch = new CustomerHome(user);
					//else if(user.getStatus() == 2)
				
				   CustomerHome ch = new CustomerHome(user);
					ch.setVisible(true);
					this.setVisible(false);
			
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame();
			rf.setVisible(true);
			this.setVisible(false);
		}
		else{}
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