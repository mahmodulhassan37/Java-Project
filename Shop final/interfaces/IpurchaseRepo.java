package interfaces;

import java.lang.*;

import entity.*;

public interface IpurchaseRepo
{
	public void insertInDB(Product p);
	public void deleteFromDB(String proId);
	public void updateInDB(Product p);
	public Product searchProduct(String proId);
	public String[][] getAllProduct();
} 