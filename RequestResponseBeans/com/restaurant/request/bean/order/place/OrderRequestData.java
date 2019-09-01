package com.restaurant.request.bean.order.place;

import java.util.List;

public class OrderRequestData
{
	private CustomerDetails customerDetails;
	private List<OrderItem> orderDetails;
	
	public CustomerDetails getCustomerDetails()
	{
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails)
	{
		this.customerDetails = customerDetails;
	}
	public List<OrderItem> getOrderDetails()
	{
		return orderDetails;
	}
	public void setOrderDetails(List<OrderItem> orderDetails)
	{
		this.orderDetails = orderDetails;
	}
}