package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public  class PurchaseFrame extends JFrame implements ActionListener
{
	private JLabel proIdLabel, proNameLabel, propriceLabel, proquantityLabel;
	private JTextField proIdTF, proNameTF, propriceTF, proquantityTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable proTable;
	private JScrollPane proTableSP;
	private Color color;
	
	private User user;
	private ProductRepo pr;
	private UserRepo ur;
	
	
	public PurchaseFrame(User user)
	{
		super("PurchaseFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		pr = new ProductRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"proId", "proName", "price", "quantity"};
		
		proTable = new JTable(data,head);
		proTableSP = new JScrollPane(proTable);
		proTableSP.setBounds(350, 100, 400, 150);
		proTable.setEnabled(false);
		panel.add(proTableSP);
		
		proIdLabel = new JLabel("ID :");
		proIdLabel.setBounds(100,100,100,30);
		panel.add(proIdLabel);
		
		proIdTF = new JTextField();
		proIdTF.setBounds(220,100,100,30);
		panel.add(proIdTF);
		
		proNameLabel = new JLabel("Name :");
		proNameLabel.setBounds(100,150,100,30);
		panel.add(proNameLabel);
		
		proNameTF = new JTextField();
		proNameTF.setBounds(220,150,100,30);
		panel.add(proNameTF);
		
		propriceLabel = new JLabel("Price: ");
		propriceLabel.setBounds(100,200,100,30);
		panel.add(propriceLabel);
		
		propriceTF = new JTextField();
		propriceTF.setBounds(220,200,100,30);
		panel.add(propriceTF);
		
		proquantityLabel = new JLabel("quantity: ");
		proquantityLabel.setBounds(100,250,100,30);
		panel.add(proquantityLabel);
		
		proquantityTF = new JTextField();
		proquantityTF.setBounds(220,250,100,30);
		panel.add(proquantityTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLUE);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		insertBtn.setBackground(Color.GREEN);
		
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
	    updateBtn.setBackground(Color.GREEN);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setBackground(Color.GREEN);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setBackground(Color.GREEN);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		getAllBtn.setBackground(Color.GREEN);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.CYAN);
		panel.add(backBtn);
		
		this.add(panel);
} 
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!proIdTF.getText().equals("") || !proIdTF.getText().equals(null))
			{
				Product p = pr.searchProduct(proIdTF.getText());
				if(p!= null)
				{
					proNameTF.setText(p.getproName());
					propriceTF.setText(p.getprice() +"");
					proquantityTF.setText(p.getquantity()+"");
					
					proIdTF.setEnabled(false);
					proNameTF.setEnabled(true);
					propriceTF.setEnabled(true);
					proquantityTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Product p = new Product();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			p.setproId(proIdTF.getText());
			p.setproName(proNameTF.getText());
			p.setprice(Integer.parseInt(propriceTF.getText()+""));
			p.setquantity(Integer.parseInt(proquantityTF.getText()+""));
			
			u.setUserId(proIdTF.getText());
			u.setPassword(x+"");
			
			if(((proNameTF.getText()).equals("food")) || ((proNameTF.getText()).equals("food")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			pr.insertInDB(p);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+proIdTF.getText()+"and Password: "+x);
			
			proIdTF.setText("");
			proNameTF.setText("");
			propriceTF.setText("");
			proquantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			proIdTF.setText("");
			proNameTF.setText("");
			propriceTF.setText("");
			proquantityTF.setText("");
			
			proIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Product p = new Product();
			
			p.setproId(proIdTF.getText());
			p.setproName(proNameTF.getText());
			p.setprice(Integer.parseInt(propriceTF.getText()+""));
			p.setquantity(Integer.parseInt(proquantityTF.getText()));
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			proIdTF.setText("");
			proNameTF.setText("");
			propriceTF.setText("");
			proquantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			proIdTF.setEnabled(true);
			proNameTF.setEnabled(true);
			propriceTF.setEnabled(true);
			proquantityTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(proIdTF.getText());
			ur.deleteUser(proIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			proIdTF.setText("");
			proNameTF.setText("");
			propriceTF.setText("");
			proquantityTF.setText("");
			
			proIdTF.setEnabled(true);
			proNameTF.setEnabled(true);
			propriceTF.setEnabled(true);
			proquantityTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllProduct();
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
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}