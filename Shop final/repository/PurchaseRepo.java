package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PurchaseRepo implements IpurchaseRepo
{
	DatabaseConnection dbc;
	
	public PurchaseRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Product p)
	{
		String query = "INSERT INTO product VALUES ('"+p.getproId()+"','"+p.getproName()+"','"+p.getprice()+"',"+p.getquantity()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
}
	public void deleteFromDB(String proId)
	{
		String query = "DELETE from product WHERE proId='"+proId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception p){System.out.println(p.getMessage());}
	}
	public void updateInDB(Product p)
	{
		String query = "UPDATE product SET proName='"+p.getproName()+"', price = '"+p.getprice()+"', quantity = "+p.getquantity()+" WHERE proId='"+p.getproId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Product searchProduct(String proId)
	{
		Product pro = null;
		String query = "SELECT `proName`, `price`, `quantity` FROM `product` WHERE `proId`='"+proId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String proname = dbc.result.getString("proName");
				int price = dbc.result.getInt("price");
				int quantity = dbc.result.getInt("quantity");
				
				pro = new Product();
				pro.setproId(proId);
			    pro.setproName(proname);
				pro.setprice(price);
				pro.setquantity(quantity);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pro;
	}
	public String[][] getAllProduct()
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



