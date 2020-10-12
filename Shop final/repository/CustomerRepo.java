package repository;

import java.lang.*;
import entity.*;
import interfaces.*;
import java.util.ArrayList;

 public class CustomerRepo implements ICustomer
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDatabase(Customer c)
	{
		String query = "Insert into customer Values ('"+c.getCustomerId()+"','"+c.getCustomerName()+"','"+c.getPhoneNumber()+"','"+c.getAddress()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateInDatabase(Customer c)
	{
		String query = "Update customer set customerName='"+c.getCustomerName()+"', phoneNumber = '"+c.getPhoneNumber()+"', address = '"+c.getAddress()+"' WHERE customerId='"+c.getCustomerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDatabase(String customerId)
	{
		String query = "Delete from customer where customerId='"+customerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public Customer searchCustomer(String customerId)
	{
		Customer customer = null;
		String query = "Select `customerName`, `phoneNumber`, `address` FROM `customer` WHERE `customerId`='"+customerId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String customerName = dbc.result.getString("customerName");
				String phoneNumber = dbc.result.getString("phoneNumber");
				String address = dbc.result.getString("address");
				
				customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setPhoneNumber(phoneNumber);
				customer.setAddress(address);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return customer;
	}
	
	public String[][] getitemProduct()
	{
		ArrayList<Product> ar = new ArrayList<Product>();
		String query = "SELECT * FROM product;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String proId = dbc.result.getString("proId");
				String proname = dbc.result.getString("proName");
				int price = dbc.result.getInt("price");
				int quantity = dbc.result.getInt("quantity");
				
				Product p = new Product(proId,proname,price,quantity);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getproId();
			data[i][1] = ((Product)obj[i]).getproName();
			data[i][2] = (((Product)obj[i]).getprice())+"";
			data[i][3] = (((Product)obj[i]).getquantity())+"";
		}
		return data;
	}
	
}




