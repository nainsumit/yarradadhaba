package com.restaurant.request.bean.order.place;

public class CustomerDetails
{
	private String orderType;
	private String address;
	private String cityAreaId;
	private String customerName;
	private String phone;
	private String email;
	
	public String getOrderType()
	{
		return orderType;
	}
	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCityAreaId()
	{
		return cityAreaId;
	}
	public void setCityAreaId(String cityAreaId)
	{
		this.cityAreaId = cityAreaId;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
