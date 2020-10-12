package entity;

import java.lang.*;

public class Customer
{
	private String customerId;
	private String customerName;
	private String phoneNumber;
	private String address ;
	
	
	public Customer(){}
	public Customer(String customerId, String customerName, String phoneNumber, String address)
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}
	
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getCustomerId()
	{
		return customerId;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getAddress()
	{
		return address;
	}
	
}