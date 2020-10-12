package entity;
import java.lang.*;

public class Purchase
{
	private String proId;
	private String proName;
	private int price;
	private int quantity;
	
	public Purchase()
	{
		
	}
	public Purchase(String proId, String proName,int price,int quantity)
	{
		this.proId=proId;
		this.proName=proName;
		this.price=price;
		this.quantity=quantity;
	}
	
	public void setproId(String proId){this.proId=proId;}
	public void setproName(String proName){this.proName=proName;}
	public void setprice(int price){this.price=price;}
	public void setquantity(int quantity){this.quantity=quantity;}
	
	public String getproId(){return proId;}
	public String getproName(){return proName;}
	public int getprice(){return price;}
	public int getquantity(){return quantity;}
}