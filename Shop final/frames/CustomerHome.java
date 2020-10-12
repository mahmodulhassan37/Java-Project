package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerHome extends JFrame implements ActionListener
{   
	private JButton itemBtn,logoutBtn,changeInformationdBtn;
	private JPanel panel;
	private JTable proTable;
	private JScrollPane proTableSP;
	
	private User user;
	
	private ProductRepo pr;
	private UserRepo ur;
	private CustomerRepo er;
	private Color color;
	
	public CustomerHome(User user)
	{
		super("Welcome Customer");
		this.setSize(800,650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"proId", "proName", "price", "quantity"};
		
		proTable = new JTable(data,head);
		proTableSP = new JScrollPane(proTable);
		proTableSP.setBounds(220, 100, 470, 300);
		proTable.setEnabled(false);
		panel.add(proTableSP);
		
		proTable = new JTable(data,head);
		proTableSP = new JScrollPane(proTable);
		proTableSP.setBounds(300, 100, 200, 150);
		proTable.setEnabled(false);
		panel.add(proTableSP);
		  
	   
		itemBtn = new JButton("itemBtn");
		itemBtn.setBounds(225, 430, 150, 60);
		itemBtn.addActionListener(this);
		itemBtn.setBackground(Color.GREEN);
		panel.add(itemBtn);
		
		
		/*PurchaseBtn = new JButton("Purchase Details");
		PurchaseBtn.setBounds(400, 100, 150, 30);
		PurchaseBtn.addActionListener(this);
		panel.add(PurchaseBtn);*/
		
		changeInformationdBtn = new JButton("Change information");
		changeInformationdBtn.setBounds(270, 510, 260, 50);
		changeInformationdBtn.addActionListener(this);
		changeInformationdBtn.setBackground(Color.GREEN);
		panel.add(changeInformationdBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(395, 430, 150, 60);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.RED);
		panel.add(logoutBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		/*else if(command.equals(itemBtn.getText()))
		{   if(user.getStatus()==2)
			{
			itemDetails fd = new itemDetails();
			fd.setVisible(true);
			this.setVisible(false);*/
			
		else if(command.equals(itemBtn.getText()))
		{
			
			String data[][] = er.getitemProduct();
			String head[] = {"proId", "proName", "price", "quantity"};
			
			panel.remove(proTableSP);
			
			proTable = new JTable(data,head);
			proTable.setEnabled(false);
			proTableSP = new JScrollPane(proTable);
			proTableSP.setBounds(350, 100, 400, 150);
			panel.add(proTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
			
			/*else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}*/
		else if(command.equals(changeInformationdBtn.getText()))
		{
			if(user.getStatus()==2)
			{
			CustomerFrame cf = new CustomerFrame(user);
			cf.setVisible(true);
			this.setVisible(false);
			}
		}
		
		else{}
	}
}